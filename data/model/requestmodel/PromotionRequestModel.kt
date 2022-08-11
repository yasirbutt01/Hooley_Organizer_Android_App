package com.hooleyapp.organizer.data.model.requestmodel

data class SavePromotionRequestModel(val regions : ArrayList<Regions> , val audiences : ArrayList<Int> , val amount : Int ,val start_time : String , val end_time : String , val event_id : Int ,
                                     val age_group : ArrayList<Int> , var stripe_token : String , var card_id : String)

data class Regions(var id : Int , var regions_cities : ArrayList<RegionsCity>)

data class RegionsCity(var id : Int)