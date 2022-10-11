package club.someoneice.pineapple;

import club.someoneice.pineapple.gem.WildPineapple;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.data.ItemsGroup;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(PineappleMain.MODID)
public class PineappleMain
{
    public static final String MODID = "pineapple_delight";
    private static final Logger LOGGER = LogUtils.getLogger();



    public PineappleMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        new ItemsGroup();

        modEventBus.addListener(this::commonSetup);
        BlockList.BLOCKS.register(modEventBus);
        ItemList.ITEMS.register(modEventBus);
        WildPineapple.FEATURES.register(modEventBus);
        WildPineapple.PATCHES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) { }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) { }
}
