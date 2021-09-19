package com.example.assigment.adapter

import android.graphics.Color
import android.graphics.Color.alpha
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.assigment.db.Contacts
import android.graphics.drawable.GradientDrawable
import java.util.*

@BindingAdapter("contactName")
fun TextView.setContactName(item: Contacts) {
    text = item.contactName
}

@BindingAdapter("contactNumber")
fun TextView.setContactNumber(item: Contacts) {
    text = item.contactNo
}

@BindingAdapter("contactType")
fun TextView.setContactType(item: Contacts) {
    text = item.contactType
}

@BindingAdapter("contactImage")
fun TextView.setProfilePic(item: Contacts) {
    val senderFirstLetter = item.contactName?.subSequence(0, 1) as String
    text = senderFirstLetter.uppercase()
    // To get random color
    val randomBackgroundColor = Random()
    val color: Int = Color.argb(
        255,
        randomBackgroundColor.nextInt(256),
        randomBackgroundColor.nextInt(256),
        randomBackgroundColor.nextInt(256)
    )
    setBackgroundColor(color)
}