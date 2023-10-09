package club.someoneice.pineapple.common;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import org.jetbrains.annotations.NotNull;

public class CropHelper extends CropBlock {
    Item seed = Items.WHEAT_SEEDS;

    // public CropHelper(Item seed) {
    public CropHelper() {
        super(Properties.of().noCollission().noOcclusion().sound(SoundType.CROP).randomTicks().instabreak());
        // this.seed = seed;
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return seed;
    }
}
