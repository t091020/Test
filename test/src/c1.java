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
public class c1 extends JFrame {
	private static JButton btnComputer = new JButton("Brown"),
			btnClear = new JButton("Clear"), btnClearAll = new JButton(
					"Clear All");
	private static JLabel lblNumber1 = new JLabel("File ");

	private static JTextField txtNumber1 = new JTextField();

	private static JTextArea txtAreaResult = new JTextArea();
	private static JScrollPane scrollPaneResult = new JScrollPane(txtAreaResult);

	public c1() {
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
							while (scaner.hasNextLine()) {
								String string = (String) scaner.nextLine();
								txtAreaResult.append(string);
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
		c1 win = new c1();
		win.setDefaultCloseOperation(EXIT_ON_CLOSE);
		win.setVisible(true);
	}// end main

}// end class
