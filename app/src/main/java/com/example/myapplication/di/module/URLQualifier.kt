package com.example.myapplication.di.module

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AdminPreference

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ClientPreference