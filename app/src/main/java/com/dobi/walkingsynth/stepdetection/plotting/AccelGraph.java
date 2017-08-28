package com.dobi.walkingsynth.stepdetection.plotting;

import android.content.Context;
import android.view.View;

public interface AccelGraph extends OnThresholdChangeListener {

    /**
     * Update all graphs on the View.
     * @param t time plotting argument
     * @param v an array of values to plot
     */
    void invalidate(double t, double[] v);

    void reset();

    /**
        Returns the view representing this graph
     */
    View createView(Context context);
}
