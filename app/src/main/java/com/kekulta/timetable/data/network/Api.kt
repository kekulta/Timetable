package com.kekulta.timetable.data.network

/**
 * All of the information I figured out about timetable api of the website
 * I have no idea  what all this stuff mean and why it looks like it looks but it still works
 * There is one endpoint and concerns separated by params(lowercase-snake-case without comments)
 */
object Api {
    /**
     * Common parameters for groups and timetable requests
     */
    object Common {
        const val p_p_id = "pubStudentSchedule_WAR_publicStudentSchedule10"
        const val p_p_lifecycle = "2"
        const val p_p_mode = "view"
        const val p_p_cacheability = "cacheLevelPage"
        const val p_p_col_id = "column-1"
        const val p_p_col_count = "1"

        /**
         * Base url for KAI website
         */
        const val KAI_BASE_URL = "https://kai.ru"

        /**
         * This is common endpoint for both requests
         * I have no idea why this is common and concerns separated by params and not by endpoints
         * Feels wrong to me but btw who I am to judge
         */
        const val ENDPOINT = "raspisanie"
    }

    /**
     * Specific parameters to request json with timetable
     * This should be a POST request
     */
    object Timetable {
        const val p_p_state = "normal"
        const val p_p_resource_id = "schedule"

        /**
         * This should be added as header or you will get empty json
         */
        const val CONTENT_TYPE_HEADER = "Content-Type: application/x-www-form-urlencoded; charset=UTF-8"
    }

    /**
     * Specific parameters to request json with groups ids
     * This should be a GET request
     */
    object Groups {
        const val p_p_state = "normal\$"
        const val p_p_resource_id = "getGroupsURL"
    }
}