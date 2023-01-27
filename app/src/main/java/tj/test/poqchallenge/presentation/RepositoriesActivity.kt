package tj.test.poqchallenge.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import tj.test.poqchallenge.databinding.ActivityRepositoriesBinding
import tj.test.poqchallenge.extension.hide
import tj.test.poqchallenge.extension.show
import tj.test.poqchallenge.extension.showSnackBar

@AndroidEntryPoint
class RepositoriesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRepositoriesBinding.inflate(layoutInflater)
    }
    private val repositoryAdapter by lazy {
        RepositoryAdapter()
    }
    private val viewModel: RepositoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
        initObservers()
    }

    private fun initView() = with(binding) {
        rvRepositories.adapter = repositoryAdapter

        ivRefresh.setOnClickListener {
            viewModel.fetchRepositoryItems()
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.repositoryItems.collectLatest {
                when(it.status) {
                    Status.LOADING -> {
                        binding.pbLoading.show()
                        binding.rvRepositories.hide()
                    }
                    Status.SUCCESS -> {
                        binding.pbLoading.hide()
                        binding.rvRepositories.show()
                        repositoryAdapter.submitList(it.data)
                    }
                    Status.ERROR -> {
                        binding.pbLoading.hide()
                        binding.rvRepositories.hide()
                        binding.root.showSnackBar(it.message)
                    }
                }
            }
        }
    }
}