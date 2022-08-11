package com.hooleyapp.organizer.view.ui.auth

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hooleyapp.organizer.HooleyApp
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.data.model.requestmodel.ForgotPasswordRequestModel
import com.hooleyapp.organizer.databinding.FragmentResetPasswordBinding
import com.hooleyapp.organizer.utilities.Constants
import com.hooleyapp.organizer.utilities.extensions.hideKeyboard
import com.hooleyapp.organizer.utilities.extensions.isEmailValid
import com.hooleyapp.organizer.utilities.extensions.showErrorDialogBox
import com.hooleyapp.organizer.utilities.extensions.validateEmail
import com.hooleyapp.organizer.utilities.helper.CustomTypefaceSpan
import com.hooleyapp.organizer.view.ui.base.ActivityBase
import com.hooleyapp.organizer.view.ui.base.BaseFragment
import com.hooleyapp.organizer.view.ui.main.HooleyOrganizerMain
import com.hooleyapp.organizer.viewmodel.auth.LoginViewModel

class ResetPasswordFragment : BaseFragment(), View.OnClickListener, TextWatcher {

    lateinit var binding : FragmentResetPasswordBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_reset_password,container,false)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        setUiObserver()
        binding.isResetSuccess = false
        setListener()
        return binding.root
    }


    private fun setUiObserver() {

        loginViewModel.failureMessage.observe(this, Observer {
            it?.let { it ->
                ActivityBase.activity.showErrorDialogBox(it)
            }
        })

        loginViewModel.objResponseGeneral.observe(this, Observer { obj ->
            val email = getColoredSpanned(binding.etEmail.text.toString(), "#FF6C00")
            val font = Typeface.createFromAsset(ActivityBase.activity.assets, "fonts/roboto_bold.ttf")
            val ss = SpannableStringBuilder(HtmlCompat.fromHtml("Check your email <b>${email}</b> to reset your password and continue to Sign In.<br><br>Don't forget to check your spam folder too!", HtmlCompat.FROM_HTML_MODE_COMPACT))
            ss.setSpan(CustomTypefaceSpan("", font), 20, email.length - 25, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
            binding.tvDescription.text = ss
            binding.isResetSuccess = true
            binding.root.hideKeyboard()
        })
    }
    private fun setListener(){
        binding.btnResetPassword.setOnClickListener(this)
        binding.btnSigIn.setOnClickListener(this)
        binding.rlBack.setOnClickListener(this)
        binding.etEmail.addTextChangedListener(this)
    }

    private fun validInput() : Boolean{
        if (binding.etEmail.validateEmail("Please enter valid email")){
            return false
        }
        return true
    }

    private fun getColoredSpanned(text: String, color: String): String {
        return "<font face='elephant' color=$color>$text</font>"
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btnResetPassword -> {
                if (validInput()) {
                    callForgetPassword()
                }
            }
            R.id.btnSigIn -> {
                binding.root.hideKeyboard()
                ActivityBase.activity.supportFragmentManager.popBackStackImmediate()
            }
            R.id.rlBack -> {
                binding.root.hideKeyboard()
                ActivityBase.activity.supportFragmentManager.popBackStackImmediate()
            }

        }
    }

    override fun afterTextChanged(p0: Editable?) {
        checkAndSet()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    private fun checkAndSet() {
        binding.emailVerified = !TextUtils.isEmpty(binding.etEmail.text.toString()) && ActivityBase.activity.isEmailValid(binding.etEmail.text.toString())
    }

    private fun callForgetPassword(){
        loginViewModel.forgetPassword(ForgotPasswordRequestModel(binding.etEmail.text.toString()))
    }
}