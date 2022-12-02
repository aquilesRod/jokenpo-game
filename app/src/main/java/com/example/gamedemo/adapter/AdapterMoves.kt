package com.example.gamedemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamedemo.databinding.MoveItemBinding
import com.example.gamedemo.model.Move

class AdapterMoves (private val context : Context, private val movesList : MutableList<Move>, private val nickname : String) :
    RecyclerView.Adapter<AdapterMoves.MoveViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        val listItem = MoveItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MoveViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        holder.imagePlayerMove = movesList[position].playerMove
        holder.imageComputerMove = movesList[position].computerMove
        holder.txtResult.text = movesList[position].result
        holder.txtPlayerNickName.text = this.nickname
    }

    override fun getItemCount() = movesList.size

    inner class MoveViewHolder(binding : MoveItemBinding) : RecyclerView.ViewHolder (binding.root) {
        var imagePlayerMove = binding.imagePlayerMove
        var imageComputerMove = binding.imageComputerMove
        var txtResult = binding.txtResult
        var txtPlayerNickName = binding.txtPlayerNickName
    }

}