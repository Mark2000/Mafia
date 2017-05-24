import javax.swing.JFrame;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class GUI extends JFrame {
	public GUI() {
		setResizable(false);
		setTitle("Character Information");
		
		JLabel lblHello = new JLabel("hello");
		lblHello.setFont(new Font("Bodoni 72", Font.PLAIN, 24));
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHello, BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		new GUI();
	}

}
