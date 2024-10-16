package com.ivan_tar;

import java.util.Objects;

public class Coordinates {
    public final Integer vertical;
    public final Integer horizontal;

    public Coordinates(Integer horizontal, Integer vertical) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    public Integer getVertical() {
        return vertical;
    }

    public Integer getHorizontal() {
        return horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(vertical, that.vertical) && Objects.equals(horizontal, that.horizontal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }
}
