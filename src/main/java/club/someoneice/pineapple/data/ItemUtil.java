package club.someoneice.pineapple.data;

import club.someoneice.pineapple.common.ItemDrinkable;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ItemUtil {
  /**
   * Here make a new food item, use it in @ItemList.
   *
   * @param hunger     - Nutrition.
   * @param saturation - Saturation.
   * @param alwaysEat  - Can always eat.
   * @param fast       - Can fast eat.
   * @return - ItemFood.
   */
  private static Item food(int hunger, float saturation, boolean alwaysEat,
                               boolean fast, boolean fireResistant, boolean isDrink) {
    Item.Properties properties = new Item.Properties();
    FoodProperties.Builder builder = new FoodProperties.Builder();

    builder.nutrition(hunger);
    builder.saturationModifier(saturation);
    if (alwaysEat) builder.alwaysEdible();
    if (fast) builder.fast();
    if (fireResistant) properties.fireResistant();

    properties.food(builder.build());
    return !isDrink ? new Item(properties) : new ItemDrinkable(properties);
  }

  public static Item foodItems(int hunger, float saturation, boolean alwaysEat,
                                boolean fast, boolean fireResistant) {
    return food(hunger, saturation, alwaysEat, fast, fireResistant, false);
  }

  public static Item foodItems(int hunger, float saturation, boolean alwaysEat,
                               boolean fast) {
    return food(hunger, saturation, alwaysEat, fast, false, false);
  }

  public static Item foodDrinkItems(int hunger, float saturation, boolean alwaysEat,
                                    boolean fast) {
    return food(hunger, saturation, alwaysEat, fast, false, true);
  }
}
