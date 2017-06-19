package com.swayam.kotlintestapp.storage

/**
 * Created by rajesh on 14/6/17.
 */

data class Contact(var name: String, var number: String){

    var id : Int? = 0

    constructor(id: Int, name: String, number: String) : this(name, number){
        this.id = id
    }

}