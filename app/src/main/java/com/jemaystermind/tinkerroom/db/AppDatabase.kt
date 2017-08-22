/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerroom.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * @author Jeremy Tecson
 */
@Database(entities = arrayOf(Person::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun personDao(): PersonDao
}
