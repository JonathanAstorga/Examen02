package astorga.jonathan.examenu2

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_regalos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgDetalle: ImageView = findViewById(R.id.imgRegalo)
        val txtPrecio: TextView = findViewById(R.id.txtRegaloPrecio)

        val bundle = intent.extras

        if(bundle != null){
            imgDetalle.setImageResource(bundle.getInt("imagen"))
            txtPrecio.setText(bundle.getString("precio"))
        }
    }
}