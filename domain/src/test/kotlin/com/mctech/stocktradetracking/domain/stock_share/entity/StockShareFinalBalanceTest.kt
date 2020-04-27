package com.mctech.stocktradetracking.domain.stock_share.entity

import org.assertj.core.api.Assertions
import org.junit.Test

class StockShareFinalBalanceTest{
    private val expectedValue = StockShareFinalBalance(
        balance = 4215.97,
        investment = 16140.20
    )

    private val expectedNegativeValue = StockShareFinalBalance(
        balance = -3310.97,
        investment = 10000.0
    )

    private val expectedEmpty = StockShareFinalBalance(
        balance = 0.0,
        investment = 0.0
    )

    @Test
    fun `should assert entity`(){
        Assertions.assertThat(expectedValue.balance).isEqualTo(4215.97)
        Assertions.assertThat(expectedValue.investment).isEqualTo(16140.20)
    }

    @Test
    fun `should format final balance description`(){
        Assertions.assertThat(expectedValue.getBalanceDescription()).isEqualTo("R$4.215,97")
        Assertions.assertThat(expectedNegativeValue.getBalanceDescription()).isEqualTo("-R$3.310,97")
        Assertions.assertThat(expectedEmpty.getBalanceDescription()).isEqualTo("R$0,00")
    }

    @Test
    fun `should format final investment description`(){
        Assertions.assertThat(expectedValue.getInvestmentDescription()).isEqualTo("R$16.140,20")
        Assertions.assertThat(expectedNegativeValue.getInvestmentDescription()).isEqualTo("R$10.000,00")
        Assertions.assertThat(expectedEmpty.getInvestmentDescription()).isEqualTo("R$0,00")
    }

    @Test
    fun `should format variation description`(){
        Assertions.assertThat(expectedValue.getVariationDescription()).isEqualTo("26.12%")
        Assertions.assertThat(expectedNegativeValue.getVariationDescription()).isEqualTo("-33.11%")
        Assertions.assertThat(expectedEmpty.getVariationDescription()).isEqualTo("0.0%")
    }

    @Test
    fun `should compute variation`(){
        Assertions.assertThat(expectedValue.getVariant()).isEqualTo(26.12)
        Assertions.assertThat(expectedNegativeValue.getVariant()).isEqualTo(-33.11)
        Assertions.assertThat(expectedEmpty.getVariant()).isEqualTo(0.0)
    }
}