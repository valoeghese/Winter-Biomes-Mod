package tk.valoeghese.winterbiomemod.init;

import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public final class WinterGenInit {
	private WinterGenInit() {
	}

	public static void init() {
		// Alpine
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.ALPINE, OverworldClimate.COOL, 0.5);
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.ALPINE, OverworldClimate.SNOWY, 2.0);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.ALPINE, WinterBiomeInit.ALPINE_PEAKS, 3.0);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.ALPINE, WinterBiomeInit.ALPINE_GLACIAL_PEAKS, 1.0);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.ALPINE_PEAKS, null);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.ALPINE, null);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.ALPINE_GLACIAL_PEAKS, null);

		// White Oaks
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.WHITE_OAKS, OverworldClimate.SNOWY, 2.0);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.WHITE_OAKS, WinterBiomeInit.WHITE_OAKS_HILLS, 2.0);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.WHITE_OAKS, WinterBiomeInit.WHITE_OAKS_THICKET, 1.0);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.WHITE_OAKS, Biomes.FROZEN_RIVER);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.WHITE_OAKS_THICKET, Biomes.FROZEN_RIVER);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.WHITE_OAKS_HILLS, Biomes.FROZEN_RIVER);

		// Subalpine
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.SUBALPINE, OverworldClimate.COOL, 1.0);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.SUBALPINE, WinterBiomeInit.SUBALPINE_CRAG, 1.0);
		OverworldBiomes.addShoreBiome(WinterBiomeInit.SUBALPINE, Biomes.BEACH, 1.0);
		OverworldBiomes.addShoreBiome(WinterBiomeInit.SUBALPINE_CRAG, Biomes.STONE_SHORE, 1.0);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.SUBALPINE_CRAG, null);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.SUBALPINE, null);

		// Ice Cap
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.ICE_CAP, OverworldClimate.SNOWY, 1.5);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.ICE_CAP, Biomes.ICE_SPIKES, 1.0);
		OverworldBiomes.addHillsBiome(WinterBiomeInit.ICE_CAP, WinterBiomeInit.ICE_CAP, 4.0);
		OverworldBiomes.addShoreBiome(WinterBiomeInit.ICE_CAP, WinterBiomeInit.ICE_CAP, 1.0);
		OverworldBiomes.setRiverBiome(WinterBiomeInit.ICE_CAP, null);

		// Tundra
		OverworldBiomes.addContinentalBiome(WinterBiomeInit.TUNDRA, OverworldClimate.COOL, 1.0);

		// Spawn Biomes
		FabricBiomes.addSpawnBiome(WinterBiomeInit.ALPINE);
		FabricBiomes.addSpawnBiome(WinterBiomeInit.WHITE_OAKS);
		FabricBiomes.addSpawnBiome(WinterBiomeInit.WHITE_OAKS_THICKET);
		FabricBiomes.addSpawnBiome(WinterBiomeInit.WHITE_OAKS_HILLS);
		FabricBiomes.addSpawnBiome(WinterBiomeInit.SUBALPINE);
	}

	private static void addDebugBiomeGen(Biome b) {
		for (OverworldClimate climate : OverworldClimate.values()) {
			OverworldBiomes.addContinentalBiome(b, climate, 4.0);
		}
	}
}
