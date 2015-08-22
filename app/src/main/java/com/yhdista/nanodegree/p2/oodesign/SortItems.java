package com.yhdista.nanodegree.p2.oodesign;

/**
 * Helper enum class for sorting movies
 */
public enum SortItems {

    TITLE(1, "title"), POPULARITY(2, "popularity"), HIGHEST_RATED(3, "highest-rated"), LOWES_RATED(4, "lowest-rated");

    private final int position;
    private final String name;

    SortItems(int value, String name) {
        this.position = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static String[] getSortItemsNames() {
        String[] names = new String[SortItems.values().length];
        int i = 0;
        for (SortItems item : SortItems.values()) {
            names[i++] = item.name;
        }
        return names;
    }


}
