package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.block.Blocks;

public class AlpinePeaksBiome extends ExtendedBiome {

	public AlpinePeaksBiome() {
		super(BiomeFactory.create(2.4f, 0.2f, Precipitation.SNOW, Category.EXTREME_HILLS).setTemperatureDownfall(-0.01f, 0.7f));
		
		this.setTopBlock(Blocks.SNOW_BLOCK.getDefaultState());
		this.setFillerBlock(Blocks.STONE.getDefaultState());
		
		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();
	}

}