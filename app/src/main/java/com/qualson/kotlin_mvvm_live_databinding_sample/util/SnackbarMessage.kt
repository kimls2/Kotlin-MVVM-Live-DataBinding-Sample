/*
 *  Copyright 2017 Google Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.qualson.kotlin_mvvm_live_databinding_sample.util

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import com.qualson.kotlin_mvvm_live_databinding_sample.data.SingleLiveEvent


/**
 * A SingleLiveEvent used for Snackbar messages. Like a [SingleLiveEvent] but also prevents
 * null messages and uses a custom observer.
 *
 *
 * Note that only one observer is going to be notified of changes.
 */
class SnackbarMessage : SingleLiveEvent<String>() {

    fun observe(owner: LifecycleOwner, observer: SnackbarObserver) {
        super.observe(owner,observer)
    }

    interface SnackbarObserver : Observer<String> {
        override fun onChanged(t: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun onNewMessage(message: String)
    }
}
