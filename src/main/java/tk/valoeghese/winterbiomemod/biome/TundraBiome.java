package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;
import tk.valoeghese.winterbiomemod.biome.util.NoiseSurface;
import tk.valoeghese.winterbiomemod.feature.CustomFeatureConfigs;
import tk.valoeghese.winterbiomemod.init.WinterSurfaceInit;
import tk.valoeghese.winterbiomemod.surfacebuilder.NoiseSurfaceBuilder;

@NoiseSurface(1)
public class TundraBiome extends ExtendedBiome {
	public TundraBiome() {
		super(BiomeFactory.create(0.12f, 0.05f, Precipitation.SNOW, Category.EXTREME_HILLS).setSurfaceBuilder(WinterSurfaceInit.NOISE_SURFACE).setTemperatureDownfall(0.4f, 0.45f).setGrassColour(0x9b5310).setSpawnChance(0.05f));

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.populator.treesPerChunk = 1;
		this.populator.addTreeFeature(Feature.JUNGLE_GROUND_BUSH, CustomFeatureConfigs.SPRUCE_BUSH, 1);
		this.populator.buildTreeFeatures();

		DefaultBiomeFeatures.addDesertLakes(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);

		this.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(CustomFeatureConfigs.COBBLESTONE_BOULDER).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, (float) 0.2, 6))));

		this.addSpawn(EntityCategory.CREATURE, 10, EntityType.RABBIT, 2, 3);
		this.addDefaultMonsters(false);
	}
	
	static {
		NoiseSurfaceBuilder.registerModifier(1, (normal, noise) -> {
			if (noise > 2.9) {
				return SurfaceBuilder.COARSE_DIRT_CONFIG;
			} else {
				return normal;
			}
		});
	}
}
