package club.someoneice.pineapple

import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.Item.Settings
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


object ItemInit {
    /* Foods Items */
    val PINEAPPLE: Item = ItemFoods(3, 0.5f, true, false, false)
    val PINEAPPLE_SIDE: Item = ItemFoods(1, 0.5f, true, false, true)
    val PINEAPPLE_PIE_SIDE: Item = ItemFoods(3, 0.5f, false, false, false)
    val PINEAPPLE_JUICE: Item = ItemFoods(5, 0.5f, false, false)
    val PINEAPPLE_FRIED_RICE: Item = ItemFoods(12, 0.4f, false, false, false)
    val PINEAPPLE_MILK_SHAKE: Item = ItemFoods(5, 0.5f, false, false)
    val PINEAPPLE_ICE_CREAM: Item = ItemFoods(5, 0.5f, false, false)

    /* Block Items */
    val PINEAPPLE_PIE = ItemBlockItems(BlockInit.PINEAPPLE_PIE)
    val PINEAPPLE_CROP = ItemBlockItems(BlockInit.PINEAPPLE_CROP)
    val PINEAPPLE_WILE_CROP = ItemBlockItems(BlockInit.WILD_PINEAPPLE_CROP)

    fun init() {
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple"), PINEAPPLE)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_side"), PINEAPPLE_SIDE)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_pie_side"), PINEAPPLE_PIE_SIDE)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_juice"), PINEAPPLE_JUICE)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_fried_rice"), PINEAPPLE_FRIED_RICE)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_milk_shake"), PINEAPPLE_MILK_SHAKE)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_ice_cream"), PINEAPPLE_ICE_CREAM)

        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_pie"), PINEAPPLE_PIE)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_wild_crop"), PINEAPPLE_CROP)
        Registry.register(Registry.ITEM, Identifier(modid, "pineapple_crop"), PINEAPPLE_WILE_CROP)
    }


    fun ItemBlockItems(block: Block): Item {
        return BlockItem(block, Settings().group(PineappleGroup))
    }

    fun ItemFoods(hunger: Int, saturation: Float, wolf: Boolean, alwaysEat: Boolean, fast: Boolean, count: Int): Item {
        val set: Settings = Settings()
        val build: FoodComponent.Builder = FoodComponent.Builder()
        set.group(PineappleGroup)
        set.maxCount(count)

        build.hunger(hunger)
        build.saturationModifier(saturation)
        if (wolf) build.meat()
        if (fast) build.snack()
        if (alwaysEat) build.alwaysEdible()

        set.food(build.build())
        return Item(set)
    }

    fun ItemFoods(hunger: Int, saturation: Float, wolf: Boolean, alwaysEat: Boolean, fast: Boolean): Item {
        val set: Settings = Settings()
        val build: FoodComponent.Builder = FoodComponent.Builder()
        set.group(PineappleGroup)

        build.hunger(hunger)
        build.saturationModifier(saturation)
        if (wolf) build.meat()
        if (fast) build.snack()
        if (alwaysEat) build.alwaysEdible()

        set.food(build.build())
        return Item(set)
    }

    fun ItemFoods(hunger: Int, saturation: Float, alwaysEat: Boolean, fast: Boolean): Item {
        val set: Settings = Settings()
        val build: FoodComponent.Builder = FoodComponent.Builder()
        set.group(PineappleGroup)

        build.hunger(hunger)
        build.saturationModifier(saturation)
        if (fast) build.snack()
        if (alwaysEat) build.alwaysEdible()

        set.food(build.build())
        return DrinkItem(set)
    }
}