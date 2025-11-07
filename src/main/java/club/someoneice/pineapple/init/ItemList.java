package club.someoneice.pineapple.init;

import club.someoneice.pineapple.common.ItemOldPineapple;
import club.someoneice.pineapple.common.ItemPineappleGolden;
import club.someoneice.pineapple.common.ItemPineappleMaceHand;
import club.someoneice.pineapple.data.ItemUtil;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static club.someoneice.pineapple.PineappleMain.MODID;

public final class ItemList {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

  public static final DeferredItem<Item> PINEAPPLE =
      ITEMS.register("pineapple", () ->
          ItemUtil.foodItems(3, 0.5f, false, false, true));
  public static final DeferredItem<Item> PINEAPPLE_SIDE =
      ITEMS.register("pineapple_side", () ->
          ItemUtil.foodItems(1, 0.5f, false, true));
  public static final DeferredItem<Item> PINEAPPLE_PIE_SIDE =
      ITEMS.register("pineapple_pie_side", () ->
          ItemUtil.foodItems(3, 0.1f, false, false));
  public static final DeferredItem<Item> PINEAPPLE_JUICE =
      ITEMS.register("pineapple_juice", () ->
          ItemUtil.foodDrinkItems(5, 0.5f, false, false));
  public static final DeferredItem<Item> PINEAPPLE_FRIED_RICE =
      ITEMS.register("pineapple_fried_rice", () ->
          ItemUtil.foodItems(12, 0.4f, false, false));
  public static final DeferredItem<Item> PINEAPPLE_MILK_SHAKE =
      ITEMS.register("pineapple_milk_shake", () ->
          ItemUtil.foodDrinkItems(5, 0.5f, false, false));
  public static final DeferredItem<Item> PINEAPPLE_ICE_CREAM =
      ITEMS.register("pineapple_ice_cream", () ->
          ItemUtil.foodDrinkItems(5, 0.5f, false, false));
  public static final DeferredItem<Item> PINEAPPLE_CAKE_SLICE =
      ITEMS.register("pineapple_cake_slice", () ->
          ItemUtil.foodItems(3, 0.4f, false, true));
  public static final DeferredItem<Item> PINEAPPLE_OLD =
      ITEMS.register("pineapple_old", ItemOldPineapple::new);
  public static final DeferredItem<Item> PINEAPPLE_MACE_HAND =
      ITEMS.register("pineapple_mace_hand", ItemPineappleMaceHand::new);
  public static final DeferredItem<Item> GOLDEN_PINEAPPLE =
      ITEMS.register("golden_pineapple", ItemPineappleGolden::new);
}
