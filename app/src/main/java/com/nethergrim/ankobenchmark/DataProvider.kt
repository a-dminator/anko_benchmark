package com.nethergrim.ankobenchmark

import java.util.*

/**
 * Created by andrej on 17.04.16.
 */
object DataProvider {

    private val users: List<User>

    init {
        var result = ArrayList<User>()
        for (i in 0..500) {
            result.add(User("Random name $i", "Random title $i", "http://developer.android.com/images/brand/Android_Robot_100.png", if (randomBool()) "Today" else "Yesterday"))
        }
        users = result
    }

    fun provideUsers(): List<User> {
        return users
    }

    fun randomBool(): Boolean {
        return Random().nextBoolean()
    }
}


data class User(var name: String, var title: String, var avatarUrl: String, var lastSeen: String)