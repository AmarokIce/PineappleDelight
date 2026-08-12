package club.someoneice.pineapple.init;

import club.someoneice.pineapple.PineappleMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundList {
  public static final DeferredRegister<SoundEvent> SOUNDS =
      DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PineappleMain.MODID);

  public static final RegistryObject<SoundEvent> HAPPY_BIRTHDAY = SOUNDS.register("happy_birthday",
      () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PineappleMain.MODID, "happy_birthday")));
}
