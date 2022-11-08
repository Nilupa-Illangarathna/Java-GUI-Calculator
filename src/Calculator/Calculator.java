package Calculator;

//Importing required packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Basic calculator functions and trigonometric functions are performed within this class
public class Calculator implements ActionListener {

    //creating requirments  for the GUI
    JFrame frame;
    JTextField textfield;

    //Creating required buttons to work with
    JButton[] numberButtons = new JButton[11];
    JButton[] functionButtons = new JButton[16];

    //Creating button objects under understandable names
    JButton addButton,subButton,mulButton,divButton, decButton, equButton, delButton, clrButton, negButton, remButton;
    JButton sinButton, cosineButton, tangentButton, sinInversButton, cosineInversButton, tanInverseButton;
    JPanel panel;

    //Creating a font with formatting for display purposes
    Font myFont = new Font("Arial",Font.BOLD,25);

    //Value storing variables
    double num1=0,num2=0,result=0;
    String output="";
    char operator;


    Calculator(){
        //Creating GUI interface
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(620, 600);
        frame.setLayout(null);

        //Defining textfield properties
        textfield = new JTextField();
        textfield.setBounds(50, 50, 500, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.white);

        //Giving labels for buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("clear");
        negButton = new JButton("(-)");
        remButton = new JButton("%");
        sinButton = new JButton("sin");
        cosineButton= new JButton("cos");
        tangentButton= new JButton("tan");
        sinInversButton= new JButton("asin");
        cosineInversButton= new JButton("acos");
        tanInverseButton= new JButton("atan");

        //Giving labels for buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = remButton;
        functionButtons[10] = sinButton;
        functionButtons[11] = cosineButton;
        functionButtons[12] = tangentButton;
        functionButtons[13] = sinInversButton;
        functionButtons[14] = cosineInversButton;
        functionButtons[15] = tanInverseButton;

        //Assigning properties for function buttons
        for(int i =0;i<16;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBounds(50,430,200,50);
        }

        //Assigning properties for number buttons
        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        //Equal button is dufferent in dimentions. These properties are used
        equButton.setBounds(50,480,500,50);


        //Creating a panel area to add buttons
        panel = new JPanel();
        panel.setBounds(50, 150, 500, 300);
        panel.setLayout(new GridLayout(5,4,10,10));

        //Adding buttons in the correct order
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(sinButton);           ///////
        panel.add(sinInversButton);     ///////
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(cosineButton);        ///////
        panel.add(cosineInversButton);  ///////
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(tangentButton);       ///////
        panel.add(tanInverseButton);    ///////
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(remButton);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(negButton);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(divButton);
        panel.add(mulButton);
        frame.add(panel);
        frame.add(equButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Getting number inputs
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        //Getting other inputs
        if(e.getSource()==decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='-';
            textfield.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='*';
            textfield.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='/';
            textfield.setText("");
        }
        if(e.getSource()==remButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='%';
            textfield.setText("");
        }

        //For Trigonometric functions
        if(e.getSource()==sinButton) {
            num1 = Double.parseDouble(textfield.getText());

            if(num1%180 == 0)
            {
                output ="sin(" + String.valueOf(num1) + ")" + " = 0";
            }
            else
            {
                result = java.lang.Math.sin(num1*Math.PI/180);
                output = "sin(" + String.valueOf(num1) + ")" + " = " + String.valueOf(result);
            }
            textfield.setText(output);
            num1=0;
            num2=0;
        }
        if(e.getSource()==cosineButton) {
            num1 = Double.parseDouble(textfield.getText());

            if(num1%90 == 0 && num1%180!=0)
            {
                output ="cos(" + String.valueOf(num1) + ")" + " = 0";
            }
            else
            {
                result = java.lang.Math.cos(num1*Math.PI/180);
                output = "cos(" + String.valueOf(num1) + ")" + " = " + String.valueOf(result);
            }
            textfield.setText(output);
            num1=0;
            num2=0;
        }
        if(e.getSource()==tangentButton) {
            num1 = Double.parseDouble(textfield.getText());

            if(num1%180 == 0)
            {
                output ="tan(" + String.valueOf(num1) + ")" + " = 0";
            }
            else if(num1%180 != 0 && num1%90==0)
            {
                output ="tan(" + String.valueOf(num1) + ")" + " is undefined";
            }
            else
            {
                result = java.lang.Math.tan(num1*Math.PI/180);
                output = "tan(" + String.valueOf(num1) + ")" + " = " + String.valueOf(result);
            }
            textfield.setText(output);
            num1=0;
            num2=0;
        }

        //inverse trigonometric
        if(e.getSource()==sinInversButton) {
            num1 = Double.parseDouble(textfield.getText());
            if (num1>1 || num1 <-1) {
                output = "Input " + String.valueOf(num1) + " is in undefined range";
            }
            else
            {
                result = java.lang.Math.asin(num1)*180/Math.PI;
                output = "sin inverse of " + String.valueOf(num1)  + " is = " + String.valueOf(result);
            }
            textfield.setText(output);
            num1=0;
            num2=0;
        }
        if(e.getSource()==cosineInversButton) {
            num1 = Double.parseDouble(textfield.getText());
            if (num1>1 || num1 <-1) {
                output = "Input " + String.valueOf(num1) + " is in undefined range";
            }
            else
            {
                result = java.lang.Math.acos(num1)*180/Math.PI;
                output = "cos inverse of " + String.valueOf(num1)  + " is = " + String.valueOf(result);
            }
            textfield.setText(output);
            num1=0;
            num2=0;
        }
        if(e.getSource()==tanInverseButton) {
            num1 = Double.parseDouble(textfield.getText());
            result = java.lang.Math.atan(num1)*180/Math.PI;
            output = "tan inverse of " + String.valueOf(num1)  + " is = " + String.valueOf(result);
            textfield.setText(output);
            num1=0;
            num2=0;
        }

        //When this button is pressed. output will be printed on the textfield
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textfield.getText());

            switch(operator) {
                case'+':
                    result=num1+num2;
                    output = String.valueOf(num1) + " + " + String.valueOf(num2) + " = " + String.valueOf(result);
                    break;
                case'-':
                    result=num1-num2;
                    output = String.valueOf(num1) + " - " + String.valueOf(num2) + " = " + String.valueOf(result);
                    break;
                case'*':
                    result=num1*num2;
                    output = String.valueOf(num1) + " x " + String.valueOf(num2) + " = " + String.valueOf(result);
                    break;
                case'/':
                    //Identifying zero devide by zero error without using exceptions
                    if(num1==0 && num2==0)
                    {
                        output = "Zero divide by zero is undefined";
                    }
                    else if(num1!=0 && num2==0)
                    {
                        output = "Divide by zero is undefined";
                    }
                    else
                    {
                        result=num1/num2;
                        output = String.valueOf(num1) + " / " + String.valueOf(num2) + " = " + String.valueOf(result);
                    }
                    break;
                case'%':
                    result=num1%num2;
                    output = String.valueOf(num1) + " % " + String.valueOf(num2) + " = " + String.valueOf(result);
                    break;
            }
            textfield.setText(String.valueOf(output));
            num1=0;
            num2=0;
        }
        if(e.getSource()==clrButton) {
            textfield.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }

        //entering negative sign befor the numbers. This should be added after the number is entered.
        //Ex, If we want to input -9 to the textfield, first 9 should be entered and then (-) should be clicked
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}
