package tkhub.project.ezysales.data.model.user

import tkhub.project.ezysales.data.model.BaseApiModal

data class UserBase(
    var error: Boolean,
    var message: String,
    var code:Int,
    var data : User
){
    constructor() : this(true, "",
        0, User()
    )

}
