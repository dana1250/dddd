package prac.app.timecom.model

import com.google.gson.annotations.SerializedName

data class Mystar(
    @SerializedName("emp_id")
    val emp_id : String,
    @SerializedName("emp_name")
    val emp_name: String,
    @SerializedName("emp_phone")
    val emp_phone : String,
    @SerializedName("emp_dept")
    val emp_dept : String,
    @SerializedName("emp_pwd")
    val emp_pwd : String )
