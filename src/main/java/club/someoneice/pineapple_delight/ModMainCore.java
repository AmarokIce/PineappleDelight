package club.someoneice.pineapple_delight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ComposterBlock;

public class ModMainCore implements ModInitializer {
  public static final String ID = "pineapple_delight";

  public static final CreativeModeTab TAB = new CreativeModeTab(-1, "pineapple_delight") {
    @Override
    public ItemStack makeIcon() {
      return InitItems.PINEAPPLE.getDefaultInstance();
    }
  };

  public static boolean SEASON_INSTALL;

  @Override
  public void onInitialize() {
    SEASON_INSTALL = FabricLoader.getInstance().isModLoaded("seasons");
    new InitItems();
    new InitBlocks();
    InitFeatures.boot();

    ComposterBlock.COMPOSTABLES.put(InitBlocks.PINEAPPLE_CROP.asItem(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(InitItems.PINEAPPLE_SIDE, 0.65f);

    ComposterBlock.COMPOSTABLES.put(InitItems.PINEAPPLE, 0.65f);
    ComposterBlock.COMPOSTABLES.put(InitItems.PINEAPPLE_SIDE, 0.2f);
    ComposterBlock.COMPOSTABLES.put(InitItems.PINEAPPLE_PIE_SIDE, 0.55f);

    ComposterBlock.COMPOSTABLES.put(InitBlocks.PINEAPPLE_PIE.asItem(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(InitBlocks.PINEAPPLE_CAKE.asItem(), 1.0f);
  }
}
