package club.someoneice.pineapple.init;

import club.someoneice.pineapple.data.ItemUtil;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static club.someoneice.pineapple.PineappleMain.MODID;

public class ItemList {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredHolder<Item, Item> PINEAPPLE = ITEMS.register("pineapple", () -> ItemUtil.foodItems(3, 0.5f, false, false));
    public static final DeferredHolder<Item, Item> PINEAPPLE_SIDE = ITEMS.register("pineapple_side", () -> ItemUtil.foodItems(1, 0.5f, false, true));
    public static final DeferredHolder<Item, Item> PINEAPPLE_PIE_SIDE = ITEMS.register("pineapple_pie_side", () -> ItemUtil.foodItems(3, 0.1f, false, false));
    public static final DeferredHolder<Item, Item> PINEAPPLE_JUICE = ITEMS.register("pineapple_juice", () -> ItemUtil.foodDrinkItems(5, 0.5f, false, false));
    public static final DeferredHolder<Item, Item> PINEAPPLE_FRIED_RICE = ITEMS.register("pineapple_fried_rice", () -> ItemUtil.foodItems(12, 0.4f, false, false));
    public static final DeferredHolder<Item, Item> PINEAPPLE_MILK_SHAKE = ITEMS.register("pineapple_milk_shake", () -> ItemUtil.foodDrinkItems(5, 0.5f, false, false));
    public static final DeferredHolder<Item, Item> PINEAPPLE_ICE_CREAM = ITEMS.register("pineapple_ice_cream", () -> ItemUtil.foodDrinkItems(5, 0.5f, false, false));
}
