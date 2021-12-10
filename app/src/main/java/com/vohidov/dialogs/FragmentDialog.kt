package com.vohidov.dialogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.view.*


class FragmentDialog : DialogFragment() {

    lateinit var root : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_dialog, container, false)

        root.btn_yes1.setOnClickListener {
            Toast.makeText(root.context, "Ha ", Toast.LENGTH_SHORT).show()
        }
        root.btn_no1.setOnClickListener{
            Toast.makeText(root.context, "Yoq", Toast.LENGTH_SHORT).show()

        }

        return root
    }

}