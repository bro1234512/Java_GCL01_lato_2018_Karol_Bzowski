package com.example.javadb.app;

import com.example.javadb.entity.Model;
import com.example.javadb.entity.Producent;

public class app {
    private Producent producent;
    private Model model;

    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
