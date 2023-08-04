package club.someoneice.pineapple.gem;

import java.util.function.Supplier;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.init.BlockList;
import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.world.WildCropGeneration;


public class WildPineapple {
    /*
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(BuiltinRegistries.CONFIGURED_FEATURE.key(), PineappleMain.MODID);
    public static final DeferredRegister<PlacedFeature> PATCHES = DeferredRegister.create(BuiltinRegistries.PLACED_FEATURE.key(), PineappleMain.MODID);

    public static RegistryObject<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_PINEAPPLE = FEATURES.register("wild_pineapple",
            () -> wildCropFeature(BlockList.PINEAPPLE_WILD_CROP, BlockTags.DIRT));

    public static RegistryObject<PlacedFeature> PATCH_WILD_PINEAPPLE = PATCHES.register("wild_pineapple",
            () -> wildCropPatch(FEATURE_PATCH_WILD_PINEAPPLE, RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));


    private static ConfiguredFeature<?, ?> wildCropFeature(Supplier<Block> wildCrop, TagKey<Block> blockTag) {
        return new ConfiguredFeature<>(Feature.RANDOM_PATCH, WildCropGeneration.randomPatchConfig(wildCrop.get(),
                64, 12, BlockPredicate.matchesTag(new BlockPos(0, -1, 0), blockTag)));
    }
    private static PlacedFeature wildCropPatch(RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return new PlacedFeature(feature.getHolder().get(), Lists.newArrayList(modifiers));
    }
    */
}
