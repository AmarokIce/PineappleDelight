package club.someoneice.pineapple_delight;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ModMainClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    registerRenderLayer();
  }

  private static void registerRenderLayer() {
    final var layerMap = BlockRenderLayerMap.INSTANCE;

    layerMap.putBlock(InitBlocks.PINEAPPLE_WILD_CROP, RenderType.cutout());
    layerMap.putBlock(InitBlocks.PINEAPPLE_CROP, RenderType.cutout());
    layerMap.putBlock(InitBlocks.HUGE_PINEAPPLE, RenderType.cutout());
  }
}
