package club.someoneice.pineapple.init;

import club.someoneice.pineapple.init.data.BlockUtil;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static club.someoneice.pineapple.PineappleMain.MODID;

public class BlockList {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Block> PINEAPPLE_PIE = BLOCKS.register("pineapple_pie", BlockUtil::pie);
    public static final RegistryObject<Block> PINEAPPLE_WILD_CROP = BLOCKS.register("pineapple_wild_crop", BlockUtil::wildBlock);
    public static final RegistryObject<Block> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop", BlockUtil::crop);

}
