package com.jemaystermind.tinkerroom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jemaystermind.tinkerroom.db.AppDatabaseProvider
import com.jemaystermind.tinkerroom.db.Person
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    Single.fromCallable {
      AppDatabaseProvider.database()
          .personDao()
          .insertAll(Person(0, "Jeremy", "Tecson"))
    }.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe()

    AppDatabaseProvider.database()
        .personDao()
        .getAllPeople()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { println(it) }
  }
}
