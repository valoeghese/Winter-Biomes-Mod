package tk.valoeghese.winterbiomemod.surfacebuilder;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.noise.SimplexNoiseSampler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class GlacierSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
	private static final BlockState WATER = Blocks.WATER.getDefaultState();
	private static final BlockState pICE = Blocks.PACKED_ICE.getDefaultState();
	private static final BlockState bICE = Blocks.BLUE_ICE.getDefaultState();

	private static SimplexNoiseSampler noiseGenerator;
	private long currentSeed = 0L;

	public GlacierSurfaceBuilder() {
		super(TernarySurfaceConfig::deserialize);
	}

	@Override
	public void generate(Random rand, Chunk chunk, Biome biome, int x, int z, int worldHeight, double noiseVal, BlockState var9, BlockState var10, int var11, long seed, TernarySurfaceConfig config) {
		if (noiseGenerator == null || seed != currentSeed) {
			noiseGenerator = new SimplexNoiseSampler(new Random(seed));
			currentSeed = seed;
		}

		double noise = noiseGenerator.sample((double) x / 260D, (double) z / 260D);
		int glacierDifference = (int) ((noise > 0.22D && noise < 0.3D) ? (1171875 * Math.pow(noise - 0.26, 4)) - 3 : 0);

		int localX = x & 15;
		int localZ = z & 15;

		BlockPos.Mutable pos = new BlockPos.Mutable(localX, 255, localZ);

		if (glacierDifference != 0) {
			pos.setY(worldHeight);
			chunk.setBlockState(pos, AIR, false);

			pos.setY(worldHeight - 1);
			chunk.setBlockState(pos, AIR, false);

			worldHeight -= 2;
		}

		int run = -1;

		int y = Math.min(worldHeight + 1, 255);

		for (; y >= 0; --y) {
			pos.setY(y);
			if (run != -2) {
				++run;
			}

			BlockState currentState = chunk.getBlockState(pos);
			if (currentState == WATER) {
				run = -2;
			} else if (currentState == AIR) {
				run = -1;
			} else if (run == -2) {
				run = -1;
				currentState = config.getUnderwaterMaterial();
			}

			if (y <= worldHeight) {

				BlockState toSet = currentState;

				if (y - worldHeight > glacierDifference) {
					toSet = (y - worldHeight == -1) ? bICE : pICE;
				} else if (currentState == STONE) {
					if (run == 0) {
						toSet = config.getTopMaterial();
					} else if (run > 0 && run < 3) {
						toSet = config.getUnderMaterial();
					}
				}

				chunk.setBlockState(pos, toSet, false);
			}
		}
	}
}