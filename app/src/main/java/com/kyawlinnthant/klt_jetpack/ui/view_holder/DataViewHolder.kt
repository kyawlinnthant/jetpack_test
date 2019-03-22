package com.kyawlinnthant.klt_jetpack.ui.view_holder

import android.view.View
import com.kyawlinnthant.klt_jetpack.R
import com.kyawlinnthant.klt_jetpack.base.BaseViewHolder
import com.kyawlinnthant.klt_jetpack.model.db.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_layout.*

class DataViewHolder(
    private val view : View,
    private val onClick : (Int)->Unit
) : BaseViewHolder<News>(view,onClick) {

    override val containerView: View? get() = view

    init {
        this.viewClick().setOnClickListener { onClick(adapterPosition) }
    }

    override fun bind(item: News?) = setupView(item)

    override fun viewClick(): View = itemView

    private fun setupView(item: News?){
        title.text = item?.title
        item?.author?.let { author.text = it }
        description.text = item?.description
        publishedAt.text = item?.publishedAt
        Picasso.get().load(item?.urlToImage).resize(235,235).placeholder(R.drawable.ic_launcher_background).into(urlToImage)
    }
}