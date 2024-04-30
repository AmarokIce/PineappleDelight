package club.someoneice.pineapple_delight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static club.someoneice.pineapple_delight.ItemInit.PINEAPPLE_ITEM;

public class Pineapple implements ModInitializer {
    public static boolean SEASON_INSTALL;

    @Override
    public void onInitialize() {
        SEASON_INSTALL = FabricLoader.getInstance().isModLoaded("seasons");
        new ItemInit();
        new BlockInit();
        FeatureInit.boot();

        var itemGroup = FabricItemGroup.builder().icon(PINEAPPLE_ITEM::getDefaultStack)
                .displayName(Text.translatable("itemGroup.pineapple")).entries((displayContext, entries) -> ItemInit.ITEMS.forEach(entries::add))
                .build();

        Registry.register(Registries.ITEM_GROUP, Identifier.of("pineapple_delight", "pineapple_tab"), itemGroup);
    }
}
