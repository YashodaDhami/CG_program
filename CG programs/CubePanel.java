import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CubePanel extends JPanel {

    // The 3D points of the cube
    private int[][] points = {
            { 100, 100, 100 }, { 200, 100, 100 }, { 200, 200, 100 }, { 100, 200, 100 },
            { 100, 100, 200 }, { 200, 100, 200 }, { 200, 200, 200 }, { 100, 200, 200 }
    };

    // The edges of the cube
    private int[][] edges = {
            { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 },
            { 4, 5 }, { 5, 6 }, { 6, 7 }, { 7, 4 },
            { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 }
    };

    CubePanel() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Rotate the points of the cube
        int angle = 45;
        double radians = Math.toRadians(angle);
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int z = point[2];
            int newX = (int) (x * Math.cos(radians) - y * Math.sin(radians));
            int newY = (int) (x * Math.sin(radians) + y * Math.cos(radians));
            point[0] = newX;
            point[1] = newY;
        }

        // Draw the edges of the cube
        g.setColor(Color.BLACK);
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int startX = points[start][0];
            int startY = points[start][1];
            int endX = points[end][0];
            int endY = points[end][1];
            g.drawLine(startX, startY, endX, endY);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cube");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CubePanel());
        frame.pack();
        frame.setVisible(true);
    }
}