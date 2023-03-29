package com.ibrahimcanerdogan.nasaspaceapp.view.marsrover

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.Injector
import com.ibrahimcanerdogan.nasaspaceapp.databinding.FragmentMarsRoverBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail
import javax.inject.Inject


class MarsRoverFragment : Fragment() {

    private var _binding: FragmentMarsRoverBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var factory: MarsRoverViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(MarsRoverViewModel::class.java)
    }

    private var currentPage  = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as Injector).createMarsRoverSubComponent().inject(this)

        viewModel.getMarsRoverData(0).observe(this, Observer {
            Log.i(TAG, it.toString())
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsRoverBinding.inflate(inflater, container, false)
        val recyclerView = binding.recyclerMarsRover
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = MarsRoverAdapter()
        recyclerView.adapter = adapter

        val responseLiveData = viewModel.getMarsRoverData(currentPage)
        getMarsRoverInformations(responseLiveData, adapter)

        binding.refreshLayout.setOnRefreshListener {
            if (currentPage == 35) {
                currentPage = 1
                val newResponse = viewModel.updateMarsRoverData(currentPage)
                getMarsRoverInformations(newResponse, adapter)
                binding.refreshLayout.isRefreshing = false
                Toast.makeText(requireContext(), "All data Reviewed!", Toast.LENGTH_SHORT).show()
            } else {
                currentPage += 1
                val newResponse = viewModel.updateMarsRoverData(currentPage)
                getMarsRoverInformations(newResponse, adapter)
                binding.refreshLayout.isRefreshing = false
            }


        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    private fun getMarsRoverInformations(
        response: LiveData<List<MarsRoverDetail>?>,
        adapter: MarsRoverAdapter
    ) {
        response.observe(requireActivity(), Observer {
            if (it != null) {
                adapter.setMarsRoverDetailList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(requireContext(), "No data available!", Toast.LENGTH_LONG).show()
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val TAG : String = MarsRoverFragment::class.java.simpleName.toString()
    }
}