package club.someoneice.pineapple.common;

import club.someoneice.pineapple.PineappleMain;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import sereneseasons.api.season.Season;
import sereneseasons.api.season.SeasonHelper;

public class PineappleCrop extends CropBlock {
    Item seed = Items.WHEAT_SEEDS;

    // public PineappleCrop(Item seed) {
    public PineappleCrop() {
        super(Properties.of().noCollission().noOcclusion().sound(SoundType.CROP).randomTicks().instabreak());
        // this.seed = seed;
    }

    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!PineappleMain.SEASON_INSTALL) super.randomTick(state, world, pos, random);
        Season season = SeasonHelper.getSeasonState(world).getSeason();
        if (season != Season.SPRING && season != Season.SUMMER) return;
        int age = this.getAge(state);
        if (age < this.getMaxAge() - 1) super.randomTick(state, world, pos, random);
        else if (season == Season.SUMMER) super.randomTick(state, world, pos, random);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return seed;
    }
}
