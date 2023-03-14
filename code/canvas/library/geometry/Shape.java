package canvas.library.geometry;

import java.util.Arrays;

public abstract class Shape implements Movable
{
    //# Fields
    protected Point[] points;
    protected int[][] linePath;

    //# Constructors
    public Shape(int points) {
        this.points = new Point[points];

        for (int i = 0; i < points; i ++) {
            this.points[i] = new Point(0, 0);
        }

        this.updateLinePath();
    }

    public Shape(Point... points) {
        this.points = points;

        this.updateLinePath();
    }

    //# Methods
    public Rectangle getBounds() {
        int[] x = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        int[] y = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };

        for (Point point : this.points) {
            x[0] = Math.min(point.x, x[0]);
            y[0] = Math.min(point.y, y[0]);

            x[1] = Math.max(point.x, x[1]);
            y[1] = Math.max(point.y, y[1]);
        }

        return new Rectangle(
                x[0], y[0], x[1] - x[0], y[1] - y[0]
        );
    }

    @Override
    public void move(int x, int y) {
        Arrays.stream(this.points).forEach(point -> point.move(x, y));
        this.updateLinePath();
    }

    public void draw(java.awt.Graphics2D graphics) {
        this.draw(graphics, false);
    }

    public void updateLinePath() {
        int n = this.points.length + (this.points.length > 2 ? 1 : 0);

        int[][] output = new int[][] { new int[n], new int[n] };

        for (int i = 0; i < n; i ++) {
            output[0][i] = this.points[i % this.points.length].x;
            output[1][i] = this.points[i % this.points.length].y;
        }

        this.linePath = output;
    }

    public void draw(java.awt.Graphics2D graphics, boolean filled) {
        if (filled) {
            graphics.drawPolygon(this.linePath[0], this.linePath[1], this.points.length + 1);
        }
        else {
            graphics.drawPolyline(this.linePath[0], this.linePath[1], this.points.length + 1);
        }
    }
}
