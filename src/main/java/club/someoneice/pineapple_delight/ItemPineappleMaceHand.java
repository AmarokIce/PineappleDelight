package club.someoneice.pineapple_delight;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;

public class ItemPineappleMaceHand extends SwordItem {
  private static final Tier tier;

  public ItemPineappleMaceHand() {
    super(tier, 5, -2.4f, new Properties()
        .fireResistant()
        .food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.1f)
            .build()
        )
    );
  }

  @Override
  public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
    if (livingEntity instanceof Player player && !player.isCreative()) {
      stack.hurtAndBreak(4, livingEntity, (it) ->
          it.broadcastBreakEvent(player.getUsedItemHand()));
    }

    level.gameEvent(GameEvent.EAT, livingEntity.position(), Context.of(livingEntity));
    return super.finishUsingItem(stack, level, livingEntity);
  }

  static {
    tier = new Tier() {
      @Override
      public int getUses() {
        return 64;
      }

      @Override
      public float getSpeed() {
        return 1.6f;
      }

      @Override
      public float getAttackDamageBonus() {
        return 2;
      }

      @Override
      public int getLevel() {
        return 2;
      }

      @Override
      public int getEnchantmentValue() {
        return 8;
      }

      @Override
      public Ingredient getRepairIngredient() {
        return Ingredient.of(InitItems.PINEAPPLE, InitItems.PINEAPPLE_SIDE);
      }
    };
  }
}
