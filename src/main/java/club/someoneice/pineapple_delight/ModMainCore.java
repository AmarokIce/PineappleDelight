package club.someoneice.pineapple_delight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.ComposterBlock;

public class ModMainCore implements ModInitializer {
  public static final String ID = "pineapple_delight";


  public static boolean SEASON_INSTALL;

  @Override
  public void onInitialize() {
    SEASON_INSTALL = FabricLoader.getInstance().isModLoaded("seasons");
    new InitItems();
    new InitBlocks();
    InitFeatures.boot();

    var itemGroup = FabricItemGroup.builder().icon(InitItems.PINEAPPLE::getDefaultInstance)
        .title(Component.translatable("itemGroup.pineapple_delight"))
        .displayItems((displayContext, entries) ->
            InitItems.ITEMS.forEach(entries::accept))
        .build();

    Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
        ResourceLocation.fromNamespaceAndPath("pineapple_delight", "pineapple_tab"),
        itemGroup);

    ComposterBlock.COMPOSTABLES.put(InitBlocks.PINEAPPLE_CROP, 0.65f);
    ComposterBlock.COMPOSTABLES.put(InitItems.PINEAPPLE_SIDE, 0.65f);

    ComposterBlock.COMPOSTABLES.put(InitItems.PINEAPPLE, 0.85f);
    ComposterBlock.COMPOSTABLES.put(InitItems.PINEAPPLE_PIE_SIDE, 0.85f);

    ComposterBlock.COMPOSTABLES.put(InitBlocks.PINEAPPLE_PIE, 1.0f);
  }
}
