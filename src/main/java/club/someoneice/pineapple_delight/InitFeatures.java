package club.someoneice.pineapple_delight;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import vectorwing.farmersdelight.common.registry.ModBiomeModifiers.FDBiomeSelector;

public class InitFeatures {
  public static ResourceKey<PlacedFeature> WILD_PINEAPPLE_PLACED =
      ResourceKey.create(Registries.PLACED_FEATURE,
          ResourceLocation.fromNamespaceAndPath(
              "pineapple_delight", "patch_wild_pineapple"));

  public static void boot() {
    BiomeModifications.addFeature(new FDBiomeSelector(0.1f, 10.0f, BiomeTags.IS_FOREST,
        BiomeTags.IS_JUNGLE), Decoration.VEGETAL_DECORATION, WILD_PINEAPPLE_PLACED);
  }
}
