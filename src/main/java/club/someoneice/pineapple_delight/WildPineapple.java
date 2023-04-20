package club.someoneice.pineapple_delight;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Collection;
import java.util.List;

public class WildPineapple {
    public static Collection<RegistryKey<Biome>> PLAINS = List.of(new RegistryKey[]{BiomeKeys.PLAINS});
    public static void register() {
        var configId = new Identifier("pineapple_delight", "wild_pineapple_feature");
        var configuredFeature = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, configId, new ConfiguredFeature<>(Feature.RANDOM_PATCH, createRandomPatchFeatureConfig()));
        RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, configId);
        Identifier featureId = new Identifier("pineapple_delight", "wild_pineapple_feature");
        Registry.register(BuiltinRegistries.PLACED_FEATURE, featureId,
                new PlacedFeature(RegistryEntry.of(configuredFeature), List.of(SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of())));
        var featureRegistryKey = RegistryKey.of(Registry.PLACED_FEATURE_KEY, featureId);

        BiomeModifications.addFeature(context -> BiomeSelectors.includeByKey(PLAINS).test(context), GenerationStep.Feature.VEGETAL_DECORATION, featureRegistryKey);
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig() {
        return new RandomPatchFeatureConfig(64, 6, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(BlockInit.PINEAPPLE_WILD_CROP))));
    }
}
