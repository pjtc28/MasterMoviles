package es.ua.eps.filmoteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.net.Uri

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    /**
     * Un "intent" es un componente fundamental que se utiliza para iniciar actividades (como abrir una nueva pantalla en una aplicación),
     * enviar o recibir datos entre componentes de una aplicación y realizar acciones específicas en el sistema Android, como abrir una página web,
     * realizar una llamada telefónica o enviar un correo electrónico.
     *
     * Los intents se utilizan para realizar acciones asíncronas y para comunicar información entre diferentes partes de una aplicación Android
     * o entre diferentes aplicaciones.
     *
     * Hay dos tipos principales de intents en Android:
         * Intent explícito: Se utiliza para iniciar una actividad o servicio específico dentro de la propia aplicación.
         * Se especifica el nombre de la clase de la actividad o servicio que se debe iniciar. Por ejemplo, puedes usar un intent explícito para abrir una
         * actividad de detalles de un elemento en una lista.

         * Intent implícito: Se utiliza para solicitar una acción que puede ser manejada por una o más aplicaciones en el dispositivo.
         * En lugar de especificar una clase de componente específica, se especifica una acción y/o un tipo de datos.
         * Por ejemplo, puedes usar un intent implícito para abrir un navegador web con una URL específica o para abrir la aplicación de correo electrónico
         * con una dirección de correo predefinida.
     * */
    fun btnWeb(view: View){
        val url = "http://www.midominio.com"
        val intent = Intent(Intent.ACTION_VIEW) //Solicita que se vean los datos solicitados
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun btnSoporte(view: View){
        val url = "mailto:midireccion@dominio.com"
        val intent = Intent(Intent.ACTION_SENDTO) // Lanza una actividad para enviar un mensaje a traves de la url
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    fun btnSalir(view: View){
        finish()
    }
}