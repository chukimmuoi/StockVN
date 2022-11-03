package com.chukimmuoi.macrobenchmark

import androidx.benchmark.macro.*
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * This is an example startup benchmark.
 *
 * It navigates to the device's home screen, and launches the default activity.
 *
 * Before running this benchmark:
 * 1) switch your app's active build variant in the Studio (affects Studio runs only)
 * 2) add `<profileable android:shell="true" />` to your app's manifest, within the `<application>` tag
 *
 * Run this benchmark from Studio to see startup measurements, and captured system traces
 * for investigating your app's performance.
 */
@OptIn(ExperimentalMetricApi::class)
@RunWith(AndroidJUnit4ClassRunner::class)
class SampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = "com.chukimmuoi.stockvn",
        metrics = listOf(
            StartupTimingMetric()
        ),
        iterations = 5,
        setupBlock = {
            // Press home button before each run to ensure the starting activity isn't visible.
            pressHome()
        }
    ) {
        // Starts default launch activity
        startActivityAndWait()

        device.wait(
            Until.hasObject(By.text("What are you interested in?")),
            30_000
        )
    }

    @Test
    fun frame() = benchmarkRule.measureRepeated(
        packageName = "com.chukimmuoi.stockvn",
        metrics = listOf(
            FrameTimingMetric(),
        ),
        iterations = 5,
        startupMode = StartupMode.COLD,
        setupBlock = {
            pressHome()
        }
    ) {
        startActivityAndWait()

        device.wait(
            Until.hasObject(By.text("What are you interested in?")),
            30_000
        )
    }

    @Test
    fun trace() = benchmarkRule.measureRepeated(
        packageName = "com.chukimmuoi.stockvn",
        metrics = listOf(
            TraceSectionMetric("RV CreateView"),
            TraceSectionMetric("RV OnBindView"),
        ),
        iterations = 5,
        startupMode = StartupMode.COLD,
        setupBlock = {
            pressHome()
        }
    ) {
        startActivityAndWait()

        device.wait(
            Until.hasObject(By.text("What are you interested in?")),
            30_000
        )
    }
}