package com.example.tarea2_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tarea2_3.databinding.LoginBinding
import com.example.tarea2_3.databinding.PartidaBinding
import java.io.Serializable
import java.util.Random

class MainActivity : AppCompatActivity() {
    val cartas = arrayOf(1,2,3,4,5,6,7,10,11,12)
    var carta : Int = 0
    var cont1 = 0.0
    var cont2 = 0.0
    var fin1 = false
    var fin2 = false
    var turno1 = true
    companion object random : Random(), Serializable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val login = LoginBinding.inflate(layoutInflater)
        val partida = PartidaBinding.inflate(layoutInflater)
        setContentView(login.root)
        val j1 = login.j1.text
        val j2 = login.j2.text
        login.jugar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                setContentView(partida.root)
            }
        })
        partida.Carta1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (fin1.equals(false) && turno1.equals(true)){
                    carta = random.nextInt()
                    if (carta.equals(10) || carta.equals(11) || carta.equals(12))
                        cont1 += 0.5
                    else
                        cont1 += carta
                    partida.cont1.text = "Puntuación: ${cont1}"
                    turno1 = false
                }
            }
        })
        partida.Plantado1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                fin1 = true
            }
        })
        partida.Carta2.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                if (fin2.equals(false) && turno1.equals(false)){
                    carta = random.nextInt()
                    if (carta.equals(10) || carta.equals(11) || carta.equals(12))
                        cont2 += 0.5
                    else
                        cont2 += carta
                    partida.cont2.text = "Puntuación: ${cont2}"
                }
                turno1 = true
            }
        })
        partida.Planta2.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                fin2 = true
            }
        })
        if (fin1.equals(true) && fin2.equals(true)){

        }
    }
}