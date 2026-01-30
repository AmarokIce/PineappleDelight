package club.someoneice.pineapple.init;

import club.someoneice.pineapple.common.BlockPineappleCake;
import club.someoneice.pineapple.common.BlockPineappleCandleCake;
import club.someoneice.pineapple.common.BlockPineappleCrop;
import club.someoneice.pineapple.data.BlockUtil;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static club.someoneice.pineapple.PineappleMain.MODID;

public final class BlockList {
  public static final DeferredRegister<Block> BLOCKS =
      DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
  public static final DeferredRegister<Item> BLOCK_ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

  public static final RegistryObject<Block> PINEAPPLE_PIE =
      BLOCKS.register("pineapple_pie", BlockUtil::pie);
  public static final RegistryObject<Block> PINEAPPLE_CAKE =
      BLOCKS.register("pineapple_cake", BlockPineappleCake::new);
  public static final RegistryObject<Block> PINEAPPLE_CRATE =
      BLOCKS.register("pineapple_crate", BlockUtil::pineappleCrate);
  public static final RegistryObject<Block> PINEAPPLE_WILD_CROP =
      BLOCKS.register("pineapple_wild_crop", BlockUtil::wildBlock);
  public static final RegistryObject<Block> PINEAPPLE_CROP =
      BLOCKS.register("pineapple_crop", BlockPineappleCrop::new);
  public static final RegistryObject<Block> HUGE_PINEAPPLE =
      BLOCKS.register("huge_pineapple", BlockUtil::pineappleHuge);

  public static final RegistryObject<Block> CANDLE_CAKE =
      BLOCKS.register("pineapple_cake_with_candle",
          () -> new BlockPineappleCandleCake(Blocks.CANDLE));
  public static final RegistryObject<Block> WHITE_CANDLE_CAKE =
      BLOCKS.register("pineapple_cake_with_white_candle",
          () -> new BlockPineappleCandleCake(Blocks.WHITE_CANDLE));
  public static final RegistryObject<Block> ORANGE_CANDLE_CAKE =
      BLOCKS.register("pineapple_cake_with_orange_candle",
          () -> new BlockPineappleCandleCake(Blocks.ORANGE_CANDLE));
  public static final RegistryObject<Block> MAGENTA_CANDLE_CAKE =
      BLOCKS.register("pineapple_cake_with_magenta_candle",
          () -> new BlockPineappleCandleCake(Blocks.MAGENTA_CANDLE));
  public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_CAKE =
      BLOCKS.register("pineapple_cake_with_light_blue_candle",
          () -> new  BlockPineappleCandleCake(Blocks.LIGHT_BLUE_CANDLE));
  public static final RegistryObject<Block> YELLOW_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_yellow_candle",
        () -> new BlockPineappleCandleCake(Blocks.YELLOW_CANDLE));
  public static final RegistryObject<Block> LIME_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_lime_candle",
        () -> new BlockPineappleCandleCake(Blocks.LIME_CANDLE));
  public static final RegistryObject<Block> PINK_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_pink_candle",
        () -> new BlockPineappleCandleCake(Blocks.PINK_CANDLE));
  public static final RegistryObject<Block> GRAY_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_gray_candle",
        () -> new BlockPineappleCandleCake(Blocks.GRAY_CANDLE));
  public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_light_gray_candle",
        () -> new BlockPineappleCandleCake(Blocks.LIGHT_GRAY_CANDLE));
  public static final RegistryObject<Block> CYAN_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_cyan_candle",
        () -> new BlockPineappleCandleCake(Blocks.CYAN_CANDLE));
  public static final RegistryObject<Block> PURPLE_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_purple_candle",
        () -> new BlockPineappleCandleCake(Blocks.PURPLE_CANDLE));
  public static final RegistryObject<Block> BLUE_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_blue_candle",
        () -> new BlockPineappleCandleCake(Blocks.BLUE_CANDLE));
  public static final RegistryObject<Block> BROWN_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_brown_candle",
        () -> new BlockPineappleCandleCake(Blocks.BROWN_CANDLE));
  public static final RegistryObject<Block> GREEN_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_green_candle",
        () -> new BlockPineappleCandleCake(Blocks.GREEN_CANDLE));
  public static final RegistryObject<Block> RED_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_red_candle",
        () -> new BlockPineappleCandleCake(Blocks.RED_CANDLE));
  public static final RegistryObject<Block> BLACK_CANDLE_CAKE
      = BLOCKS.register("pineapple_cake_with_black_candle",
        () -> new BlockPineappleCandleCake(Blocks.BLACK_CANDLE));

  public static final RegistryObject<Item> PINEAPPLE_PIE_ITEM =
      BLOCK_ITEMS.register("pineapple_pie", () ->
          new BlockItem(PINEAPPLE_PIE.get(), new Properties()));
  public static final RegistryObject<Item> PINEAPPLE_CAKE_ITEM =
      BLOCK_ITEMS.register("pineapple_cake", () ->
          new BlockItem(PINEAPPLE_CAKE.get(), new Properties()));
  public static final RegistryObject<Item> PINEAPPLE_CRATE_ITEM =
      BLOCK_ITEMS.register("pineapple_crate", () ->
          new BlockItem(PINEAPPLE_CRATE.get(), new Properties()));
  public static final RegistryObject<Item> PINEAPPLE_WILD_CROP_ITEM =
      BLOCK_ITEMS.register("pineapple_wild_crop", () ->
          new BlockItem(PINEAPPLE_WILD_CROP.get(), new Properties()));
  public static final RegistryObject<Item> PINEAPPLE_CROP_ITEM =
      BLOCK_ITEMS.register("pineapple_crop", () ->
          new BlockItem(PINEAPPLE_CROP.get(), new Properties()));
  public static final RegistryObject<Item> HUGE_PINEAPPLE_ITEM =
      BLOCK_ITEMS.register("huge_pineapple", () ->
          new BlockItem(HUGE_PINEAPPLE.get(), new Properties()));
}
