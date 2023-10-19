package com.ssoaharison.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.ssoaharison.memorygame.databinding.ActivityMainBinding
import com.ssoaharison.memorygame.models.BoardSize
import com.ssoaharison.memorygame.utils.DEFAULT_ICONS

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var boardSize: BoardSize = BoardSize.EASY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chosenImages = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImages + chosenImages).shuffled()

        binding.rvBoard.apply {
            adapter = MemoryBoardAdapter(this@MainActivity, boardSize, randomizedImages)
            layoutManager = GridLayoutManager(this@MainActivity, boardSize.getWidth())
            setHasFixedSize(true)
        }
    }
}