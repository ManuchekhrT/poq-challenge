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

    companion object {
        private const val ANGLE_0f = 0f
        private const val ANGLE_180f = 180f
        private const val ANIMATION_DURATION = 500L
    }

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
                        rotationAngle = if(rotationAngle == ANGLE_0f) ANGLE_180f else ANGLE_0f
                        ivArrowIcon
                            .animate()
                            .rotation(rotationAngle)
                            .setDuration(ANIMATION_DURATION)
                            .start()
                        tvDescription.isVisible = rotationAngle == ANGLE_180f
                    }
                } else {
                    ivArrowIcon.isVisible = false
                    tvDescription.isVisible = false
                }
            }
        }
    }
}