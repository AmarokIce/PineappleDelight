package club.someoneice.pineapple.common;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class DrinkItems extends Item {

    public DrinkItems(Properties properties) {
        super(properties);
    }

    @Nonnull @Override
    public UseAction getUseAnimation(ItemStack itemStack) {
        return UseAction.DRINK;
    }

   @Nonnull @Override
    public ItemStack finishUsingItem(ItemStack itemStack, World world, LivingEntity entityLiving) {
        super.finishUsingItem(itemStack, world, entityLiving);
        if (itemStack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            PlayerEntity player = (PlayerEntity) entityLiving;
            if (!player.inventory.add(new ItemStack(Items.GLASS_BOTTLE))) {
                player.drop(new ItemStack(Items.GLASS_BOTTLE), false);
            }
        }
        return itemStack;
    }
}
