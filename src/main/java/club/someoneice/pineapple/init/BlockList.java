package club.someoneice.pineapple.init;

import club.someoneice.pineapple.common.BlockPineappleCake;
import club.someoneice.pineapple.data.BlockUtil;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static club.someoneice.pineapple.PineappleMain.MODID;

public final class BlockList {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
  public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(MODID);

  public static final DeferredBlock<Block> PINEAPPLE_PIE =
      BLOCKS.register("pineapple_pie", BlockUtil::pie);
  public static final DeferredBlock<Block> PINEAPPLE_CAKE =
      BLOCKS.register("pineapple_cake", BlockPineappleCake::new);
  public static final DeferredBlock<Block> PINEAPPLE_CRATE =
      BLOCKS.register("pineapple_crate", BlockUtil::pineappleCrate);
  public static final DeferredBlock<Block> PINEAPPLE_WILD_CROP =
      BLOCKS.register("pineapple_wild_crop", BlockUtil::wildBlock);
  public static final DeferredBlock<Block> PINEAPPLE_CROP =
      BLOCKS.register("pineapple_crop", BlockUtil::crop);
  public static final DeferredBlock<Block> HUGE_PINEAPPLE =
      BLOCKS.register("huge_pineapple", BlockUtil::pineappleHuge);

  public static final DeferredItem<Item> PINEAPPLE_PIE_ITEM =
      BLOCK_ITEMS.register("pineapple_pie", () ->
          new BlockItem(PINEAPPLE_PIE.get(), new Properties()));
  public static final DeferredItem<Item> PINEAPPLE_CAKE_ITEM =
      BLOCK_ITEMS.register("pineapple_cake", () ->
          new BlockItem(PINEAPPLE_CAKE.get(), new Properties()));
  public static final DeferredItem<Item> PINEAPPLE_CRATE_ITEM =
      BLOCK_ITEMS.register("pineapple_crate", () ->
          new BlockItem(PINEAPPLE_CRATE.get(), new Properties()));
  public static final DeferredItem<Item> PINEAPPLE_WILD_CROP_ITEM =
      BLOCK_ITEMS.register("pineapple_wild_crop", () ->
          new BlockItem(PINEAPPLE_WILD_CROP.get(), new Properties()));
  public static final DeferredItem<Item> PINEAPPLE_CROP_ITEM =
      BLOCK_ITEMS.register("pineapple_crop", () ->
          new BlockItem(PINEAPPLE_CROP.get(), new Properties()));
  public static final DeferredItem<Item> HUGE_PINEAPPLE_ITEM =
      BLOCK_ITEMS.register("huge_pineapple", () ->
          new BlockItem(HUGE_PINEAPPLE.get(), new Properties()));
}
