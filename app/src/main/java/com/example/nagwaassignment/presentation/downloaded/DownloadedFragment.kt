package com.example.nagwaassignment.presentation.downloaded

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nagwaassignment.MyApplication
import com.example.nagwaassignment.databinding.FragmentDownloadedBinding

class DownloadedFragment : Fragment() {

    private var _binding: FragmentDownloadedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val downloadedViewModel =
            ViewModelProvider(this)[DownloadedViewModel::class.java]

        _binding = FragmentDownloadedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDownloaded
        downloadedViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }
}