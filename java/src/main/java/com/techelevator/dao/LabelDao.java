package com.techelevator.dao;

import com.techelevator.model.Label;

public interface LabelDao {
    Label getLabelById(int id);
    boolean updateLabel(Label label);
    void addLabel(Label label);
    int deleteLabelById(int id);
}
