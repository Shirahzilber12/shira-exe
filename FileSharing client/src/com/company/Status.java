package com.company;

/**
 * Created by hackeru on 3/30/2017.
 */
public class Status implements Listener{

    Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void printSautes(long percent) {
        if (listener!=null)
            listener.printSautes(percent);
    }
}
