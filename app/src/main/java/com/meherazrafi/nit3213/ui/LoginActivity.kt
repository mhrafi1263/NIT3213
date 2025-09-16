package com.meherazrafi.nit3213.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.meherazrafi.nit3213.R
import com.meherazrafi.nit3213.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var b: ActivityLoginBinding
    private val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(b.root)

        setSupportActionBar(b.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = getString(R.string.login_title)

        b.btnLogin.setOnClickListener {
            val username = b.etFirstName.text?.toString()?.trim().orEmpty()
            val password = b.etStudentId.text?.toString()?.trim().orEmpty()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, getString(R.string.error_missing_credentials), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            lifecycleScope.launch {
                setLoading(true)
                try {
                    // Campus fixed to "br" per your class
                    val keypass = vm.login(username, password, campus = "br")
                    startActivity(
                        Intent(this@LoginActivity, DashboardActivity::class.java)
                            .putExtra("keypass", keypass)
                    )
                    finish()
                } catch (e: Exception) {
                    Toast.makeText(
                        this@LoginActivity,
                        e.message ?: getString(R.string.error_network),
                        Toast.LENGTH_LONG
                    ).show()
                } finally {
                    setLoading(false)
                }
            }
        }
    }

    private fun setLoading(loading: Boolean) {
        b.progress.visibility = if (loading) View.VISIBLE else View.GONE
        b.btnLogin.isEnabled = !loading
        b.etFirstName.isEnabled = !loading
        b.etStudentId.isEnabled = !loading
    }
}
