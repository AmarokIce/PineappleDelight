package club.someoneice.pineapple.gem;

import club.someoneice.pineapple.PineappleMain;
import club.someoneice.pineapple.init.BlockList;
import com.google.common.collect.Lists;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.world.WildCropGeneration;

import static vectorwing.farmersdelight.common.world.WildCropGeneration.BLOCK_BELOW;

public class WildPineapple {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(BuiltinRegistries.CONFIGURED_FEATURE.key(), PineappleMain.MODID);
    public static final DeferredRegister<PlacedFeature> PATCHES = DeferredRegister.create(BuiltinRegistries.PLACED_FEATURE.key(), PineappleMain.MODID);

    public static RegistryObject<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_PINEAPPLE = FEATURES.register("wild_pineapple", () -> wildCropFeature(BlockList.PINEAPPLE_WILD_CROP.get()));
    public static RegistryObject<PlacedFeature> PATCH_WILD_PINEAPPLE = PATCHES.register("wild_pineapple", () -> wildCropPatch(FEATURE_PATCH_WILD_PINEAPPLE, RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    private static ConfiguredFeature<?, ?> wildCropFeature(Block wildCrop) {
        return new ConfiguredFeature<>(Feature.RANDOM_PATCH, WildCropGeneration.randomPatchConfig(wildCrop, 64, 4, BlockPredicate.matchesTag(BLOCK_BELOW, BlockTags.DIRT)));
    }

    private static PlacedFeature wildCropPatch(RegistryObject<ConfiguredFeature<?, ?>> feature, PlacementModifier... modifiers) {
        return new PlacedFeature(feature.getHolder().get(), Lists.newArrayList(modifiers));
    }
}
