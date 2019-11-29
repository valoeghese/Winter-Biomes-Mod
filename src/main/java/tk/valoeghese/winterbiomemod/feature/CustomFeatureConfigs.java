package tk.valoeghese.winterbiomemod.feature;

import java.util.Arrays;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.decorator.TreeDecorator;
import net.minecraft.world.gen.feature.MegaTreeFeatureConfig;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;
import tk.valoeghese.winterbiomemod.Required;

public class CustomFeatureConfigs {
	public static final MegaTreeFeatureConfig ALPINE = megaTree(Blocks.SPRUCE_LOG.getDefaultState(), Blocks.SPRUCE_LEAVES.getDefaultState()).height(17, 14).crownHeight(15).build();
	
	// state provider
	private static SimpleStateProvider provider(BlockState state) {
		return new SimpleStateProvider(state);
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
