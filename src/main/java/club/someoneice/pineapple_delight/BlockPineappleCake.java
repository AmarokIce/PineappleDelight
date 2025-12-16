package club.someoneice.pineapple_delight;

import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
  public BlockPineappleCake() {
    super(Properties.copy(Blocks.CAKE));
  }

  @Override
  public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player,
                               InteractionHand hand, BlockHitResult hit) {
    int i = state.getValue(BITES);

    if (!player.getMainHandItem().is(ModTags.KNIVES)) {
      return super.use(state, world, pos, player, hand, hit);
    }

    if (i < 6) {
      world.setBlock(pos, state.setValue(BITES, i + 1), 3);
    } else {
      world.removeBlock(pos, false);
      world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
    }

    final var cake = new ItemStack(InitItems.PINEAPPLE_CAKE_SLICE);

    if (!player.addItem(cake)) {
      world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), cake));
    }

    return InteractionResult.SUCCESS;
  }

  public static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state,
                                      Player player) {
    if (!player.canEat(false)) {
      return InteractionResult.PASS;
    }

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
