package com.openkotlin.jqacoount.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonParseException
import kotlinx.coroutines.*
import java.net.SocketTimeoutException

/**
 *
 *  Current name : BaseViewModel in `JQAcoount`
 *
 *  Created by Tanck on 2019-11-14 11:05.
 *
 *  Note : N/A
 *
 */
abstract class BaseViewModel : ViewModel() {

    /**
     * This is template for shows how to working with the coroutine.
     */
    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(e: Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit
    ) {
        coroutineScope {
            try {
                tryBlock()
            } catch (e: Throwable) {
                catchBlock(e)
            } finally {
                finallyBlock()
            }
        }
    }

    /**
     * A common exception handle method
     */
    fun handlingExceptions(e: Throwable) {

        // TODO : Adding a debug to here, Should be removed when the library is ready to go - Tanck
//        Log.e("Tanck", e.message)

        when (e) {
            is CancellationException -> {
            }
            is SocketTimeoutException -> {
            }
            is JsonParseException -> {
            }
            else -> {
            }
        }
    }

    /**
     * The block will running on the IO of dispatcher
     */
    fun launchOnIO(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(e: Throwable) -> Unit = {},
        finallyBlock: suspend CoroutineScope.() -> Unit = {}
    ) {
        /**
         * [CoroutineScope] tied to this [ViewModel].
         * This scope will be canceled when ViewModel will be cleared, i.e [ViewModel.onCleared] is called
         *
         * This scope is bound to [Dispatchers.Main]
         */
        viewModelScope.launch(Dispatchers.IO) {
            tryCatch(tryBlock, catchBlock, finallyBlock)
        }
    }

    /**
     * The block will running on the MAIN of dispatcher
     */
    fun launchOnMain(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(e: Throwable) -> Unit = {},
        finallyBlock: suspend CoroutineScope.() -> Unit = {}
    ) {
        /**
         * [CoroutineScope] tied to this [ViewModel].
         * This scope will be canceled when ViewModel will be cleared, i.e [ViewModel.onCleared] is called
         *
         * This scope is bound to [Dispatchers.Main]
         */
        viewModelScope.launch {
            tryCatch(tryBlock, catchBlock, finallyBlock)
        }
    }

    /**
     * This scope will be canceled when ViewModel will be cleared, i.e [ViewModel.onCleared] is called
     */
    override fun onCleared() {
        super.onCleared()
        // Note: Please remember invoke the `cancel` method when the onCleared is invoked
        viewModelScope.cancel()
    }
}