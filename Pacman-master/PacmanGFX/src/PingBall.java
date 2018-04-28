import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PingBall extends JComponent {
	
    private final static int ANCHO = 768;

    private final static int ALTO = 384;

    private final static int DIAMETRO = 20;

    private float x, y;

    private float vx, vy;

    private boolean arriba, abajo, izquierda, derecha;

    public PingBall() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        x = 10;
        y = 20;
        addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    actualiza(e.getKeyCode(), true);
                }

                public void keyReleased(KeyEvent e) {
                    actualiza(e.getKeyCode(), false);
                }

                private void actualiza(int keyCode, boolean pressed) {
                    switch (keyCode) {
                        case KeyEvent.VK_UP:
                            arriba = pressed;
                            break;

                        case KeyEvent.VK_DOWN:
                            abajo = pressed;
                            break;

                        case KeyEvent.VK_LEFT:
                            izquierda = pressed;
                            break;

                        case KeyEvent.VK_RIGHT:
                            derecha = pressed;
                            break;
                    }
                }
            });
        setFocusable(true);
    }

    private float clamp(float valor, float min, float max) {
        if (valor > max)
            return max;
        if (valor < min)
            return min;
        return valor;
    }

    private void fisica(float dt) {
        vx = 0;
        vy = 0;
        if (arriba)
            vy = -150;
        if (abajo)
            vy = 150;
        if (izquierda)
            vx = -150;
        if (derecha)
            vx = 150;
        x = clamp(x + vx * dt, 0, ANCHO - DIAMETRO);
        y = clamp(y + vy * dt, 0, ALTO - DIAMETRO);
    }

    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
    }

    private void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    paintImmediately(0, 0, ANCHO, ALTO);
                }
            });
    }

    public void cicloPrincipalJuego() throws Exception {
        long tiempoViejo = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
            tiempoViejo = tiempoNuevo;
            fisica(dt);
            dibuja();
        }
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("PingBall");
        jf.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        PingBall ball = new PingBall();
        jf.getContentPane().add(ball);
        jf.pack();
        jf.setVisible(true);
        ball.cicloPrincipalJuego();
    }
}
