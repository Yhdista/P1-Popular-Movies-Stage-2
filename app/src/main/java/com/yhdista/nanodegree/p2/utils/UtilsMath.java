package com.yhdista.nanodegree.p2.utils;

/**
 * Math Utility
 */
public class UtilsMath {

    /**
     * Compaer two doubles
     *
     * @param d1
     * @param d2
     * @return
     */
    public static int compareDouble(double d1, double d2) {
        if (d1 < d2) return -1;
        if (d1 > d2) return 1;
        return 0;
    }

    public static int convertBoolean2Integer(boolean b) {
        return (b) ? 1 : 0;
    }

    public static boolean convertInteger2Boolean(int i) {
        return (i == 1) ? true : false;
    }


}


