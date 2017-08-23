/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerroom.data

import android.arch.lifecycle.LiveData
import com.jemaystermind.tinkerroom.db.Person
import com.jemaystermind.tinkerroom.db.PersonDao

/**
 * @author Jeremy Tecson
 */
class PersonRepository(private val personDao: PersonDao) {

  fun getPerson(userId: Long): LiveData<Person> {
    return personDao.getPersonById(userId)
//    return MutableLiveData<Person>().apply {
//      value = Person(userId, "Tok", "Hang")
//    }
  }
}
