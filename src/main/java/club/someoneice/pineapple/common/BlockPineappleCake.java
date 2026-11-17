package club.someoneice.pineapple.common;

import club.someoneice.pineapple.init.ItemList;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import vectorwing.farmersdelight.common.tag.ModTags;

public final class BlockPineappleCake extends CakeBlock {
  public BlockPineappleCake() {
    super(Properties.ofFullCopy(Blocks.CAKE));
  }

  @Override
  protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
    int i = state.getValue(BITES);

    if (!stack.is(ModTags.KNIVES)) {
      return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    if (i < 6) {
      level.setBlock(pos, state.setValue(BITES, i + 1), 3);
    } else {
      level.removeBlock(pos, false);
      level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
    }

    final var cake = new ItemStack(ItemList.PINEAPPLE_CAKE_SLICE.get());

    if (!player.addItem(cake)) {
      level.addFreshEntity(new ItemEntity((Level) level, pos.getX(), pos.getY(), pos.getZ(), cake));
    }

    return ItemInteractionResult.SUCCESS;
  }

  public static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state,
                                      Player player) {
    int i = state.getValue(BITES);

    if(!player.canEat(false)) {
      return InteractionResult.PASS;
    } else {
      player.awardStat(Stats.EAT_CAKE_SLICE);
      player.getFoodData().eat(3, 0.4F);
      level.gameEvent(player, GameEvent.EAT, pos);
      if (i < 6) {
        level.setBlock(pos, state.setValue(BITES, i + 1), 3);
      } else {
        level.removeBlock(pos, false);
        level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
      }

      return InteractionResult.SUCCESS;
    }
  }
}
