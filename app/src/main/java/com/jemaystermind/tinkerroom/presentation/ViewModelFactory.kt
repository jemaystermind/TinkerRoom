package com.jemaystermind.tinkerroom.presentation;

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jemaystermind.tinkerroom.data.PersonRepository

class ViewModelFactory(private val dataSource: PersonRepository) : ViewModelProvider.Factory {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
      @Suppress("UNCHECKED_CAST")
      return PersonViewModel(dataSource) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}
