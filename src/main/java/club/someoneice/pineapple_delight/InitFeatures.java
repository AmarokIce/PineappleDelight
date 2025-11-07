package club.someoneice.pineapple_delight;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class InitFeatures {
  public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_PINEAPPLE_CONFIGURED =
      ResourceKey.create(Registries.CONFIGURED_FEATURE,
          ResourceLocation.fromNamespaceAndPath(
              "pineapple_delight", "patch_wild_pineapple"));
  public static ResourceKey<PlacedFeature> WILD_PINEAPPLE_PLACED =
      ResourceKey.create(Registries.PLACED_FEATURE,
          ResourceLocation.fromNamespaceAndPath(
              "pineapple_delight", "patch_wild_pineapple"));

  public static void boot() {
    BiomeModifications.addFeature(BiomeSelectors.includeByKey(
            Biomes.DESERT, Biomes.JUNGLE,
            Biomes.BAMBOO_JUNGLE, Biomes.SPARSE_JUNGLE)
        , GenerationStep.Decoration.VEGETAL_DECORATION,
        WILD_PINEAPPLE_PLACED);
  }
}
