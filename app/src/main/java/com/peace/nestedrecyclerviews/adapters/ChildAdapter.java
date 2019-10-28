package com.peace.nestedrecyclerviews.adapters;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.peace.nestedrecyclerviews.R;
import com.peace.nestedrecyclerviews.model.ChildModel;

import java.util.ArrayList;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.MyViewHolder> {

    ArrayList<ChildModel> dataSet;

    public ChildAdapter(ArrayList<ChildModel> dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ChildAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.child_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.MyViewHolder holder, int position) {
        try {
            holder.itemTitle.setText(dataSet.get(position).getTitle());
            //if(dataSet.get(position).getBgcolor().equals("Secondary"))
              //  holder.itemMain.setBackgroundColor(holder.itemTitle.getContext().getResources().getColor(R.color.colorSecondaryLight));
            holder.itemValue.setText(Html.fromHtml(dataSet.get(position).getValue()));
            //if (holder.itemTitle.getText().toString().equals("Pesticide Name"))
                //holder.item.setVisibility(View.VISIBLE);

            /*holder.itemMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(v.getContext(), "Pressed "+dataSet.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                    if (holder.item.getVisibility() == View.GONE)
                        holder.item.setVisibility(View.VISIBLE);
                    else
                        holder.item.setVisibility(View.GONE);
                }
            });*/
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTitle,itemValue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //item=itemView.findViewById(R.id.info_more);
            itemTitle=itemView.findViewById(R.id.info_title);
            itemValue=itemView.findViewById(R.id.info_value);
            //itemMain=itemView.findViewById(R.id.info_main);
        }
    }
}
