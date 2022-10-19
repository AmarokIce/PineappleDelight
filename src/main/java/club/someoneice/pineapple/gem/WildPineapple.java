package club.someoneice.pineapple.gem;

import club.someoneice.pineapple.init.BlockList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;

public class WildPineapple {
    public static final BlockClusterFeatureConfig CORN_PATCH_CONFIG = (new BlockClusterFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockList.PINEAPPLE_WILD_CROP.get().defaultBlockState()), new SimpleBlockPlacer())).tries(64).xspread(2).zspread(2).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK.getBlock())).noProjection().build();


    public static final ConfiguredFeature<?, ?> PATCH_WILD_CORN = Feature.RANDOM_PATCH.configured(CORN_PATCH_CONFIG)
            .decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).chance(5);

    public static <FC extends IFeatureConfig> void register() {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "patch_wild_pineapple", (ConfiguredFeature<FC, ?>) WildPineapple.PATCH_WILD_CORN);
    }
}
