package com.meherazrafi.nit3213.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.meherazrafi.nit3213.R
import com.meherazrafi.nit3213.data.remote.FashionItem
import com.meherazrafi.nit3213.databinding.ActivityDashboardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import androidx.lifecycle.lifecycleScope

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var b: ActivityDashboardBinding
    private val vm: DashboardViewModel by viewModels()

    private val adapter = FashionAdapter { item: FashionItem ->
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("item", item)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        b = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(b.root)

        // Top App Bar
        b.topAppBar.title = getString(R.string.dashboard_title)

        // RecyclerView
        b.rv.layoutManager = LinearLayoutManager(this)
        b.rv.adapter = adapter

        // Logout
        b.btnLogout.setOnClickListener {
            // back to Login and clear stack
            val i = Intent(this, LoginActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        }

        // Load once (uses keypass from Login)
        val keypass = intent.getStringExtra("keypass") ?: "fashion"
        vm.load(keypass)

        // Pull to refresh
        b.swipe.setOnRefreshListener {
            vm.load(keypass)
        }

        // Collect list
        lifecycleScope.launchWhenStarted {
            vm.items.collectLatest { list ->
                adapter.submitList(list)
                b.swipe.isRefreshing = false
            }
        }

        // Collect error
        lifecycleScope.launchWhenStarted {
            vm.error.collectLatest { msg ->
                msg?.let {
                    Toast.makeText(this@DashboardActivity, it, Toast.LENGTH_SHORT).show()
                    b.swipe.isRefreshing = false
                }
            }
        }
    }
}
