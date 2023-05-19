package com.example.StreamItMovieApp.ui

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.StreamItMovieApp.R
import com.example.StreamItMovieApp.databinding.RecyclerViewBinding

class RecyclerViewFragment : Fragment() {

    private var _binding : RecyclerViewBinding? = null
    private val binding get() = _binding!!
    var trueFlag = true

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

        val myList = listOf(DataCall(R.mipmap.ic_launcher, "Movie 1", "(2002)"),
                            DataCall(R.mipmap.ic_launcher_round, "The Movie db", "(2020)"))

        binding.recyclerViewID.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewID.adapter = AdapterRV(myList)
        binding.recyclerViewID.addItemDecoration(itemDecoration(25))
        binding.recyclerViewID.setHasFixedSize(true)

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