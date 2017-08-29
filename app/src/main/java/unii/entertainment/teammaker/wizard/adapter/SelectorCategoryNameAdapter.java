package unii.entertainment.teammaker.wizard.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.category.model.Category;

public class SelectorCategoryNameAdapter extends RecyclerView.Adapter<SelectorCategoryNameAdapter.ViewHolder> {

    private List<Category> categoryList;
    private int selectedPosition;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_wizzard_category_configuration, parent, false);
        SelectorCategoryNameAdapter.ViewHolder viewHolder = new SelectorCategoryNameAdapter.ViewHolder(inflatedView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Category category = categoryList.get(position);
        //TODO: add information about players
        // int countPlayers = categoryListViewModel.countPlayersWithCategoryId(category.getId());
        holder.categoryName.setText(category.getCategoryName());
        //TODO: Add better code (without rechecking all data)
        if (position != selectedPosition) {
            holder.categoryName.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.categoryName_selector)
        CheckBox categoryName;

        @OnCheckedChanged(R.id.categoryName_selector)
        public void onChange() {
            if (categoryName.isSelected()) {
                selectedPosition = getAdapterPosition();
            }
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
