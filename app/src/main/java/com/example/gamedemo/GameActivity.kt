package com.example.gamedemo

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gamedemo.databinding.ActivityGameBinding
import com.example.gamedemo.model.Move
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGameBinding
    private val listMoves: MutableList<Move> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtPlayerNickName.setText(playerNickName())

        binding.btnHistory.setOnClickListener(){ goToActivity(HistoryActivity()) }

        binding.btnPaper.setOnClickListener() {
            binding.imagePlayerMove.setImageDrawable(getDrawable(R.drawable.player_paper))
            binding.txtResult.text = playGame(0)
            insertMove()
        }
        binding.btnRock.setOnClickListener() {
            binding.imagePlayerMove.setImageDrawable(getDrawable(R.drawable.player_rock))
            binding.txtResult.text = playGame(1)
            insertMove()
        }
        binding.btnScissor.setOnClickListener() {
            binding.imagePlayerMove.setImageDrawable(getDrawable(R.drawable.player_scissor))
            binding.txtResult.text = playGame(2)
            insertMove()
        }
    }

    private fun insertMove() {
        var move = Move(binding.imagePlayerMove, binding.imageComputerMove, binding.txtResult.text.toString())
        listMoves.add(move)
    }

    private fun goToActivity(activity: Activity) {
        val nickName = playerNickName()
        val intent = Intent(this, activity::class.java)
        intent.putExtra("nickName", nickName)
        GlobalParams.listMoves = this.listMoves
        startActivity(intent)
    }

    private fun playGame (playerMove : Int) : String {
        binding.imageComputerMove.visibility = View.VISIBLE
        var computerMove = Random.nextInt(3)
        var gameResult : String = ""

        when(computerMove) {
            0 -> binding.imageComputerMove.setImageDrawable(getDrawable(R.drawable.computer_paper))
            1 -> binding.imageComputerMove.setImageDrawable(getDrawable(R.drawable.computer_rock))
            2 -> binding.imageComputerMove.setImageDrawable(getDrawable(R.drawable.computer_scissor))
        }

        if (computerMove == playerMove) {
            gameResult = "Tie"
            binding.txtResult.setTextColor(Color.GRAY)
        } else if ((computerMove == 0 && playerMove == 1) || (computerMove == 1 && playerMove == 2) || (computerMove == 2 && playerMove == 0)) {
            gameResult = "Lose"
            binding.txtResult.setTextColor(Color.RED)
        } else {
            gameResult = "Win"
            binding.txtResult.setTextColor(Color.GREEN)
        }

        return gameResult
    }

    private fun playerNickName() : String{
        return intent.getStringExtra("nickName").toString()
    }

}