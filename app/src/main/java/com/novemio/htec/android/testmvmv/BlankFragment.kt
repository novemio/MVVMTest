package com.novemio.htec.android.testmvmv


import android.util.Log
import androidx.lifecycle.Observer

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


private val TAG by lazy { BlankFragment::class.java.simpleName }

class BlankFragment : BaseFragment() {


    private val vm by lazy {
        getViewModel<TestVm>()

    }

    override fun getLayoutId() = R.layout.fragment_blank

    override fun initView() {
        setViewModel(vm)
        observeThings()
    }

    private fun observeThings() {
        vm.name.observe(viewLifecycleOwner, Observer<NameString> {
            when (it) {
                is NameString.onSuccess -> Log.d(TAG, "observeThings: ${it.string}")
                is NameString.onError -> Log.e(TAG, "observeThings: ${it.msg}")
            }

        })


        vm.getData()
    }


}
