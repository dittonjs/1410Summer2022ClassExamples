package com.usu.showyourwork;

import com.usu.Point;

public class Rectangle {
    PointCollection pointCollection;
    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getWidth() {
        return bottomRight.getX() - topLeft.getX();
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }
}
