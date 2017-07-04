package com.qualson.kotlin_mvvm_live_databinding_sample.injection_normal

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@Retention(value = RUNTIME)
annotation class PerActivity