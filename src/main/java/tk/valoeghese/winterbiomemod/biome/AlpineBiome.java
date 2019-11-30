package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;
import tk.valoeghese.winterbiomemod.feature.CustomFeatureConfigs;

public class AlpineBiome extends ExtendedBiome {

	public AlpineBiome() {
		super(BiomeFactory.create(1.7f, 0.2f, Precipitation.SNOW, Category.EXTREME_HILLS).setTemperatureDownfall(-0.01f, 0.7f));

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.populator.treesPerChunk = 4;
		this.populator.addTreeFeature(Feature.MEGA_SPRUCE_TREE, CustomFeatureConfigs.ALPINE, 1);
		this.populator.addTreeFeature(Feature.NORMAL_TREE, DefaultBiomeFeatures.SPRUCE_TREE_CONFIG, 3);
		this.populator.buildTreeFeatures();
	}

}
