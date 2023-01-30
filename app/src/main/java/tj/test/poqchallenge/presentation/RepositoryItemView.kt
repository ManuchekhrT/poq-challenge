package tj.test.poqchallenge.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isVisible
import tj.test.poqchallenge.databinding.ItemRepositoryBinding

class RepositoryItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding =
        ItemRepositoryBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun setItem(item: RepositoryItem) {
        with(binding) {
            tvName.text = item.name
            tvDescription.isVisible = item.description.isNotBlank()
            tvDescription.text = item.description
            tvIsPrivate.isVisible = !item.isPrivate
            tvForks.text = item.forksCount.toString()
            tvStar.text = item.starsCount.toString()
            tvIssue.text = item.issuesCount.toString()
            tvLang.isVisible = item.language.isNotBlank()
            ivCircleLang.isVisible = item.language.isNotBlank()
            tvLang.text = item.language
        }
    }
}