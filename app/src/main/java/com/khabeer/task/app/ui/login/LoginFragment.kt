package com.khabeer.task.app.ui.login

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.Khabeer.task.R
import com.Khabeer.task.databinding.FragmentLoginBinding
import com.khabeer.task.app.core.PAYROLL
import com.khabeer.task.data.network.ResponseWrapper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            viewModel.login(
                binding.phoneNumber.text.toString(),
                binding.password.text.toString()
            )
        }
        lifecycleScope.launchWhenStarted {
            viewModel.loginMutableSharedFlow.collect {
                when (it) {
                    is ResponseWrapper.Error -> {
                        binding.loader.visibility=View.GONE
                        binding.loginBtn.isEnabled = true
                        Toast.makeText(
                            requireContext(),
                            it.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    ResponseWrapper.Loading -> {
                        binding.loader.visibility=View.VISIBLE
                        binding.loginBtn.isEnabled = false
                    }
                    is ResponseWrapper.Success -> findNavController().navigate(R.id.action_loginFragment_to_homeFragment,
                        bundleOf(PAYROLL to it.data))
                }
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}