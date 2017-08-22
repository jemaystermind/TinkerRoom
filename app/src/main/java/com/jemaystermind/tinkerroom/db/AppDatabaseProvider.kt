package com.jemaystermind.tinkerroom.db

import android.arch.persistence.room.Room
import android.content.Context

/**
 * @author Jeremy Tecson
 */
object AppDatabaseProvider {
  private lateinit var database: AppDatabase

  fun init(context: Context) {
    val applicationContext = context.applicationContext
    database = Room.databaseBuilder(applicationContext, AppDatabase::class.java,
        "tinker-room").build()
  }

  fun database(): AppDatabase {
    return database
  }
}
