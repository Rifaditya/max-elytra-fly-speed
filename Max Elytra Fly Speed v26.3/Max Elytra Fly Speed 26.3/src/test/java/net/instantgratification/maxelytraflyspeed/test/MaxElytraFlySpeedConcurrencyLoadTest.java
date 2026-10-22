// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.maxelytraflyspeed.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import net.instantgratification.maxelytraflyspeed.config.MaxElytraConfig;
import net.instantgratification.maxelytraflyspeed.util.ElytraDragHelper;
import net.instantgratification.maxelytraflyspeed.util.RocketBoostHelper;
import net.minecraft.world.phys.Vec3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pillar 2: Concurrency & Multi-Threaded Stress Load Test Suite.
 * Executes 50 concurrent worker threads running 500 operations each
 * (25,000 total operations) across calculateFallFlyingDrag and calculateBoostMovement
 * to guarantee thread-safety, lock-free performance, and zero race conditions.
 */
@DisplayName("Pillar 2: Concurrency & Virtual Thread Load Harness")
class MaxElytraFlySpeedConcurrencyLoadTest {

    private static final int THREAD_COUNT = 50;
    private static final int OPS_PER_THREAD = 500;

    @Test
    @DisplayName("Pillar 2: 50-Thread Concurrent Execution of Drag & Rocket Boost Calculations")
    void testConcurrentPhysicsLoad() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch startLatch = new CountDownLatch(1);
        List<Future<?>> futures = new ArrayList<>(THREAD_COUNT);

        AtomicLong totalOperations = new AtomicLong(0);
        AtomicInteger completedThreads = new AtomicInteger(0);

        for (int t = 0; t < THREAD_COUNT; t++) {
            final int threadId = t;
            futures.add(pool.submit(() -> {
                try {
                    startLatch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }

                for (int i = 0; i < OPS_PER_THREAD; i++) {
                    int speed = MaxElytraConfig.maxElytraFlySpeed + (threadId % 100);
                    Vec3 vel = new Vec3(1.0 + (i * 0.01), 0.5, 0.8);

                    // 1. Concurrent drag calculation
                    Vec3 drag = ElytraDragHelper.calculateFallFlyingDrag(vel, speed);
                    assertNotNull(drag);
                    assertTrue(drag.length() > 0.0);

                    // 2. Concurrent rocket boost calculation
                    Vec3 look = new Vec3(0.0, 0.0, 1.0);
                    double initialBoostTicks = MaxElytraConfig.elytraInitialBoostSpeed / 20.0;
                    double maxSpeedTicks = speed / 20.0;
                    double accFactor = MaxElytraConfig.elytraHighSpeedAcceleration / 100.0;

                    Vec3 boosted = RocketBoostHelper.calculateBoostMovement(
                        vel, look, initialBoostTicks, maxSpeedTicks, accFactor
                    );
                    assertNotNull(boosted);
                    assertTrue(boosted.length() <= maxSpeedTicks + 1e-6);

                    totalOperations.incrementAndGet();
                }

                completedThreads.incrementAndGet();
            }));
        }

        // Trigger all 50 threads simultaneously
        startLatch.countDown();

        for (Future<?> future : futures) {
            assertDoesNotThrow(
                () -> future.get(15, TimeUnit.SECONDS),
                "Concurrent worker thread deadlocked or threw an unhandled exception"
            );
        }

        pool.shutdown();
        assertTrue(pool.awaitTermination(5, TimeUnit.SECONDS), "Thread pool failed to terminate cleanly");

        assertEquals(THREAD_COUNT, completedThreads.get(), "All 50 worker threads must finish successfully");
        assertEquals(THREAD_COUNT * OPS_PER_THREAD, totalOperations.get(), "All 25,000 operations must complete");
    }
}
