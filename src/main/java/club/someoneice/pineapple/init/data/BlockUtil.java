package club.someoneice.pineapple.init.data;

import club.someoneice.pineapple.common.CropHelper;
import club.someoneice.pineapple.init.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import vectorwing.farmersdelight.blocks.PieBlock;
import vectorwing.farmersdelight.blocks.WildCropsBlock;

public class BlockUtil {
    public static Block pie() {
        return new PieBlock(Block.Properties.copy(Blocks.CAKE), ItemList.PINEAPPLE_PIE_SIDE);
    }

    public static Block wildBlock() {
        return new WildCropsBlock(Block.Properties.of(Material.PLANT).noCollission().noOcclusion().sound(SoundType.CROP).randomTicks().instabreak());
    }

    public static Block crop() {
        return new CropHelper();
    }
}
