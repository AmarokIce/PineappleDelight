package club.someoneice.pineapple.client;

import club.someoneice.pineapple.init.BlockList;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BlockRenderInit {
    @SubscribeEvent
    public static void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_WILD_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_CROP.get(), RenderType.cutout());
        });
    }
}