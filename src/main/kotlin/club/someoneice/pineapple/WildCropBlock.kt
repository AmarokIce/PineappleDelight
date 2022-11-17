package club.someoneice.pineapple

import com.nhoryzon.mc.farmersdelight.block.WildPatchBlock
import net.minecraft.block.BlockState
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

class WildCropBlock: WildPatchBlock() {
    override fun isTranslucent(state: BlockState, world: BlockView?, pos: BlockPos?): Boolean {
        return true
    }
}