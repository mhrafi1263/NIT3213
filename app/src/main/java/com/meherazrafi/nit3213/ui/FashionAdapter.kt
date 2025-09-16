package com.meherazrafi.nit3213.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.meherazrafi.nit3213.R
import com.meherazrafi.nit3213.data.remote.FashionItem

class FashionAdapter(private val onClick: (FashionItem) -> Unit)
    : ListAdapter<FashionItem, FashionAdapter.VH>(Diff) {

    object Diff : DiffUtil.ItemCallback<FashionItem>() {
        override fun areItemsTheSame(a: FashionItem, b: FashionItem) = a.itemName == b.itemName
        override fun areContentsTheSame(a: FashionItem, b: FashionItem) = a == b
    }

    inner class VH(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.txtName)
        val meta: TextView = v.findViewById(R.id.txtMeta)
        val cat:  TextView = v.findViewById(R.id.txtCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.row_fashion_item, parent, false))

    override fun onBindViewHolder(h: VH, position: Int) {
        val e = getItem(position)
        h.name.text = e.itemName
        h.meta.text = "${e.designer} • ${e.yearIntroduced} • ${e.material}"
        h.cat.text  = e.category
        h.itemView.setOnClickListener { onClick(e) }
    }
}
