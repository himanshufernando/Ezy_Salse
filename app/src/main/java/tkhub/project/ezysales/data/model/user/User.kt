package tkhub.project.ezysales.data.model.user

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "user")
@Parcelize
data class User(
    @PrimaryKey
    var user_id : Long,
    val user_uuid : String,
    var user_name : String,
    val user_email : String,
    var user_mobile : String,
    val user_emp_id : String,
    val user_is_active : Int,
    var user_password : String,
    var user_push_token : String,
    val user_profile : String,
    val user_level : Long

) : Parcelable {
    constructor() : this(0,"","","","","",0,"", "","",0)

}
