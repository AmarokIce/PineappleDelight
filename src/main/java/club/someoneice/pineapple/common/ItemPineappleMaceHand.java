package club.someoneice.pineapple.common;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.init.ItemList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import org.jetbrains.annotations.NotNull;

public class ItemPineappleMaceHand extends SwordItem {
  private static final Tier tier = new Tier() {
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
    public TagKey<Block> getTag() {
      return BlockTags.create(
          new ResourceLocation(PineappleMain.MODID, "pineapple"));
    }

    @Override
    public int getEnchantmentValue() {
      return 8;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
      return Ingredient.of(ItemList.PINEAPPLE.get(), ItemList.PINEAPPLE_SIDE.get());
    }
  };

  public ItemPineappleMaceHand() {
    super(tier, 5, -2.4f,
        new Properties()
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
        it.broadcastBreakEvent(EquipmentSlot.MAINHAND));
    }
    level.gameEvent(GameEvent.EAT, livingEntity.position(),
        Context.of(livingEntity));
    return super.finishUsingItem(stack, level, livingEntity);
  }
}
