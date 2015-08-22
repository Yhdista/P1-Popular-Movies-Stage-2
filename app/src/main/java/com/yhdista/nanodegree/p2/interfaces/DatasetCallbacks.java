package com.yhdista.nanodegree.p2.interfaces;

import java.util.List;

/**
 * MainFragment callbacks
 */
public interface DatasetCallbacks<E> {

    void setData(List<E> elements);

    void sortBy(int which);

}
