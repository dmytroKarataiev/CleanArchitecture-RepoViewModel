package com.example.viewmodelrepomemoryleak

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelrepomemoryleak.repos.Repo

class MainViewModel(val repo: Repo) : ViewModel() {

    val id = MediatorLiveData<Long>()

    init {
        id.addSource(repo) {
            id.value = it
        }
    }

    fun setId(stafferId: Long) {
        repo.id.value = stafferId
    }

}

/**
 * Factory for [MainViewModel].
 */
object LiveDataMainFactory : ViewModelProvider.Factory {

    private val id = MutableLiveData<Long>()
    private val repo =
        Repo(id)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(
            repo
        ) as T
    }

}
