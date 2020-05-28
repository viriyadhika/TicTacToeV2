package com.example.myapplication;

import androidx.annotation.Nullable;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Coordinate) {
            Coordinate coordinate = (Coordinate) obj;
            return this.x == coordinate.x && this.y == coordinate.y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Integer.toString(x + y).hashCode();
    }
}
