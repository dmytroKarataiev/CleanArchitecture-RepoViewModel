package com.example.viewmodelrepomemoryleak.repos

import androidx.lifecycle.MutableLiveData

/**
 * Repository which is responsible for all interactions with the local and remote data sources.
 * Usually it should be injected with a Data Access Object to perform database reads/writes
 * and an Api Manager (Network client).
 *
 * Open for testing to create a MockRepo.
 */
class Repo(id: MutableLiveData<Long>): AbstractRepo(id) {

    init {
        addSource(id) { number ->
            value = number
        }
    }

}