// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.util;

// Verified against: FireworkRocketEntity.java (26.2+)

import net.minecraft.world.phys.Vec3;

public final class RocketBoostHelper {
    private RocketBoostHelper() {}

    /**
     * Calculates the new entity movement vector after applying firework rocket propulsion.
     *
     * @param oldMovement Current velocity vector of the entity.
     * @param lookAngle Normalized look angle of the entity.
     * @param initialBoostSpeedTicks Threshold speed in blocks/tick for vanilla launch acceleration.
     * @param maxSpeedTicks Configured maximum flight speed ceiling in blocks/tick.
     * @param highAccFactor Proportional convergence factor towards max speed (0.05 to 1.0).
     * @return The resulting velocity vector clamped to maxSpeedTicks.
     */
    public static Vec3 calculateBoostMovement(
        Vec3 oldMovement,
        Vec3 lookAngle,
        double initialBoostSpeedTicks,
        double maxSpeedTicks,
        double highAccFactor
    ) {
        if (oldMovement == null) {
            oldMovement = Vec3.ZERO;
        }
        if (lookAngle == null) {
            lookAngle = Vec3.ZERO;
        }

        double currentSpeed = oldMovement.length();
        Vec3 targetBoost;

        if (currentSpeed < initialBoostSpeedTicks) {
            // Snappy vanilla acceleration up to the configured initial boost threshold (0.5 convergence)
            targetBoost = lookAngle.scale(0.1).add(
                lookAngle.scale(initialBoostSpeedTicks).subtract(oldMovement).scale(0.5)
            );
        } else {
            // Proportional vector difference convergence pulling smoothly toward target max speed
            Vec3 targetVelocity = lookAngle.scale(maxSpeedTicks);
            targetBoost = lookAngle.scale(0.1).add(
                targetVelocity.subtract(oldMovement).scale(highAccFactor)
            );
        }

        Vec3 targetMovement = oldMovement.add(targetBoost);
        double targetSpeed = targetMovement.length();
        if (targetSpeed > maxSpeedTicks && targetSpeed > 0.0) {
            targetMovement = targetMovement.scale(maxSpeedTicks / targetSpeed);
        }
        return targetMovement;
    }
}
