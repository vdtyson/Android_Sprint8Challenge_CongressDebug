package com.lambdaschool.congressdata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class CongresspersonProfileViewModel(var id: String?) : ViewModel() {
    var profile: LiveData<CongresspersonProfile>? = null
    get() {
        return if (field == null) {
            loadProfile()
        } else {
            field
        }
    }

    private fun loadProfile(): LiveData<CongresspersonProfile>? {
        profile = ProfileRepository.getProfile(id)
        return profile
    }
}
