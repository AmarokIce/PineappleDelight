package club.someoneice.pineapple_delight;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

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
