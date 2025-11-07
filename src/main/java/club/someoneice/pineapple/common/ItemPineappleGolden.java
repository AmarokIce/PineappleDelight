package club.someoneice.pineapple.common;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties.Builder;
import net.minecraft.world.item.Item;

public class ItemPineappleGolden extends Item {
  public ItemPineappleGolden() {
    super(new Properties()
        .fireResistant()
        .food(
        new Builder()
            .nutrition(6)
            .saturationModifier(1.2f)
            .effect(() ->
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 600),
                1.0f)
            .effect(() ->
                new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900),
                1.0f)
            .effect(() ->
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3000),
                1.0f)
            .effect(() ->
                new MobEffectInstance(MobEffects.HEALTH_BOOST, 600),
                1.0f)
            .build()
    ));
  }
}
