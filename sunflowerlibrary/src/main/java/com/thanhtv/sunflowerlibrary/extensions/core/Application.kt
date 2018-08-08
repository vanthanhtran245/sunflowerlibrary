package com.thanhtv.sunflowerlibrary.extensions.core

import android.app.Activity
import android.app.Application
import android.app.Fragment
import android.app.Service
import android.view.View
import android.support.v4.app.Fragment as SupportFragment


fun Activity.getApp(): Application = application

fun Service.getApp(): Application = application

fun View.getApp(): Application = context.applicationContext as Application

fun Fragment.getApp(): Application = activity.application

fun SupportFragment.getApp(): Application = activity!!.application


