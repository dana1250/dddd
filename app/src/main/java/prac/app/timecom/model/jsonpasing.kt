package prac.app.timecom.model

//https://stackoverflow.com/questions/41928803/how-to-parse-json-in-kotlin
/*var gson = Gson()
var mMineUserEntity = gson?.fromJson(response, MineUserEntity.MineUserInfo::class.java)*/

class jsonpasing{
    data class mm(
        val result : Result
    )
    
    data class Result(
        val emp_id: Int,
        val emp_name: String,
        val emp_phone: String,
        val emp_dept: String,
        val emp_pwd: String
    )
}
