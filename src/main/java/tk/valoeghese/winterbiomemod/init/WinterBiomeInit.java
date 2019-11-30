package tk.valoeghese.winterbiomemod.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import tk.valoeghese.winterbiomemod.WinterBiomeMod;
import tk.valoeghese.winterbiomemod.biome.AlpineBiome;
import tk.valoeghese.winterbiomemod.biome.AlpineGlacierBiome;
import tk.valoeghese.winterbiomemod.biome.AlpinePeaksBiome;
import tk.valoeghese.winterbiomemod.biome.SubalpineBiome;
import tk.valoeghese.winterbiomemod.biome.WhiteOaksBiome;

public final class WinterBiomeInit {
	private WinterBiomeInit() {
	}

	public static final Biome ALPINE = new AlpineBiome();
	public static final Biome ALPINE_PEAKS = new AlpinePeaksBiome();
	public static final Biome ALPINE_GLACIER = new AlpineGlacierBiome();

	public static final Biome WHITE_OAKS = new WhiteOaksBiome(0.2f, 0.12f, 4, 2);
	public static final Biome WHITE_OAKS_THICKET = new WhiteOaksBiome(0.2f, 0.12f, 10, 2);
	public static final Biome WHITE_OAKS_HILLS = new WhiteOaksBiome(0.35f, 0.3f, 3, 4);

	public static final Biome SUBALPINE = new SubalpineBiome(1);
	public static final Biome SUBALPINE_CRAG = new SubalpineBiome(3);

	public static void init() {
		// 1.0.0
		Registry.register(Registry.BIOME, WinterBiomeMod.id("alpine"), ALPINE);
		Registry.register(Registry.BIOME, WinterBiomeMod.id("alpine_peaks"), ALPINE_PEAKS);
		Registry.register(Registry.BIOME, WinterBiomeMod.id("alpine_glacier"), ALPINE_GLACIER);

		Registry.register(Registry.BIOME, WinterBiomeMod.id("white_oaks"), WHITE_OAKS);
		Registry.register(Registry.BIOME, WinterBiomeMod.id("white_oaks_thicket"), WHITE_OAKS_THICKET);
		Registry.register(Registry.BIOME, WinterBiomeMod.id("white_oaks_hills"), WHITE_OAKS_HILLS);

		Registry.register(Registry.BIOME, WinterBiomeMod.id("subalpine"), SUBALPINE);
		Registry.register(Registry.BIOME, WinterBiomeMod.id("subalpine_crag"), SUBALPINE_CRAG);
	}
}
