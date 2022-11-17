package club.someoneice.pineapple

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier

const val modid: String = "pineapple_delight"

val PineappleGroup: ItemGroup = FabricItemGroupBuilder.build(
    Identifier(modid, "pineapple")
) { ItemStack(Items.CAKE) }

fun init() {
    ItemInit.init()
    BlockInit.init()
}
