package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

      _binding = FragmentFirstBinding.inflate(inflater, container, false)

      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        if (number != 0) {
            binding.numberInput.setText(number.toString())
        }

        binding.buttonFirst.setOnClickListener {
            val text: String = binding.numberInput.text.toString()
            if(text.isNotEmpty()) {
                val textInt = text.toInt()
                if (textInt in 1..999) {
                    number = text.toInt()
                }
            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}