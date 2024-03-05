package com.warpradar.misc.utils;

public class RuslaDoubleMath {

    public static double nthRoot(double a, double b) {
        double c = Math.pow(a, 1.0 / b);
        return Math.pow(Math.round(c), b);
    }

}
