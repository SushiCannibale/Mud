package fr.sushi.mud.registries;

import fr.sushi.mud.Mud;
import fr.sushi.mud.items.MudBallItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemRegistry {
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mud.MODID);

    public static final RegistryObject<Item> MUDBALL = ModRegistry.registerObject(MOD_ITEMS, "mudball", () -> new MudBallItem(new Item.Properties()
            .stacksTo(16)
            .tab(CreativeModeTab.TAB_MISC)));




    public static RegistryObject<Item> simpleItem(String name) {
        return MOD_ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
}
