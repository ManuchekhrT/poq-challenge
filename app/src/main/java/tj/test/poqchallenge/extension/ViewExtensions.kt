package tj.test.poqchallenge.extension

import android.view.View
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import tj.test.poqchallenge.presentation.Status

fun View.show() {
    this.isVisible = true
}

fun View.hide() {
    this.isVisible = false
}

fun View.showSnackBar(message: String? = null, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message ?: "", duration).show()
}

