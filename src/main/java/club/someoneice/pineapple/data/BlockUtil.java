package club.someoneice.pineapple.data;

import club.someoneice.pineapple.common.BlockPineappleCrop;
import club.someoneice.pineapple.init.ItemList;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class BlockUtil {
  public static Block pie() {
    return new PieBlock(Properties.copy(Blocks.CAKE),
        ItemList.PINEAPPLE_PIE_SIDE);
  }

  public static Block pineappleHuge() {
    return new Block(Properties.copy(Blocks.MELON));
  }

  public static Block pineappleCrate() {
    return new Block(Properties.copy(Blocks.OAK_PLANKS));
  }

  public static Block wildBlock() {
    return new WildCropBlock(MobEffects.SATURATION, 8,
        Properties.of(Material.PLANT)
            .noCollission()
            .noOcclusion()
            .sound(SoundType.CROP)
            .randomTicks()
            .instabreak());
  }
}
