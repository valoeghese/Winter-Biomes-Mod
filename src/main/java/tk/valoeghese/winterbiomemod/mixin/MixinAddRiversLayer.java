package tk.valoeghese.winterbiomemod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.AddRiversLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import net.minecraft.world.biome.layer.util.LayerSampler;
import tk.valoeghese.winterbiomemod.init.WinterBiomeInit;
import tk.valoeghese.winterbiomemod.util.OSNoise;

@Mixin(value = AddRiversLayer.class, priority = 1001)
public class MixinAddRiversLayer {

	@Unique
	private OSNoise glacierNoise = new OSNoise();

	@Inject(at = @At("RETURN"), method = "sample", cancellable = true)
	private void addRiversSample(LayerRandomnessSource rand, LayerSampler biomeSampler, LayerSampler riverSampler, int x, int z, CallbackInfoReturnable<Integer> info) {
		Biome returnValue = Registry.BIOME.get(info.getReturnValueI());
		if (returnValue == WinterBiomeInit.ALPINE || returnValue == WinterBiomeInit.ALPINE_PEAKS) {
			if (glacierNoise == null) {
				glacierNoise = new OSNoise((long) (rand.getNoiseSampler().originX) * -7427 + (long) (rand.getNoiseSampler().originZ) * 6235);
			}

			double sample = glacierNoise.sample((double) x / 19.2, (double) z / 19.2);

			if (sample > 0.1D && sample < 0.2D) {
				info.setReturnValue(Registry.BIOME.getRawId(WinterBiomeInit.ALPINE_GLACIER));
			}
		}
	}
}
