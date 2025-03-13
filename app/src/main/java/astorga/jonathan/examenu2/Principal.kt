package astorga.jonathan.examenu2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnDetalles: Button = findViewById(R.id.btnDetalles)
        val btnGlobos: Button = findViewById(R.id.btnGloblos)
        val btnPeluches: Button = findViewById(R.id.btnPeluches)
        val btnRegalos: Button = findViewById(R.id.btnRegalos)
        val btnTazas: Button = findViewById(R.id.btnTazas)

        btnDetalles.setOnClickListener{
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("detalleType", "Detalles")
            startActivity(intent)
        }
        btnGlobos.setOnClickListener{
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("detalleType", "Globos")
            startActivity(intent)
        }
        btnPeluches.setOnClickListener{
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("detalleType", "Peluches")
            startActivity(intent)
        }
        btnRegalos.setOnClickListener{
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("detalleType", "Regalos")
            startActivity(intent)
        }
        btnTazas.setOnClickListener{
            var intent: Intent = Intent(this, Regalos::class.java)
            intent.putExtra("detalleType", "Tazas")
            startActivity(intent)
        }
    }
}