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

package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qualson.kotlin_mvvm_live_databinding_sample.R
import com.qualson.kotlin_mvvm_live_databinding_sample.data.model.GalleryImage
import com.qualson.kotlin_mvvm_live_databinding_sample.databinding.MainItemBinding
import com.qualson.kotlin_mvvm_live_databinding_sample.ui.common.DataBoundListAdapter


class MainAdapter(private val dataBindingComponent: android.databinding.DataBindingComponent,
                  private val galleryClickCallback: GalleryClickCallback) : DataBoundListAdapter<GalleryImage, MainItemBinding>() {

    override fun createBinding(parent: ViewGroup): MainItemBinding {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), R.layout.main_item,
                parent, false, dataBindingComponent)
        binding.root.setOnClickListener(View.OnClickListener {
            //            val galleryImage = binding.
//                    galleryClickCallback.onClick(galleryImage)
//            galleryClickCallback.onClick()
//            galleryClickCallback.onClick(galleryImage = )

        })
        return binding as MainItemBinding
    }

    override fun bind(binding: MainItemBinding, item: GalleryImage) {
        binding.galleryImage = item
    }

    override fun areItemsTheSame(oldItem: GalleryImage, newItem: GalleryImage): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: GalleryImage, newItem: GalleryImage): Boolean {
        return true
    }

    interface GalleryClickCallback {
        fun onClick(galleryImage: GalleryImage)
    }
}
