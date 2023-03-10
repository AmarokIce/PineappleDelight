/*
package club.someoneice.pineapple.gem;

import club.someoneice.pineapple.PineappleMain;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.level.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = PineappleMain.MODID)
public class WorldEvent {
    @SubscribeEvent
    public static void onBiomeLoad(ChunkLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        Biome.ClimateSettings climate = event.getClimate();
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildPineapple.PATCH_WILD_PINEAPPLE.getHolder().get());

        // if (climate.temperature > 0.3F) {
        //     builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WildPineapple.PATCH_WILD_PINEAPPLE.getHolder().get());
        // }
    }
}

*/