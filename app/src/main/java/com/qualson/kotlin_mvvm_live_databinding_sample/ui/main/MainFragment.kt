package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main


import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qualson.kotlin_mvvm_live_databinding_sample.di.Injectable
import javax.inject.Inject

/**
 * Created by ykim on 2017. 6. 28..
 */

class MainFragment : Fragment(), LifecycleRegistryOwner, Injectable {

    private val lifecycleRegistry = LifecycleRegistry(this)

    @Inject
    internal var viewModelFactory: ViewModelProvider.Factory? = null
//    private var mainViewModel: MainViewModel? = null

//    internal var dataBindingComponent: android.databinding.DataBindingComponent = FragmentDataBindingComponent(this)
//    internal var binding: AutoClearedValue<MainFragmentBinding>
//    internal var adapter: AutoClearedValue<MainAdapter>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //        mainViewModel = MainActivity.obtainViewModel(getActivity());


    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        val dataBinding = DataBindingUtil.inflate<ViewDataBinding>(inflater!!, R.layout.main_fragment, container, false)
//        binding = AutoClearedValue(this, dataBinding)
        return null

    }

    override fun onResume() {
        super.onResume()
//        mainViewModel!!.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        mainViewModel!!.destroy()
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
