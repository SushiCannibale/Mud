package fr.sushi.mud.client.entities.renderers;

import fr.sushi.mud.registries.ModEntityTypeRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class MudBallEntityRenderer {

    // Call pour charge le bloc
    public static void load() {}

    static {
        EntityRenderers.register(ModEntityTypeRegistry.ENTITY_MUD_BALL.get(), ThrownItemRenderer::new);
    }

}
