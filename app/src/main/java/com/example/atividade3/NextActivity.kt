package com.example.atividade3

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class NextActivity : AppCompatActivity() {

    private lateinit var seekBar1: SeekBar
    private lateinit var seekBar2: SeekBar
    private lateinit var seekBar3: SeekBar
    private lateinit var view: View
    private lateinit var color: TextView
    private lateinit var buttonSalvar: Button
    private lateinit var buttonCancelar: Button
    private lateinit var corgerada: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

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

        buttonSalvar = findViewById(R.id.buttonSalvar)
        buttonSalvar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("COLOR", corgerada.text );
            }

            if(intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

        buttonCancelar = findViewById(R.id.buttonCancelar)
        buttonCancelar.setOnClickListener{
            this.finish()
        }
    }
    inner class OnChange:SeekBar.OnSeekBarChangeListener {
        private lateinit var tela: View
        private lateinit var seekBar1: SeekBar
        private lateinit var seekBar2: SeekBar
        private lateinit var seekBar3: SeekBar
        private lateinit var textoCor1: TextView
        private lateinit var textoCor2: TextView
        private lateinit var textoCor3: TextView

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this.tela = findViewById(R.id.tvColor)
            this.seekBar1 = findViewById(R.id.seekBar1)
            this.seekBar2 = findViewById(R.id.seekBar2)
            this.seekBar3 = findViewById(R.id.seekBar3)
            corgerada = findViewById(R.id.Hexa)
            this.textoCor1 = findViewById(R.id.redTextValue)
            this.textoCor2 = findViewById(R.id.greenTextValue)
            this.textoCor3 = findViewById(R.id.blueTextValue)

            this.textoCor1.text = seekBar1.progress.toString()
            this.textoCor2.text = seekBar2.progress.toString()
            this.textoCor3.text = seekBar3.progress.toString()

            this.tela.setBackgroundColor(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress))

            corgerada.setText(java.lang.Integer.toHexString(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress)).substring(2,8)
                .uppercase(Locale.getDefault()))
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }
    }
}