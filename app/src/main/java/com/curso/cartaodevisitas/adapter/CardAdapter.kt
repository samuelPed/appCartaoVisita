package com.curso.cartaodevisitas.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.curso.cartaodevisitas.data.DatabaseCard
import com.curso.cartaodevisitas.databinding.ItemCardBinding

class CardAdapter:
    ListAdapter<DatabaseCard, CardAdapter.ViewHolder>(DiffCallback()){

        var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCardBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: DatabaseCard){
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener{
                listenerShare(it)
            }
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<DatabaseCard>(){
    override fun areItemsTheSame(oldItem: DatabaseCard, newItem: DatabaseCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: DatabaseCard, newItem: DatabaseCard) = oldItem.id == newItem.id
}