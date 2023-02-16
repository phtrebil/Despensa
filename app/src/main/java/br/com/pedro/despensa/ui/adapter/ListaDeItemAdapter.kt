package br.com.pedro.despensa.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pedro.despensa.R
import br.com.pedro.despensa.databinding.ItemListaBinding
import br.com.pedro.despensa.model.Despensa
import coil.load

class ListaDeItemAdapter(
    despensa: List<Despensa> = emptyList(),
    private val context: Context,
    var quandoClicaNoItem: (despensa: Despensa) -> Unit = {}
): RecyclerView.Adapter<ListaDeItemAdapter.ItemViewHolder>() {

    private val despensa = despensa.toMutableList()

    inner class ItemViewHolder(
        private val binding: ItemListaBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var despensa: Despensa

        init {
            itemView.setOnClickListener {
                if(::despensa.isInitialized){
                    quandoClicaNoItem(despensa)
                }
            }
        }


        fun vincula(despensa: Despensa) {
            this.despensa = despensa
            binding.nomeItem.text = despensa.nome
            binding.quantidade.text = despensa.quantidade
            binding.imagemItem.load(despensa.imagem){
                fallback(R.drawable.erro)
                error(R.drawable.erro)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inf = LayoutInflater.from(context)
        return ItemViewHolder(ItemListaBinding.inflate(inf, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val despensa = despensa[position]
        holder.vincula(despensa)
    }

    override fun getItemCount(): Int = despensa.size

}