package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;
import tk.valoeghese.winterbiomemod.feature.CustomFeatureConfigs;
import tk.valoeghese.winterbiomemod.init.WinterSurfaceInit;

public class AlpineBiome extends ExtendedBiome {
	public AlpineBiome() {
		super(BiomeFactory.create(1.8f, 0.2f, Precipitation.SNOW, Category.EXTREME_HILLS).setSurfaceBuilder(WinterSurfaceInit.GLACIER).setTemperatureDownfall(-0.01f, 0.7f));

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.populator.treesPerChunk = 4;
		this.populator.addTreeFeature(Feature.MEGA_SPRUCE_TREE, CustomFeatureConfigs.ALPINE, 1);
		this.populator.addTreeFeature(Feature.NORMAL_TREE, DefaultBiomeFeatures.SPRUCE_TREE_CONFIG, 3);
		this.populator.buildTreeFeatures();

		this.addSpawn(EntityCategory.CREATURE, 15, EntityType.RABBIT, 3, 5);
		this.addSpawn(EntityCategory.CREATURE, 2, EntityType.WOLF, 4, 6);
		this.addSpawn(EntityCategory.AMBIENT, 10, EntityType.BAT, 8, 8);
		this.addSpawn(EntityCategory.MONSTER, 20, EntityType.SKELETON, 4, 4);
		this.addSpawn(EntityCategory.MONSTER, 80, EntityType.STRAY, 4, 4);
		this.addSpawn(EntityCategory.MONSTER, 100, EntityType.SPIDER, 4, 4);
	}
}
