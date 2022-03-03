package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {
    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter(viewContract, 0)
    }

    @Test
    fun onIncrement_equals() {
        presenter.onIncrement()
        assertEquals(presenter.getCount,1)
    }

    @Test
    fun onDecrement_equals() {
        presenter.onDecrement()
        assertEquals(presenter.getCount,-1)
    }

    @Test
    fun setCounter_equals() {
        presenter.setCounter(12)
        assertEquals(presenter.getCount,12)
    }

    @Test
    fun onIncrement_onDecrement_equals() {
        presenter.onIncrement()
        presenter.onDecrement()
        assertEquals(presenter.getCount,0)
    }

    @Test
    fun onIncrement_viewContract_setCount() {
        presenter.onIncrement()
        verify(viewContract, times(1)).setCount(1)
    }

    @Test
    fun onDecrement_viewContract_setCount() {
        presenter.onDecrement()
        verify(viewContract, times(1)).setCount(-1)
    }
}