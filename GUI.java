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

public class GUI extends JFrame {
	public GUI() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Select player names.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Bodoni 72", Font.PLAIN, 24));
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Bodoni 72", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(0, 0, 0));
		getContentPane().add(btnNewButton);
		setResizable(false);
		setSize(800,600);
		setTitle("MAFIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
