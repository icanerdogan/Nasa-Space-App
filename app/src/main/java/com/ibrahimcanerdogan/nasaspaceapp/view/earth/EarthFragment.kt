package com.ibrahimcanerdogan.nasaspaceapp.view.earth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.ibrahimcanerdogan.nasaspaceapp.R
import com.ibrahimcanerdogan.nasaspaceapp.data.dependencyinjection.Injector
import com.ibrahimcanerdogan.nasaspaceapp.databinding.FragmentEarthBinding
import com.ibrahimcanerdogan.nasaspaceapp.databinding.FragmentMarsRoverBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail
import com.ibrahimcanerdogan.nasaspaceapp.view.marsrover.MarsRoverAdapter
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class EarthFragment : Fragment() {

    private var _binding: FragmentEarthBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var factory: EarthViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, factory).get(EarthViewModel::class.java)
    }
    private var todayDate = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as Injector).createEarthSubComponent().inject(this)
        todayDate = initDay()

        viewModel.getEarthData(todayDate).observe(this) {
            Log.i(TAG, it.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEarthBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPagerEarth
        val adapter = EarthAdapter()
        viewPager.adapter = adapter

        val responseLiveData = viewModel.getEarthData(todayDate)
        getEarthInformations(responseLiveData, adapter)

        binding.refreshLayout.setOnRefreshListener {
            todayDate = initDay()
            val newResponse = viewModel.getEarthData(todayDate)
            getEarthInformations(newResponse, adapter)
            binding.refreshLayout.isRefreshing = false
            Toast.makeText(requireContext(), "All data Reviewed!", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    private fun getEarthInformations(
        response: LiveData<List<EarthDetail>?>,
        adapter: EarthAdapter
    ) {
        response.observe(requireActivity()) {
            if (it != null) {
                adapter.setEarthList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(requireContext(), "No data available!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initDay() : String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, -2)
        val date = calendar.time

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(date)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val TAG : String = EarthFragment::class.java.simpleName.toString()
    }
}