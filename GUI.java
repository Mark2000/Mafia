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

public class GUI extends JFrame {
	public GUI() {
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		setSize(800,600);
		setTitle("MAFIA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[40%,grow][30%:n,center][40%]", "[110.00][20%,top][20%][grow]"));
		
		JLabel title = new JLabel("Mafia");
		title.setForeground(new Color(178, 34, 34));
		title.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 70));
		getContentPane().add(title, "cell 1 1,alignx center,aligny bottom");
		
		SpinnerModel numPlayersModel = new SpinnerNumberModel(5,5,20,1);
		JSpinner numPlayers = new JSpinner(numPlayersModel);
		numPlayers.setFont(new Font("Bodoni 72", Font.PLAIN, 16));
		getContentPane().add(numPlayers, "flowx,cell 1 2,alignx center");
		
		JButton startButton = new JButton("Start Game");
		startButton.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		getContentPane().add(startButton, "cell 1 2,alignx center");
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

}
