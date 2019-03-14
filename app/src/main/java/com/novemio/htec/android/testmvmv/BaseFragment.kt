package com.novemio.htec.android.testmvmv

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

private val TAG by lazy { BaseFragment::class.java.simpleName }

abstract class BaseFragment : Fragment() {

		private var viewModel: BaseViewModel? = null

		abstract fun initView()

		@LayoutRes
		abstract fun getLayoutId(): Int

		override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

				return inflater.inflate(getLayoutId(), container, false)
		}

		override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
				super.onViewCreated(view, savedInstanceState)
				initView()
		}

		fun setViewModel(vm: BaseViewModel) {
				viewModel = vm
				observeBaseFunctions()
		}

		private fun observeBaseFunctions() {
				viewModel!!.getStatus()
						.observe(viewLifecycleOwner, Observer<Status> {
								Log.e(TAG, "observeBaseFunctions: ${it.toString()}")
						})

		}

}
