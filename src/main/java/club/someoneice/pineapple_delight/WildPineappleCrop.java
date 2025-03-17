package club.someoneice.pineapple_delight;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PlantBlock;

public class WildPineappleCrop extends PlantBlock {
    public WildPineappleCrop(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return createCodec(WildPineappleCrop::new);
    }
}
