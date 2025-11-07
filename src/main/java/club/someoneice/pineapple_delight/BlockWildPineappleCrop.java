package club.someoneice.pineapple_delight;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseCoralPlantBlock;
import net.minecraft.world.level.block.Blocks;

public class BlockWildPineappleCrop extends BaseCoralPlantBlock {
  public BlockWildPineappleCrop(Properties settings) {
    super(settings);
  }

  public BlockWildPineappleCrop() {
    super(Properties.ofFullCopy(Blocks.WHEAT));
  }

  @Override
  public MapCodec<BaseCoralPlantBlock> codec() {
    return simpleCodec(BlockWildPineappleCrop::new);
  }
}
