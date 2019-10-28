package com.peace.nestedrecyclerviews.model;

import java.util.ArrayList;

public class ParentModel {
    ArrayList<ChildModel> childModels;

    public ParentModel(ArrayList<ChildModel> childModels) {
        this.childModels = childModels;
    }

    public ArrayList<ChildModel> getChildModels() {
        return childModels;
    }
    public ChildModel getChildModel(int position) {
        return childModels.get(position);
    }
}
