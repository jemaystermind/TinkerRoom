/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerroom.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.jemaystermind.tinkerroom.data.PersonRepository
import com.jemaystermind.tinkerroom.db.Person

/**
 * @author Jeremy Tecson
 */
class PersonViewModel(private val repository: PersonRepository) : ViewModel() {

  private var userID: Long = 0L
  private lateinit var person: LiveData<Person>

  fun init(id: Long) {
    this.userID = id
    person = repository.getPerson(id)
  }

  fun getPerson() = person
}
