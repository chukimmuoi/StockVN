package com.chukimmuoi.macrobenchmark

import androidx.benchmark.macro.*
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
/**
 * @author: My Project
 * @Skype: chukimmuoi
 * @Mobile : +84 167 367 2505
 * @Email: chukimmuoi@gmail.com
 * @Website: https://github.com/chukimmuoi
 * @Project: StockVN
 * Created by chukimmuoi on 29/10/2022.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ColdStartupBenchmark : AbstractStartupBenchmark(StartupMode.COLD)
abstract class AbstractStartupBenchmark(private val startupMode: StartupMode) {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startupNoCompilation() =
        startup(
            CompilationMode.None()
        )

    @Test
    fun startupPartialCompilation() =
        startup(
            CompilationMode.Partial(
                baselineProfileMode = BaselineProfileMode.Disable,
                warmupIterations = 3
            )
        )

    @Test
    fun startupPartialWithBaselineProfiles() =
        startup(
            CompilationMode.Partial(
                baselineProfileMode = BaselineProfileMode.Require
            )
        )

    @Test
    fun startupFullCompilation() = startup(CompilationMode.Full())

    private fun startup(compilationMode: CompilationMode) =
        benchmarkRule.measureRepeated(
            packageName = "com.chukimmuoi.stockvn",
            metrics = listOf(StartupTimingMetric()),
            compilationMode = compilationMode,
            iterations = 10,
            startupMode = startupMode,
            setupBlock = {
                pressHome()
            }
        ) {
            startActivityAndWait()
        }
}