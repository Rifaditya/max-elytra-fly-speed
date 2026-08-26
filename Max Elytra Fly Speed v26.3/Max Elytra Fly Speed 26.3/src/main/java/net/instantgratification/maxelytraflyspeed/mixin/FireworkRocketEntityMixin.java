package net.instantgratification.maxelytraflyspeed.mixin;

// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3

// Verified against: FireworkRocketEntity.java (26.2+)

import net.instantgratification.maxelytraflyspeed.MaxElytraFlySpeedFabric;
import net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper;
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
        double highAccFactor = Math.max(0.05, highAccPermille / 100.0);

        Vec3 lookAngle = entity.getLookAngle();
        Vec3 targetMovement = RocketBoostHelper.calculateBoostMovement(
            oldMovement, lookAngle, initialBoostSpeedTicks, maxSpeedTicks, highAccFactor
        );
        entity.setDeltaMovement(targetMovement);
    }
}
