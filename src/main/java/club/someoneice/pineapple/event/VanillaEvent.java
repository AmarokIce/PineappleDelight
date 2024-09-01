package club.someoneice.pineapple.event;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, modid = PineappleMain.MODID)
public class VanillaEvent {
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        var type = event.getType();
        if (type != VillagerProfession.FARMER) {
            return;
        }

        trades.get(2).add(new BasicItemListing(3, new ItemStack(ItemList.PINEAPPLE.get(), 2), 3, 12, 0.05F));
        trades.get(1).add(new BasicItemListing(1, new ItemStack(BlockList.PINEAPPLE_CROP_ITEM.get(), 1), 3, 12, 0.05F));
    }

    @SubscribeEvent
    public static void wandererTradesSell(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        trades.add(new BasicItemListing(3, new ItemStack(ItemList.PINEAPPLE.get(), 2), 3, 12, 0.05F));
        trades.add(new BasicItemListing(1, new ItemStack(BlockList.PINEAPPLE_CROP_ITEM.get(), 1), 3, 12, 0.05F));
    }
}
