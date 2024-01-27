package club.someoneice.pineapple_delight;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ItemInit {

    public static final Item PINEAPPLE_ITEM = itemFoodBase("pineapple", 3, 0.5f, true, false, false);
    public static final Item PINEAPPLE_SIDE = itemFoodBase("pineapple_side", 1, 0.5f, true, false, true);
    public static final Item PINEAPPLE_PIE_SIDE = itemFoodBase("pineapple_pie_side", 3, 0.1f, false, false, false);
    public static final Item PINEAPPLE_JUICE = itemFoodDrink("pineapple_juice", 5, 0.5f, false, false, Items.GLASS_BOTTLE, StatusEffects.JUMP_BOOST);
    public static final Item PINEAPPLE_FRIED_RICE = itemFoodBase("pineapple_fried_rice", 12, 0.4f, false, false, false);
    public static final Item PINEAPPLE_MILK_SHAKE = itemFoodDrink("pineapple_milk_shake", 5, 0.5f, false, false, Items.GLASS_BOTTLE, StatusEffects.HEALTH_BOOST);
    public static final Item PINEAPPLE_ICE_CREAM = itemFoodDrink("pineapple_ice_cream", 5, 0.5f, false, false, Items.GLASS_BOTTLE, StatusEffects.SPEED);

    public static final ItemGroup PINEAPPLE = ItemGroup.create(ItemGroup.Row.BOTTOM, 0).icon(PINEAPPLE_ITEM::getDefaultStack).displayName(Text.translatable("itemGroup.pineapple")).entries(
            ((displayContext, entries) -> {
                entries.add(PINEAPPLE_ITEM);
                entries.add(PINEAPPLE_SIDE);
                entries.add(PINEAPPLE_PIE_SIDE);
                entries.add(PINEAPPLE_JUICE);
                entries.add(PINEAPPLE_FRIED_RICE);
                entries.add(PINEAPPLE_MILK_SHAKE);
                entries.add(PINEAPPLE_ICE_CREAM);
            })
    ).build();


    private static Item itemFoodBase(String name, int hunger, float saturation, boolean wolf, boolean fast, boolean alwaysEat) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger).saturationModifier(saturation);
        if (wolf) builder.meat();
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new Item(new Item.Settings().food(builder.build())), name);
    }

    private static Item itemFoodDrink(String name, int hunger, float saturation, boolean fast, boolean alwaysEat, Item returnItem) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger).saturationModifier(saturation);
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new ItemDrink(new Item.Settings().food(builder.build())).setReturnItem(returnItem), name);
    }

    private static Item itemFoodDrink(String name, int hunger, float saturation, boolean fast, boolean alwaysEat, Item returnItem, StatusEffect ... effects) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger).saturationModifier(saturation);
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new ItemDrink(new Item.Settings().food(builder.build())).setReturnItem(returnItem).setEffect(effects), name);
    }

    private static Item registry(Item item, String name) {
        Registry.register(Registries.ITEM, new Identifier("pineapple_delight", name), item);
        return item;
    }

    private static class ItemDrink extends Item {
        ItemStack returnItem;
        StatusEffect[] effects = null;

        public ItemDrink(Settings settings) {
            super(settings);
        }

        public ItemDrink setReturnItem(ItemStack item) {
            this.returnItem = item;
            return this;
        }

        public ItemDrink setReturnItem(Item item) {
            this.returnItem = item.getDefaultStack();
            return this;
        }

        public ItemDrink setEffect(StatusEffect ... effect) {
            this.effects = effect;
            return this;
        }

                                   @Override
        public UseAction getUseAction(ItemStack stack) {
            return UseAction.DRINK;
        }

        @Override
        public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
            super.finishUsing(stack, world, user);
            if (!returnItem.isEmpty()) ((PlayerEntity) user).giveItemStack(returnItem);
            if (effects != null) for (StatusEffect effect : effects)
                user.addStatusEffect(new StatusEffectInstance(effect, 20 * 30, 1));

            return stack;
        }
    }
}
