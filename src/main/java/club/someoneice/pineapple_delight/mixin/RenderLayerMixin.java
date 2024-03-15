package club.someoneice.pineapple_delight.mixin;

/*
import club.someoneice.pineapple_delight.BlockInit;
import club.someoneice.pineapple_delight.BlockItemPineapple;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderLayers.class)
public class RenderLayerMixin {
    @Inject(method = "getItemLayer", at = @At("HEAD"), cancellable = true)
    private static void onItemRender(ItemStack stack, boolean direct, CallbackInfoReturnable<RenderLayer> cir) {
        Item item = stack.getItem();
        if (item instanceof BlockItemPineapple) {
            Block block = BlockInit.PINEAPPLE_BLOCK;
            cir.setReturnValue(RenderLayers.getEntityBlockLayer(block.getDefaultState(), direct));
        }
    }
}
*/