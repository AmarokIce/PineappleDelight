package club.someoneice.pineapple_delight;

import net.fabricmc.api.ClientModInitializer;

public class PineappleClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockInit.registerRenderLayer();
    }
}
