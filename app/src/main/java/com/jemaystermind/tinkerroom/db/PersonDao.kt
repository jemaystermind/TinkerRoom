/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerroom.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface PersonDao {

  @Query("SELECT * FROM persons where uid = :id")
  fun getPersonById(id: Long): LiveData<Person>

  @Query("SELECT * FROM persons")
  fun getAllPeople(): Flowable<List<Person>>

  @Query("SELECT * FROM persons WHERE first_name = (:names)")
  fun collectionTest(names: List<String>): LiveData<List<Person>>

  @Insert
  fun insertAll(vararg persons: Person)

  @Delete
  fun delete(person: Person)
}
