package com.asknsolve.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.asknsolve.lotto.databinding.ActivitySplashBinding

private lateinit var binding: ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 4초 정도 지났을 때 자동으로 MainActivity로

        var handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() //스플래시 화면은 더이상 사용하지 않으므로 finish()
        }

        handler.postDelayed(runnable, 4000)

        // 클릭 시 MainActivity로
        binding.animationView.setOnClickListener {
            handler.removeCallbacks(runnable)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() //스플래시 화면은 더이상 사용하지 않으므로 finish()
        }

    }
}