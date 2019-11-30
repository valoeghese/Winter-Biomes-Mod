package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;
import tk.valoeghese.winterbiomemod.feature.CustomFeatureConfigs;

public class WhiteOaksBiome extends ExtendedBiome {
	public WhiteOaksBiome(float baseHeight, float scale, int tpc, int rpc) {
		super(BiomeFactory.create(baseHeight, scale, Biome.Precipitation.SNOW, Biome.Category.FOREST).setTemperatureDownfall(-0.1f, 0.6f));

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();
		DefaultBiomeFeatures.addDefaultLakes(this);

		this.populator.treesPerChunk = tpc;
		this.populator.addTreeFeature(Feature.NORMAL_TREE, DefaultBiomeFeatures.OAK_TREE_CONFIG, 1f);
		this.populator.addTreeFeature(Feature.JUNGLE_GROUND_BUSH, CustomFeatureConfigs.OAK_BUSH, 0.4f);
		this.populator.addTreeFeature(Feature.FANCY_TREE, DefaultBiomeFeatures.FANCY_TREE_CONFIG, 0.1f);
		this.populator.buildTreeFeatures();
		
		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(CustomFeatureConfigs.STONE_BOULDER).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(rpc))));
	}
}
