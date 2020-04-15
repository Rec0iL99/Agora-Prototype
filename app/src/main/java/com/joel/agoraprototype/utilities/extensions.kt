package com.joel.agoraprototype.utilities

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty

fun Context.toastSuccess( message : String ) {
    Toasty.success(this, message, Toast.LENGTH_SHORT, true).show()
}