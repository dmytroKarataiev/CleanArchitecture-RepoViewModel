package com.example.viewmodelrepomemoryleak.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData

class Repo(val stafferId: MutableLiveData<Long>): MediatorLiveData<Long>() {

    private val query: LiveData<Long> = MutableLiveData<Long>()

    init {
        addSource(stafferId) {
            (query as MutableLiveData).value = it
        }
        addSource(query) { staffers ->
            value = staffers
        }
    }

}