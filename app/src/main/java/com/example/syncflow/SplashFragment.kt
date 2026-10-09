package com.example.syncflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.syncflow.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Başlangıçta hepsi görünmez
        listOf(binding.logo,binding.txtSync,binding.txtFlow,binding.txtTagline)
            .forEach {
                it.alpha=0f
            }
        binding.logo.translationY = 40f
        // Logo aşağıdan yukarı çıkar
        binding.logo.animate().alpha(1f).translationY(0f).setDuration(1000).start()

        // Yazı gelir
        binding.txtSync.animate().alpha(1f).setStartDelay(900).setDuration(1000).start()
        binding.txtFlow.animate().alpha(1f).setStartDelay(1200).setDuration(1000).start()

        // Slogan gelir
        binding.txtTagline.animate().alpha(1f).setStartDelay(2000).setDuration(800).start()

        // 2.5 saniye sonra login ekranına geç
        viewLifecycleOwner.lifecycleScope.launch {
            delay(4000)
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}