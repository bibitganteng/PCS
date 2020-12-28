package com.bibitaries.sepakbola.ui.olahraga

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.bibitaries.sepakbola.R
import com.bibitaries.sepakbola.data.model.Olahraga
import com.bibitaries.sepakbola.databinding.ItemOlahragaBinding
import com.bibitaries.sepakbola.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class OlahragaAdapter(val context: Context) : BaseAdapter<Olahraga>(R.layout.item_olahraga) {
    override fun onBind(binding: ViewDataBinding?, data: Olahraga) {
        val mBinding = binding as ItemOlahragaBinding
        Glide.with(context).load(data.poster).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: Olahraga) {
        val intent = Intent(context, OlahragaActivity::class.java)
        intent.putExtra(OlahragaActivity.OPEN_OLAHRAGA, data)
        context.startActivity(intent)
    }
}