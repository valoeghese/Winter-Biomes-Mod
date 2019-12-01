package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.LakeDecoratorConfig;
import net.minecraft.world.gen.feature.BushFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;

public class IceCapBiome extends ExtendedBiome {
	public IceCapBiome() {
		super(BiomeFactory.create(-0.5f, 0.02f, Biome.Precipitation.SNOW, Biome.Category.ICY).setTemperatureDownfall(-1.0f, 0.0f));

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.setTopBlock(Blocks.SNOW_BLOCK.getDefaultState());
		this.setFillerBlock(Blocks.PACKED_ICE.getDefaultState());
		this.setUnderwaterBlock(Blocks.STONE.getDefaultState());

		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, ExtendedBiome.configure(Feature.ICEBERG, new BushFeatureConfig(Blocks.PACKED_ICE.getDefaultState()), Decorator.ICEBERG, new LakeDecoratorConfig(8)));
		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, ExtendedBiome.configure(Feature.ICEBERG, new BushFeatureConfig(Blocks.BLUE_ICE.getDefaultState()), Decorator.ICEBERG, new LakeDecoratorConfig(20)));
		
		this.addDefaultMonsters(true);
	}
}
