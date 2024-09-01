package club.someoneice.pineapple.init;

import club.someoneice.pineapple.data.BlockUtil;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static club.someoneice.pineapple.PineappleMain.MODID;

public class BlockList {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredHolder<Block, Block> PINEAPPLE_PIE = BLOCKS.register("pineapple_pie", BlockUtil::pie);
    public static final DeferredHolder<Block, Block> PINEAPPLE_WILD_CROP = BLOCKS.register("pineapple_wild_crop", BlockUtil::wildBlock);
    public static final DeferredHolder<Block, Block> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop", BlockUtil::crop);


    public static final DeferredHolder<Item, Item> PINEAPPLE_PIE_ITEM = BLOCK_ITEMS.register("pineapple_pie", () -> new BlockItem(BlockList.PINEAPPLE_PIE.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> PINEAPPLE_WILD_CROP_ITEM = BLOCK_ITEMS.register("pineapple_wild_crop", () -> new BlockItem(BlockList.PINEAPPLE_WILD_CROP.get(), new Item.Properties()));
    public static final DeferredHolder<Item, Item> PINEAPPLE_CROP_ITEM = BLOCK_ITEMS.register("pineapple_crop", () -> new BlockItem(BlockList.PINEAPPLE_CROP.get(), new Item.Properties()));
}
