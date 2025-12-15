package club.someoneice.pineapple_delight;

import com.mojang.serialization.MapCodec;
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

public class BlockPineappleCake extends CakeBlock {
  public BlockPineappleCake(Properties properties) {
    super(properties);
  }

  public BlockPineappleCake() {
    super(Properties.ofFullCopy(Blocks.CAKE));
  }

  @Override
  public MapCodec<CakeBlock> codec() {
    return simpleCodec(BlockPineappleCake::new);
  }

  @Override
  protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
    if (!itemStack.is(ModTags.KNIVES)) {
      return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    int i = blockState.getValue(BITES);
    if (i < 6) {
      level.setBlock(blockPos, blockState.setValue(BITES, i + 1), 3);
    } else {
      level.removeBlock(blockPos, false);
      level.gameEvent(player, GameEvent.BLOCK_DESTROY, blockPos);
    }

    final var cake = new ItemStack(InitItems.PINEAPPLE_CAKE_SLICE);

    if (!player.addItem(cake)) {
      level.addFreshEntity(
          new ItemEntity((Level) level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), cake));
    }

    return ItemInteractionResult.SUCCESS;
  }

  public static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state,
                                      Player player) {
    if (!player.canEat(false)) {
      return InteractionResult.PASS;
    } else {
      player.awardStat(Stats.EAT_CAKE_SLICE);
      player.getFoodData().eat(3, 0.4F);
      int i = state.getValue(BITES);
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
