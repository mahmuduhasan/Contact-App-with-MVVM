package com.example.todoapp

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.FragmentShowContactBinding
import com.example.todoapp.db.ContactDB
import com.example.todoapp.model.ContactModel

class ShowContactFragment : Fragment() {
    private val modelView : ContactModel by activityViewModels()
    private lateinit var binder: FragmentShowContactBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = FragmentShowContactBinding.inflate(inflater,container, false)
        val adapter = ContactAdapter()
        binder.contactRecycleView.layoutManager = LinearLayoutManager(activity)
        binder.contactRecycleView.adapter = adapter
        adapter.submitList(modelView.getAllContact())
        binder.addContact.setOnClickListener {
            findNavController().navigate(R.id.action_showContactFragment_to_createContactFragment)
        }
        return binder.root
    }

}