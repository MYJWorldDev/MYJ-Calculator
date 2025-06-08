package com.yousufjamil.calculator.sessionhistory

object CalcHistory {
    private val _history = mutableListOf<String>()
    val history: List<String> = _history

    fun AddToHistory(item: String) {
        _history.add(item)
    }
}