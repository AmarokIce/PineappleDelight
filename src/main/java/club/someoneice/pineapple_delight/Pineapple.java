package club.someoneice.pineapple_delight;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class Pineapple implements ModInitializer {
    public static boolean SEASON_INSTALL;

    @Override
    public void onInitialize() {
        SEASON_INSTALL = FabricLoader.getInstance().isModLoaded("seasons");

        new ItemInit();
        new BlockInit();
    }
}
