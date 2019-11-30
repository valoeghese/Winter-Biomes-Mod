package tk.valoeghese.winterbiomemod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.layer.EaseBiomeEdgeLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import tk.valoeghese.winterbiomemod.init.WinterBiomeInit;

@Mixin(EaseBiomeEdgeLayer.class)
public class MixinEaseBiomeEdgeLayer {
	
	@Inject(at = @At("HEAD"), method = "sample", cancellable = true)
	private void injectSample(LayerRandomnessSource context, int n, int e, int s, int w, int centre, CallbackInfoReturnable<Integer> info) {
		final int subalpineId = Registry.BIOME.getRawId(WinterBiomeInit.SUBALPINE);
		
		if (centre == subalpineId) {
			// if subalpine surrounded by subalpine put alpine
			if (n == subalpineId && e == subalpineId && s == subalpineId && w == subalpineId) {
				info.setReturnValue(Registry.BIOME.getRawId(WinterBiomeInit.ALPINE));
			}
		} else {
			if (n == subalpineId || e == subalpineId || s == subalpineId || w == subalpineId) {
				info.setReturnValue(subalpineId); // invade the world! grow that subalpine biome! :P
			}
		}
	}
}
