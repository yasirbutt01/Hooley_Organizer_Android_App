package com.hooleyapp.organizer.view.ui.bottomsheet

import android.annotation.SuppressLint
import android.app.Dialog
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hooleyapp.organizer.R
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("ValidFragment")
class BottomSheetDatePickerFragment constructor(var selectedDate: String, var type: String, var endDate: String, var startDate: String) : BottomSheetDialogFragment() {

    private lateinit var mListener: ISelectDobListener
    private var mYear: Int = 0
    private var mMonth: Int = 0
    private var mDay: Int = 0

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, R.layout.fragment_bottom_sheet_date_picker, null)
        dialog.setContentView(contentView)
        val datepicker: DatePicker = dialog.findViewById(R.id.date_picker)
        when (type) {
            "start" -> {
                datepicker.minDate = Calendar.getInstance().timeInMillis
            }
            "end" -> {
                if (startDate == "")
                    datepicker.minDate = Calendar.getInstance().timeInMillis
                else {
                    val sdf = SimpleDateFormat("yyyy-MM-dd")
                    val date = sdf.parse(startDate)
                    datepicker.minDate = date.time
                }

            }
        }

        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val date = sdf.parse(endDate.split("T")[0])
        datepicker.maxDate = date.time

        val c: Calendar = Calendar.getInstance()
        if (!TextUtils.isEmpty(selectedDate)) {
            val splitedDate = selectedDate.split("-")
            mYear = Integer.parseInt(splitedDate[0])
            mMonth = Integer.parseInt(splitedDate[1]) - 1
            mDay = Integer.parseInt(splitedDate[2])
        } else {
            mYear = c.get(Calendar.YEAR)
            mMonth = c.get(Calendar.MONTH)
            mDay = c.get(Calendar.DAY_OF_MONTH)
        }
        (contentView.parent as View).setBackgroundColor(resources.getColor(android.R.color.transparent))
        datepicker.updateDate(mYear, mMonth, mDay)
        dialog.findViewById<Button>(R.id.btnSelect).setOnClickListener {

            mListener.onSelectDob("" + datepicker.year + "-" + (datepicker.month + 1) + "-" + datepicker.dayOfMonth, type)
            dialog.dismiss()
        }
    }


    fun setMyListener(listener: ISelectDobListener) {
        mListener = listener
    }

    interface ISelectDobListener {
        fun onSelectDob(dob: String, type: String)

    }
}