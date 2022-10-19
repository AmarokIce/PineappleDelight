package club.someoneice.pineapple;

import club.someoneice.pineapple.gem.WildPineapple;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.data.ItemsGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PineappleMain.MODID)
public class PineappleMain {
    public static final String MODID = "pineapple_delight";

    public PineappleMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        new ItemsGroup();

        modEventBus.addListener(this::commonSetup);
        BlockList.BLOCKS.register(modEventBus);
        ItemList.ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event){
        event.enqueueWork(() -> {
            WildPineapple.register();
        });
    }
}
