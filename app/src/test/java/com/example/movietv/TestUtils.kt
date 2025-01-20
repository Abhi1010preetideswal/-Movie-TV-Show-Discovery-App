package com.example.movietv

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.mockito.Mockito

object TestUtils {

    fun <T> LiveData<T>.testObserver(): Observer<T> {
        val observer: Observer<T> = Mockito.mock(Observer::class.java) as Observer<T>
        this.observeForever(observer)
        return observer
    }
}
