package club.someoneice.pineapple_delight;

import net.fabricmc.api.ModInitializer;

public class Pineapple implements ModInitializer {
    @Override
    public void onInitialize() {
        new ItemInit();
        new BlockInit();

        WildPineapple.register();
    }
}
