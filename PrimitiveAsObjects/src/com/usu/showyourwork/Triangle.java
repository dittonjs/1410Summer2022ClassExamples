package com.usu.showyourwork;

import com.usu.Point;

public class Triangle extends Rectangle {
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        super(point1, point2);
        this.point3 = point3;
    }

    public Point getPoint3() {
        return point3;
    }
}
