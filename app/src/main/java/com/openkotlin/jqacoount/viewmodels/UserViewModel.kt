package com.openkotlin.jqacoount.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.openkotlin.jqacoount.api.UserApi
import com.openkotlin.jqacoount.data.rsp.UserAccountRsp

/**
 *
 *  Current name : UserViewModel in `JQAcoount`
 *
 *  Created by Tanck on 2019-11-14 15:31.
 *
 *  Note : N/A
 *
 */
class UserViewModel : BaseViewModel() {


    private val repository by lazy { UserApi() }

    var userAccountRsps: MutableLiveData<List<UserAccountRsp>> = MutableLiveData()

    init {
        updateAllAccount()
    }

    fun updateAllAccount() {
        launchOnIO(
            tryBlock = {
                // 1. Try with server to get data
                val serverMsg = repository.queryAllAccounts()
                // 2. Update the data to live data
                // Switch to the UI thread
                userAccountRsps.postValue(serverMsg)
//                msg.value = serverMsg.message
                Log.d("Tanck", "tryBlock Block: $serverMsg")
            },
            catchBlock = {
                userAccountRsps.postValue(null)
            },
            finallyBlock = {

            }
        )
    }

}