package tk.valoeghese.winterbiomemod.init;

import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;

public final class WinterGenInit {
	private WinterGenInit() {
	}
	
	public static void init() {
		// Alpine
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.ALPINE, OverworldClimate.COOL, 0.3);
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.ALPINE, OverworldClimate.SNOWY, 1.0);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.ALPINE, null);
	}
}
