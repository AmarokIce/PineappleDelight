package club.someoneice.pineapple.data;

import club.someoneice.pineapple.common.DrinkItems;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ItemUtil {
    /**
     * Make a new item here.
     * @return - Item.
     */
    public static Item itemItems() {
        Item.Properties properties = new Item.Properties();
        properties.tab(ItemsGroup.TAB);
        return new Item(properties);
    }

    /**
     * Here make a new food item, use it in @ItemList.
     * @param hunger - Nutrition.
     * @param saturation - Saturation.
     * @param wolf - Can feed dogs.
     * @param alwaysEat - Can always eat.
     * @param fast - Can fast eat.
     * @return - ItemFood.
     */
    public static Item foodItems(int hunger, float saturation, boolean wolf, boolean alwaysEat, boolean fast) {
        Item.Properties properties = new Item.Properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();

        properties.tab(ItemsGroup.TAB);

        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        if (wolf) builder.meat();
        if (alwaysEat) builder.alwaysEat();
        if (fast) builder.fast();

        properties.food(builder.build());
        return new Item(properties);
    }

    public static Item foodDrinkItems(int hunger, float saturation, boolean alwaysEat, boolean fast) {
        Item.Properties properties = new Item.Properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();

        properties.tab(ItemsGroup.TAB);

        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        if (alwaysEat) builder.alwaysEat();
        if (fast) builder.fast();

        properties.food(builder.build());
        return new DrinkItems(properties);
    }
}
