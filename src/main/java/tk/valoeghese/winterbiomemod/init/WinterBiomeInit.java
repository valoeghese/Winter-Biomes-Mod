package tk.valoeghese.winterbiomemod.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import tk.valoeghese.winterbiomemod.WinterBiomeMod;
import tk.valoeghese.winterbiomemod.biome.AlpineBiome;

public final class WinterBiomeInit {
	private WinterBiomeInit() {
	}
	
	public static final Biome ALPINE = new AlpineBiome();
	
	public static void init() {
		// 1.0.0
		Registry.register(Registry.BIOME, WinterBiomeMod.id("alpine"), ALPINE);
	}
}
