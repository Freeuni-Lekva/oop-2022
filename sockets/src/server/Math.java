package server;

import shared.Point;

public class Math {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b, int c) {
        return a - b - c;
    }

    public double distance(Point a, Point b) {
        return a.distance(b);
    }
}
