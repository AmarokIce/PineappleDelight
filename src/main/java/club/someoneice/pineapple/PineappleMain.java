package club.someoneice.pineapple;

import club.someoneice.pineapple.event.VanillaEvent;
import club.someoneice.pineapple.gem.WildPineapple;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.data.ItemsGroup;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(PineappleMain.MODID)
public class PineappleMain
{
    public static final String MODID = "pineapple_delight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PineappleMain() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        new ItemsGroup();

        modEventBus.addListener(this::onRenderTypeSetup);
        ItemList.ITEMS.register(modEventBus);
        BlockList.BLOCKS.register(modEventBus);
        BlockList.BLOCK_ITEMS.register(modEventBus);

        WildPineapple.FEATURES.register(modEventBus);
        WildPineapple.PATCHES.register(modEventBus);

        // MinecraftForge.EVENT_BUS.register(new WorldEvent());
        MinecraftForge.EVENT_BUS.register(new VanillaEvent());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_WILD_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_CROP.get(), RenderType.cutout());
        });
    }
}
