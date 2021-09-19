package com.example.assigment.ui.viewContact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assigment.R
import com.example.assigment.adapter.ContactAdapter
import com.example.assigment.databinding.ViewContactFragmentBinding

class ViewContactFragment : Fragment() {

    private var _binding: ViewContactFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewContactViewModel: ViewContactViewModel


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = ViewContactFragmentBinding.inflate(inflater, container, false)
        viewContactViewModel = ViewModelProvider(this).get(ViewContactViewModel::class.java)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ContactAdapter()
        binding.contactList.adapter = adapter

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_viewContactFragment_to_AddContactFragment)
        }

        viewContactViewModel.allContacts.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
                val visibility = if(it.isNotEmpty()) View.GONE else View.VISIBLE
                binding.textviewFirst.visibility = visibility
                viewContactViewModel.emptyListMessageVisibility.set(visibility)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}