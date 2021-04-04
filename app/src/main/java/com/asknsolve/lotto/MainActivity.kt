package com.asknsolve.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.asknsolve.lotto.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val lotteryNumbers = arrayListOf(binding.number1, binding.number2, binding.number3, binding.number4, binding.number5, binding.number6)

        val countDownTimer = object: CountDownTimer(1000,10){
            override fun onFinish() {
            }

            override fun onTick(p0: Long) {
/*                lotteryNumbers.forEach {
                    val randomList = (1..45).shuffled().take(6)
                    val randomNumber = randomList[i]
                    it.text = "$randomNumber"
                }
 */
                val randomList = (1..45).shuffled().take(6)
                for(i in 0..5){
                    lotteryNumbers[i].text = "${randomList[i]}"
                }
            }
        }

        binding.lotteryButton.setOnClickListener {
            if(binding.lotteryButton.isAnimating){
                binding.lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            }else {
                binding.lotteryButton.playAnimation()
                countDownTimer.start()
            }
        }
    }
}