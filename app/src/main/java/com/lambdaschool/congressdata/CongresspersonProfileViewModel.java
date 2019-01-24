package com.lambdaschool.congressdata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

public class CongresspersonProfileViewModel extends ViewModel {
    private LiveData<CongresspersonProfile> profile;
    private String                          id;

    public void init(String id) {
        this.id = id;
    }

    public LiveData<CongresspersonProfile> getProfile() {
        if (profile == null) {
            loadProfile();
        }
        return profile;
    }

    private void loadProfile() {
        profile = ProfileRepository.getProfile(id);
    }
}
