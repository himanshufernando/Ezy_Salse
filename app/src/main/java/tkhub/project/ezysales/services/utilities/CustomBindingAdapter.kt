package tkhub.project.ezysales.services.utilities

import android.graphics.Color
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter

object CustomBindingAdapter {
    @BindingAdapter("setMenuSelection")
    @JvmStatic
    fun setMenuSelection(view: ConstraintLayout, isSelect : Boolean) {
        if(isSelect){
            view.setBackgroundColor(Color.parseColor("#FFDA05"))
        }else{
            view.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

    }
}