package club.someoneice.pineapple;

import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.SoundList;
import club.someoneice.pineapple.init.TabInit;
import com.starmeow.starmeowcraft.StarMeowCraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@Mod(PineappleMain.MODID)
public class PineappleMain {
  public static final String MODID = "pineapple_delight";
  private static final Logger LOGGER = LoggerFactory.getLogger(MODID);

  public static boolean SEASON_INSTALL = false;
  public static boolean SMC_INSTALL = false;

  public PineappleMain() {
    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    ItemList.ITEMS.register(modEventBus);
    BlockList.BLOCKS.register(modEventBus);
    BlockList.BLOCK_ITEMS.register(modEventBus);
    SoundList.SOUNDS.register(modEventBus);
    TabInit.TABS.register(modEventBus);

    modEventBus.addListener(this::onRenderTypeSetup);
    modEventBus.addListener(this::init);
  }

  // 看来有些东西我弄乱了，而安全的修改方式就是创建对象。别担心，这些垃圾很快就会被回收。
  private static void fixCandleCakes() throws NoSuchFieldException, IllegalAccessException {
    var field = CandleCakeBlock.class.getDeclaredField("BY_CANDLE");
    field.setAccessible(true);
    var map = (Map<Block, CandleCakeBlock>) field.get(null);

    map.put(Blocks.CANDLE, (CandleCakeBlock) Blocks.CANDLE_CAKE);
    map.put(Blocks.WHITE_CANDLE, (CandleCakeBlock) Blocks.WHITE_CANDLE_CAKE);
    map.put(Blocks.ORANGE_CANDLE, (CandleCakeBlock) Blocks.ORANGE_CANDLE_CAKE);
    map.put(Blocks.MAGENTA_CANDLE, (CandleCakeBlock) Blocks.MAGENTA_CANDLE_CAKE);
    map.put(Blocks.LIGHT_BLUE_CANDLE, (CandleCakeBlock) Blocks.LIGHT_BLUE_CANDLE_CAKE);
    map.put(Blocks.YELLOW_CANDLE, (CandleCakeBlock) Blocks.YELLOW_CANDLE_CAKE);
    map.put(Blocks.LIME_CANDLE, (CandleCakeBlock) Blocks.LIME_CANDLE_CAKE);
    map.put(Blocks.PINK_CANDLE, (CandleCakeBlock) Blocks.PINK_CANDLE_CAKE);
    map.put(Blocks.GRAY_CANDLE, (CandleCakeBlock) Blocks.GRAY_CANDLE_CAKE);
    map.put(Blocks.LIGHT_GRAY_CANDLE, (CandleCakeBlock) Blocks.LIGHT_GRAY_CANDLE_CAKE);
    map.put(Blocks.CYAN_CANDLE, (CandleCakeBlock) Blocks.CYAN_CANDLE_CAKE);
    map.put(Blocks.PURPLE_CANDLE, (CandleCakeBlock) Blocks.PURPLE_CANDLE_CAKE);
    map.put(Blocks.BLUE_CANDLE, (CandleCakeBlock) Blocks.BLUE_CANDLE_CAKE);
    map.put(Blocks.BROWN_CANDLE, (CandleCakeBlock) Blocks.BROWN_CANDLE_CAKE);
    map.put(Blocks.GREEN_CANDLE, (CandleCakeBlock) Blocks.GREEN_CANDLE_CAKE);
    map.put(Blocks.RED_CANDLE, (CandleCakeBlock) Blocks.RED_CANDLE_CAKE);
    map.put(Blocks.BLACK_CANDLE, (CandleCakeBlock) Blocks.BLACK_CANDLE_CAKE);
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
    SMC_INSTALL = FMLLoader.getLoadingModList().getModFileById("smc") != null;

    ComposterBlock.COMPOSTABLES.put(BlockList.PINEAPPLE_CROP_ITEM.get(), 0.1f);

    ComposterBlock.COMPOSTABLES.put(ItemList.PINEAPPLE.get(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(ItemList.PINEAPPLE_SIDE.get(), 0.2f);
    ComposterBlock.COMPOSTABLES.put(ItemList.PINEAPPLE_PIE_SIDE.get(), 0.25f);

    ComposterBlock.COMPOSTABLES.put(BlockList.PINEAPPLE_PIE_ITEM.get(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(BlockList.PINEAPPLE_CAKE_ITEM.get(), 1.0f);

    try {
      fixCandleCakes();
    } catch (NoSuchFieldException | IllegalAccessException e) {
      // This will never be happening.
    }

  }
}
