package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

import Controler.Logica;
import Controler.Registro;
import CriadorFases.Calculo;
import Model.Sons;
import Model.Usuario;

public class TelaSecundaria extends JFrame {

	private JPanel status;

	
	private CargaImg carga = new CargaImg();
	private ArrayList<JLabel> labelsCont = new ArrayList<JLabel>();
	private int [] array = new int[10];
	private Logica log  = new Logica();
	private Usuario user = new Usuario();
	private Sons som = new Sons();
	Registro r  = new Registro();
	private int operacao = 0,numero = 0;
	ArrayList<Calculo> calculo  = new ArrayList<Calculo>();
	String frutas = "";
	
	public TelaSecundaria(int nivel,Usuario user){
		
		super (" Somando ");

	
		if(nivel == 0){
			operacao = 11;
			calculo = log.GerarSubtracao();
			frutas = "Limao";
		
		}
		if(nivel == 1){
			operacao = 10;
			calculo = log.GerarSomas();
			frutas = "Uva";
		
		}else if(nivel==2){
			operacao = 11;
			calculo = log.GerarSubtracao();
			frutas = "Banana";
		}else if (nivel == 3){
			operacao = 10;
			calculo = log.GerarSomas();
			frutas = "Maca";
			
		}
		
		
		setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("BackgUm.png"))));
		setLayout(new FlowLayout());
		setSize(800,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		status = new JPanel();
		status.setSize(800, 100);
		status.setBackground(getForeground().green);
		
		String endereco = "numero2/";
		
		for(int i = 0 ; i<10; i++){
			labelsCont.add(new JLabel(new ImageIcon()));
			carga.CargaNivel(labelsCont.get(i), i);
			

			labelsCont.get(i).setSize(150,150);
			labelsCont.get(i).addMouseListener(new MouseListener() {
				
				public void mouseReleased(java.awt.event.MouseEvent e) {}
				
				public void mousePressed(java.awt.event.MouseEvent e) {}
				
				public void mouseExited(java.awt.event.MouseEvent e) {}
				
				public void mouseEntered(java.awt.event.MouseEvent e) {}
				
				public void mouseClicked(java.awt.event.MouseEvent e) {
					for (int i = 0 ;i<10;i++){
						if(labelsCont.get(i)==e.getSource()){
							som.ClickSom();
							
							new TelaAplic(calculo.get(i).getElemUm(),calculo.get(i).getElemDois(),operacao,frutas,user);
							
						}
					}
					
				}
			});
		
				
			
			add(labelsCont.get(i));
			
		}
		add(status, BorderLayout.EAST);
		setVisible(true);
		
		
		
	}

	

}
