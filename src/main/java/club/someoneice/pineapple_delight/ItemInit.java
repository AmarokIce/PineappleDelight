package club.someoneice.pineapple_delight;

import com.google.common.collect.Lists;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = Lists.newArrayList();

    public static final Item PINEAPPLE_ITEM = itemFoodBase("pineapple", 3, 0.5f, true, false, false);
    public static final Item PINEAPPLE_SIDE = itemFoodBase("pineapple_side", 1, 0.5f, true, false, true);
    public static final Item PINEAPPLE_PIE_SIDE = itemFoodBase("pineapple_pie_side", 3, 0.1f, false, false, false);
    public static final Item PINEAPPLE_JUICE = itemFoodDrink("pineapple_juice", StatusEffects.JUMP_BOOST);
    public static final Item PINEAPPLE_FRIED_RICE = itemFoodBase("pineapple_fried_rice", 12, 0.4f, false, false, false);
    public static final Item PINEAPPLE_MILK_SHAKE = itemFoodDrink("pineapple_milk_shake", StatusEffects.HEALTH_BOOST);
    public static final Item PINEAPPLE_ICE_CREAM = itemFoodDrink("pineapple_ice_cream", StatusEffects.SPEED);


    private static Item itemFoodBase(String name, int hunger, float saturation, boolean wolf, boolean fast, boolean alwaysEat) {
        var builder = new FoodComponent.Builder();
        builder.hunger(hunger).saturationModifier(saturation);
        if (wolf) builder.meat();
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new Item(new Item.Settings().food(builder.build())), name);
    }

    private static Item itemFoodDrink(String name, StatusEffect ... effects) {
        var builder = new FoodComponent.Builder();
        builder.hunger(5).saturationModifier((float) 0.5);
        if (false) builder.snack();
        if (false) builder.alwaysEdible();
        return registry(new ItemDrink(new Item.Settings().food(builder.build())).setReturnItem(Items.GLASS_BOTTLE).setEffect(effects), name);
    }

    private static Item registry(Item item, String name) {
        Registry.register(Registries.ITEM, new Identifier("pineapple_delight", name), item);
        ITEMS.add(item);
        return item;
    }

    private static class ItemDrink extends Item {
        ItemStack returnItem;
        StatusEffect[] effects = null;

        public ItemDrink(Settings settings) {
            super(settings);
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
