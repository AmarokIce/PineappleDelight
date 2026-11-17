package club.someoneice.pineapple;

import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.TabInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.ComposterBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
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
      ItemBlockRenderTypes.setRenderLayer(BlockList.HUGE_PINEAPPLE.get(), RenderType.cutout());
    });
  }

  public void init(FMLCommonSetupEvent event) {
    SEASON_INSTALL = FMLLoader.getLoadingModList().getModFileById("sereneseasons") != null;

    ComposterBlock.COMPOSTABLES.put(BlockList.PINEAPPLE_CROP_ITEM.get(), 0.65f);

    ComposterBlock.COMPOSTABLES.put(ItemList.PINEAPPLE.get(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(ItemList.PINEAPPLE_SIDE.get(), 0.2f);
    ComposterBlock.COMPOSTABLES.put(ItemList.PINEAPPLE_PIE_SIDE.get(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(ItemList.PINEAPPLE_CAKE_SLICE.get(), 0.3f);

    ComposterBlock.COMPOSTABLES.put(BlockList.PINEAPPLE_PIE_ITEM.get(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(BlockList.PINEAPPLE_CAKE_ITEM.get(), 1.0f);
  }
}
