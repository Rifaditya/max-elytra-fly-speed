package net.instantgratification.maxelytraflyspeed.mixin;

// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3

// Verified against: FireworkRocketEntity.java (26.2+)

import net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FireworkRocketEntity.class)
public abstract class FireworkRocketEntityMixin {

    @Shadow
    private LivingEntity attachedToEntity;

    @Redirect(
        method = "tick",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/LivingEntity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"
        )
    )
    private void maxelytraflyspeed$scaleRocketBoost(LivingEntity entity, Vec3 newMovement) {
        Vec3 oldMovement = entity.getDeltaMovement();
        int maxSpeedBps = DynamicGameRuleManager.getInt(entity.level(), MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED);
        double maxSpeedTicks = maxSpeedBps / 20.0;

        int initialBoostSpeedBps = DynamicGameRuleManager.getInt(entity.level(), MaxElytraFlySpeedFabric.ELYTRA_INITIAL_BOOST_SPEED);
        double initialBoostSpeedTicks = initialBoostSpeedBps / 20.0;

        int highAccPermille = DynamicGameRuleManager.getInt(entity.level(), MaxElytraFlySpeedFabric.ELYTRA_HIGH_SPEED_ACCELERATION);
        double highAcc = highAccPermille / 1000.0;

        double currentSpeed = oldMovement.length();
        Vec3 lookAngle = entity.getLookAngle();
        Vec3 targetBoost;

        if (currentSpeed < initialBoostSpeedTicks) {
            // Snappy vanilla acceleration up to the configured initial boost speed threshold
            targetBoost = lookAngle.scale(0.1).add(
                lookAngle.scale(initialBoostSpeedTicks).subtract(oldMovement).scale(0.5)
            );
        } else {
            // Gradual acceleration with drag compensation above initial boost speed threshold
            double gravity = entity.getGravity();
            double dragLossV = Math.min(0.02, gravity / maxSpeedTicks);
            double dragLossH = Math.min(0.01, dragLossV * 0.5);
            Vec3 dragCompensation = new Vec3(oldMovement.x * dragLossH, oldMovement.y * dragLossV, oldMovement.z * dragLossH);
            targetBoost = dragCompensation.add(lookAngle.scale(highAcc));
        }

        Vec3 targetMovement = oldMovement.add(targetBoost);
        double targetSpeed = targetMovement.length();
        if (targetSpeed > maxSpeedTicks && targetSpeed > 0.0) {
            targetMovement = targetMovement.scale(maxSpeedTicks / targetSpeed);
        }
        entity.setDeltaMovement(targetMovement);
    }
}
