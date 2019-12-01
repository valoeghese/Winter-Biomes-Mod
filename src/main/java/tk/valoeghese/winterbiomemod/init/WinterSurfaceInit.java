package tk.valoeghese.winterbiomemod.init;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import tk.valoeghese.winterbiomemod.WinterBiomeMod;
import tk.valoeghese.winterbiomemod.surfacebuilder.GlacierSurfaceBuilder;

public class WinterSurfaceInit {
	public static final SurfaceBuilder<TernarySurfaceConfig> GLACIER = new GlacierSurfaceBuilder();
	
	public static void init() {
		Registry.register(Registry.SURFACE_BUILDER, WinterBiomeMod.id("glacier"), GLACIER);
	}
}
