package tkhub.project.ezysales.ui.fragment.login

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.HttpException
import tkhub.project.ezysales.R
import tkhub.project.ezysales.data.model.EzySalesResult
import tkhub.project.ezysales.databinding.FragmentLoginBinding
import tkhub.project.ezysales.services.utilities.AppPrefs
import tkhub.project.ezysales.ui.activity.MainActivity
import tkhub.project.ezysales.ui.dialog.InfoDialog
import tkhub.project.ezysales.viewmodels.login.LoinViewModel
import java.net.SocketTimeoutException


class LoginFragment : Fragment(),  View.OnClickListener,  InfoDialog.InfoDialogListener {

    private  lateinit var binding:FragmentLoginBinding
    private val viewmodel: LoinViewModel by activityViewModels()
    var appPrefs = AppPrefs
    lateinit var mainActivity: MainActivity
    private var disposable: Disposable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginViewModel = viewmodel
        return binding.root
    }
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mainActivity = (activity as MainActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListeners()


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

    override fun onClick(v: View) {
        if(viewmodel.layoutLoginLoading.get() == true){
           return
        }
        mainActivity.hideKeyboard()
        when (v.id) {
            R.id.cl_signin -> signIn()


        }

    }

    private fun showInfoDialog(message: String, code: Int, type: Int) {
        val dialogInfoFragment = InfoDialog.newInstance(message, code,type)
        dialogInfoFragment.setListener(this)
        dialogInfoFragment.show(activity?.supportFragmentManager!!, "")
    }
    override fun onInfoDialogPositive(code: Int) {

    }

    private fun clickListeners(){
        cl_signin.setOnClickListener(this)
        img_fingerprint.setOnClickListener(this)
    }

    private fun signIn(){
        viewmodel.userLogin().observe(viewLifecycleOwner, Observer {
            when (it) {
                is EzySalesResult.Success -> {
                    println("ccccccccccccccccccccccccccccccccccccccccc 05")
                }
                is EzySalesResult.LogicalError.LogError -> showInfoDialog(it.exception.message,0,appPrefs.INFO_DIALOG_ERROR)
                is EzySalesResult.ExceptionError.ExError -> {
                    when (it.exception) {
                        is HttpException -> showInfoDialog(resources.getString(R.string.network_failed),0,appPrefs.INFO_DIALOG_ERROR)
                        is SocketTimeoutException -> showInfoDialog(resources.getString(R.string.timeout),0,appPrefs.INFO_DIALOG_ERROR)
                        else -> showInfoDialog( resources.getString(R.string.something_went_wrong),0,appPrefs.INFO_DIALOG_ERROR)
                    }
                }
            }
        })

    }

}