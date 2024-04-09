package EmailyDiseñografico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Dibujo {
    public JButton createDibujoButton() {
        JButton dibujoButton = new JButton("Dibujo");
        dibujoButton.addActionListener(e -> {
            VentanaDibujo ventanaDibujo = new VentanaDibujo();
            ventanaDibujo.setVisible(true);
        });

        return dibujoButton;
    }

    private class VentanaDibujo extends JFrame {
        private ArrayList<Point> points = new ArrayList<>();

        public VentanaDibujo() {
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.setColor(Color.BLACK);
                    for (Point point : points) {
                        g.fillOval(point.x, point.y, 5, 5);
                    }
                }
            };

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    points.add(e.getPoint());
                    panel.repaint();
                }
            });

            panel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    points.add(e.getPoint());
                    panel.repaint();
                }
            });

            add(panel);
        }
    }
}
