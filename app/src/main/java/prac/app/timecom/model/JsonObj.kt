package prac.app.timecom.model

import com.google.gson.annotations.SerializedName

data class JsonObj(
    @SerializedName("result")
    val result : List<Mystar>)
