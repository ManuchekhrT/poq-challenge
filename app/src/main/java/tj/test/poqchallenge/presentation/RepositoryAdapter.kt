package tj.test.poqchallenge.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RepositoryAdapter : ListAdapter<RepositoryItem, RepositoryAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RepositoryItemView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        (holder.itemView as RepositoryItemView).setItem(item)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RepositoryItem>() {
            override fun areItemsTheSame(
                oldItem: RepositoryItem,
                newItem: RepositoryItem
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: RepositoryItem,
                newItem: RepositoryItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}