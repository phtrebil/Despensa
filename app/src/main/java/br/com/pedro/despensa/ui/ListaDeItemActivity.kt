package br.com.pedro.despensa.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.pedro.despensa.data.DespensaRetrofit
import br.com.pedro.despensa.databinding.ActivityListaDeItemBinding
import br.com.pedro.despensa.model.Despensa
import br.com.pedro.despensa.ui.adapter.ListaDeItemAdapter
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


class ListaDeItemActivity : AppCompatActivity() {

    private val adapter = ListaDeItemAdapter(this)
    private val retrofit = DespensaRetrofit()
    private val binding by lazy {
        ActivityListaDeItemBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        lifecycleScope.launch(IO) {
            val call: Call<List<Despensa>> = DespensaRetrofit().despensaService.buscaTodas()
            val resposta: Response<List<Despensa>> = call.execute()
            resposta.body()?.let {
                val recyclerView = binding.rvListaDespensa
                recyclerView.adapter = adapter
                recyclerView.layoutManager = StaggeredGridLayoutManager(2, 1)
            }

        }
    }
}