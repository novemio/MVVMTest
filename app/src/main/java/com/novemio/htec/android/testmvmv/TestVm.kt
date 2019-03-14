package com.novemio.htec.android.testmvmv

import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate


/**
 * Created by novemio on 3/14/19.
 */
class TestVm : BaseViewModel() {

    var name = MutableLiveData<NameString>()


    fun getData() {
        val nameString = NameString.onSuccess("Milan")

        name.postValue(nameString)
        Timer().scheduleAtFixedRate(5, 500) {

            if (name.value is NameString.onSuccess) {
                var value = (name.value as NameString.onSuccess).string + "dawdwadwa"
                name.postValue(NameString.onSuccess(value))
            }


        }


        Timer().schedule(5000) {
            name.postValue(NameString.onError("Jbg radi"))

        }


        Timer().schedule(5000) {
            setStatus(Status.NETWORK_ERROR)

        }
    }
}


sealed class NameString {
    data class onSuccess(val string: String) : NameString()
    data class onError(val msg: String) : NameString()
}