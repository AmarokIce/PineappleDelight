package club.someoneice.pineapple_delight;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;

public class BlockWildPineappleCrop extends BushBlock {
  public BlockWildPineappleCrop(Properties settings) {
    super(settings);
  }

  public BlockWildPineappleCrop() {
    super(Properties.ofFullCopy(Blocks.WHEAT));
  }

  @Override
  protected MapCodec<? extends BushBlock> codec() {
    return simpleCodec(BlockWildPineappleCrop::new);
  }
}
