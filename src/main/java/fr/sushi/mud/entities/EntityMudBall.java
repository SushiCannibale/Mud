package fr.sushi.mud.entities;

import fr.sushi.mud.Mud;
import fr.sushi.mud.registries.ModEntityTypeRegistry;
import fr.sushi.mud.registries.ModItemRegistry;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class EntityMudBall extends ThrowableItemProjectile {

    public EntityMudBall(EntityType<? extends EntityMudBall> entityType, Level level) {
        super(entityType, level);
    }

    public EntityMudBall(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypeRegistry.ENTITY_MUD_BALL.get(), pShooter, pLevel);
    }

    // Tiré depuis un dispenser
    public EntityMudBall(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntityTypeRegistry.ENTITY_MUD_BALL.get(), pX, pY, pZ, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItemRegistry.MUDBALL.get();
    }

    private ParticleOptions getParticle() {
       return new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(ModItemRegistry.MUDBALL.get()));
    }

    public void handleEntityEvent(byte eventId) {
        if (eventId == 3) {
            ParticleOptions particleoptions = this.getParticle();
//            Mud.LOGGER.debug(String.valueOf(dx));

            for(int i = 0; i < 8; ++i) {
                double dx = (this.level.random.nextDouble() - 0.5D) / 4.0D;
                double dz = (this.level.random.nextDouble() - 0.5D) / 4.0D;
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), dx, 0.0D, dz);
            }
        }
    }

    // TODO : Applique le layer de boue à l'entité
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), 0.0f);

        //Mud.LOGGER.debug("Entity hit !");
    }


    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();

            //Mud.LOGGER.debug("Other thing ?-? !");
        }

    }


}
