package club.someoneice.pineapple_delight;

import com.mojang.serialization.MapCodec;
import io.github.lucaargolo.seasons.FabricSeasons;
import io.github.lucaargolo.seasons.utils.Season;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;

public class BlockPineappleCrop extends CropBlock {
  public BlockPineappleCrop(Properties properties) {
    super(properties);
  }

  public BlockPineappleCrop() {
    super(Properties.ofFullCopy(Blocks.WHEAT));
  }

  @Override
  public MapCodec<? extends CropBlock> codec() {
    return simpleCodec(BlockPineappleCrop::new);
  }

  @Override
  protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
    return blockState.is(BlockTags.DIRT)
        || blockState.is(Blocks.SAND)
        || blockState.is(Blocks.FARMLAND);
  }

  @Override
  public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
    if (!ModMainCore.SEASON_INSTALL) {
      super.randomTick(state, world, pos, random);
      return;
    }

    Season season = FabricSeasons.getCurrentSeason(world);
    if (season != Season.SPRING && season != Season.SUMMER) {
      return;
    }

    int age = this.getAge(state);
    if (age < this.getMaxAge() - 1 || season == Season.SUMMER) {
      super.randomTick(state, world, pos, random);
    }

    if (age != this.getMaxAge() || world.getMoonPhase() != 1) {
      return;
    }

    float f = getGrowthSpeed(this, world, pos);
    if (random.nextInt((int)(25.0F / f) + 1) != 0) {
      return;
    }

    world.setBlock(pos, InitBlocks.HUGE_PINEAPPLE.defaultBlockState(), 2);
    world.gameEvent(GameEvent.BLOCK_CHANGE, pos, Context.of(state));
  }
}
