package com.lambdaschool.congressdata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log

import com.lambdaschool.congressdataapiaccess.CongressDao
import com.lambdaschool.congressdataapiaccess.CongresspersonOverview

import java.util.ArrayList

object OverviewListRepository {
    val overviewList: LiveData<ArrayList<OfficialOverview>>
        get() {
            Log.i("Repository", "Retreiving Data")
            val listLiveData = MutableLiveData<ArrayList<OfficialOverview>>()

            val overviews = ArrayList<OfficialOverview>()
            val allMembers = CongressDao.getAllMembers()

            for (member in allMembers) {
                overviews.add(OfficialOverview(member))
            }

            listLiveData.value = overviews

            return listLiveData
        }
}
