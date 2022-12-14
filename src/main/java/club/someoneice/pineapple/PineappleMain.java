package club.someoneice.pineapple;

import club.someoneice.pineapple.gem.WildPineapple;
import club.someoneice.pineapple.gem.WorldEvent;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.data.ItemsGroup;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
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

        modEventBus.addListener(this::commonSetup);
        ItemList.ITEMS.register(modEventBus);
        BlockList.BLOCKS.register(modEventBus);
        BlockList.BLOCK_ITEMS.register(modEventBus);

        WildPineapple.FEATURES.register(modEventBus);
        WildPineapple.PATCHES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new WorldEvent());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) { }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) { }
}
