package club.someoneice.pineapple_delight;

import com.google.common.collect.Lists;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
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
        builder.nutrition(hunger).saturationModifier(saturation);
        if (fast) builder.snack();
        if (alwaysEat) builder.alwaysEdible();
        return registry(new Item(new Item.Settings().food(builder.build())), name);
    }

    private static Item registry(Item item, String name) {
        Registry.register(Registries.ITEM, Identifier.of("pineapple_delight", name), item);
        ITEMS.add(item);
        return item;
    }
    
    private static Item itemFoodDrink(String name, RegistryEntry<StatusEffect> ... effects) {
        var builder = new FoodComponent.Builder();
        builder.nutrition(5).saturationModifier((float) 0.5);
        return registry(new ItemDrink(new Item.Settings().food(builder.build())).setReturnItem(Items.GLASS_BOTTLE).setEffect(effects), name);
    }

    private static class ItemDrink extends Item {
        ItemStack returnItem;
        RegistryEntry<StatusEffect>[] effects = null;

        public ItemDrink(Settings settings) {
            super(settings);
        }

        public ItemDrink setReturnItem(Item item) {
            this.returnItem = item.getDefaultStack();
            return this;
        }

        public ItemDrink setEffect(RegistryEntry<StatusEffect> ... effect) {
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
            if (effects != null) for (RegistryEntry<StatusEffect> effect : effects)
                user.addStatusEffect(new StatusEffectInstance(effect, 20 * 30, 1));

            return stack;
        }
    }
}
