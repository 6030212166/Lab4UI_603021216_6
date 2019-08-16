package com.example.lab4

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar.getInstance
import javax.security.auth.Subject


class TimePickerFragment : DialogFragment () , TimePickerDialog.OnTimeSetListener {
   @RequiresApi(Build.VERSION_CODES.N)
   override fun onCreateDialog(savedInstanceState: Bundle?) : Dialog {

    val c = Calendar.getInstance()
    val hour = c.get(Calendar.HOUR_OF_DAY)
    val minute = c.get(Calendar.MINUTE)

    return TimePickerDialog(activity,2,this, hour, minute,true )}


override fun onTimeSet(View: TimePicker, hour0fDay:Int, minute: Int ) {
    val minuteNew : String = if (minute<10) "0${minute.toString()}" else minute.toString()
    activity?.findViewById<TextView>(R.id.text_time)?.text = "$hour0fDay : $minuteNew"
}
override fun onCancel(dialog: DialogInterface?) {
    Toast.makeText(activity,"Please select a time ." , Toast.LENGTH_SHORT).show()
    super.onCancel(dialog)
}

}
