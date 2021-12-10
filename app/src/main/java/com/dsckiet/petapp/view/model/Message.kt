package com.dsckiet.petapp.view.model

import com.squareup.moshi.Json

data class Message(
    @Json(name = "receiver")
    val recieve:String="Riciever",
    @Json(name="sender")
    val sender:String="Sender",
    @Json(name = "msg")
    val message: String="HEY BROTHER"
)
