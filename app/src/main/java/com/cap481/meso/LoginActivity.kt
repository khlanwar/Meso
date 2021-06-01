package com.cap481.meso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.cap481.meso.databinding.ActivityLoginBinding
import com.cap481.meso.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityLoginBinding
    private var emailValid = false
    private var passwordConfirmationValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        auth = FirebaseAuth.getInstance()

        binding.tvNotHaveAccount.setOnClickListener{
            intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.tvForgetPassword.setOnClickListener {
            intent = Intent(this,ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            val email = binding.edEmail.text.toString().trim()
            val password = binding.edConfirmPassword.text.toString().trim()

            binding.progressBar.visibility = View.VISIBLE

            loginUser(email, password)
        }

        validateButton()

        binding.edEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateEmail()
            }
        })

        binding.edConfirmPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validatePasswordConfirmation()
            }
        })


    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    binding.progressBar.visibility = View.INVISIBLE
                    Intent(this, HomeActivity::class.java).also{ intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                }else{
                    binding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this,it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun validateEmail() {
        val input = binding.edEmail.text.toString()
        if (!Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
            emailValid = false
            showEmailExistAlert(true)
        } else {
            emailValid = true
            showEmailExistAlert(false)
        }
        validateButton()
    }

    fun validatePasswordConfirmation() {
        val input = binding.edConfirmPassword.text.toString()
        if (input.length < 6) {
            passwordConfirmationValid = false
            showPasswordConfirmationAlert(true)
        } else {
            passwordConfirmationValid = true
            showPasswordConfirmationAlert(false)
        }
        validateButton()
    }

    private fun validateButton() {
        if ( emailValid && passwordConfirmationValid) {
            binding.btnLogin.isEnabled = true
            binding.btnLogin.setBackgroundColor(ContextCompat.getColor(this, R.color.color_background_green))
        } else {
            binding.btnLogin.isEnabled = false
            binding.btnLogin.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray))
        }
    }

    private fun showEmailExistAlert(isNotValid: Boolean) {
        binding.edEmail.error = if (isNotValid) getString(R.string.email_not_valid) else null
    }

    private fun showPasswordConfirmationAlert(isNotValid: Boolean) {
        binding.edConfirmPassword.error = if (isNotValid) getString(R.string.password_not_valid) else null
    }
}