package com.example.pokemon

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
//        delay(1000)
        println("hello")
    }
    job.start()
    delay(1000)
    println("world")
}

