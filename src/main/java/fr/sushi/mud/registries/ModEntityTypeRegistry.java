package fr.sushi.mud.registries;

import fr.sushi.mud.Mud;
import fr.sushi.mud.entities.EntityMudBall;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypeRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mud.MODID);

    public static final RegistryObject<EntityType<EntityMudBall>> ENTITY_MUD_BALL = ENTITY_TYPES.register("mudball",
            () -> EntityType.Builder.<EntityMudBall>of(EntityMudBall::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(new ResourceLocation(Mud.MODID, "mudball").toString()));
}
