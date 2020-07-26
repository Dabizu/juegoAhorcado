import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("hola mundo");
		Ventana ventana=new Ventana();
		ventana.setVisible(true);
	}

}

class Ventana extends JFrame
{
	private JButton boton;
	private JPanel panel;
	private JTextField texto;
	public Ventana()
	{
		super("juego del ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		panel=new JPanel();
		boton=new JButton("boton");
		boton.addActionListener(new Accion());
		texto=new JTextField(15);
		panel.add(new JLabel("dame palabra a adivinar:"));
		panel.add(texto);
		panel.add(boton);
		add(panel);
	}
	private class Accion implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent evento) {
			// TODO Auto-generated method stub
			if(boton==evento.getSource())
			{
				VentanaJuego ventanaJuego=new VentanaJuego(texto.getText());
				ventanaJuego.setVisible(true);
			}
		}
		
	}

}

class VentanaJuego extends JFrame
{
	private JPanel panel;
	private JTextArea areaTexto;
	private JButton botonPredictivo;
	private JTextField insertaTexto;
	private int contador=0;
	private String AuxTexto;
	private JLabel label;
	public VentanaJuego(String dato)
	{
		super("juego");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400,400);
	    panel=new JPanel();
	    areaTexto=new JTextArea(20,20);
	    botonPredictivo=new JButton("respuesta");
	    botonPredictivo.addActionListener(new Accion());
	    insertaTexto=new JTextField(10);
	    label=new JLabel();
	    panel.add(new JLabel(""));
	    panel.add(areaTexto);
	    panel.add(botonPredictivo);
	    panel.add(insertaTexto);
	    panel.add(label);
	    add(panel);
	    AuxTexto=dato;
	    System.out.println("dato: "+dato);
	    System.out.println("auxtexto: "+AuxTexto);
		String cadena="_";
		int tama=dato.length();
		for(int i=0;i<tama;i++)
		{
			cadena=cadena+cadena;
		}
		System.out.println("cadena: "+cadena);
		label.setText(cadena);
	}
	private class Accion implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(botonPredictivo==e.getSource())
			{
				busca(AuxTexto,insertaTexto.getText());
				//areaTexto.setText(monitos());
			}
		}
		
	}
	public void busca(String textoInsertado,String texto)
	{
		System.out.println("texto: "+texto);
		int tamanio=textoInsertado.length();
		System.out.println("tamanio: "+tamanio);
		char c = 0;
		int v=0;
		for(int i=0;i<tamanio;i++)
		{
			c=textoInsertado.charAt(i);
			System.out.println(i);
			if(c==texto.charAt(0))
			{
				StringBuilder NuevaCadena=new StringBuilder(label.getText());
				char ch=texto.charAt(0);
				NuevaCadena.setCharAt(i, ch);
				label.setText(NuevaCadena.toString());
				v=1;
			}
		}
		if(v==0)
		{
			areaTexto.setText(monitos(contador));
			contador++;
			v=0;
		}
	}
	public String monitos(int cont)
	{
		String mono;
		if(cont==0)
		{
			return mono="....\n"+
		         "|  |\n"+
		         "|  o\n"+
		         "|   \n"+
		         "|   \n"+
		         "|   \n"+
		         "------";
		}
		if(cont==1)
		{
			return mono="....\n"+
			     "|  |\n"+
			     "|  o\n"+
			     "| / \n"+
			     "|   \n"+
			     "|   \n"+
			     "------";
		}
		if(cont==2)
		{
			return mono="....\n"+
			     "|  |\n"+
				 "|  o\n"+
				 "| /| "+"\n"+
				 "|   \n"+
				 "|   \n"+
				 "------";
		}
		if(cont==3)
		{
			return mono="....\n"+
			     "|  |\n"+
			     "|  o\n"+
	             "| /|\\ "+"\n"+
			     "|   \n"+
		         "|   \n"+
			     "------";
		}
		if(cont==4)
		{
			return mono="....\n"+
			     "|  |\n"+
			     "|  o\n"+
			     "| /|\\"+"\n"+
			     "| /  \n"+
			     "|   \n"+
			     "------";
		}
		if(cont==5)
		{
			return mono="....\n"+
				 "|  |\n"+
				 "|  o\n"+
				 "| /|\\"+"\n"+
				 "| / \\"+"\n"+
				 "|   \n"+
				 "------";
		}
		return null;
	}
}