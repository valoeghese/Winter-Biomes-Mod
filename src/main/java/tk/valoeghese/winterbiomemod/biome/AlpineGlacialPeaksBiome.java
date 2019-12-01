package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;

public class AlpineGlacialPeaksBiome extends ExtendedBiome {
	public AlpineGlacialPeaksBiome() {
		super(BiomeFactory.create(2.7f, 0.3f, Precipitation.SNOW, Category.EXTREME_HILLS).setTemperatureDownfall(-0.01f, 0.7f).setSpawnChance(0.04f));

		this.setTopBlock(Blocks.PACKED_ICE.getDefaultState());
		this.setFillerBlock(Blocks.BLUE_ICE.getDefaultState());

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.addSpawn(EntityCategory.AMBIENT, 10, EntityType.BAT, 8, 8);
		this.addSpawn(EntityCategory.MONSTER, 20, EntityType.SKELETON, 4, 4);
		this.addSpawn(EntityCategory.MONSTER, 80, EntityType.STRAY, 4, 4);
	}
}
