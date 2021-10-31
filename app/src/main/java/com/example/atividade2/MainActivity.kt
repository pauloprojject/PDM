package com.example.atividade2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar1: SeekBar
    private lateinit var seekBar2: SeekBar
    private lateinit var seekBar3: SeekBar
    private lateinit var view: View
    private  lateinit var color: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.seekBar1 = findViewById(R.id.seekBar1)
        this.seekBar1.setOnSeekBarChangeListener(OnChange())

        this.seekBar2 = findViewById(R.id.seekBar2)
        this.seekBar2.setOnSeekBarChangeListener(OnChange())

        this.seekBar3 = findViewById(R.id.seekBar3)
        this.seekBar3.setOnSeekBarChangeListener(OnChange())

        this.view = findViewById(R.id.tvColor)

        this.view.setBackgroundColor(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress))

        this.color = findViewById(R.id.Hexa)
        this.color.setText(java.lang.Integer.toHexString(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress)).substring(2,8)
            .uppercase(Locale.getDefault()))
    }
    inner class OnChange:SeekBar.OnSeekBarChangeListener {
        private lateinit var tela: View
        private lateinit var seekBar1: SeekBar
        private lateinit var seekBar2: SeekBar
        private lateinit var seekBar3: SeekBar
        private  lateinit var corgerada: TextView

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this.tela = findViewById(R.id.tvColor)
            this.seekBar1 = findViewById(R.id.seekBar1)
            this.seekBar2 = findViewById(R.id.seekBar2)
            this.seekBar3 = findViewById(R.id.seekBar3)
            this.corgerada = findViewById(R.id.Hexa)

            this.tela.setBackgroundColor(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress))

            this.corgerada.setText(java.lang.Integer.toHexString(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress)).substring(2,8)
                .uppercase(Locale.getDefault()))
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }
    }
}