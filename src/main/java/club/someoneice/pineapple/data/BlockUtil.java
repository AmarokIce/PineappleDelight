package club.someoneice.pineapple.data;

import club.someoneice.pineapple.common.BlockPineappleCrop;
import club.someoneice.pineapple.init.ItemList;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class BlockUtil {
  public static Block pie() {
    return new PieBlock(Blocks.CAKE.properties(), ItemList.PINEAPPLE_PIE_SIDE);
  }

  public static Block pineappleHuge() {
    return new Block(Properties.ofFullCopy(Blocks.MELON));
  }

  public static Block pineappleCrate() {
    return new Block(Properties.ofFullCopy(Blocks.OAK_PLANKS));
  }

  public static Block wildBlock() {
    return new WildCropBlock(MobEffects.SATURATION, 8,
        Block.Properties.of().noCollission().noOcclusion().sound(SoundType.CROP).randomTicks().instabreak());
  }

  public static Block crop() {
    return new BlockPineappleCrop();
  }
}
