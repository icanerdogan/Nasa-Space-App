package com.ibrahimcanerdogan.nasaspaceapp.view.astronomy

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
import com.ibrahimcanerdogan.nasaspaceapp.R
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.Injector
import com.ibrahimcanerdogan.nasaspaceapp.databinding.FragmentAstronomyBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import javax.inject.Inject


class AstronomyFragment : Fragment() {

    private var _binding: FragmentAstronomyBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: AstronomyViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(AstronomyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as Injector).createAstronomySubComponent().inject(this)

        viewModel.getAstronomyData().observe(this, Observer {
            Log.i(TAG, it.toString())
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAstronomyBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPagerAstronomy
        val adapter = AstronomyAdapter()
        viewPager.adapter = adapter

        val responseLiveData = viewModel.getAstronomyData()
        getAstronomyInformations(responseLiveData, adapter)

        binding.refreshLayout.setOnRefreshListener {
            val response = viewModel.updateAstronomyData()
            getAstronomyInformations(response, adapter)
            binding.refreshLayout.isRefreshing = false
            viewPager.setCurrentItem(0, false)
        }

        return binding.root
    }

    private fun getAstronomyInformations(
        response: LiveData<List<Astronomy>?>,
        adapter: AstronomyAdapter
    ) {
        response.observe(requireActivity(), Observer {
            if (it != null) {
                adapter.setAstronomyList(it)
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
        private val TAG : String = AstronomyFragment::class.java.simpleName.toString()
    }
}