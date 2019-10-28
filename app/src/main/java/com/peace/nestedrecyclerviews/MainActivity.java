package com.peace.nestedrecyclerviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.peace.nestedrecyclerviews.adapters.ParentAdapter;
import com.peace.nestedrecyclerviews.model.ChildModel;
import com.peace.nestedrecyclerviews.model.ParentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter lAdapter;
    private ArrayList<ParentModel> infoListP;
    private ArrayList<ChildModel> infoList,infoList2,infoList3;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoList = new ArrayList<ChildModel>();
        infoList2= new ArrayList<ChildModel>();
        infoList3= new ArrayList<ChildModel>();
        infoListP = new ArrayList<ParentModel>();

        recyclerView=findViewById(R.id.parent_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        infoList.add(new ChildModel("Test","1"));
        infoList.add(new ChildModel("Test","2"));
        infoList.add(new ChildModel("Test","3"));
        infoList.add(new ChildModel("Test","4"));
        infoList.add(new ChildModel("Test","5"));
        infoList.add(new ChildModel("Test","6"));
        infoList.add(new ChildModel("Test","7"));

        infoList2.add(new ChildModel("List 2","1"));
        infoList2.add(new ChildModel("List 2","2"));

        infoList3.add(new ChildModel("List 3","1"));
        infoList3.add(new ChildModel("List 3","2"));

        infoListP.add(new ParentModel(infoList));
        infoListP.add(new ParentModel(infoList2));
        infoListP.add(new ParentModel(infoList3));


        lAdapter=new ParentAdapter(infoListP);
        recyclerView.setAdapter(lAdapter);
    }
}
