package astorga.jonathan.examenu2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Regalos : AppCompatActivity() {
    var adapter: RegalosAdapter? = null
    var detalles: ArrayList<Detalles> = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_regalos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var detallesOption: String? = intent.getStringExtra("detalleType")
        val titulo: TextView = findViewById(R.id.txtTitulo)
        titulo.setText(detallesOption)
        cargarDetalles(detallesOption)

        adapter = RegalosAdapter(this, detalles)

        var gridDetalles: GridView =findViewById(R.id.gVCatalogoRegalos)

        gridDetalles.adapter = adapter
    }

    fun cargarDetalles(option: String?){
        when(option){
            "Detalles" ->{
                detalles.add(Detalles(R.drawable.cumplebotanas, "$280.00"))
                detalles.add(Detalles(R.drawable.cumplecheve, "$320.00"))
                detalles.add(Detalles(R.drawable.cumpleescolar, "$330.00"))
                detalles.add(Detalles(R.drawable.cumplepaletas, "$190.00"))
                detalles.add(Detalles(R.drawable.cumplesnack, "$150.00"))
                detalles.add(Detalles(R.drawable.cumplevinos, "$370.00"))
            }
            "Globos" ->{
                detalles.add(Detalles(R.drawable.globoamor, "$240.00"))
                detalles.add(Detalles(R.drawable.globocumple, "$820.00"))
                detalles.add(Detalles(R.drawable.globofestejo, "$260.00"))
                detalles.add(Detalles(R.drawable.globonum, "$760.00"))
                detalles.add(Detalles(R.drawable.globoregalo, "$450.00"))
                detalles.add(Detalles(R.drawable.globos, "$240.00"))
            }
            "Peluches" ->{
                detalles.add(Detalles(R.drawable.peluchemario, "$320.00"))
                detalles.add(Detalles(R.drawable.pelucheminecraft, "$320.00"))
                detalles.add(Detalles(R.drawable.peluchepeppa, "$290.00"))
                detalles.add(Detalles(R.drawable.peluches, "400.00"))
                detalles.add(Detalles(R.drawable.peluchesony, "$330.00"))
                detalles.add(Detalles(R.drawable.peluchestich, "$280.00"))
                detalles.add(Detalles(R.drawable.peluchevarios, "$195.00"))
            }
            "Regalos" ->{
                detalles.add(Detalles(R.drawable.peluchemario, "$320.00"))
                detalles.add(Detalles(R.drawable.pelucheminecraft, "$320.00"))
                detalles.add(Detalles(R.drawable.peluchepeppa, "$290.00"))
                detalles.add(Detalles(R.drawable.peluches, "400.00"))
                detalles.add(Detalles(R.drawable.peluchesony, "$330.00"))
                detalles.add(Detalles(R.drawable.peluchestich, "$280.00"))
                detalles.add(Detalles(R.drawable.peluchevarios, "$195.00"))
            }
            "Tazas" ->{
                detalles.add(Detalles(R.drawable.tazaabuela, "$120.00"))
                detalles.add(Detalles(R.drawable.tazalove, "$120.00"))
                detalles.add(Detalles(R.drawable.tazaquiero, "260.00"))
                detalles.add(Detalles(R.drawable.tazas, "280.00"))
            }
        }
    }

}

class RegalosAdapter: BaseAdapter {
    var detalles = ArrayList<Detalles>()
    var context: Context? = null

    constructor(context: Context, detalles: ArrayList<Detalles>): super(){
        this.detalles = detalles
        this.context = context
    }

    override fun getCount(): Int {
        return detalles.size
    }

    override fun getItem(position: Int): Any {
        return detalles[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var detalle = detalles[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)
        var image: ImageView = vista.findViewById(R.id.imgRegalo)
        var precio: TextView = vista.findViewById(R.id.txtRegaloPrecio)

        image.setImageResource(detalle.imagen)
        precio.setText(detalle.precio)

        image.setOnClickListener{
            val intento = Intent(context, DetalleRegalos::class.java)
            intento.putExtra("imagen", detalle.imagen)
            intento.putExtra("precio", detalle.precio)
            context!!.startActivity(intento)
        }
        return vista
    }

}