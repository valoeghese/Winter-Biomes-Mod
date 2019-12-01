package tk.valoeghese.winterbiomemod.biome.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory.BiomePopulator;

//from valar lib, originally from tbo
public abstract class ExtendedBiome extends net.minecraft.world.biome.Biome {
	public final BiomeFactory factory;
	public final BiomePopulator populator;

	protected ExtendedBiome(BiomeFactory biomeFactory) {
		super(biomeFactory.build());

		biomeFactory.setParent(this);
		factory = biomeFactory;
		populator = biomeFactory.createPopulator();
	}

	public static <T extends FeatureConfig, U extends DecoratorConfig> ConfiguredFeature<?, ?> configure(Feature<T> feature, T featureConfig, Decorator<U> decorator, U decoratorConfig) {
		return feature.configure(featureConfig).createDecoratedFeature(decorator.configure(decoratorConfig));
	}

	protected void addSpawn(EntityCategory category, int weight, EntityType<?> entityType, int minGroupSize, int maxGroupSize) {
		this.addSpawn(category, new SpawnEntry(entityType, weight, minGroupSize, maxGroupSize));
	}

	protected void addDefaultMonsters(boolean iceSkeletons) {
		// not a monster, but still in every biome
		this.addSpawn(EntityCategory.AMBIENT, 10, EntityType.BAT, 8, 8);
		
		this.addSpawn(EntityCategory.MONSTER, 95, EntityType.ZOMBIE, 4, 4);
		this.addSpawn(EntityCategory.MONSTER, 5, EntityType.ZOMBIE_VILLAGER, 1, 1);

		if (iceSkeletons) {
			this.addSpawn(EntityCategory.MONSTER, 20, EntityType.SKELETON, 4, 4);
			this.addSpawn(EntityCategory.MONSTER, 80, EntityType.STRAY, 4, 4);
		} else {
			this.addSpawn(EntityCategory.MONSTER, 100, EntityType.SKELETON, 4, 4);
		}

		this.addSpawn(EntityCategory.MONSTER, 100, EntityType.CREEPER, 4, 4);
		this.addSpawn(EntityCategory.MONSTER, 100, EntityType.SLIME, 4, 4);
		this.addSpawn(EntityCategory.MONSTER, 10, EntityType.ENDERMAN, 1, 4);
		this.addSpawn(EntityCategory.MONSTER, 5, EntityType.WITCH, 1, 1);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getGrassColorAt(double x, double z) {
		return this.factory.hasCustomGrassColour ? this.factory.getGrassColour() : super.getGrassColorAt(x, z);
	}

	@Override
	@Environment(EnvType.CLIENT)
	public int getFoliageColorAt() {
		return this.factory.hasCustomFoliageColour ? this.factory.getFoliageColour() : super.getFoliageColorAt();
	}

	@Override
	public float getMaxSpawnLimit() {
		return this.factory.getSpawnChance();
	}

	public void setTopBlock(BlockState top) {
		this.factory.surfaceConfig.setTopMaterial(top);
	}
	public void setFillerBlock(BlockState under) {
		this.factory.surfaceConfig.setUnderMaterial(under);
	}
	public void setUnderwaterBlock(BlockState underwater) {
		this.factory.surfaceConfig.setUnderwaterMaterial(underwater);
	}

	//============================================================================//

	public static class MutableTernarySurfaceConfig extends TernarySurfaceConfig implements Cloneable {
		private BlockState top;
		private BlockState under;
		private BlockState waterfloor;

		public MutableTernarySurfaceConfig(BlockState top, BlockState under, BlockState underwater) {
			super(top, under, underwater);

			this.top = top;
			this.under = under;
			this.waterfloor = underwater;
		}

		@Override
		public BlockState getTopMaterial() {
			return this.top;
		}
		@Override
		public BlockState getUnderMaterial() {
			return this.under;
		}
		@Override
		public BlockState getUnderwaterMaterial() {
			return this.waterfloor;
		}

		public MutableTernarySurfaceConfig setTopMaterial(BlockState top) {
			this.top = top;
			return this;
		}
		public MutableTernarySurfaceConfig setUnderMaterial(BlockState under) {
			this.under = under;
			return this;
		}
		public MutableTernarySurfaceConfig setUnderwaterMaterial(BlockState waterfloor) {
			this.waterfloor = waterfloor;
			return this;
		}

		@Override
		public MutableTernarySurfaceConfig clone() {
			return new MutableTernarySurfaceConfig(this.top, this.under, this.waterfloor);
		}
	}
}