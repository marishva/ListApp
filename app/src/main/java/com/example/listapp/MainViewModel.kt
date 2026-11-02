package com.example.listapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val key = "cards_count"
    var count: Int
        get() = state.get<Int>(key) ?: 0
        set(value) { state.set(key, value) }
    fun addCard() {
        count = count + 1
    }
}