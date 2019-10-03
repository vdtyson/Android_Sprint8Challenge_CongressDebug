package com.lambdaschool.congressdata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class CongresspersonProfileViewModel(val id: String) : ViewModel() {
    private var profile: LiveData<CongresspersonProfile>? = null

    fun getProfile(): LiveData<CongresspersonProfile>? {
        if (profile == null) {
            loadProfile()
        }
        return profile
    }

    private fun loadProfile() {
        profile = ProfileRepository.getProfile(id)
    }
}
