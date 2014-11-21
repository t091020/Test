import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

/**
 * @author Tan Nguyen T091020
 * 
 */
public class c2 extends JFrame {
	private static JButton btnComputer = new JButton("Brown"),
			btnClear = new JButton("Clear"), btnClearAll = new JButton(
					"Clear All");
	private static JLabel lblNumber1 = new JLabel("File ");

	private static JTextField txtNumber1 = new JTextField();

	private static JTextArea txtAreaResult = new JTextArea();
	private static JScrollPane scrollPaneResult = new JScrollPane(txtAreaResult);

	public c2() {
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

		btnComputer.setBounds(iX, lblNumber1.getY() + iHeight + iRow,
				iWidthBTN, iHeight);
		btnClear.setBounds(btnComputer.getX() + iWidthBTN + iCol,
				btnComputer.getY(), iWidthBTN, iHeight);
		btnClearAll.setBounds(btnClear.getX() + iWidthBTN + iCol,
				btnComputer.getY(), iWidthBTN, iHeight);

		scrollPaneResult.setBounds(iX, btnComputer.getY() + iHeight + iRow,
				getWidth() - iX - 20, 90);
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
					JFileChooser model = new JFileChooser();
					int iFile = model.showOpenDialog(null);
					if (iFile == JFileChooser.APPROVE_OPTION) {
						File file = model.getSelectedFile();
						try {
							Scanner scaner = new Scanner(file);
							txtNumber1.setText(file.getAbsolutePath());
							String string = (String) scaner.nextLine();
							txtAreaResult.append(computer(string));
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							txtAreaResult.append("File Not Found Exception\n");
						}
					}// if btn Computer
				}// if else
			}// method
		};// action

		btnComputer.addActionListener(action);
		btnClear.addActionListener(action);
		btnClearAll.addActionListener(action);
	}// end construct

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		c2 win = new c2();
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);
		win.setVisible(true);
	}// end main

	/**
	 * Max of array
	 * 
	 * @param array
	 * @return max
	 */
	public static double getMaxArray(double[] array) {
		int endFor = array.length;
		double dMax = array[0];
		for (int i = 1; i < endFor; i++) {
			if (array[i] > dMax)
				dMax = array[i];
		}// for
		return dMax;
	}// method

	/**
	 * Min of array
	 * 
	 * @param array
	 * @return
	 */
	public static double getMinArray(double[] array) {
		int endFor = array.length;
		double dMin = array[0];
		for (int i = 1; i < endFor; i++) {
			if (array[i] < dMin)
				dMin = array[i];
		}// for
		return dMin;
	}// method

	public static String computer(String str) {
		String[] array = str.split(" ");
		String sResult = "";
		int endFor = array.length;
		for (int i = 0; i < endFor; i++) {
			if (!isStringIsDoubleNumber(array[i]))
				return "Input Error";
		}// end for
		double[] dArray = getArrayNumberDouble(array);
		sResult += "Max: " + getMaxArray(dArray) + "\n";
		sResult += "Min: " + getMinArray(dArray) + "\n";
		return sResult;
	}// method

	/**
	 * Get array integer to Number of string
	 * 
	 * @param str
	 * @return
	 */
	public static double[] getArrayNumberDouble(String[] strArray) {
		double[] arrayNumber = new double[strArray.length];
		int endFor = strArray.length;
		for (int i = 0; i < endFor; i++) {
			arrayNumber[i] = Double.parseDouble(strArray[i]);
		}// for
		return arrayNumber;
	}// method

	/**
	 * Test String is double number
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isStringIsDoubleNumber(String str) {
		int endFor = str.length() - 1;
		for (int i = 0; i <= endFor; i++) {
			if (!isStringHaveInString("0123456789.", str.substring(i, i + 1)))
				return false;
		}// for
		int iPoint = 0;
		for (int i = 0; i <= endFor; i++) {
			if (str.substring(i, i + 1).equals(".")) {
				iPoint++;
			}
		}
		if (iPoint <= 1)
			return true;
		else
			return false;
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
