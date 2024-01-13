import javax.swing.JFrame;

public class Canvas extends JFrame {

    public Canvas(String title,PhysicsPanel physics_panel){
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(physics_panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
