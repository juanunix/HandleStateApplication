package com.juansanz.handlestateapplication

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var mSavedStateViewModel: SavedStateViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.saved_state_activity)

        // Obtain the ViewModel
        mSavedStateViewModel = ViewModelProvider(this).get(SavedStateViewModel::class.java)

        // Show the ViewModel property's value in a TextView
        mSavedStateViewModel!!.name.observe(this,
            Observer<String?> { savedString ->
                (findViewById<View>(R.id.saved_vm_tv) as TextView).text =
                    getString(R.string.saved_in_vm, savedString)
            })

        // Save button
        findViewById<View>(R.id.save_bt).setOnClickListener {
            val newName = (findViewById<View>(R.id.name_et) as EditText).text.toString()
            mSavedStateViewModel!!.saveNewName(newName)
        }
    }
}