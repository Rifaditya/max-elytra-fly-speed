// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.util;

// Verified against: LivingEntity.java (26.3 snapshots 10)

import net.minecraft.world.phys.Vec3;

public final class ElytraDragHelper {
    private ElytraDragHelper() {}

    /**
     * Calculates the adjusted aerodynamic drag vector for Elytra fall-flying movement.
     * Dynamic drag damping scales inversely with higher configured max speed limits to allow
     * natural high-speed diving and sustained glide momentum.
     *
     * @param movement Current fall-flying velocity vector before damping.
     * @param maxSpeedBps Configured maximum flight speed ceiling in Blocks/Second.
     * @return The movement vector damped by dynamic drag factors.
     */
    public static Vec3 calculateFallFlyingDrag(Vec3 movement, int maxSpeedBps) {
        if (movement == null) {
            return Vec3.ZERO;
        }

        // At <= 50 BPS, speedRatio is 1.0 (exact vanilla 0.99H / 0.98V drag).
        // At > 50 BPS (e.g. 100 or 200), drag relaxes smoothly to allow high-speed glide.
        double speedRatio = Math.max(1.0, maxSpeedBps / 50.0);
        double dragLossH = 0.01 / speedRatio;
        double dragLossV = 0.02 / speedRatio;

        return movement.multiply(1.0 - dragLossH, 1.0 - dragLossV, 1.0 - dragLossH);
    }
}
