/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerroom.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true) val uid: Long,
    @ColumnInfo(name = "first_name") val firstName: String = "",
    @ColumnInfo(name = "last_name") val lastName: String = "")
