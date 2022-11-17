package club.someoneice.pineapple

import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.UseAction
import net.minecraft.world.World

class DrinkItem(settings: Settings): Item(settings) {
    override fun getUseAction(stack: ItemStack?): UseAction {
        return UseAction.DRINK
    }

    override fun finishUsing(stack: ItemStack?, world: World?, user: LivingEntity?): ItemStack {
        super.finishUsing(stack, world, user)
        return ItemStack(Items.GLASS_BOTTLE)
    }
}