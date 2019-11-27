package com.example.viewmodelrepomemoryleak.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.viewmodelrepomemoryleak.repos.AbstractRepo
import getOrAwaitValue
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.TimeoutException

/**
 * Example of a Unit test for a ViewModel with an injected Repo.
 */
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    // Class under test.
    private lateinit var viewModel: MainViewModel

    @Before
    fun initViewModel() {
        val id = MutableLiveData<Long>()
        viewModel = MainViewModel(FakeRepo(id))
    }

    @Test
    fun testGetId() {
        viewModel.setId(100)

        assertEquals(100, viewModel.id.getOrAwaitValue())
    }

    @Test(expected = TimeoutException::class)
    fun testGetIdDoesNotExist() {
        viewModel.setId(999)

        assertEquals(null, viewModel.id.getOrAwaitValue())
    }

}

class FakeRepo(id: MutableLiveData<Long>) : AbstractRepo(id) {

    init {
        addSource(id) {
            when (it) {
                100L -> {
                    value = it
                }
                999L -> {
                    // value will stay null
                }
            }
        }
    }

}