package com.qualson.kotlin_mvp.injection_normal

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@Retention(value = RUNTIME)
annotation class PerActivity