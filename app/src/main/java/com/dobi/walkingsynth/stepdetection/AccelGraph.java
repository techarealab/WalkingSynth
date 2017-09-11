package com.dobi.walkingsynth.stepdetection;

import android.content.Context;
import android.view.View;

public interface AccelGraph {

    /**
     * Update all graphs on the View.
     */
    void invalidate(long time);

    void reset();

    View createView(Context context);
}

