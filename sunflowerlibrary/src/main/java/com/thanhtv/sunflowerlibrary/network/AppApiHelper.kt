package com.thanhtv.sunflowerlibrary.network

import javax.inject.Inject

/**
 * Created by jyotidubey on 04/01/18.
 */
abstract class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {}