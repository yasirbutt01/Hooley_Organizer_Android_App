package com.hooleyapp.organizer.view.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.hooleyapp.organizer.R
import com.hooleyapp.organizer.databinding.ActivityAuthBinding
import com.hooleyapp.organizer.utilities.extensions.hideKeyboard
import com.hooleyapp.organizer.view.ui.base.ActivityBase

class AuthActivity : ActivityBase(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
        mActivity = activity
        setStatusBarColor(ContextCompat.getColor(this, android.R.color.white), View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        callFragment(R.id.container, LoginFragment(), null)
    }

    companion object {
        private lateinit var binding: ActivityAuthBinding
        lateinit var mActivity: AppCompatActivity
    }

    override fun onResume() {
        activity = mActivity
        super.onResume()
    }

    override fun onBackPressed() {
        binding.root.hideKeyboard()
        super.onBackPressed()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (val fragment = supportFragmentManager.findFragmentById(R.id.container)) {
            is LoginFragment -> fragment.onActivityResult(requestCode, resultCode, data)
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }
}