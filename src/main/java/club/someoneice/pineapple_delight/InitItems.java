package club.someoneice.pineapple_delight;

import com.google.common.collect.Lists;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.List;

public class InitItems {
  public static final List<Item> ITEMS = Lists.newArrayList();

  public static final Item PINEAPPLE =
      itemFoodBase("pineapple", 3, 0.5f, false);
  public static final Item PINEAPPLE_SIDE =
      itemFoodBase("pineapple_side", 1, 0.5f, true);
  public static final Item PINEAPPLE_PIE_SIDE =
      itemFoodBase("pineapple_pie_side", 3, 0.1f, false);
  public static final Item PINEAPPLE_JUICE =
      itemFoodDrink("pineapple_juice", MobEffects.JUMP);
  public static final Item PINEAPPLE_FRIED_RICE =
      itemFoodBase("pineapple_fried_rice", 12, 0.4f, false);
  public static final Item PINEAPPLE_MILK_SHAKE =
      itemFoodDrink("pineapple_milk_shake", MobEffects.HEALTH_BOOST);
  public static final Item PINEAPPLE_ICE_CREAM =
      itemFoodDrink("pineapple_ice_cream", MobEffects.MOVEMENT_SPEED);
  public static final Item PINEAPPLE_CAKE_SLICE =
      itemFoodBase("pineapple_cake_slice", 3, 0.4f, false);
  public static final Item OLD_PINEAPPLE =
      registry(new ItemOldPineapple(), "pineapple_old");
  public static final Item GOLDEN_PINEAPPLE =
      registry(new ItemPineappleGolden(), "golden_pineapple");
  public static final Item PINEAPPLE_MACE =
      registry(new ItemPineappleMaceHand(), "pineapple_mace");

  private static Item itemFoodBase(String name, int hunger, float saturation,
                                   boolean alwaysEat) {
    var builder = new FoodProperties.Builder();
    builder.nutrition(hunger).saturationMod(saturation);
    if (alwaysEat) builder.alwaysEat();
    return registry(new Item(new Item.Properties()
        .tab(ModMainCore.TAB)
        .food(builder.build())), name);
  }

  private static Item registry(Item item, String name) {
    Registry.register(Registry.ITEM,
        new ResourceLocation("pineapple_delight", name), item);
    ITEMS.add(item);
    return item;
  }

  private static Item itemFoodDrink(String name, MobEffect... effects) {
    var builder = new FoodProperties.Builder();
    builder.nutrition(5).saturationMod((float) 0.5);
    return registry(new ItemDrink(new Item.Properties()
        .tab(ModMainCore.TAB)
        .food(builder.build()))
        .setReturnItem(Items.GLASS_BOTTLE)
        .setEffect(effects), name);
  }

  private static class ItemDrink extends Item {
    ItemStack returnItem;
    MobEffect[] effects = null;

    public ItemDrink(Properties settings) {
      super(settings);
    }

    public ItemDrink setReturnItem(Item item) {
      this.returnItem = item.getDefaultInstance();
      return this;
    }

    @SafeVarargs
    public final ItemDrink setEffect(MobEffect... effect) {
      this.effects = effect;
      return this;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
      return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
      super.finishUsingItem(stack, world, user);
      if (!returnItem.isEmpty()) ((Player) user).addItem(returnItem);
      if (effects != null) for (MobEffect effect : effects)
        user.addEffect(new MobEffectInstance(effect, 20 * 30, 1));

      return stack;
    }
  }
}
