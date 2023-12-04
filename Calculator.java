import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionsButtons = new JButton[10];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton,delButton, clrButton, negButton, sqrtButton;
	JPanel panel;

	Font myFont = new Font("Garamond",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		//textfield.setCaretColor(Color.WHITE);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("←");
		clrButton = new JButton("C");
		negButton = new JButton("+-");
		sqrtButton = new JButton("√");
		
		functionsButtons[0] = addButton;
		functionsButtons[1] = subButton;
		functionsButtons[2] = mulButton;
		functionsButtons[3] = divButton;
		functionsButtons[4] = decButton;
		functionsButtons[5] = equButton;
		functionsButtons[6] = delButton;
		functionsButtons[7] = clrButton;
		functionsButtons[8] = negButton;
		functionsButtons[9] = sqrtButton;
		
		for (int i = 0; i<10;i++) {
			functionsButtons[i].addActionListener(this);
			functionsButtons[i].setFont(myFont);
			functionsButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		/*
		negButton.setBounds(50,430,75,75);
		delButton.setBounds(100,430,75,75);
		clrButton.setBounds(200,430,75,75);
		sqrtButton.setBounds(300,430,75,75);
		*/
		
		panel = new JPanel();
		panel.setBounds(50,100,300,300);
		panel.setLayout(new GridLayout(5,4,10,10));
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(divButton);
		
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(mulButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(subButton);
		
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(addButton);
		
		panel.add(negButton);
		panel.add(delButton);
		panel.add(clrButton);
		panel.add(sqrtButton);
		
		/*
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(sqrtButton);
		*/
		
		frame.add(textfield);
		
		frame.add(panel);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i =0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");			
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");			
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");			
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");			
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clrButton) {
			textfield.setText("");			
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
		if(e.getSource() == sqrtButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp = Math.sqrt(temp);
			textfield.setText(String.valueOf(temp));
		}
	}

}
