package tk.valoeghese.winterbiomemod.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import tk.valoeghese.winterbiomemod.WinterBiomeMod;
import tk.valoeghese.winterbiomemod.surfacebuilder.GlacierSurfaceBuilder;
import tk.valoeghese.winterbiomemod.surfacebuilder.NoiseSurfaceBuilder;

public class WinterSurfaceInit {
	public static final SurfaceBuilder<TernarySurfaceConfig> GLACIER = new GlacierSurfaceBuilder();
	public static final SurfaceBuilder<TernarySurfaceConfig> NOISE_SURFACE = new NoiseSurfaceBuilder();

	public static void init() {
		Registry.register(Registry.SURFACE_BUILDER, WinterBiomeMod.id("glacier"), GLACIER);
		Registry.register(Registry.SURFACE_BUILDER, WinterBiomeMod.id("noise"), NOISE_SURFACE);
	}
}
