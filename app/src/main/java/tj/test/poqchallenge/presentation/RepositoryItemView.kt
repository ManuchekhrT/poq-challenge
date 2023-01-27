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

    private var rotationAngle = 0f

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun setItem(item: RepositoryItem) {
        item.apply {
            val name = this.name
            val description = this.description
            val htmlUrl = this.htmlUrl

            with(binding) {
                tvName.text = name
                binding.tvHtmlUrl.text = htmlUrl

                if (description.isNotBlank()) {
                    ivArrowIcon.isVisible = true
                    tvDescription.text = description
                    ivArrowIcon.setOnClickListener {
                        rotationAngle = if(rotationAngle == 0f) 180f else 0f
                        ivArrowIcon.animate().rotation(rotationAngle).setDuration(500).start()
                        tvDescription.isVisible = rotationAngle == 180f
                    }
                } else {
                    ivArrowIcon.isVisible = false
                    tvDescription.isVisible = false
                }
            }
        }
    }
}