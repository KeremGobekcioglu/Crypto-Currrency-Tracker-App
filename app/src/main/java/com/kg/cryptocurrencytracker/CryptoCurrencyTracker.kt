package com.kg.cryptocurrencytracker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * This is the main application class for the CryptoCurrencyTracker app.
 * It is annotated with @HiltAndroidApp to enable Hilt for the application.
 */
@HiltAndroidApp
class CryptoCurrencyTracker : Application()