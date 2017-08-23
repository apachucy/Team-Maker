package unii.entertainment.teammaker.category.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.category.model.Category;
import unii.entertainment.teammaker.category.viewmodel.CategoryListViewModel;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
    private CategoryListViewModel categoryListViewModel;

    public CategoryListAdapter(CategoryListViewModel categoryListViewModel) {
        this.categoryListViewModel = categoryListViewModel;
    }

    //TODO what to do if list is empty?
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_category_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflatedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category = categoryListViewModel.getCategoryList().get(position);
        int countPlayers = categoryListViewModel.countPlayersWithCategoryId(category.getId());
        holder.categoryNameTextView.setText(category.getCategoryName());

        holder.playersInCategoryTextView.setText(Integer.toString(countPlayers));
    }

    @Override
    public int getItemCount() {
        List<Category> categoryList = categoryListViewModel.getCategoryList();
        if (categoryList != null) {
            return categoryList.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.categoryNameTextView)
        TextView categoryNameTextView;
        @BindView(R.id.playersInCategoryTextView)
        TextView playersInCategoryTextView;

        @OnClick(R.id.row_category)
        public void checkItem(View currentItemView) {
            //TODO: open new view with providedId
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
