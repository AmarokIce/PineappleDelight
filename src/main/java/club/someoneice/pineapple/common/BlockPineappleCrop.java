package club.someoneice.pineapple.common;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.init.BlockList;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeHooks;
import org.jetbrains.annotations.NotNull;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;

import java.util.Random;

public class BlockPineappleCrop extends CropBlock {
  public BlockPineappleCrop() {
    super(Properties.copy(Blocks.WHEAT));
  }

  @Override
  public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
    if (!PineappleMain.SEASON_INSTALL) {
      super.randomTick(state, world, pos, random);
      return;
    }

    Season season = SeasonHelper.getSeasonState(world).getSeason();
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
    if (!ForgeHooks.onCropsGrowPre(world, pos, state,
        random.nextInt((int) (25.0F / f) + 1) == 0)) {
      return;
    }
    world.setBlock(pos, BlockList.HUGE_PINEAPPLE.get().defaultBlockState(), 2);
    world.gameEvent(GameEvent.BLOCK_CHANGE, pos);
    ForgeHooks.onCropsGrowPost(world, pos, state);
  }

  @Override
  protected @NotNull ItemLike getBaseSeedId() {
    return BlockList.PINEAPPLE_CROP_ITEM.get();
  }
}
