package com.peace.nestedrecyclerviews.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;

import com.peace.nestedrecyclerviews.R;
import com.peace.nestedrecyclerviews.model.ParentModel;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.MyViewHolder> {

    ArrayList<ParentModel> dataSet;

   // RecycledViewPool viewPool;
    private LinearLayoutManager childLayoutManager;
    private ChildAdapter childAdapter;

    public ParentAdapter(ArrayList<ParentModel> dataSet) {
        this.dataSet = dataSet;
        //viewPool= new RecycledViewPool();
    }

    @NonNull
    @Override
    public ParentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.parent_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.MyViewHolder holder, int position) {
        ParentModel parentModel=dataSet.get(position);
        childLayoutManager= new LinearLayoutManager(holder.recyclerView.getContext(), RecyclerView.VERTICAL,false);
        childLayoutManager.setInitialPrefetchItemCount(4);
        holder.recyclerView.setLayoutManager(childLayoutManager);
        childAdapter = new ChildAdapter(parentModel.getChildModels());
        holder.recyclerView.setAdapter(childAdapter);
        //holder.recyclerView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.child_rv);
        }
    }
}
