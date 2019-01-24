package com.lambdaschool.congressdata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class CongresspersonListViewModel extends ViewModel {
    private LiveData<ArrayList<OfficialOverview>> overviewList;

    public LiveData<ArrayList<OfficialOverview>> getOverviewList() {
        if (overviewList == null) {
            loadList();
        }
        return overviewList;
    }

    private void loadList() {
        overviewList = OverviewListRepository.getOverviewList();
    }
}
