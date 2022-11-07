package fr.sushi.mud.registries;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModRegistry {

    public static <T> RegistryObject<T> registerObject(final DeferredRegister<T> registry, String name, Supplier<? extends T> sup) {
        return registry.register(name, sup);
    }

    public static void register(IEventBus bus) {
        ModItemRegistry.MOD_ITEMS.register(bus);
        ModSoundRegistry.MOD_SOUNDS.register(bus);
        ModEntityTypeRegistry.ENTITY_TYPES.register(bus);
    }
}
