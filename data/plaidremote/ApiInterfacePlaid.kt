package com.hooleyapp.organizer.data.plaidremote


import com.hooleyapp.organizer.data.model.requestmodel.*
import com.hooleyapp.organizer.data.model.responsemodels.announcement.GetAnnouncementResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.auth.LoginResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.community.GetCommunityAlertsResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.community.GetMediaReportsDetailResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.dashboard.GetDashboardResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.events.*
import com.hooleyapp.organizer.data.model.responsemodels.general.GeneralResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.manageteam.GetManageEventResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.more.GetContantResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.notification.GetUserNotificationResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.plaid.AuthResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.plaid.ExchangeTokenResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.promotion.GetEventPromoteResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.promotion.GetPromotionStatsResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.scan.GetScanStatsResponseModel
import com.hooleyapp.organizer.data.model.responsemodels.wallet.*
import com.hooleyapp.organizer.utilities.Constants
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.util.ArrayList


interface  ApiInterfacePlaid {

    @POST(Constants.PLAID_AUTH)
    fun auth(@Body obj: AuthRequestModel): Call<AuthResponseModel>

    @POST(Constants.PLAID_EXCHANGE_TOKEN)
    fun exchangeToken(@Body obj: ExchangeTokenRequestModel): Call<ExchangeTokenResponseModel>

}