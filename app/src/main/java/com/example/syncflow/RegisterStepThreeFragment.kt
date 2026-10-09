package com.example.syncflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.syncflow.databinding.FragmentRegisterStepThreeBinding
import com.example.syncflow.databinding.ItemDepartmentBinding
import com.example.syncflow.databinding.ItemTeamBinding


class RegisterStepThreeFragment : Fragment() {

    private var _binding: FragmentRegisterStepThreeBinding? = null
    private val binding get() = _binding!! // Fragment aktif olduğu sürece binding'in null olmayacağını garanti eden güvenli getter tanımı

    // Fragment ilk oluşturulurken çağrılır
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    // Fragmentın ekranını oluşturduğu yer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterStepThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Başlangıç işleri ve Tıklama Olayları
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addDepartment() // ilk kart hazır gelsin

        // yeni Departman Ekle butonuna basılınca yeni kart eklensin
        binding.tvAddDepartment.setOnClickListener {
            addDepartment()
        }
    }


    private fun addDepartment(){
        // ItemDepartment'dan yeni kopya üret
        val item = ItemDepartmentBinding.inflate(
            layoutInflater, binding.departmentContainer, false
        )

        // Departmana Yeni Ekip Ekle
        item.btnAddTeam.setOnClickListener {
            addTeam(item.teamContainer)
        }

        // Bu Departmanı Sil
        item.btnRemoveDepartment.setOnClickListener {
            binding.departmentContainer.removeView(item.root)
        }


        binding.departmentContainer.addView(item.root)
        addTeam(item.teamContainer) // Her departmanda ekip satırı gelmiş olsun
    }

    // Ekip Satırı Üretme
    private fun addTeam(container: LinearLayout){
        val row= ItemTeamBinding.inflate(layoutInflater,container,false)

        row.btnRemoveTeam.setOnClickListener {
            container.removeView(row.root)
        }

        container.addView(row.root)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}