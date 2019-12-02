package tk.valoeghese.winterbiomemod.surfacebuilder;

import java.util.Random;
import java.util.function.ToIntFunction;

import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import tk.valoeghese.winterbiomemod.WinterBiomeMod;
import tk.valoeghese.winterbiomemod.biome.util.NoiseSurface;

public class NoiseSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
	private static final NoiseSurfaceConfigModifier[] MODIFIERS = new NoiseSurfaceConfigModifier[16];
	private static final Object2IntMap<Biome> BIOME_TO_MODIFIER_CACHE = new Object2IntArrayMap<>();
	private static final NoiseSurfaceConfigModifier DEFAULT_MODIFIER = (normal, noise) -> normal;

	private static final ToIntFunction<Biome> modifierProvider = biome -> {
		Class<? extends Biome> biomeClass = biome.getClass();
		if (biomeClass.isAnnotationPresent(NoiseSurface.class)) {
			try {
				return biomeClass.getAnnotation(NoiseSurface.class).value();
			} catch (NullPointerException e) {
				WinterBiomeMod.logger.warn("Unregistered noise surface id / null noise surface!");
				e.printStackTrace();
				return 0;
			}
		} else {
			return 0;
		}
	};

	public NoiseSurfaceBuilder() {
		super(TernarySurfaceConfig::deserialize);
	}

	@Override
	public void generate(Random random, Chunk chunk, Biome biome, int x, int z, int height, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig surfaceBlocks) {
		SurfaceBuilder.DEFAULT.generate(random, chunk, biome, x, z, height, noise, defaultBlock, defaultFluid, seaLevel, seed, MODIFIERS[getModifier(biome)].modify(surfaceBlocks, noise));
	}

	public static void registerModifier(int id, NoiseSurfaceConfigModifier modifier) {
		if (MODIFIERS[id] != null) {
			throw new RuntimeException("Modifier id " + String.valueOf(id) + " already registered!");
		}

		MODIFIERS[id] = modifier;
	}

	public static int getModifier(Biome biome) {
		return BIOME_TO_MODIFIER_CACHE.computeIntIfAbsent(biome, modifierProvider);
	}

	public static interface NoiseSurfaceConfigModifier {
		TernarySurfaceConfig modify(TernarySurfaceConfig normal, double noise);
	}

	static {
		registerModifier(0, DEFAULT_MODIFIER);
	}
}
