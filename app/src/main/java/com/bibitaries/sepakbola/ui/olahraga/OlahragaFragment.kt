package com.bibitaries.sepakbola.ui.olahraga

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import com.bibitaries.sepakbola.R
import com.bibitaries.sepakbola.databinding.FragmentOlahragaBinding
import com.bibitaries.sepakbola.ui.home.MainActivity
import kotlin.math.log

class OlahragaFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentOlahragaBinding
    private val viewModel: OlahragaViewModel by lazy { OlahragaViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOlahragaBinding.inflate(inflater, container, false).apply {
            viewModel = this@OlahragaFragment.viewModel
            lifecycleOwner = this@OlahragaFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }


    private fun init() {
        binding.recycelerView.adapter = OlahragaAdapter(parent)
        viewModel.listOlahraga()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listOlahraga()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = it
        }

        viewModel.actionState.observe(viewLifecycleOwner) {
            if (it.isConsumed) {
            Log.i("ActionState", "isConsumed")
        } else if (!it.isSuccess) {
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}