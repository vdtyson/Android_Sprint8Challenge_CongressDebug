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

        val expected = "first middle last"
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

        val expected = "first last"
        // EXECUTE
        displayName = officialOverview.displayName!!
        // CHECK
        assertEquals(expected, displayName)
        // Error caused by buildDisplay name have "null" instead of null
    }
}