package com.meherazrafi.nit3213.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.meherazrafi.nit3213.data.remote.FashionItem
import com.meherazrafi.nit3213.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var b: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(b.root)

        // Set up toolbar as the ActionBar and enable the back arrow
        setSupportActionBar(b.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        // Receive the item
        val item = intent.getParcelableExtra<FashionItem>("item")

        // Bind UI
        item?.let {
            b.tvItemName.text     = it.itemName
            b.tvDesigner.text     = "Designer: ${it.designer}"
            b.tvYear.text         = "Year: ${it.yearIntroduced}"
            b.tvCategory.text     = "Category: ${it.category}"
            b.tvMaterial.text     = "Material: ${it.material}"
            b.tvDescription.text  = it.description
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
