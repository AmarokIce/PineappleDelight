package club.someoneice.pineapple.common;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.init.BlockList;
import club.someoneice.pineapple.init.ItemList;
import club.someoneice.pineapple.init.SoundList;
import com.starmeow.starmeowcraft.StarMeowCraft;
import com.starmeow.starmeowcraft.init.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.time.LocalDate;
import java.time.Month;

public final class BlockPineappleCake extends CakeBlock {
  public BlockPineappleCake() {
    super(Properties.copy(Blocks.CAKE));
  }

  @Override
  public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player,
                               InteractionHand hand, BlockHitResult hit) {
    final var item = player.getItemInHand(hand);

    if (item.is(ModTags.KNIVES)) {
      cuttingCake(state, world, pos, player);
      return InteractionResult.SUCCESS;
    }

    if (item.is(ItemTags.CANDLES)
        && state.getValue(BITES) == 0
        && Block.byItem(item.getItem()) instanceof CandleBlock block) {
      setCandle(world, pos, player, block, item);
      return InteractionResult.SUCCESS;
    }

    return onEat(world, pos, state, player);
  }

  @Override
  public void onRemove(BlockState p_60515_, Level p_60516_, BlockPos p_60517_, BlockState p_60518_, boolean p_60519_) {
    super.onRemove(p_60515_, p_60516_, p_60517_, p_60518_, p_60519_);
    if (!p_60516_.isClientSide()) {
      return;
    }

    Minecraft.getInstance().getSoundManager().stop();
  }

  public static void setCandle(Level world, BlockPos pos, Player player,
                               CandleBlock block, ItemStack item) {
    if (!player.isCreative()) {
      item.shrink(1);
    }

    world.playSound(null, pos, SoundEvents.CAKE_ADD_CANDLE, SoundSource.BLOCKS, 1.0F, 1.0F);
    world.setBlockAndUpdate(pos, BlockPineappleCandleCake.createByCandle(block));
    world.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
    player.awardStat(Stats.ITEM_USED.get(item.getItem()));

    checkBirthday(world, pos, player);
  }

  private static void checkBirthday(Level world, BlockPos pos, Player player) {
    LocalDate currentDate = LocalDate.now();
    int date = currentDate.getDayOfMonth();
    Month month = currentDate.getMonth();

    if (date != 12 || month != Month.JANUARY) {
      return;
    }

    world.setBlockAndUpdate(pos,
        world.getBlockState(pos).setValue(BlockPineappleCandleCake.LIT, true));

    if (PineappleMain.SMC_INSTALL) {
      player.addItem(new ItemStack(ItemRegistry.DOLL_1.get()));
    }


    if (world.isClientSide()) {
      Minecraft.getInstance().gui.setTitle(Component.literal("祝小喵生日快乐！"));
      return;
    }

    world.playSeededSound(null, pos.getX(), pos.getY(), pos.getZ(),
        SoundList.HAPPY_BIRTHDAY.get(), SoundSource.BLOCKS, 1.0f, 1.0f, 0);
  }

  public static void cuttingCake(BlockState state, Level world, BlockPos pos, Player player) {
    if (state.getBlock() instanceof CandleCakeBlock) {
      world.setBlockAndUpdate(pos, BlockList.PINEAPPLE_CAKE.get().defaultBlockState());
      state = world.getBlockState(pos);
    }

    if (!state.hasProperty(BITES)) {
      return;
    }

    int i = state.getValue(BITES);

    if (i < 6) {
      world.setBlock(pos, state.setValue(BITES, i + 1), 3);
    } else {
      world.removeBlock(pos, false);
      world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
    }

    final var cake = new ItemStack(ItemList.PINEAPPLE_CAKE_SLICE.get());

    if (!player.addItem(cake)) {
      world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), cake));
    }
  }

  public static InteractionResult onEat(Level world, BlockPos pos, BlockState state,
                                        Player player) {
    if (!player.canEat(false)) {
      return InteractionResult.PASS;
    }

    if (state.getBlock() instanceof CandleCakeBlock) {
      world.setBlockAndUpdate(pos, BlockList.PINEAPPLE_CAKE.get().defaultBlockState());
      state = world.getBlockState(pos);
    }

    if (!state.hasProperty(BITES)) {
      return InteractionResult.FAIL;
    }

    final int i = state.getValue(BITES);

    player.awardStat(Stats.EAT_CAKE_SLICE);
    player.getFoodData().eat(3, 0.4F);
    world.gameEvent(player, GameEvent.EAT, pos);

    if (i < 6) {
      world.setBlock(pos, state.setValue(BITES, i + 1), 3);
      return InteractionResult.SUCCESS;
    }

    world.removeBlock(pos, false);
    world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);

    return InteractionResult.SUCCESS;
  }
}
