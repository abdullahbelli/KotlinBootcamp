import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odev6.Filmler
import com.example.odev6.databinding.CardTasarimBinding
import com.example.odev6.databinding.FilmItemBinding

class FilmlerAdapter(
    private val mContext: Context,
    private val filmlerListesi: List<Filmler>
) : RecyclerView.Adapter<FilmlerAdapter.FilmViewHolder>() {

    inner class FilmViewHolder(val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmlerListesi[position]
        val t = holder.binding

        t.filmResim.setImageResource(
            mContext.resources.getIdentifier(film.resim, "drawable", mContext.packageName)
        )

        Log.d("FilmlerAdapter", "Film adı: ${film.ad}")
    }

    override fun getItemCount(): Int = filmlerListesi.size
}

