/*
 * Copyright (C) 2017 Jeremy Tecson
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.jemaystermind.tinkerroom

import android.app.Application
import com.jemaystermind.tinkerroom.db.AppDatabaseProvider

/**
 * @author Jeremy Tecson
 */
class App : Application() {

  override fun onCreate() {
    super.onCreate()
    AppDatabaseProvider.init(this)
  }
}
