package com.lambdaschool.congressdata

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView


/*public class MainActivity extends LifecycleActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        MainActivityViewModel model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        model.getFruitList().observe(this, fruitlist -> {
            // update UI
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, fruitlist);
            // Assign adapter to ListView
            listView.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        });
    }
}*/


class MainActivity : AppCompatActivity() {

    private var layoutList: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var listAdapter: OverviewListAdapter? = null

    private var context: Context? = null
    private var viewModel: CongresspersonListViewModel? = null
    private var activity: Activity? = null

    var themeId: Int = 0
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        activity = this
        themeUtils.onActivityCreateSetTheme(activity!!)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this
        layoutList = findViewById(R.id.layout_list)
        layoutList!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        layoutList!!.layoutManager = layoutManager


        viewModel = ViewModelProviders.of(this).get(CongresspersonListViewModel::class.java!!)

        viewModel!!.overviewList!!.observe(this, { overviewList ->
            runOnUiThread {
                assert(overviewList != null)

                // using recycler view
                listAdapter = OverviewListAdapter(overviewList)
                layoutList!!.adapter = listAdapter

                // using scroll view
                /*for (OfficialOverview officialOverview : overviewList) {
                scrollData.addView(getDefaultTextView(officialOverview.getDisplayName(),
                                                      officialOverview.getId()));
            }*/
            }
        })
    }

    override fun setTheme(themeId: Int) {
        super.setTheme(themeId)
        this.themeId = themeId
    }


    override fun onStart() {
        if (themeId != themeUtils.getcTheme(activity)) {
            themeUtils.refreshActivity(activity!!)
        }
        super.onStart()
    }

    override fun onResume() {
        if (themeId != themeUtils.getcTheme(activity)) {
            themeUtils.refreshActivity(activity!!)
        }
        super.onResume()
    }

    /**
     * This method generates default TextView objects for the congressperson list in this activity.
     *
     * @param text display name for the congressperson
     * @param id   api id for the congressperson
     * @return TextView object with the text and tag set as provided
     */
    private fun getDefaultTextView(text: String, id: String): TextView {
        val dataView = TextView(context)
        dataView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
        dataView.setPadding(10, 20, 10, 20)
        dataView.typeface = Typeface.DEFAULT_BOLD
        dataView.text = text
        dataView.tag = id

        dataView.setOnClickListener { view ->
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("id", view.tag.toString())
            startActivity(intent)
        }
        return dataView
    }
}
