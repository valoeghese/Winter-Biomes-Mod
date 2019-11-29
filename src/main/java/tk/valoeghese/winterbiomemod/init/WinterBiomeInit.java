package tk.valoeghese.winterbiomemod.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import tk.valoeghese.winterbiomemod.WinterBiomeMod;
import tk.valoeghese.winterbiomemod.biome.AlpineBiome;
import tk.valoeghese.winterbiomemod.biome.AlpineGlacierBiome;
import tk.valoeghese.winterbiomemod.biome.AlpinePeaksBiome;

public final class WinterBiomeInit {
	private WinterBiomeInit() {
	}
	
	public static final Biome ALPINE = new AlpineBiome();
	public static final Biome ALPINE_PEAKS = new AlpinePeaksBiome();
	public static final Biome ALPINE_GLACIER = new AlpineGlacierBiome();
	
	public static void init() {
		// 1.0.0
		Registry.register(Registry.BIOME, WinterBiomeMod.id("alpine"), ALPINE);
		Registry.register(Registry.BIOME, WinterBiomeMod.id("alpine_peaks"), ALPINE_PEAKS);
		Registry.register(Registry.BIOME, WinterBiomeMod.id("alpine_glacier"), ALPINE_GLACIER);
	}
}
