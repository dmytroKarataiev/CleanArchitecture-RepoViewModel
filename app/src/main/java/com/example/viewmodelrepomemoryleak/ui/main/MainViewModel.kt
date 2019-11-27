package com.example.viewmodelrepomemoryleak.ui.main

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(val repo: Repo) : ViewModel() {

    val staffer = MediatorLiveData<Long>()

    init {
        staffer.addSource(repo) {
            staffer.value = it
        }
    }

    fun setId(stafferId: Long) {
        repo.stafferId.value = stafferId
    }

    override fun onCleared() {
        super.onCleared()
//        repo.teardown()
    }
}


/**
 * Factory for [MainViewModel].
 */
object LiveDataMainFactory : ViewModelProvider.Factory {

    private val stafferId = MutableLiveData<Long>()
    private val repo = Repo(stafferId)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(repo) as T
    }

}
