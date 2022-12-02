package com.example.gamedemo.model

import android.widget.ImageView

data class Move (
    val playerMove: ImageView,
    val computerMove: ImageView,
    val result: String?= null
)