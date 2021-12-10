package com.vohidov.dialogs

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_layout.*
import kotlinx.android.synthetic.main.dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogAlert.setOnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)

            dialog.setMessage("You wanna quit?")

            dialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "Positive pressed", Toast.LENGTH_SHORT).show()
                }
            })

            dialog.setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@MainActivity, "No pressed", Toast.LENGTH_SHORT).show()
                }
            })

            dialog.show()
        }

        dialogCustom.setOnClickListener {
            val view = View.inflate(this@MainActivity, R.layout.dialog_layout, null) // Copyright.

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            view.btn_yes.setOnClickListener {
                Toast.makeText(this, "Yes pressed", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            view.btn_no.setOnClickListener {
                Toast.makeText(this, "No pressed", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            dialog.show()
        }

        dialogFragment.setOnClickListener {
            val dialogFragment = FragmentDialog()

            dialogFragment.show(supportFragmentManager.beginTransaction(), "keys")
        }

        dialogDatePicker.setOnClickListener {
            val datePickerDialog = DatePickerDialog(this@MainActivity)

            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(this, "${dayOfMonth}.${month + 1}.$year", Toast.LENGTH_SHORT).show()
            }

            datePickerDialog.show()
        }

        dialogTimePicker.setOnClickListener {
            val dialogTimePicker = TimePickerDialog(
                    this,
                    object : TimePickerDialog.OnTimeSetListener {
                        override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                            Toast.makeText(this@MainActivity, "$hourOfDay:$minute", Toast.LENGTH_SHORT)
                                    .show()
                        }
                    }, 24, 60, true
            )

            dialogTimePicker.updateTime(12, 50)
            dialogTimePicker.show()
        }

        bottomSheetDialog.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(
                    layoutInflater.inflate(
                            R.layout.dialog_layout,
                            null,
                            false
                    )
            )

            bottomSheetDialog.btn_yes.setOnClickListener {
                Toast.makeText(this, "Yes Pressed", Toast.LENGTH_SHORT).show()
            }

            bottomSheetDialog.btn_no.setOnClickListener {
                Toast.makeText(this, "No Pressed", Toast.LENGTH_SHORT).show()
            }

            bottomSheetDialog.show()
        }

        snackbar.setOnClickListener {
            val snackbar = Snackbar.make(it, "Jamshidbek watching you!", Snackbar.LENGTH_LONG)

            snackbar.setAction("Press", object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(this@MainActivity, "Pressed", Toast.LENGTH_SHORT).show()
                }
            })

            snackbar.show()
        }
    }
}