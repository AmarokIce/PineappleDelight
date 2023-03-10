package club.someoneice.pineapple.event;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = PineappleMain.MODID)
public class VanillaEvent {
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        ResourceLocation professionKey = ForgeRegistries.VILLAGER_PROFESSIONS.getKey(event.getType());
        if (professionKey != null && professionKey.getNamespace().equals("farmer")) {
            trades.get(2).add(new BasicItemListing(3, new ItemStack(ItemList.PINEAPPLE.get(), 2), 3, 12, 0.05F));
            trades.get(1).add(new BasicItemListing(1, new ItemStack(BlockList.PINEAPPLE_CROP_ITEM.get(), 1), 3, 12, 0.05F));
        }
    }

    @SubscribeEvent
    public void wandererTradesSell(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        trades.add(new BasicItemListing(3, new ItemStack(ItemList.PINEAPPLE.get(), 2), 3, 12, 0.05F));
        trades.add(new BasicItemListing(1, new ItemStack(BlockList.PINEAPPLE_CROP_ITEM.get(), 1), 3, 12, 0.05F));
    }
}
