package club.someoneice.pineapple.common;

import club.someoneice.pineapple.PineappleMain;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.Nonnull;

public class ItemDrinkable extends Item {

  public ItemDrinkable(Properties properties) {
    super(properties.tab(PineappleMain.PINEAPPLE_TAB));
  }

  @Nonnull
  @Override
  public UseAnim getUseAnimation(final ItemStack itemStack) {
    return UseAnim.DRINK;
  }

  @Nonnull
  @Override
  public ItemStack finishUsingItem(final ItemStack itemStack,
                                   final Level world,
                                   final LivingEntity entityLiving) {
    super.finishUsingItem(itemStack, world, entityLiving);
    if (entityLiving instanceof ServerPlayer serverPlayer) {
      CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, itemStack);
      serverPlayer.awardStat(Stats.ITEM_USED.get(this));
    }

    if (itemStack.isEmpty()) {
      return new ItemStack(Items.GLASS_BOTTLE);
    }

    if (entityLiving instanceof Player player
        && !player.getAbilities().instabuild
        && !player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE))
    ) {
      player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
    }
    return itemStack;
  }
}
