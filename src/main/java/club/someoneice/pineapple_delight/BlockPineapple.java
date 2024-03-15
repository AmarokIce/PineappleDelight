package club.someoneice.pineapple_delight;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockPineapple extends Block {
    public BlockPineapple() {
        super(Settings.copy(Blocks.WHEAT));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.canConsume(false)) player.eatFood(world, ItemInit.PINEAPPLE_ITEM.getDefaultStack());
        return ActionResult.SUCCESS;
    }}
