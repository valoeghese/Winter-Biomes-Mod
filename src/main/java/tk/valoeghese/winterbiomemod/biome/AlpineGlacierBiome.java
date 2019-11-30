package tk.valoeghese.winterbiomemod.biome;

import net.minecraft.block.Blocks;
import tk.valoeghese.winterbiomemod.biome.util.BiomeFactory;
import tk.valoeghese.winterbiomemod.biome.util.ExtendedBiome;

public class AlpineGlacierBiome extends ExtendedBiome {

	public AlpineGlacierBiome() {
		super(BiomeFactory.create(1.65f, 0.1f, Precipitation.SNOW, Category.EXTREME_HILLS).setTemperatureDownfall(-0.01f, 0.7f));
		
		this.setTopBlock(Blocks.PACKED_ICE.getDefaultState());
		this.setFillerBlock(Blocks.BLUE_ICE.getDefaultState());
		
		this.factory.addDefaultGeneration();
		this.factory.addDefaultMineables();
	}

}
