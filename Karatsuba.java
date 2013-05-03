import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;
import java.math.BigInteger.*;
// <applet width="240" height="200" code="Karatsuba"></applet>
public class Karatsuba extends Applet implements ActionListener{
	Label l1,l2;
	TextField t1,t2,t3;
	Button mul;
	int m;
	double b=10.0;//Se escogió base 10
	public Karatsuba(){
		l1=new Label("Ingrese x");
		l2=new Label("Ingrese y");
		t1=new TextField(15);
		t2=new TextField(15);
		t3=new TextField(25);
		mul=new Button("Resultado");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(mul);
		add(t3);
		mul.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		int contx=1, conty=1;
		long num_x=Integer.parseInt(t1.getText());
		long num_y=Integer.parseInt(t2.getText());
		long digx=num_x, digy=num_y;
		//Conteo de dígitos de los números ingresados en X y Y
		while(digx>=10){
			contx++;
			digx=digx/10;
		}
		while(digy>=10){
			conty++;
			digy=digy/10;
		}
		m=Math.min(contx,conty)-1;//potencia de la Base b
		long x1=num_x/((int)Math.pow(b,m));
		long x0=num_x%((int)Math.pow(b,m));
		long y1=num_y/((int)Math.pow(b,m));
		long y0=num_y%((int)Math.pow(b,m));
		double z2=x1*y1;
		double z0=x0*y0;
		double z1=(x1+x0)*(y1+y0)-z2-z0;
		double resultado=z2*Math.pow(b,(2*m))+z1*Math.pow(b,m)+z0;
		t3.setText(""+resultado);
	}
}