package club.someoneice.pineapple;

import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.TabInit;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Mod(PineappleMain.MODID)
public class PineappleMain {
    public static final String MODID = "pineapple_delight";
    private static final Logger LOGGER = LoggerFactory.getLogger(MODID);


    public static boolean SEASON_INSTALL = false;

    public PineappleMain(IEventBus modEventBus, ModContainer modContainer) {
        ItemList.ITEMS.register(modEventBus);
        BlockList.BLOCKS.register(modEventBus);
        BlockList.BLOCK_ITEMS.register(modEventBus);
        TabInit.TABS.register(modEventBus);

        modEventBus.addListener(this::onRenderTypeSetup);
        modEventBus.addListener(this::init);
    }

    public void onRenderTypeSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_WILD_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockList.PINEAPPLE_CROP.get(), RenderType.cutout());
        });
    }

    public void init(FMLCommonSetupEvent event) {
        SEASON_INSTALL = FMLLoader.getLoadingModList().getModFileById("sereneseasons") != null;
    }
}
