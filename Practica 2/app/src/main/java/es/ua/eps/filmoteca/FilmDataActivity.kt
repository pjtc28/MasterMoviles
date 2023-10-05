package es.ua.eps.filmoteca

import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.net.Uri
import android.os.Build
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class FilmDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmdata)

        // Obtener el extra del intent
        val filmTitle = intent.getStringExtra(EXTRA_FILM_TITLE)

        // Verificar si el extra no es nulo y configurar el texto en la etiqueta
        if (filmTitle != null) {
            val filmTitleTextView = findViewById<TextView>(R.id.textNombrePeli)
            filmTitleTextView.text = "Película: $filmTitle"
        }
    }

    companion object {
        const val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE"
        const val EDIT_FILM_REQUEST_CODE = 1
    }

    fun btnEP(view: View) {
        val intent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
        if(Build.VERSION.SDK_INT >= 30) {
            startForResult.launch(intent)
        }
        else {
            @Suppress("DEPRECATION")
            startActivityForResult(intent, EDIT_FILM_REQUEST_CODE)
        }
    }

    fun btnVPR(view: View) {
        val extraVPR = "Viendo peliculas relacionadas"
        val intent = Intent(this@FilmDataActivity, FilmDataActivity::class.java)
        intent.putExtra(EXTRA_FILM_TITLE, extraVPR)
        startActivity(intent)
    }

    fun btnBackToMain(view: View) {
        val intent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        finish()
    }

    /**
     * Usamos la propiedad flags para establecer dos indicadores:
         * Intent.FLAG_ACTIVITY_CLEAR_TOP: Esto eliminará todas las actividades encima de la actividad principal en la pila.
         * Intent.FLAG_ACTIVITY_SINGLE_TOP: Esto asegura que si la actividad principal ya está en la cima de la pila, no se cree una nueva instancia de la misma,
             sino que se utiliza la existente.
     */


    /**
     * En FilmEditActivity podemos GUARDAR => RESULT_OK
     *                                      o
     *                              CANCELAR => RESULT_CANCELED
     *
     * Vamos a llamar a dicha actividad desde FilmDataActivity con el método startActivityForResult.
     * Implementaremos también de forma adecuada el método onActivityResult y en caso de haber sido editada lo indicaremos en la etiqueta de texto.*/

    private val startForResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            onActivityResult(EDIT_FILM_REQUEST_CODE, result.resultCode, result.data)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        val filmTitleTextView = findViewById<TextView>(R.id.textNombrePeli)
        if (requestCode == EDIT_FILM_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK){
                filmTitleTextView.text = "Película Guardada"
            } else if (resultCode == Activity.RESULT_CANCELED) {
                filmTitleTextView.text = "Película Cancelada"
            }
        }
    }
}
