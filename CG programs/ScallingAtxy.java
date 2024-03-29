import java.awt.*;
import javax.swing.JFrame;
import java.util.Scanner;

public class ScallingAtxy extends Canvas {
    static int x1, y1, x2, y2, sx, sy, xf, yf;

    ScallingAtxy(int x1, int y1, int x2, int y2, int sx, int sy, int xf, int yf) {
        ScallingAtxy.x1 = x1;
        ScallingAtxy.y1 = y1;
        ScallingAtxy.x2 = x2;
        ScallingAtxy.y2 = y2;
        ScallingAtxy.sx = sx;
        ScallingAtxy.sy = sy;
        ScallingAtxy.xf = xf;
        ScallingAtxy.yf = yf;
    }

    public void paint(Graphics g) {
        int xn1, yn1, xn2, yn2;
        g.setColor(Color.orange);
        g.drawRect(x1, y1, x2, y2);
        xn1 = x1 - xf;
        yn1 = y1 - yf;
        xn2 = x2 - xf;
        yn2 = y2 - yf;

        xn1 = xn1 * sx;
        yn1 = yn1 * sy;
        xn2 = xn2 * sx;
        yn2 = yn2 * sy;

        xn1 = x1 + xf;
        yn1 = y1 + yf;
        xn2 = x2 + xf;
        yn2 = y2 + yf;
        g.setColor(Color.green);
        g.drawRect(xn1, yn1, xn2, yn2);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lower left corner (x1,y1)");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println("Enter upper right corner (x2,y2)");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println("Enter Scaling factor (sx,sy)");
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        System.out.println("Enter fixed point (xf,yf)");
        int xf = sc.nextInt();
        int yf = sc.nextInt();
        sc.close();
        ScallingAtxy s = new ScallingAtxy(x1, y1, x2, y2, sx, sy, xf, yf);
        JFrame f = new JFrame();
        f.add(s);
        f.setSize(800, 800);
        f.setVisible(true);

    }

}