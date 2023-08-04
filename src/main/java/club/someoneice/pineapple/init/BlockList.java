package club.someoneice.pineapple.init;

import club.someoneice.pineapple.data.BlockUtil;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static club.someoneice.pineapple.PineappleMain.MODID;

public class BlockList {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block> PINEAPPLE_PIE = BLOCKS.register("pineapple_pie", BlockUtil::pie);
    public static final RegistryObject<Block> PINEAPPLE_WILD_CROP = BLOCKS.register("pineapple_wild_crop", BlockUtil::wildBlock);
    public static final RegistryObject<Block> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop", BlockUtil::crop);


    public static final RegistryObject<Item> PINEAPPLE_PIE_ITEM = BLOCK_ITEMS.register("pineapple_pie", () -> new BlockItem(BlockList.PINEAPPLE_PIE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PINEAPPLE_WILD_CROP_ITEM = BLOCK_ITEMS.register("pineapple_wild_crop", () -> new BlockItem(BlockList.PINEAPPLE_WILD_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> PINEAPPLE_CROP_ITEM = BLOCK_ITEMS.register("pineapple_crop", () -> new BlockItem(BlockList.PINEAPPLE_CROP.get(), new Item.Properties()));
}
