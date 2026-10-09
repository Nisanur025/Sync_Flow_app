package com.example.syncflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.example.syncflow.databinding.FragmentLoginBinding
import com.example.syncflow.databinding.FragmentRegisterStepThreeBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Giriş Yap Butonu
        binding.btnLogin.setOnClickListener {
            // Boş kontrolü
            val companyCode = binding.etCompanyCode.text.toString().trim()
            val etEmail = binding.etEmail.text.toString().trim()
            val etpassword = binding.etPassword.text.toString()

            if(companyCode.isEmpty()){
                binding.CompanyCodeLayout.error = "Firma kodu koş olamaz"
            }
            if(etEmail.isEmpty()){
                binding.etEmailLayout.error="Email boş olamaz"
            }
            if(etpassword.isEmpty()){
                binding.etPasswordLayout.error="Şifre boş olamaz"
            }
            else{
                // TODO : Safe args kullanarak ana sayfaya yönlendir
                // TODO : Veri tabanı bağlanınca Girilen bilgilerin doğruluğunu kontrol et
            }

            clearErrorText(binding.etCompanyCode,binding.CompanyCodeLayout)
            clearErrorText(binding.etEmail,binding.etEmailLayout)
            clearErrorText(binding.etPassword,binding.etPasswordLayout)

        }

    }

    // EditTexte Tıklayınca Error Mesajını silme
    private fun clearErrorText(editText: TextInputEditText,layout: TextInputLayout){
        editText.doAfterTextChanged { layout.error=null }
    }


}