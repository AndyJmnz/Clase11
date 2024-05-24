package com.example.clase11

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.util.Objects

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class fragment_galeria : Fragment() {

    private lateinit var vista: View
    private lateinit var efecto: Button
    private lateinit var musica: Button
    private lateinit var barraVol: SeekBar
    private lateinit var barraTime: SeekBar
    private lateinit var tiempo: TextView

    private var song: MediaPlayer? = null
    private var sound: MediaPlayer? = null

    private var  reproducirSound = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_galeria, container, false)
        efecto = vista.findViewById(R.id.btnEfecto)
        musica = vista.findViewById(R.id.btnMusica)
        barraVol = vista.findViewById(R.id.sbVolumen)
        barraTime = vista.findViewById(R.id.sbReproduccion)
        tiempo = vista.findViewById(R.id.txtTiempo)

        sound = MediaPlayer.create(context, R.raw.aplausos)
        song = MediaPlayer.create(context, R.raw.cancion)

        sound?.isLooping = true
        song?.isLooping = true

        efecto.setOnClickListener {
            Toast.makeText(context,"Reproduciendo sonido", Toast.LENGTH_SHORT).show()
            reproducirSound = if(!reproducirSound) {
                sound?.start()
                true
            }else{
                sound?.pause()
                false
            }
        }

        musica.setOnClickListener {
            Toast.makeText(context, "Reproduccion cancion", Toast.LENGTH_SHORT).show()
            reproducirSound = if(!reproducirSound){
                song?.start()
                true
            } else{
                song?.pause()
                false
            }
        }

        barraVol.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                song?.setVolume(progress/100.0f, progress/100.00f)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        barraTime.max = song!!.duration

        barraTime.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val max = song!!.duration/1000
                val inicio = barraTime.progress.toLong()/1000
                tiempo.text = "Duracion: $inicio /$max"
                if (fromUser) {
                    Toast.makeText(context, "Fromuser", Toast.LENGTH_SHORT).show()
                    song!!.pause()
                    song!!.seekTo(progress)
                    song!!.start()
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        return vista
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_galeria().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}