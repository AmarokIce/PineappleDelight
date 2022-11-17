package club.someoneice.pineapple

import net.minecraft.block.BlockState
import net.minecraft.block.CropBlock
import net.minecraft.block.Material
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView


class CropBlocksBase: CropBlock(Settings.of(Material.PLANT)) {
    override fun isTranslucent(state: BlockState, world: BlockView?, pos: BlockPos?): Boolean {
        return true
    }
}