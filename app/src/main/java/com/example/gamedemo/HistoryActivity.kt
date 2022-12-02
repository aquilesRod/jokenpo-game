package com.example.gamedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamedemo.adapter.AdapterMoves
import com.example.gamedemo.databinding.ActivityHistoryBinding
import com.example.gamedemo.model.Move
import java.nio.file.Files.move

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHistoryBinding
    private lateinit var movesAdapter : AdapterMoves
    private var listMoves: MutableList<Move> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nickname = printPlayerNickName()

        val movesRecyclerView = binding.movesRecyclerView
        movesRecyclerView.layoutManager = LinearLayoutManager(this)
        movesRecyclerView.setHasFixedSize(true)
        movesAdapter = AdapterMoves(this, listMoves, nickname)
        movesRecyclerView.adapter = movesAdapter
        move()
    }

    private fun move () {
        for(move in GlobalParams.listMoves) {
            var newMove = Move(move.playerMove, move.computerMove, move.result)
            newMove.playerMove.setImageDrawable(move.playerMove.drawable)
            newMove.playerMove.setImageDrawable(move.playerMove.drawable)
            this.listMoves.add(newMove)
        }
    }

    private fun printPlayerNickName (): String {
        return intent.getStringExtra("nickName").toString()
    }

}