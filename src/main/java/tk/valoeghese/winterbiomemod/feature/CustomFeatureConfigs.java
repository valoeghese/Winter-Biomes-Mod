package tk.valoeghese.winterbiomemod.feature;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.decorator.TreeDecorator;
import net.minecraft.world.gen.feature.BoulderFeatureConfig;
import net.minecraft.world.gen.feature.MegaTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;
import tk.valoeghese.winterbiomemod.Required;

public class CustomFeatureConfigs {
	public static final MegaTreeFeatureConfig ALPINE = megaTree(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()).height(17, 14).crownHeight(15).build();
	public static final BoulderFeatureConfig STONE_BOULDER = new BoulderFeatureConfig(Blocks.STONE.getDefaultState(), 1);
	public static final BoulderFeatureConfig COBBLESTONE_BOULDER = new BoulderFeatureConfig(Blocks.COBBLESTONE.getDefaultState(), 1);
	public static final TreeFeatureConfig OAK_BUSH = new TreeFeatureConfig.Builder(provider(Blocks.OAK_LOG), provider(Blocks.OAK_LEAVES)).baseHeight(4).build();
	public static final TreeFeatureConfig SPRUCE_BUSH = new TreeFeatureConfig.Builder(provider(Blocks.SPRUCE_LOG), provider(Blocks.SPRUCE_LEAVES)).baseHeight(4).build();

	// state provider
	private static SimpleStateProvider provider(BlockState state) {
		return new SimpleStateProvider(state);
	}
	private static SimpleStateProvider provider(Block block) {
		return new SimpleStateProvider(block.getDefaultState());
	}

	// mega tree
	private static MegaTreeFeatureConfigBuilder megaTree(BlockState log, BlockState leaves) {
		return new MegaTreeFeatureConfigBuilder(log, leaves);
	}

	public static class MegaTreeFeatureConfigBuilder {
		private final MegaTreeFeatureConfig.Builder parent;

		public MegaTreeFeatureConfigBuilder(BlockState log, BlockState leaves) {
			parent = new MegaTreeFeatureConfig.Builder(provider(log), provider(leaves));
		}

		@Required
		public MegaTreeFeatureConfigBuilder height(int minHeight, int interval) {
			parent.baseHeight(minHeight).heightInterval(interval);
			return this;
		}

		@Required
		public MegaTreeFeatureConfigBuilder crownHeight(int crownHeight) {
			parent.crownHeight(crownHeight);
			return this;
		}

		public MegaTreeFeatureConfigBuilder treeDecorators(TreeDecorator...decorators) {
			parent.method_23411(Arrays.asList(decorators));
			return this;
		}

		public MegaTreeFeatureConfig build() {
			return parent.build();
		}
	}
}
