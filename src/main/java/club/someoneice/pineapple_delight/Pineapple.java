package club.someoneice.pineapple_delight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.ComposterBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Pineapple implements ModInitializer {
    public static boolean SEASON_INSTALL;

    @Override
    public void onInitialize() {
        SEASON_INSTALL = FabricLoader.getInstance().isModLoaded("seasons");
        new ItemInit();
        new BlockInit();
        FeatureInit.boot();

        var itemGroup = FabricItemGroup.builder().icon(ItemInit.PINEAPPLE_ITEM::getDefaultStack)
                .displayName(Text.translatable("itemGroup.pineapple"))
                .entries((displayContext, entries) -> ItemInit.ITEMS.forEach(entries::add))
                .build();

        Registry.register(Registries.ITEM_GROUP, Identifier.of("pineapple_delight", "pineapple_tab"), itemGroup);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.PINEAPPLE_CROP, 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.PINEAPPLE_SIDE, 0.65f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.PINEAPPLE_ITEM, 0.85f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ItemInit.PINEAPPLE_PIE_SIDE, 0.85f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(BlockInit.PINEAPPLE_PIE, 1.0f);
    }
}
