package tkhub.project.ezysales.ui.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import tkhub.project.ezysales.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trasperat()

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)


    }
    override fun onResume() {
        super.onResume()

    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()

    }



    private fun trasperat() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
          window.statusBarColor = Color.WHITE
          window.navigationBarColor = Color.BLACK

    }
    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win =window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }
    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

}