package com.dobi.walkingsynth.stepdetection.accelerometer;

public final class ScalarKalmanFilter {

    private double mX0; // predicted state
    private double mP0; // predicted covariance
    private double mF; // factor of real value to previous real value
    private double mH; // factor of measured value to real value
    private double mQ; // measurement noise
    private double mR; // environment noise
    private double mState = 0; // current state
    private double mCovariance = 0.1f; // current covariance

    public ScalarKalmanFilter(float f, float h, float q, float r){
        mF = f;
        mH = h;
        mQ = q;
        mR = r;
    }

    double correct(double measuredValue){
        // time update - prediction
        mX0 = mF * mState;
        mP0 = mF * mCovariance*mF + mQ;

        // measurement update - correction
        double k = mH * mP0/(mH * mP0 * mH + mR);
        mCovariance = (1 - k * mH) * mP0;
        return mState = mX0 + k * (measuredValue - mH * mX0);
    }
}