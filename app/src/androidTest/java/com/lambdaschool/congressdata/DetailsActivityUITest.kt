package com.lambdaschool.congressdata


import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import java.nio.file.Files.exists

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DetailsActivityUITest {
    companion object {
        private val congresspersonProfileViewModel = CongresspersonProfileViewModel()
        private const val id = 1
    }
   @Rule
   @JvmField
   var activityScenarioRule = ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun checkNameText() {

        // SETUP

        // EXECUTE


        // CHECK
        onView(withId(R.id.profile_name))
                .check(matches(withText("Trent P. Kelly")))
    }
    @Rule
    @JvmField
    var activityScenarioRule2 = ActivityScenarioRule(DetailsActivity::class.java)
    @Test
    fun checkParty() {

        // CHECK
        onView(withId(R.id.profile_party))
                .check(matches(withText("Republican")))
    }
}


