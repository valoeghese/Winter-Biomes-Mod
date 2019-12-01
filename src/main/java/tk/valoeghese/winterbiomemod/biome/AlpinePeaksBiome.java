package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;
import tk.valoeghese.winterbiomemod.init.WinterSurfaceInit;

public class AlpinePeaksBiome extends ExtendedBiome {
	public AlpinePeaksBiome() {
		super(BiomeFactory.create(3.1f, 0.2f, Precipitation.SNOW, Category.EXTREME_HILLS).setSurfaceBuilder(WinterSurfaceInit.GLACIER).setTemperatureDownfall(-0.01f, 0.7f).setSpawnChance(0.06f));

		this.setTopBlock(Blocks.SNOW_BLOCK.getDefaultState());
		this.setFillerBlock(Blocks.STONE.getDefaultState());

		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();

		this.addSpawn(EntityCategory.AMBIENT, 10, EntityType.BAT, 8, 8);
		this.addSpawn(EntityCategory.MONSTER, 20, EntityType.SKELETON, 4, 4);
		this.addSpawn(EntityCategory.MONSTER, 80, EntityType.STRAY, 4, 4);
	}
}
