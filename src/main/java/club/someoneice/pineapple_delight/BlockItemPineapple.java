package club.someoneice.pineapple_delight;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BlockItemPineapple extends BlockItem {
    public BlockItemPineapple() {
        super(BlockInit.PINEAPPLE_BLOCK, new Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).meat().build()));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer().isSneaking()) super.useOnBlock(context);
        else use(context.getWorld(), context.getPlayer(), context.getHand());
        return ActionResult.SUCCESS;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!player.canConsume(this.getFoodComponent().isAlwaysEdible())) return TypedActionResult.fail(itemStack);
        player.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }
}
