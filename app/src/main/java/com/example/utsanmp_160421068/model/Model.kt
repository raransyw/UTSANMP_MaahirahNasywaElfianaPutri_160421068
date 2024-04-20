package com.example.utsanmp_160421068.model

data class Hobby(
    var id:Int,
    var title:String?,
    var sub:String?,
    var desc:String?,
    var image_url:String?,
    var created_at:String?,
    var users_id:Int,
    var username:String?
)

data class Users(
    var id:Int,
    var username:String?,
    var first_name:String?,
    var last_name:String?,
    var email:String?,
    var password:String?
)