package com.khabeer.task.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.Khabeer.task.databinding.FragmentHomeBinding
import com.khabeer.task.app.core.PAYROLL
import com.khabeer.task.domain.model.EmployeeModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var adapter: EmployeeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val payroll:List<EmployeeModel> = (arguments?.get(PAYROLL) ?: emptyList<EmployeeModel>()) as List<EmployeeModel>
        adapter = EmployeeAdapter(payroll)
        binding.employeesRv.adapter=adapter


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}