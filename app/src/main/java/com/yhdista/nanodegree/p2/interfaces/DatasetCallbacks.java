package com.yhdista.nanodegree.p2.interfaces;

/**
 * MainFragment callbacks
 */
public interface DatasetCallbacks<T> {

    void setData(T t);

    void sortBy(int which);

}
