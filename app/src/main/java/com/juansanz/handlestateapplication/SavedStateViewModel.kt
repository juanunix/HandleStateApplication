package com.juansanz.handlestateapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavedStateViewModel(  // getLiveData obtains an object that is associated with the key wrapped in a LiveData
    private val mState: SavedStateHandle
) : ViewModel() {
    // so it can be observed for changes.
    // Expose an immutable LiveData
    val name: LiveData<String>
        get() =// getLiveData obtains an object that is associated with the key wrapped in a LiveData
            // so it can be observed for changes.
            mState.getLiveData(NAME_KEY)

    fun saveNewName(newName: String?) {
        // Sets a new value for the object associated to the key. There's no need to set it
        // as a LiveData.
        mState.set(NAME_KEY, newName)
    }

    companion object {
        private const val NAME_KEY = "name"
    }
}