package club.someoneice.pineapple;

import club.someoneice.pineapple.event.VanillaEvent;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.TabInit;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import org.slf4j.Logger;

@Mod(PineappleMain.MODID)
public class PineappleMain {
    public static final String MODID = "pineapple_delight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static Boolean SEASON_INSTALL;

    public PineappleMain() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemList.ITEMS.register(modEventBus);
        BlockList.BLOCKS.register(modEventBus);
        BlockList.BLOCK_ITEMS.register(modEventBus);
        TabInit.TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new VanillaEvent());
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::onRenderTypeSetup);
    }

    @SubscribeEvent
    public void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_WILD_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_CROP.get(), RenderType.cutout());
        });
    }

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        SEASON_INSTALL = FMLLoader.getLoadingModList().getModFileById("sereneseasons") != null;
    }
}
