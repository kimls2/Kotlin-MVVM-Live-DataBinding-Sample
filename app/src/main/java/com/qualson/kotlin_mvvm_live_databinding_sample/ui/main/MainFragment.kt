package com.qualson.kotlin_mvvm_live_databinding_sample.ui.main


import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qualson.kotlin_mvvm_live_databinding_sample.R
import com.qualson.kotlin_mvvm_live_databinding_sample.binding.FragmentDataBindingComponent
import com.qualson.kotlin_mvvm_live_databinding_sample.databinding.MainFragmentBinding
import com.qualson.kotlin_mvvm_live_databinding_sample.util.AutoClearedValue
import com.qualson.kotlin_mvvm_live_databinding_sample.util.SnackbarUtils
import com.qualson.kotlin_mvvm_live_databinding_sample.util.getAppComponent
import javax.inject.Inject

/**
 * Created by ykim on 2017. 6. 28..
 */

class MainFragment : Fragment(), LifecycleRegistryOwner {


    private val lifecycleRegistry = LifecycleRegistry(this)
    private val dataBindingComponent: android.databinding.DataBindingComponent = FragmentDataBindingComponent(this)
    private lateinit var binding: AutoClearedValue<MainFragmentBinding>
    private lateinit var adapter: AutoClearedValue<MainAdapter>

    @Inject lateinit var mainViewModel: MainViewModel
    lateinit var mainComponent: MainComponent

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mainComponent = context.getAppComponent().inject(MainModule())
        mainComponent.inject(this)
        val mainAdapter: MainAdapter = MainAdapter(dataBindingComponent)
        adapter = AutoClearedValue(this, mainAdapter)
        binding.get().imageList.adapter = mainAdapter
        mainViewModel.getListGalleryImages().observe(this, Observer { gallery -> adapter.get().replace(gallery) })
        mainViewModel.snackbarMessage.observe(this, Observer { SnackbarUtils.showSnackbar(view, it) })

        // db test
        mainViewModel.insert()
        mainViewModel.select()

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

    override fun onResume() {
        super.onResume()
        mainViewModel.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mainViewModel.destroy()
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}
