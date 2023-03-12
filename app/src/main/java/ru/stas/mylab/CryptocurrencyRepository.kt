package ru.stas.mylab

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}