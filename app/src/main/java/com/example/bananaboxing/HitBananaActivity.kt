package com.example.bananaboxing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import java.util.Random

class HitBananaActivity : AppCompatActivity() {

    lateinit var score: TextView
    lateinit var good: RelativeLayout

    lateinit var banana1: RelativeLayout
    lateinit var banana2: RelativeLayout
    lateinit var banana3: RelativeLayout
    lateinit var banana4: RelativeLayout
    lateinit var banana5: RelativeLayout
    lateinit var banana6: RelativeLayout
    lateinit var banana7: RelativeLayout
    lateinit var banana8: RelativeLayout
    lateinit var banana9: RelativeLayout

    var scoreNum = 0
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hit_banana)
        initialivate()

        banana1.visibility = View.INVISIBLE
        banana2.visibility = View.INVISIBLE
        banana3.visibility = View.INVISIBLE
        banana4.visibility = View.INVISIBLE
        banana5.visibility = View.INVISIBLE
        banana6.visibility = View.INVISIBLE
        banana7.visibility = View.INVISIBLE
        banana8.visibility = View.INVISIBLE
        banana9.visibility = View.INVISIBLE

        good.visibility = View.INVISIBLE

        score.text = scoreNum.toString()

        banana1.setOnClickListener { ckickBanana(banana1) }
        banana2.setOnClickListener { ckickBanana(banana2) }
        banana3.setOnClickListener { ckickBanana(banana3) }
        banana4.setOnClickListener { ckickBanana(banana4) }
        banana5.setOnClickListener { ckickBanana(banana5) }
        banana6.setOnClickListener { ckickBanana(banana6) }
        banana7.setOnClickListener { ckickBanana(banana7) }
        banana8.setOnClickListener { ckickBanana(banana8) }
        banana9.setOnClickListener { ckickBanana(banana9) }

        animate(banana1, generateRandom().toLong())
        animate(banana2, generateRandom().toLong())
        animate(banana3, generateRandom().toLong())
        animate(banana4, generateRandom().toLong())
        animate(banana5, generateRandom().toLong())
        animate(banana6, generateRandom().toLong())
        animate(banana7, generateRandom().toLong())
        animate(banana8, generateRandom().toLong())
        animate(banana9, generateRandom().toLong())

    }

    private fun ckickBanana(item: RelativeLayout) {
        if (!isTrue()) {
            val intent = Intent(this, ResultsGameActivity::class.java)
            intent.putExtra("result", scoreNum)
            startActivity(intent)
        }

        item.visibility = View.INVISIBLE
        scoreNum += 180
        counter++
        score.text = scoreNum.toString()

        val timer = object: CountDownTimer(500, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                good.visibility = View.VISIBLE
            }

            override fun onFinish() {
                good.visibility = View.INVISIBLE
            }
        }
        timer.start()
    }

    private fun isTrue(): Boolean {
        var isTrue = true
        if (counter == 8)
            isTrue = false
        return isTrue
    }

    private fun initialivate() {
        banana1 = findViewById(R.id.banana1)
        banana2 = findViewById(R.id.banana2)
        banana3 = findViewById(R.id.banana3)
        banana4 = findViewById(R.id.banana4)
        banana5 = findViewById(R.id.banana5)
        banana6 = findViewById(R.id.banana6)
        banana7 = findViewById(R.id.banana7)
        banana8 = findViewById(R.id.banana8)
        banana9 = findViewById(R.id.banana9)

        score = findViewById(R.id.score)
        good = findViewById(R.id.good)
    }

    private fun animate(item: RelativeLayout, randomTime: Long) {
        val handler = android.os.Handler()
        handler.postDelayed({
            item.visibility = View.VISIBLE
            item.animate().translationY(1000F)
            item.animate().duration = 3000
        }, randomTime.toLong())
    }

    private fun generateRandom(): Int {
        val random = (1000..15000).random()
        return random
    }
}