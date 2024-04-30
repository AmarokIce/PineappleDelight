package club.someoneice.pineapple_delight;

import io.github.lucaargolo.seasons.FabricSeasons;
import io.github.lucaargolo.seasons.utils.Season;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;

public class PineappleCrop extends CropBlock {
    public PineappleCrop() {
        super(Settings.copy(Blocks.WHEAT));
    }

    @Override
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.SAND) || floor.isOf(Blocks.FARMLAND);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!Pineapple.SEASON_INSTALL){
            super.randomTick(state, world, pos, random);
            return;
        }

        Season season = FabricSeasons.getCurrentSeason(world);
        if (season != Season.SPRING && season != Season.SUMMER) return;
        int age = this.getAge(state);
        if (age < this.getMaxAge() - 1) super.randomTick(state, world, pos, random);
        else if (season == Season.SUMMER) super.randomTick(state, world, pos, random);
    }
}
