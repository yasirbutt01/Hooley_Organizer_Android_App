package com.hooleyapp.organizer.view.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hooleyapp.organizer.HooleyApp
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.databinding.FragmentLoginBinding
import com.hooleyapp.organizer.utilities.Constants
import com.hooleyapp.organizer.utilities.extensions.*
import com.hooleyapp.organizer.view.ui.base.ActivityBase
import com.hooleyapp.organizer.view.ui.base.BaseFragment
import com.hooleyapp.organizer.view.ui.main.HooleyOrganizerMain
import com.hooleyapp.organizer.viewmodel.auth.LoginViewModel


class LoginFragment  : BaseFragment(), View.OnClickListener, TextWatcher {

    lateinit var binding: FragmentLoginBinding
    lateinit var loginViewModel: LoginViewModel
    private var IS_FOR_AUTH_REQUEST_CODE = 1011
    private var authToken = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        setUiObserver()
        setListeners()
        return binding.root
    }

    private fun setUiObserver() {
        loginViewModel.failureMessage.observe(this, Observer {
            it?.let { it ->
                ActivityBase.activity.showErrorDialogBox(it)
            }
        })

        loginViewModel.objResponse.observe(this, Observer { obj ->
            HooleyApp.db.putString(Constants.USER_EMAIL,binding.etEmail.text.toString())
            HooleyApp.db.putString(Constants.ACCESS_TOKEN, obj.data!!.authToken!!)
            HooleyApp.db.putBoolean(Constants.CONST_IS_LOGIN, true)
            HooleyApp.db.putString(Constants.USER_NAME , obj.data!!.user!!.name!!)
            HooleyApp.db.putString(Constants.USER_IMAGE , obj.data!!.user!!.url!!)
            HooleyApp.db.putString(Constants.USER_EMAIL , obj.data!!.user!!.email!!)
            val intent = Intent(AuthActivity.mActivity, HooleyOrganizerMain::class.java)
            ActivityBase.activity.startActivity(intent)
            ActivityBase.activity.finish()
        })
    }

    private fun setListeners() {
        binding.btnSigin.setOnClickListener(this)
        binding.ivShowPassword.setOnClickListener(this)
        binding.rlLoginWIthHooley.setOnClickListener(this)
        binding.etEmail.addTextChangedListener(this)
        binding.etPassword.addTextChangedListener(this)
        binding.tvForgotPassword.setOnClickListener(this)
    }

    private fun validInput() : Boolean{
        if (binding.etEmail.validateEmail("Please enter valid email")){
            return false
        }else if (binding.etPassword.validateNullOrEmpty("Please enter Password")){
            return false
        }
        return true
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btnSigin -> {
                if (validInput())
                   callLogin()
            }
            R.id.rlLoginWIthHooley -> {
                if (ActivityBase.activity.isAppInstall("com.hooleyapp.hooley")) {
                    val i2 = Intent()
                    i2.setClassName(
                        "com.hooleyapp.hooley",
                        "com.hooleyapp.hooley.view.ui.splash.Splash"
                    )
                    i2.putExtra(Constants.CONST_IS_FOR_TOKEN, true)
                    i2.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivityForResult(i2, IS_FOR_AUTH_REQUEST_CODE)
                }else {
                    ActivityBase.activity.openAnAppInPlayStore("com.hooleyapp.hooley")
                }
            }
            R.id.ivShowPassword -> {
                if (!TextUtils.isEmpty(binding.etPassword.text.toString())) {
                    if (binding.showPassword != null && binding.showPassword!!) {
                        binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        binding.showPassword = false
                    } else {
                        binding.etPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                        binding.showPassword = true

                    }
                    binding.etPassword.setSelection(binding.etPassword.length())
                }
            }

            R.id.tvForgotPassword -> {
                callFragmentWithReplace(R.id.container,ResetPasswordFragment(),"ResetPasswordFragment")
            }
        }
    }

    private fun callLogin(){
        loginViewModel.login(binding.etEmail.text.toString(),binding.etPassword.text.toString(),authToken,true)
    }
    override fun afterTextChanged(p0: Editable?) {
        checkAndSet()
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    private fun checkAndSet() {
        binding.emailVerified = !TextUtils.isEmpty(binding.etEmail.text.toString()) && ActivityBase.activity.isEmailValid(binding.etEmail.text.toString())
        binding.passwordVerified = !TextUtils.isEmpty(binding.etPassword.text.toString())
        binding.allInputValid = !TextUtils.isEmpty(binding.etEmail.text.toString()) && !TextUtils.isEmpty(binding.etPassword.text.toString())
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            authToken = data!!.getStringExtra("authToken")
            callLogin()
        }
    }
}