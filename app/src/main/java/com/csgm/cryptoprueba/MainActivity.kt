package com.csgm.cryptoprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.csgm.cryptoprueba.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        fetchAssets()

        fetchAssetDetail("bitcoin")
    }

    private fun fetchAssets() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val repository = Repository()
                val cryptoResponse = repository.getAssets()

                Log.d("MainActivity", "Data size: ${cryptoResponse.data.size}")
                // Accede a la lista de activos en cryptoResponse.data
                //val assets = cryptoResponse.data

                // Haz algo con la lista de activos, por ejemplo, imprime los nombres
   /*             for (asset in assets) {
                    println("Nombre del activo: ${asset.name}")
                }*/
            } catch (e: Exception) {
                // Maneja los errores aquí
                e.printStackTrace()
            }
        }
    }

    private fun fetchAssetDetail(id: String) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val repository = Repository()
                val assetDetail = repository.getAssetDetail(id)

                // Imprime el detalle del activo en el log
                Log.d("MainActivity", "Detalle del activo: $assetDetail")
            } catch (e: Exception) {
                // Maneja los errores aquí
                e.printStackTrace()
            }
        }
    }
}