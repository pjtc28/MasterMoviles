package es.ua.eps.filmoteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class FilmListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmlist)
    }

    fun btnA(view: View){
        // Obtener el nombre de la película seleccionada (cambia esto según tu lógica).
        val filmTitle = "A"
        // Los intents se usan para poder trasladarnos de una actividad a otra.
        val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
        intent.putExtra(FilmDataActivity.EXTRA_FILM_TITLE, filmTitle)
        startActivity(intent)
    }

    fun btnB(view: View){
        // Obtener el nombre de la película seleccionada (cambia esto según tu lógica).
        val filmTitle = "B"
        // Los intents se usan para poder trasladarnos de una actividad a otra.
        val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
        intent.putExtra(FilmDataActivity.EXTRA_FILM_TITLE, filmTitle)
        startActivity(intent)
    }

    fun btnAcerca(view: View){
        val intent = Intent(this@FilmListActivity, AboutActivity::class.java)
        startActivity(intent)
    }
}
