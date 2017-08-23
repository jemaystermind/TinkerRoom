package com.jemaystermind.tinkerroom.presentation

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.os.Bundle
import com.jemaystermind.tinkerroom.R
import com.jemaystermind.tinkerroom.data.PersonRepository
import com.jemaystermind.tinkerroom.db.AppDatabaseProvider
import com.jemaystermind.tinkerroom.db.Person
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : LifecycleActivity() {

  lateinit var personViewModel: PersonViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

//    Single.fromCallable {
//      AppDatabaseProvider.database()
//          .personDao()
//          .insertAll(Person(0, "Jeremy", "Tecson"))
//    }.subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe()
//
//    AppDatabaseProvider.database()
//        .personDao()
//        .getAllPeople()
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe { println(it) }


    personViewModel = ViewModelFactory(
        PersonRepository(AppDatabaseProvider.database().personDao())).create(
        PersonViewModel::class.java)
    personViewModel.init(1)

    personViewModel.getPerson().observe(this, Observer<Person> {
      println("Person=$it")
      hello.text = it?.firstName
    })
  }
}
