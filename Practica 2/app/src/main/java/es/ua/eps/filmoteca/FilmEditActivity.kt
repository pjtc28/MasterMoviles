package es.ua.eps.filmoteca

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FilmEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmedit)
    }

    fun btnGuardar(view: View){
        // Establecer el resultado como RESULT_OK y cerrar la actividad
        setResult(Activity.RESULT_OK)
        finish()
    }

    fun btnCancelar(view: View){
        // Establecer el resultado como RESULT_CANCELED y cerrar la actividad
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}
