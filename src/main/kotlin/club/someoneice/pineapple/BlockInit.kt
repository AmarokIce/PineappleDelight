package club.someoneice.pineapple

import com.nhoryzon.mc.farmersdelight.block.PieBlock
import com.nhoryzon.mc.farmersdelight.registry.BlocksRegistry
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object BlockInit {
    val PINEAPPLE_PIE = PieBlock(ItemInit.PINEAPPLE_PIE_SIDE)

    val WILD_PINEAPPLE_CROP = WildCropBlock()
    val PINEAPPLE_CROP = CropBlocksBase()

    fun init() {
        Registry.register(Registry.BLOCK, Identifier(modid, "pineapple_pie"), PINEAPPLE_PIE)
        Registry.register(Registry.BLOCK, Identifier(modid, "pineapple_wild_crop"), WILD_PINEAPPLE_CROP)
        Registry.register(Registry.BLOCK, Identifier(modid, "pineapple_crop"), PINEAPPLE_CROP)

        /* Render corp blocks.*/
        registerRenderLayer()
    }

    @Environment(EnvType.CLIENT)
    fun registerRenderLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(PINEAPPLE_PIE, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(WILD_PINEAPPLE_CROP, RenderLayer.getCutout())
        BlockRenderLayerMap.INSTANCE.putBlock(PINEAPPLE_CROP, RenderLayer.getCutout())
    }
}