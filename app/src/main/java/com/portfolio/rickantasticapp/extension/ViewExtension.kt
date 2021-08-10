package com.portfolio.rickantasticapp.extension

import android.view.View

fun View.hide(){
    this.visibility = View.INVISIBLE
}
fun View.remove(){
    this.visibility = View.GONE
}
fun View.show(){
    this.visibility = View.VISIBLE
}