package com.hooleyapp.organizer.data.model.requestmodel

data class AddUpdateAnnouncementRequestModel(val id : Int , val event_id : Int , val announcement : String , val broadcast_all : Boolean , val broadcast_here_now : Boolean , val remove_image : Boolean)

data class DeleteAnnouncementRequestModel(val id : Int)