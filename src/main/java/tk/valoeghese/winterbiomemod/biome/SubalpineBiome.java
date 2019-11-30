package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;
import tk.valoeghese.winterbiomemod.feature.CustomFeatureConfigs;

public class SubalpineBiome extends ExtendedBiome {

	public SubalpineBiome(int rpc) {
		super(BiomeFactory.create(1.2f, 0.28f, Precipitation.SNOW, Category.EXTREME_HILLS).setTemperatureDownfall(0.2f, 0.45f).setGrassColour(0xada010));

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.populator.treesPerChunk = 1;
		this.populator.addTreeFeature(Feature.NORMAL_TREE, DefaultBiomeFeatures.SPRUCE_TREE_CONFIG, 1);
		this.populator.addTreeFeature(Feature.JUNGLE_GROUND_BUSH, CustomFeatureConfigs.SPRUCE_BUSH, 2);
		this.populator.buildTreeFeatures();
		
		DefaultBiomeFeatures.addSavannaGrass(this);

		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(CustomFeatureConfigs.STONE_BOULDER).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(rpc))));
	}

}
