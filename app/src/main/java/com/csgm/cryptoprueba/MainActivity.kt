package com.csgm.cryptoprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/** LISTA DE TAREAS
 * [ ] consumo de API
 *      [ ] dependencias de retrofit
 *      [ ] permiso de internet
 *      [ ] POJOs
 *      [ ] interfaz de operaciones
 *      [ ] cliente de conexión con la API
 * [ ] Repositorio
 * [ ] ViewModel
 * [ ] Fragmento de listado
 * [ ] adeaptador + viewholder + recycleview
 * [ ] persistencia de datos con ROOM
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}