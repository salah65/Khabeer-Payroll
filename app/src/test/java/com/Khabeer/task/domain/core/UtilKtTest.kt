package com.Khabeer.task.domain.core

import com.khabeer.task.app.core.formatDate
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilKtTest {
    @Test
    fun `formateDate with valid date then return formatted date`() {
        val actual = formatDate("09/2021")
        val expected = "سبتمبر ,2021"
        //assert
        assertEquals(expected, actual)
    }
}