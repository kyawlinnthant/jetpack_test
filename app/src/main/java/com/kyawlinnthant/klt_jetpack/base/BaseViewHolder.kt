package com.kyawlinnthant.klt_jetpack.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<T>(
    private val view: View,
    private val onClick : (Int) -> Unit
):RecyclerView.ViewHolder(view), LayoutContainer {

    init {
         this.viewClick().setOnClickListener { onClick(adapterPosition) }
    }

    override val containerView: View? get() = view

    abstract fun  bind(item : T?)
    abstract fun viewClick() : View

}