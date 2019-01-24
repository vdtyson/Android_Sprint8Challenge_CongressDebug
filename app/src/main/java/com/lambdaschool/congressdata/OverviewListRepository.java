package com.lambdaschool.congressdata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import java.util.ArrayList;

public class OverviewListRepository {
    public static LiveData<ArrayList<OfficialOverview>> getOverviewList() {
        Log.i("Repository", "Retreiving Data");
        final MutableLiveData<ArrayList<OfficialOverview>> listLiveData = new MutableLiveData<>();

        ArrayList<OfficialOverview>       overviews  = new ArrayList<>();
        ArrayList<CongresspersonOverview> allMembers = CongressDao.getAllMembers();

        for (CongresspersonOverview member:allMembers) {
            overviews.add(new OfficialOverview(member));
        }

        listLiveData.setValue(overviews);

        return listLiveData;
    }
}
