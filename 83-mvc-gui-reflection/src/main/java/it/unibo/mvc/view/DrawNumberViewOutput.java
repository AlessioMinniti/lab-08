package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberViewOutput implements DrawNumberView{

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }

    @Override
    public void setController(DrawNumberController observer) {
        // output only
    }

    @Override
    public void start() {
        //always active
    }
}