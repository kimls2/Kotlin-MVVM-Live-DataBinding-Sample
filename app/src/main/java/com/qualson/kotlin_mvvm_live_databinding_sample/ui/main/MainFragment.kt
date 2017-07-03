package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main


import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qualson.kotlin_mvvm_live_databinding_sample.R
import com.qualson.kotlin_mvvm_live_databinding_sample.binding.FragmentDataBindingComponent
import com.qualson.kotlin_mvvm_live_databinding_sample.databinding.MainFragmentBinding
import com.qualson.kotlin_mvvm_live_databinding_sample.di.Injectable
import com.qualson.kotlin_mvvm_live_databinding_sample.util.AutoClearedValue
import javax.inject.Inject

/**
 * Created by ykim on 2017. 6. 28..
 */

class MainFragment : Fragment(), LifecycleRegistryOwner, Injectable {

    private val lifecycleRegistry = LifecycleRegistry(this)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    fun newInstance(): MainFragment {
        return MainFragment()
    }

    private var mainViewModel: MainViewModel? = null

    private var dataBindingComponent: android.databinding.DataBindingComponent = FragmentDataBindingComponent(this)
    private lateinit var binding: AutoClearedValue<MainFragmentBinding>
//    internal var adapter: AutoClearedValue<MainAdapter>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //        mainViewModel = MainActivity.obtainViewModel(getActivity());
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
//        val mainAdapter:MainAdapter = MainAdapter(dataBindingComponent )


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val dataBinding: MainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding = AutoClearedValue(this, dataBinding)
        return dataBinding.root

    }

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }


}
