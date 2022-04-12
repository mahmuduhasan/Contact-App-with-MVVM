package com.example.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todoapp.databinding.FragmentCreateContactBinding
import com.example.todoapp.db.ContactDB
import com.example.todoapp.model.ContactModel

class CreateContactFragment : Fragment() {
    private val modelView : ContactModel by activityViewModels()
    private lateinit var binding : FragmentCreateContactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateContactBinding.inflate(inflater,container,false)
        
        binding.contactAdd.setOnClickListener { 
            saveInfo()
        }
        
        return binding.root
    }

    private fun saveInfo() {
        if (binding.name.text.isEmpty()){
            Toast.makeText(activity, "Please Insert Name", Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.phone.text.isEmpty()){
            Toast.makeText(activity, "Please Insert Phone", Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.address.text.isEmpty()){
            Toast.makeText(activity, "Please Insert Address", Toast.LENGTH_SHORT).show()
            return
        }
        if (binding.email.text.isEmpty()){
            Toast.makeText(activity, "Please Insert Email", Toast.LENGTH_SHORT).show()
            return
        }

        val name = binding.name.text.toString()
        val phone = binding.phone.text.toString()
        val email = binding.email.text.toString()
        val address = binding.address.text.toString()

        val newContact = Contact(
            name = name,
            phone = phone,
            email = email,
            address = address
        )

        modelView.addContact(newContact)

        findNavController().navigate(R.id.action_createContactFragment_to_showContactFragment)
    }

}