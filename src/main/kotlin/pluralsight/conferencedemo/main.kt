package pluralsight.conferencedemo

import com.pluralsight.conferencedemo.api.SessionsControllerApi

fun main() {
    val sessionsControllerApi = SessionsControllerApi()
    val data = sessionsControllerApi.list1()
    println(data.toString())
}