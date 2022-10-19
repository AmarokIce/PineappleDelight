package club.someoneice.pineapple.common;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class CropHelper extends CropsBlock {
    public CropHelper() {
        super(AbstractBlock.Properties.of(Material.PLANT).noCollission().noOcclusion().sound(SoundType.CROP).randomTicks().instabreak());
    }
}
