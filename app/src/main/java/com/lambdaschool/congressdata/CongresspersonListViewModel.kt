package com.lambdaschool.congressdata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

import java.util.ArrayList

class CongresspersonListViewModel : ViewModel() {
    private var overviewList: LiveData<ArrayList<OfficialOverview>>? = null

    fun getOverviewList(): LiveData<ArrayList<OfficialOverview>>? {
        if (overviewList == null) {
            loadList()
        }
        return overviewList
    }

    private fun loadList() {
        overviewList = OverviewListRepository.overviewList
    }
}
