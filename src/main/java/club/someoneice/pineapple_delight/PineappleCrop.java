package club.someoneice.pineapple_delight;

import io.github.lucaargolo.seasons.FabricSeasons;
import io.github.lucaargolo.seasons.utils.Season;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class PineappleCrop extends CropBlock {
    public PineappleCrop() {
        super(Settings.create().noCollision().nonOpaque().ticksRandomly());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!Pineapple.SEASON_INSTALL) super.randomTick(state, world, pos, random);

        Season season = FabricSeasons.getCurrentSeason(world);
        if (season != Season.SPRING && season != Season.SUMMER) return;
        int age = this.getAge(state);
        if (age < this.getMaxAge() - 1) super.randomTick(state, world, pos, random);
        else if (season == Season.SUMMER) super.randomTick(state, world, pos, random);
    }
}
