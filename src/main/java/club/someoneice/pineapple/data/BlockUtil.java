package club.someoneice.pineapple.data;

import club.someoneice.pineapple.common.BlockPineappleCrop;
import club.someoneice.pineapple.init.ItemList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootParams;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.List;

public class BlockUtil {
  public static Block pie() {
    return new PieBlock(Blocks.CAKE.properties(), ItemList.PINEAPPLE_PIE_SIDE);
  }

  public static Block pineappleHuge() {
    return new Block(Properties.ofFullCopy(Blocks.MELON));
  }

  public static Block pineappleCrate() {
    return new Block(Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
      @Override
      protected List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        final var list = super.getDrops(state, params);
        list.add(this.asItem().getDefaultInstance());
        return list;
      }
    };
  }

  public static Block wildBlock() {
    return new WildCropBlock(MobEffects.SATURATION, 8,
        Block.Properties.of().noCollission().noOcclusion().sound(SoundType.CROP).randomTicks().instabreak());
  }

  public static Block crop() {
    return new BlockPineappleCrop();
  }
}
