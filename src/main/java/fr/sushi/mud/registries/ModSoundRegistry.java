package fr.sushi.mud.registries;

import fr.sushi.mud.Mud;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundRegistry {
    public static final DeferredRegister<SoundEvent> MOD_SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Mud.MODID);

//    public static final RegistryObject<SoundEvent> MUDBALL_THROW = ModRegistry.registerObject(MOD_SOUNDS, "mudball_throw",
//            () -> new SoundEvent(new ResourceLocation(Mud.MODID, "entity.mudball.throw")));
}
