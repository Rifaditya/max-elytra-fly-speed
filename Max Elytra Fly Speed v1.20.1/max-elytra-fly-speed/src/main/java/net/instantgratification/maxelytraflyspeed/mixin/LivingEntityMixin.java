// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.mixin;

// Verified against: LivingEntity.java (1.20.1 Mojmap)

import net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric;
import net.instantgratification.maxelytraflyspeed.util.ElytraDragHelper;
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
        method = "travel",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/phys/Vec3;multiply(DDD)Lnet/minecraft/world/phys/Vec3;"
        )
    )
    private Vec3 maxelytraflyspeed$adjustDrag(Vec3 movement, double x, double y, double z) {
        if (((LivingEntity) (Object) this).isFallFlying()) {
            int maxSpeedBps = DynamicGameRuleManager.getInt(((LivingEntity) (Object) this).level(), MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED);
            return ElytraDragHelper.calculateFallFlyingDrag(movement, maxSpeedBps);
        }
        return movement.multiply(x, y, z);
    }

    @Inject(
        method = "travel",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/LivingEntity;move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V"
        )
    )
    private void maxelytraflyspeed$clampBeforeMove(Vec3 movementInput, CallbackInfo ci) {
        LivingEntity entity = (LivingEntity) (Object) this;
        if (entity.isFallFlying()) {
            int maxSpeedBps = DynamicGameRuleManager.getInt(entity.level(), MaxElytraFlySpeedFabric.MAX_ELYTRA_FLY_SPEED);
            Vec3 currentDelta = entity.getDeltaMovement();
            Vec3 clamped = ElytraDragHelper.clampToMaxSpeed(currentDelta, maxSpeedBps);
            if (clamped != currentDelta) {
                entity.setDeltaMovement(clamped);
            }
        }
    }
}
