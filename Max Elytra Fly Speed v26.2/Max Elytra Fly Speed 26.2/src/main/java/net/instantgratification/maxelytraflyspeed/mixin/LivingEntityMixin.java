package net.instantgratification.maxelytraflyspeed.mixin;

// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3

// Verified against: LivingEntity.java (26.2+)

import net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric;
import net.dasik.social.api.gamerule.DynamicGameRuleManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Redirect(
        method = "updateFallFlyingMovement",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/phys/Vec3;multiply(DDD)Lnet/minecraft/world/phys/Vec3;"
        )
    )
    private Vec3 maxelytraflyspeed$adjustDrag(Vec3 movement, double x, double y, double z) {
        LivingEntity entity = (LivingEntity) (Object) this;
        int maxSpeedBps = DynamicGameRuleManager.getInt(entity.level(), MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED);
        double maxSpeedTicks = maxSpeedBps / 20.0;

        double gravity = entity.getGravity();
        double dragLossV = Math.min(0.02, gravity / maxSpeedTicks);
        double dragLossH = Math.min(0.01, dragLossV * 0.5);

        return movement.multiply(1.0 - dragLossH, 1.0 - dragLossV, 1.0 - dragLossH);
    }

    @Inject(
        method = "travelFallFlying",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/LivingEntity;move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V"
        )
    )
    private void maxelytraflyspeed$clampMaxSpeed(Vec3 input, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        int maxSpeedBps = DynamicGameRuleManager.getInt(entity.level(), MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED);
        double maxSpeedTicks = maxSpeedBps / 20.0;
        Vec3 velocity = entity.getDeltaMovement();
        double currentSpeed = velocity.length();
        if (currentSpeed > maxSpeedTicks && currentSpeed > 0.0) {
            entity.setDeltaMovement(velocity.scale(maxSpeedTicks / currentSpeed));
        }
    }
}
