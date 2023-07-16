package com.bignerdranch.android.testapplication.utils

class IndexClickListener(val clickListener: (Int) -> Unit) {
    fun onClick(index: Int) = clickListener(index)
}
