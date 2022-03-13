package com.peachgenz.mvvm.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.peachgenz.mvvm.databinding.FragmentMainBinding
import com.peachgenz.mvvm.ui.main.adapter.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel by sharedViewModel<MainViewModel>()

    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTopNews()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachObserver()
        initAdapter()
    }

    private fun attachObserver() {
        with(viewModel) {
            uiState.observe(viewLifecycleOwner) {}

            getTopNewsUseCaseSuccess.observe(viewLifecycleOwner) { response ->
                response?.articles.let {
                    if (it != null) {
                        adapter.newsData = it
                    }
                }
            }
        }
    }

    private fun initAdapter() {
        adapter = NewsAdapter()
        binding.rvNews.adapter = adapter
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
    }
}