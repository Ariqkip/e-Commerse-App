package com.deveric.esales.Services

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent

class Pop_Alert(context: Context, activity: Activity) {

    val context: Context = context
    val activity: Activity = activity

    fun showAlert(title: String, msg: String, redirect: Boolean, intent: Intent?){
        val builder = AlertDialog.Builder(context)
        val positiveButtonClick = { dialog: DialogInterface, which: Int ->
            if(redirect) {
                context.startActivity(intent);
                activity.finish()
            }
        }
        with(builder)
        {
            setTitle(title)
            setMessage(msg)
            setCancelable(true)
            setPositiveButton("Got it", DialogInterface.OnClickListener(function = positiveButtonClick))
            show()
        }
    }
}