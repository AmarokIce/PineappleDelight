package club.someoneice.pineapple.common;

import club.someoneice.pineapple.PineappleMain;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public final class ItemOldPineapple extends Item {
  public ItemOldPineapple() {
    super(new Properties()
        .tab(PineappleMain.PINEAPPLE_TAB)
        .rarity(Rarity.RARE)
        .fireResistant()
        .food(new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(2.0f)
            .effect(() -> new MobEffectInstance(
                MobEffects.REGENERATION, 100, 1), 1.0F)
            .effect(() -> new MobEffectInstance(
                MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .alwaysEat()
            .build()
    ));
  }
}
