 
import java.awt.Dimension; //controls-label textfields, button
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image; //useful for layouts
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author wrl123u
 */
public class LilCeasarLogin extends JFrame {

	public LilCeasarLogin() {

		super("LIL CEASAR LOGIN");
		setSize(300, 300);
		setLayout(new GridLayout(6, 2));
		setLocationRelativeTo(null); // centers window

		// SET UP CONTROLS
		JLabel lblUsername = new JLabel("Username", JLabel.LEFT);
		JLabel lblPassword = new JLabel("Password", JLabel.LEFT);
		JLabel lblStatus = new JLabel(" ", JLabel.CENTER);
		JLabel lblSpacer = new JLabel(" ", JLabel.CENTER);
		JLabel lblImg = // rescale image
				new JLabel(new ImageIcon(
						new ImageIcon("logo.png").getImage().getScaledInstance(100, 89, Image.SCALE_DEFAULT)));

		JTextField txtUname = new JTextField(10);
		JPasswordField txtPassword = new JPasswordField();

		JButton btn = new JButton("Submit"), btnExit = new JButton("Exit");
		// add font styles
		Font font1 = new Font("SansSerif", Font.BOLD, 18);

		txtUname.setFont(font1);
		txtPassword.setFont(font1);
		btn.setFont(font1);
		lblUsername.setFont(font1);
		lblPassword.setFont(font1);
		lblStatus.setFont(font1);
		btnExit.setFont(font1);

		// ADD OBJECTS TO FRAME
		JLabel l = new JLabel();
		add(l);
		getContentPane().add(lblImg);
		setPreferredSize(new Dimension(16 * 28, 5 * 92)); // set width , height params
		pack(); // set frame sizing option
		add(l);
		add(lblUsername); // 1st row
		add(txtUname);
		add(lblPassword); // 2nd row
		add(txtPassword);
		add(btn); // 3rd row
		add(btnExit);
		add(lblStatus); // 4th row
		add(lblSpacer); // w. filler

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				// read in csv file and grab 1st col (username)
				// and 2nd col (password) and check those values
				// and verify those credentials against the textfield
				// entries as below
				// new Main();
				File fin = new File("users.csv");
				Scanner scan = null;
				try {
					scan = new Scanner(fin);

					// read the column headings from the flat text file

					while (scan.hasNext()) { // cycle thru data , verify users , print data

						String[] list = scan.nextLine().split(","); // read in line from file
						String user = list[0];
						String passw = list[1];
						System.out.println("User: " + user + " Password: " + passw);
						if (user.equals(txtUname.getText()) && passw.equals(txtPassword.getText())) {
							System.out.println("User Found");
							new Main();
							break;
						} else
							lblStatus.setText("Try again!");

					}

					/*
					 * if (txtUname.getText().equals("admin") &&
					 * txtPassword.getText().equals("admin1")) {
					 * lblStatus.setText("You are logged in"); new Main(txtUname.getText()); } else
					 * { lblStatus.setText("Try again!"); }
					 */

				} catch (FileNotFoundException ex) {
					Logger.getLogger(LilCeasarLogin.class.getName()).log(Level.SEVERE, null, ex);
				}

			}

		});

		btnExit.addActionListener(e -> System.exit(0));
		setLocationRelativeTo(null); // centers window
		setResizable(false); // dont resize window
		setVisible(true); // SHOW THE FRAME

	}

	public static void main(String[] args) {

		new LilCeasarLogin();
	}

}
