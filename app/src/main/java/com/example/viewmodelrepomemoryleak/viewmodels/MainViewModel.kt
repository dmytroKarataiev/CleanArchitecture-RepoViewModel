package com.example.viewmodelrepomemoryleak.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelrepomemoryleak.repos.AbstractRepo
import com.example.viewmodelrepomemoryleak.repos.Repo

/**
 * ViewModel that is injected with a Repository which emits data to views.
 */
class MainViewModel(private val repo: AbstractRepo<Long>) : ViewModel() {

    val id = MediatorLiveData<Long>()

    init {
        id.addSource(repo) {
            id.value = it
        }
    }

    fun setId(stafferId: Long) {
        repo.observable.value = stafferId
    }

    override fun onCleared() {
        super.onCleared()
        repo.onClear()
    }

}

/**
 * Factory for [MainViewModel].
 */
object LiveDataMainFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val id = MutableLiveData<Long>()
        val repo = Repo(id)

        @Suppress("UNCHECKED_CAST")
        return MainViewModel(
            repo
        ) as T
    }

}