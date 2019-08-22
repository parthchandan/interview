package com.example.testinterview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testinterview.R;
import com.example.testinterview.model.ImageList;
import com.example.testinterview.viewmodel.ListViewModel;


import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.RepoViewHolder>{

    private final List<ImageList> data = new ArrayList<>();

    public ImageListAdapter(ListViewModel viewModel, LifecycleOwner lifecycleOwner) {
        viewModel.getRepos().observe(lifecycleOwner, repos -> {
            data.clear();
            if (repos != null) {
                data.addAll(repos);
                notifyDataSetChanged();
            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image_list, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).id;
    }

    static final class RepoViewHolder extends RecyclerView.ViewHolder {


        TextView repoNameTextView;

        TextView repoDescriptionTextView;
        TextView forksTextView;

        TextView starsTextView;

        private ImageList repo;

        RepoViewHolder(View itemView) {
            super(itemView);
            repoNameTextView = itemView.findViewById(R.id.tv_repo_name);
            repoDescriptionTextView = itemView.findViewById(R.id.tv_repo_description);
            forksTextView = itemView.findViewById(R.id.tv_forks);
            starsTextView = itemView.findViewById(R.id.tv_stars);
//            ButterKnife.bind(this, itemView);
//            itemView.setOnClickListener(v -> {
//                if(repo != null) {
////                    repoSelectedListener.onRepoSelected(repo);
//                }
//            });
        }

        void bind(ImageList repo) {
            this.repo = repo;
            repoNameTextView.setText(repo.name);
            repoDescriptionTextView.setText(repo.description);
            forksTextView.setText(String.valueOf(repo.forks));
            starsTextView.setText(String.valueOf(repo.stars));
        }
    }
}
