package club.someoneice.pineapple_delight;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ItemInit {
    public static final ItemGroup PINEAPPLE = FabricItemGroupBuilder.create(new Identifier("pineapple_delight", "pineapple")).icon(() -> new ItemStack(ItemInit.PINEAPPLE_ITEM)).build();

    public static final Item PINEAPPLE_ITEM = itemFoodBase("pineapple", 3, 0.5f, true, false, false);
    public static final Item PINEAPPLE_SIDE = itemFoodBase("pineapple_side", 1, 0.5f, true, false, true);
    public static final Item PINEAPPLE_PIE_SIDE = itemFoodBase("pineapple_pie_side", 3, 0.1f, false, false, false);
    public static final Item PINEAPPLE_JUICE = itemFoodDrink("pineapple_juice", 5, 0.5f, false, false, Items.GLASS_BOTTLE, StatusEffects.JUMP_BOOST);
    public static final Item PINEAPPLE_FRIED_RICE = itemFoodBase("pineapple_fried_rice", 12, 0.4f, false, false, false);
    public static final Item PINEAPPLE_MILK_SHAKE = itemFoodDrink("pineapple_milk_shake", 5, 0.5f, false, false, Items.GLASS_BOTTLE, StatusEffects.HEALTH_BOOST);
    public static final Item PINEAPPLE_ICE_CREAM = itemFoodDrink("pineapple_ice_cream", 5, 0.5f, false, false, Items.GLASS_BOTTLE, StatusEffects.SPEED);


    private static Item itemBase(String name) {
        return registry(new Item(new Item.Settings().group(PINEAPPLE)), name);
    }

    private static Item itemFoodBase(String name, int hunger, float saturation, boolean wolf, boolean fast, boolean alwaysEat) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger).saturationModifier(saturation);
        if (wolf) builder.meat();
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new Item(new Item.Settings().group(PINEAPPLE).food(builder.build())), name);
    }

    private static Item itemFoodDrink(String name, int hunger, float saturation, boolean fast, boolean alwaysEat, Item returnItem) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger).saturationModifier(saturation);
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new ItemDrink(new Item.Settings().group(PINEAPPLE).food(builder.build())).setReturnItem(returnItem), name);
    }

    private static Item itemFoodDrink(String name, int hunger, float saturation, boolean fast, boolean alwaysEat, Item returnItem, StatusEffect ... effects) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger).saturationModifier(saturation);
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new ItemDrink(new Item.Settings().group(PINEAPPLE).food(builder.build())).setReturnItem(returnItem).setEffect(effects), name);
    }

    private static Item registry(Item item, String name) {
        Registry.register(Registry.ITEM, new Identifier("pineapple_delight", name), item);
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
            if (!returnItem.isItemEqual(ItemStack.EMPTY)) ((PlayerEntity) user).giveItemStack(returnItem);
            if (effects != null) for (StatusEffect effect : effects)
                user.addStatusEffect(new StatusEffectInstance(effect, 20 * 30, 1));

            return stack;
        }
    }
}
