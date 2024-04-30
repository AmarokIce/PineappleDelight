package club.someoneice.pineapple_delight;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FeatureInit {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_PINEAPPLE_CONFIGURED = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier("pineapple_delight", "pineapple_wild_crop"));
    public static RegistryKey<PlacedFeature> WILD_PINEAPPLE_PLACED = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("pineapple_delight", "pineapple_wild_crop"));

    public static void boot() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT, BiomeKeys.JUNGLE, BiomeKeys.BAMBOO_JUNGLE, BiomeKeys.SPARSE_JUNGLE), GenerationStep.Feature.VEGETAL_DECORATION, WILD_PINEAPPLE_PLACED);
    }
}
