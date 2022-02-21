package tkhub.project.ezysales.services.utilities

import android.content.Context

object AppPrefs {


    //shard pref keys
    const val PREFNAME = "sfapref"
    const val KEY_PUSH_ID = "push_id"


    const val KEY_USER = "user"

    //info Dialog Type
    const val INFO_DIALOG_ERROR = 1
    const val INFO_DIALOG_SUCCESS = 2

    //Error Code
     const val ERROR_INTERNET = 404



    //Customer Error Code 10
    const val ERROR_CUSTOMER_EMPTY_NAME = 2001
    const val ERROR_CUSTOMER_EMPTY_ADDRESS = 2002
    const val ERROR_CUSTOMER_EMPTY_DISTRICT = 2003
    const val ERROR_CUSTOMER_EMPTY_AREA = 2004
    const val ERROR_CUSTOMER_EMPTY_TOWN = 2005
    const val ERROR_CUSTOMER_EMPTY_ROUTE= 2006
    const val ERROR_CUSTOMER_EMPTY_STATUS= 2007
    const val ERROR_CUSTOMER_EMPTY_CONTACT_NUMBER= 2008
    const val ERROR_CUSTOMER_INVALID_CONTACT_NUMBER= 2009
    const val ERROR_CUSTOMER_INVALID_EMAIL= 2010


    //User Error Code 10
    const val ERROR_USER_EMPTY_MOBILE = 1005
    const val ERROR_USER_INVALID_MOBILE = 1006
    const val ERROR_USER_EMPTY_PASSWORD = 1007


    fun setPushIdPrefs(ctx: Context, id: String) {
        val sharedPref = ctx.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(KEY_PUSH_ID, id)
            commit()
        }
    }

    fun getPushIdPrefs(ctx: Context): String {
        val sharedPref = ctx.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE)
        return sharedPref.getString(KEY_PUSH_ID, "")!!
    }



}