package club.someoneice.pineapple.common;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class ItemDrinkable extends Item {

  public ItemDrinkable(Properties properties) {
    super(properties);
  }

  @Nonnull
  @Override
  public UseAnim getUseAnimation(ItemStack itemStack) {
    return UseAnim.DRINK;
  }

  @Nonnull
  @Override
  public ItemStack finishUsingItem(final ItemStack itemStack,
                                   final Level world,
                                   final LivingEntity entityLiving) {
    super.finishUsingItem(itemStack, world, entityLiving);
    if (!(entityLiving instanceof ServerPlayer serverPlayer)) {
      return itemStack;
    }

    CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
    serverPlayer.awardStat(Stats.ITEM_USED.get(this));

    final ItemStack glassBottle = new ItemStack(Items.GLASS_BOTTLE);

    if (itemStack.isEmpty()) {
      return glassBottle;
    }

    if (serverPlayer.isCreative()) {
      return itemStack;
    }

    if (!serverPlayer.getInventory().add(glassBottle)) {
      serverPlayer.drop(glassBottle, false);
    }

    return itemStack;
  }
}
