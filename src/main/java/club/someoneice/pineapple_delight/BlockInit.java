package club.someoneice.pineapple_delight;

import com.nhoryzon.mc.farmersdelight.block.PieBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockInit {
    public static final Block PINEAPPLE_PIE = registry(new PieBlock(ItemInit.PINEAPPLE_PIE_SIDE), "pineapple_pie");
    public static final Block PINEAPPLE_WILD_CROP = registry(new CropBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().nonOpaque().ticksRandomly()), "pineapple_wild_crop");
    public static final Block PINEAPPLE_CROP = registry(new CropBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().nonOpaque().ticksRandomly()), "pineapple_crop");
    public static final Block PINEAPPLE_BLOCK = registry(new Block(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)), "pineapple_crate");

    private static Block registry(Block block, String name) {
        Registry.register(Registry.BLOCK, new Identifier("pineapple_delight", name), block);
        Registry.register(Registry.ITEM, new Identifier("pineapple_delight", name), new BlockItem(block, new Item.Settings().group(ItemInit.PINEAPPLE)));
        return block;
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(PINEAPPLE_WILD_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PINEAPPLE_CROP, RenderLayer.getCutout());
    }
}
