package com.hooleyapp.organizer.data.plaidremote

import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.remote.callback.IGenericCallBack
import com.hooleyapp.organizer.utilities.Constants
import com.hooleyapp.organizer.utilities.extensions.hideAppLoader
import com.hooleyapp.organizer.utilities.extensions.onTokenExpiredLogout
import com.hooleyapp.organizer.utilities.extensions.showAppLoader
import com.hooleyapp.organizer.view.ui.base.ActivityBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException


object SingleEnqueueCallPlaid {

    var snackbar = Snackbar.make(
        ActivityBase.activity.findViewById(android.R.id.content),
        Constants.CONST_NO_INTERNET_CONNECTION,
        Snackbar.LENGTH_INDEFINITE)

    fun <T> callRetrofit(
        call: Call<T>,
        strApiName: String,
        isLoaderShown: Boolean,
        apiListener: IGenericCallBack
    ) {
        if (isLoaderShown)
            ActivityBase.activity.showAppLoader()
        snackbar.dismiss()
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                hideAppLoader()
                if (response.isSuccessful) {
                    apiListener.success(strApiName, response.body())
                } else {
                    when {
                        response.code() == 401 -> {
                            onTokenExpiredLogout()
                            return
                        }
                        response.errorBody() != null -> try {
                            val gson = GsonBuilder().create()
                            try {
                                val errorModel: GeneralResponseModel = gson.fromJson(
                                    response.errorBody()!!.string(),
                                    GeneralResponseModel::class.java
                                )
                                apiListener.failure(strApiName, errorModel.message)
                            } catch (ex: Exception) {
                                ex.printStackTrace()
                                apiListener.failure(
                                    strApiName,
                                    Constants.CONST_SERVER_NOT_RESPONDING
                                )
                            }
                        } catch (e: IOException) {
                            e.printStackTrace()
                            apiListener.failure(strApiName, Constants.CONST_SERVER_NOT_RESPONDING)
                        }
                        else -> {
                            apiListener.failure(strApiName, Constants.CONST_SERVER_NOT_RESPONDING)
                            return
                        }
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                hideAppLoader()
                val callBack = this
                if (t.message != "Canceled") {
                    if (t is UnknownHostException || t is IOException) {
                            snackbar.setAction("Retry") {
                                snackbar.dismiss()
                                enqueueWithRetry(call, callBack, isLoaderShown)
                            }
                            snackbar.show()
                        apiListener.failure(strApiName, Constants.CONST_NO_INTERNET_CONNECTION)
                    } else {
                        apiListener.failure(strApiName, t.toString())
                    }
                }
            }
        })
    }

    fun <T> enqueueWithRetry(call: Call<T>, callback: Callback<T>, isLoaderShown: Boolean) {
        ActivityBase.activity.showAppLoader()
        call.clone().enqueue(callback)
    }
}
