package case_study_3;

import java.util.*;

public class Rectangles {
    private class Rectangle {
        int width;
        int height;
        int area;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
            this.area = width * height;
        }
    }

    private int calculateArea(int[] x, int[] h, int[] w) {
        int[] x2 = new int[x.length];

        for (int i = 0; i < x.length; i++) {
            x2[i] = x[i] + w[i];
        }

        ArrayList<Integer> points = new ArrayList<>();

        for (int i = 0; i < x.length; i++) {
            points.add(x[i]);
            points.add(x[i] + w[i]);
        }

        Collections.sort(points);

        int tempHeight;
        ArrayList<Rectangle> rectanglesToCalculate = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++) {
            tempHeight = 0;
            int beginPoint = points.get(i);
            int endPoint = points.get(i + 1);

            for (int j = 0; j < x.length; j++) {
                if (x[j] <= beginPoint && x2[j] >= endPoint && h[j] > tempHeight) {
                    tempHeight = h[j];
                }
            }

            if (tempHeight > 0) {
                rectanglesToCalculate.add(new Rectangle(endPoint - beginPoint, tempHeight));
            }
        }

        int area = 0;
        for (Rectangle r : rectanglesToCalculate) {
            area += r.area;
        }

        return area;
    }

    public static void main(String[] args) {
        Rectangles rectangles = new Rectangles();

        int[] x = {1, 2, 4, 3, 2, 6, 9, 11};
        int[] h = {2, 4, 1, 3, 6, 2, 8, 5};
        int[] w = {2, 3, 7, 5, 2, 1, 1, 2};

        int area = rectangles.calculateArea(x, h, w);

        System.out.println(area);
    }
}