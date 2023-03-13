package ru.stas.mylab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ru.stas.mylab.databinding.FragmentAddBlogsBinding

@AndroidEntryPoint
class AddBlogsFragment : Fragment() {

    private var _binding: FragmentAddBlogsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBlogsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeCryptoCurrency()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun observeCryptoCurrency() = binding.cryptocurrencyList.apply {
        adapter = CryptocurrencyAdapter(emptyList())
        layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        viewModel.cryptoCurrency.observe(viewLifecycleOwner){data ->
            adapter = CryptocurrencyAdapter(data)
        }
    }
}