package tkhub.project.ezysales.ui.fragment.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tkhub.project.ezysales.R


class SplashFragment : Fragment() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)


    }


    override fun onResume() {
        super.onResume()

        try {
            lifecycleScope.launch(context = Dispatchers.Main) {
                delay(3000)
                goToLogin()

            }
        }catch (e : Exception){
            e.printStackTrace()
            goToLogin()
        }
    }


    private fun goToLogin(){ NavHostFragment.findNavController(this).navigate(R.id.fragment_splash_to_login) }
    private fun goToHome(){ NavHostFragment.findNavController(this).navigate(R.id.fragment_splash_to_dashboard) }
}