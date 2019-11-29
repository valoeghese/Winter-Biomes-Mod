package tk.valoeghese.winterbiomemod.init;

import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;

public final class WinterGenInit {
	private WinterGenInit() {
	}
	
	public static void init() {
		// Alpine
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.ALPINE, OverworldClimate.COOL, 0.5);
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.ALPINE, OverworldClimate.SNOWY, 2.0);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.ALPINE, WinterBiomeInit.ALPINE_PEAKS, 1);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.ALPINE_PEAKS, null);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.ALPINE, null);
		
		// Spawn Biomes
		FabricBiomes.addSpawnBiome(WinterBiomeInit.ALPINE);
	}
}
