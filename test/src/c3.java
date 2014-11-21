import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author Tan Nguyen T091020
 * 
 */
public class c3 extends JFrame {
	private static JButton btnComputer = new JButton("Computer"),
			btnClear = new JButton("Clear"), btnClearAll = new JButton(
					"Clear All");
	private static JLabel lblNumber1 = new JLabel("Number 1");

	private static JTextField txtNumber1 = new JTextField();

	private static JTextArea txtAreaResult = new JTextArea();
	private static JScrollPane scrollPaneResult = new JScrollPane(txtAreaResult);

	public c3() {
		super("Number - T091020");
		setSize(300, 200);
		setLayout(null);

		// add conpoment
		add(lblNumber1);
		add(txtNumber1);

		add(btnComputer);
		add(btnClear);
		add(btnClearAll);

		add(scrollPaneResult);
		// set bounds
		int iX = 5;
		int iY = 5;
		int iWidthBTN = 90;
		int iWidthLBL = 100;
		int iHeight = 25;
		int iRow = 5;
		int iCol = 5;
		int iWidthTXT = getWidth() - iX - iCol - iWidthLBL - 20;

		lblNumber1.setBounds(iX, iY, iWidthLBL, iHeight);
		txtNumber1.setBounds(lblNumber1.getX() + iWidthLBL + iCol,
				lblNumber1.getY(), iWidthTXT, iHeight);

		btnComputer.setBounds(iX, txtNumber1.getY() + iHeight + iRow,
				iWidthBTN, iHeight);
		btnClear.setBounds(btnComputer.getX() + iWidthBTN + iCol,
				btnComputer.getY(), iWidthBTN, iHeight);
		btnClearAll.setBounds(btnClear.getX() + iWidthBTN + iCol,
				btnComputer.getY(), iWidthBTN, iHeight);

		scrollPaneResult.setBounds(iX, btnComputer.getY() + iHeight + iRow,
				getWidth() - iX - 20, 100);
		// TODO Auto-generated constructor stub

		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == btnClear) {
					txtNumber1.setText("");

				} else if (e.getSource() == btnClearAll) {
					txtNumber1.setText("");

					txtAreaResult.setText("");
				} else if (e.getSource() == btnComputer) {
					txtAreaResult.append(function(txtNumber1.getText()));
				}
			}
		};

		btnComputer.addActionListener(action);
		btnClear.addActionListener(action);
		btnClearAll.addActionListener(action);
	}// end construct

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		c3 win = new c3();
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);
		win.setVisible(true);
	}// end main

	public static String function(String sString) {
		if (!isStringIsIntegerNumber(sString)) {
			return "Input Error\n";
		}
		int iN = Integer.parseInt(sString);
		if (iN == 0)
			return "Input Error\n";
		int iFound = 0;
		String sResult = "";
		for (int iA = 1; iA < iN; iA++) {
			for (int iB = 1; iB <= iN - iA; iB++) {
				for (int iC = 1; iC <= iN - iA - iB; iC++) {
					if ((iA + iB + iC) == iN) {
						sResult += iA + "+" + iB + "+" + iC + "\n";
						iFound++;
					}// if else
				}// iC
			}// iB
		}// iA
		sResult += "Found: "+iFound + "\n";
		return sResult;
	}

	/**
	 * Test String is double number
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isStringIsIntegerNumber(String str) {
		int endFor = str.length() - 1;
		for (int i = 0; i <= endFor; i++) {
			if (!isStringHaveInString("0123456789", str.substring(i, i + 1)))
				return false;
		}// for
		return true;
	}

	/**
	 * Is value(once string) find in string
	 * 
	 * @param string
	 * @param value
	 * @return true or false
	 */
	public static boolean isStringHaveInString(String string, String value) {
		int endFor = string.length() - 1;
		for (int i = 0; i <= endFor; i++) {
			if (string.substring(i, i + 1).equals(value))
				return true;
		}// for
		return false;
	}// method

}// end class
