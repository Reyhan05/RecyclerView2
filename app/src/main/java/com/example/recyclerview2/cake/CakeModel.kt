package com.example.recyclerview2.cake

/*
class CakeModel(
    var name: String,
    var type: String,
    var id: String
)*/

class CakeModel(
    var id: String = "",
    var type: String? = null,
    val batters: Batter
)

class Batter(
    val batter: ArrayList<BatterItem>
)

class BatterItem(
    var id: String = "",
    var type: String? = null
)
