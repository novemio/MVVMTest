package com.novemio.htec.android.testmvmv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by novemio on 3/14/19.
 */
open class BaseViewModel : ViewModel() {

    private var status = MutableLiveData<Status>()

    fun getStatus() = status

    fun setStatus(status: Status) {
        this.status.postValue( status)
    }


}


enum class Status {
    NO_ERROR,
    NETWORK_ERROR
}