package com.example.StreamItMovieApp.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.StreamItMovieApp.API.RetrofitInstance
import com.example.StreamItMovieApp.R
import com.example.StreamItMovieApp.databinding.RecyclerViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecyclerViewFragment : Fragment() {

    private var _binding : RecyclerViewBinding? = null
    private val binding get() = _binding!!

    //Inflamos el binding con el archivo xml
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Adaptar las vistas a la lista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        CoroutineScope(Dispatchers.IO).launch {

            val callResponse = RetrofitInstance.theMovieDbService.getPlayingNowList("a18af9730f4b36fd3032baedeeb0de39","en-US", 1)

            withContext(Dispatchers.Main){
                val movieList = callResponse.PlayingNowList1.map { DataCall(it.imageResource, it.movieName, it.movieYear) }
                val movieAdapter = AdapterRV(movieList)
                binding.recyclerViewID.adapter = AdapterRV(movieList)
            }
        }
        binding.recyclerViewID.addItemDecoration(itemDecoration(25))
        binding.recyclerViewID.setHasFixedSize(true)

    }

    private fun callMovies(){
        //llamada a la red asincronica con Coroutines, añadiendo un Dispatchers.IO para que dedique un hilo especial para las operaciones entrada/salida
        CoroutineScope(Dispatchers.IO).launch {

            val callResponse = RetrofitInstance.theMovieDbService.getPlayingNowList("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhMThhZjk3MzBmNGIzNmZkMzAzMmJhZWRlZWIwZGUzOSIsInN1YiI6IjY0NjA0MjBjYTY3MjU0MDE0MzY2OTE1NiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.hSqbYXebxRCwMkNTi0aCrrEypq1WK8IKrTE_icXr1EY","en-US", 1)

            withContext(Dispatchers.Main){
                val movieList = callResponse.PlayingNowList1.map { DataCall(it.imageResource, it.movieName, it.movieYear) }
                val movieAdapter = AdapterRV(movieList)
                binding.recyclerViewID.adapter = AdapterRV(movieList)
            }
        }
    }


    //Limpiar el binding cuando es destruido
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //decoracion de item (esta vez para poner un espacio entre cada item)
    class itemDecoration(private val spaceHeight : Int) : RecyclerView.ItemDecoration(){

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.bottom = spaceHeight
        }
    }

}