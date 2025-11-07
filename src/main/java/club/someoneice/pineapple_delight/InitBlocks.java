package club.someoneice.pineapple_delight;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class InitBlocks {
  public static final Block PINEAPPLE_PIE = pie();
  public static final Block PINEAPPLE_CAKE = cake();
  public static final Block PINEAPPLE_WILD_CROP = wildPineapple();
  public static final Block PINEAPPLE_CROP = pineappleCrop();
  public static final Block PINEAPPLE_CRATE = pineappleCrate();
  public static final Block HUGE_PINEAPPLE = hugePineapple();

  private static Block registry(Block block, String name) {
    Registry.register(BuiltInRegistries.BLOCK,
        new ResourceLocation("pineapple_delight", name), block);
    var item = new BlockItem(block, new Item.Properties());
    Registry.register(BuiltInRegistries.ITEM,
        new ResourceLocation("pineapple_delight", name), item);

    InitItems.ITEMS.add(item);
    return block;
  }

  private static Block pie() {
    return registry(new PieBlock(
        Properties.copy(ModBlocks.APPLE_PIE.get()),
        () -> InitItems.PINEAPPLE_PIE_SIDE), "pineapple_pie");
  }

  private static Block cake() {
    return registry(new BlockPineappleCake(), "pineapple_cake");
  }

  private static Block wildPineapple() {
    return registry(new BlockWildPineappleCrop(), "pineapple_wild_crop");
  }

  private static Block pineappleCrop() {
    return registry(new BlockPineappleCrop(), "pineapple_crop");
  }

  private static Block hugePineapple() {
    return registry(new Block(Properties.copy(Blocks.MELON)),
        "huge_pineapple");
  }

  private static Block pineappleCrate() {
    return registry(new Block(Properties.copy(Blocks.OAK_WOOD)),
        "pineapple_crate");
  }
}
