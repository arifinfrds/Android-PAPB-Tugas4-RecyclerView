package com.arifinfrds.tugas4recyclerview;

/**
 * Created by arifinfrds on 11/6/17.
 */

public class OperatingSystem {

    private int imageResId;
    private String name;

    public OperatingSystem(int imageResId, String name) {
        this.imageResId = imageResId;
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }


}
