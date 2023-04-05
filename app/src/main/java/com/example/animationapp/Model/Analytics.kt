package com.example.animationapp.Model

import com.example.animationapp.Model.Onclick
import com.example.animationapp.Model.Onload
import com.example.animationapp.Model.Onsent

data class Analytics(
    val onclick: Onclick,
    val onload: Onload,
    val onsent: Onsent
)