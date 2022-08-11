package com.hooleyapp.organizer.data.model.requestmodel

data class ScanTicketRequestModel(val event_id : Int , val qr_info : QrInfo)

data class QrInfo(val ticket_id : String)