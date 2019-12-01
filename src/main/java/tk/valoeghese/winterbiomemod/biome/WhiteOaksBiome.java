package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
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

		DefaultBiomeFeatures.addForestGrass(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);

		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(CustomFeatureConfigs.STONE_BOULDER).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(rpc))));

		this.addSpawn(EntityCategory.CREATURE, 12, EntityType.SHEEP, 4, 4);
		this.addSpawn(EntityCategory.CREATURE, 10, EntityType.PIG, 4, 4);
		this.addSpawn(EntityCategory.CREATURE, 10, EntityType.CHICKEN, 4, 4);
		this.addSpawn(EntityCategory.CREATURE, 8, EntityType.COW, 4, 4);
		this.addSpawn(EntityCategory.CREATURE, 4, EntityType.WOLF, 4, 4);
		this.addSpawn(EntityCategory.CREATURE, 5, EntityType.RABBIT, 2, 3);
		this.addSpawn(EntityCategory.CREATURE, 2, EntityType.FOX, 2, 4);
		this.addDefaultMonsters(false);
	}
}
