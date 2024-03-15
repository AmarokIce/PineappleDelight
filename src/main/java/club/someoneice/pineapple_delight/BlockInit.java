package club.someoneice.pineapple_delight;

import com.nhoryzon.mc.farmersdelight.block.PieBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BlockInit {
    public static final Block PINEAPPLE_BLOCK = registryPineapple();
    public static final Block PINEAPPLE_PIE = registry(new PieBlock(ItemInit.PINEAPPLE_PIE_SIDE), "pineapple_pie");
    public static final Block PINEAPPLE_WILD_CROP = registry(new PlantBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)), "pineapple_wild_crop");
    public static final Block PINEAPPLE_CROP = registry(new PineappleCrop(), "pineapple_crop");
    public static final Block PINEAPPLE_CRATE_BLOCK = registry(new Block(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)), "pineapple_crate");

    private static Block registry(Block block, String name) {
        Registry.register(Registries.BLOCK, new Identifier("pineapple_delight", name), block);
        var item = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, new Identifier("pineapple_delight", name), item);

        ItemInit.ITEMS.add(item);
        return block;
    }

    private static Block registryPineapple() {
        var block = new BlockPineapple();
        Registry.register(Registries.BLOCK, new Identifier("pineapple_delight", "pineapple"), block);
        return block;
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(PINEAPPLE_WILD_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PINEAPPLE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PINEAPPLE_BLOCK, RenderLayer.getCutout());
    }
}
