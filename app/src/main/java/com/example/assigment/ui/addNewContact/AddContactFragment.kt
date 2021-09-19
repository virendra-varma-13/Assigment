package com.example.assigment.ui.addNewContact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.assigment.R
import com.example.assigment.databinding.AddContactFragmentBinding

class AddContactFragment : Fragment() {

    private var _binding: AddContactFragmentBinding? = null

    private val binding get() = _binding!!

    private lateinit var addContactViewModel: AddContactViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View {

        _binding = AddContactFragmentBinding.inflate(inflater, container, false)
        addContactViewModel = ViewModelProvider(this).get(AddContactViewModel::class.java)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener{
            val contactType = if(binding.contactType.checkedRadioButtonId == binding.personal.id)
                "Personal"
            else
                "Business"
            addContactViewModel.saveContact(binding.contactNameInput.text.toString(), binding.contactNumberInput.text.toString(), contactType)
        }

        addContactViewModel.navigateToSleepTracker.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                this.findNavController().navigate(R.id.action_addContactFragment_to_viewContactFragment)
                addContactViewModel.doneNavigating()
            }
            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}