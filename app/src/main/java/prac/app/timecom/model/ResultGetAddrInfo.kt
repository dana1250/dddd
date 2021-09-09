package prac.app.timecom.model

//https://velog.io/@yeji/Retrofit2-Open-API

data class ResultGetAddrState(
    var results : AddrResult
)

data class AddrResult(
    val common : AddrState,
    val juso : List<AddrInfo>
)

data class AddrState(
    var errorMessage : String = "",
    var countPerPage : String = "",
    var totalCount : String = "",
    var errorCode : String = "",
    var currentPage : String = ""
)

data class AddrInfo(
    var day : String = "",
    var date : String = ""
)

data class ResultGetCoordState(
    var results : CoordResult
)

data class CoordResult(
    val common : CoordState,
    val juso : List<CoordInfo>
)

data class CoordState(
    var errorMessage : String = "",
    var totalCount : String = "",
    var errorCode : String = ""
)

data class CoordInfo(
    var buldMnnm : String = "",
    var rnMgtSn : String = "",
    var bdNm : String = "",
    var entX : String = "",
    var entY : String = "",
    var admCd : String = "",
    var bdMgtSn : String = "",
    var buldSlno : String = "",
    var udrtYn : String = ""
)
