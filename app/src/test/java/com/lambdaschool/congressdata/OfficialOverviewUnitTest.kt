package com.lambdaschool.congressdata

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`

class OfficialOverviewUnitTest {
    @Test
    fun returnDisplayName_WithMiddleName() {
        //SETUP

        val firstName = "First"
        val middleName = "Middle"
        val lastName = "Last"
        val party = "Republican"
        val state = "PA"
        val id = "id"

        val displayName: String
        val officialOverview = OfficialOverview(firstName, middleName, lastName, party, state, id)

        val expected = "First Middle Last"
        // EXECUTE
        displayName = officialOverview.displayName!!
        // CHECK
        assertEquals(expected, displayName)

    }

    @Test
    fun returnDisplayName_WithoutMiddleName() {
        //SETUP

        val firstName = "First"
        val lastName = "Last"
        val party = "Republican"
        val state = "PA"
        val id = "id"

        val displayName: String
        val officialOverview = OfficialOverview(firstName = firstName, lastName = lastName, party =  party, state = state,id =  id)

        val expected = "First Last"
        // EXECUTE
        displayName = officialOverview.displayName!!
        // CHECK
        assertEquals(expected, displayName)
        // Error caused by buildDisplay name have "null" instead of null
    }
    @Test
    fun returnDisplayName_WithJsonNullValue() {
        // SETUP
        val firstName = "First"
        val lastName = "Last"
        val middle = "null"
        val displayName: String
        val expected = "First Last"
        val officialOverview: OfficialOverview

        //EXECUTE
        officialOverview = OfficialOverview(firstName = firstName, middleName = middle, lastName = lastName)
        displayName = officialOverview.displayName!!

        // CHECK
        assertEquals(expected, displayName)
    }
    @Test
    fun returnDisplayName_WithActucalNullValue() {

        // SETUP
        val firstName = "First"
        val mName: String? = null
        val lName = "Last"
        val displayName: String
        val expected = "First Last"
        val officialOverview: OfficialOverview

        // EXECUTE
        officialOverview = OfficialOverview(firstName = firstName, middleName = mName, lastName = lName)
        displayName = officialOverview.displayName!!

        //CHECK

        assertEquals(expected,displayName)

    }
}