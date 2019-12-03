package com.example.viewmodelrepomemoryleak.repos

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Repository which is responsible for all interactions with the local and remote data sources.
 * Usually it should be injected with a Data Access Object to perform database reads/writes
 * and an Api Manager (Network client).
 *
 * Open for testing to create a MockRepo.
 */
class Repo(id: MutableLiveData<Long>) : AbstractRepo<Long>(id) {

    init {
        addSource(id) { number ->

            scope.launch {
                val idValue: Long = 3
                delay(5000)
                postValue(idValue)
            }

            value = number
        }
    }

}