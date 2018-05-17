package Pricipal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Visual {

	private JFrame frame;
	private JLabel lblBarra;
	private JLabel lblPonteiro;
	
	private int posPonteiro = 65;
	private boolean statusPonteiro = false;
	public boolean irOuVirPonteiro = true;
	public int chanceDeAcerto = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual window = new Visual();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Visual() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == e.VK_SPACE) {
					statusPonteiro = true;
					moverPosicaoPonteiro();
				}
				if (e.getKeyCode() == e.VK_SHIFT) {
					statusPonteiro = false;
					moverPosicaoPonteiro();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == e.VK_SPACE) {
					chanceDeAcerto = (posPonteiro-65)/3;
					//System.out.println(chanceDeAcerto);
					verificarAcerto();
					statusPonteiro = false;
					moverPosicaoPonteiro();
				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblPonteiro = new JLabel("");
		lblPonteiro.setIcon(new ImageIcon("G:\\ArremecoBasca\\Ponteiro.png"));
		lblPonteiro.setBounds(posPonteiro, 220, 15, 30);
		frame.getContentPane().add(lblPonteiro);
		
		lblBarra = new JLabel("");
		lblBarra.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblBarra.setIcon(new ImageIcon("G:\\ArremecoBasca\\Barra.jpg"));
		lblBarra.setBounds(70, 225, 300, 20);
		frame.getContentPane().add(lblBarra);
	}
	
	public void moverPosicaoPonteiro() {
		if (statusPonteiro == true) {
			if (irOuVirPonteiro == true) {
				posPonteiro += 21;
				if (posPonteiro >= 365) {
					irOuVirPonteiro = false;
				}
			}
			if (irOuVirPonteiro == false) {
				posPonteiro -= 21;
				if (posPonteiro <= 65) {
					irOuVirPonteiro = true;
				}
			}
			lblPonteiro.setBounds(posPonteiro, 220, 15, 30);
		}
		
		if (statusPonteiro == false) {
			posPonteiro = 65;
			lblPonteiro.setBounds(posPonteiro, 220, 15, 30);
		}
	}

	
	public void verificarAcerto() {
		int chanceSorteada;
		Random numeroAleatorio = new Random();
		chanceSorteada = numeroAleatorio.nextInt(101);
		
		if (chanceDeAcerto < 25) {
			if (chanceSorteada <= 25) {
				System.out.println("Tijolada convertida!");
			}else {
				System.out.println("Air ball!");
			}
		}
		if (chanceDeAcerto >= 25 && chanceDeAcerto < 50) {
			if (chanceSorteada <= 50) {
				System.out.println("Granada convertido!");
			}else {
				System.out.println("Air ball!");
			}
		}
		if (chanceDeAcerto >= 50 && chanceDeAcerto < 75) {
			if (chanceSorteada <= 75) {
				System.out.println("Arremesso convertido!");
			}else {
				System.out.println("Errou o arremesso!");
			}
		}
		if (chanceDeAcerto >= 75 && chanceDeAcerto < 85) {
			if (chanceSorteada <= 85) {
				System.out.println("Arremesso convertido!");
			}else {
				System.out.println("Errou o arremesso!");
			}
		}
		if (chanceDeAcerto >= 85 && chanceDeAcerto < 90) {
			if (chanceSorteada <= 90) {
				System.out.println("Chuá!");
			}else {
				System.out.println("Chorou mas não caiu!");
			}
		}
		if (chanceDeAcerto >= 95 && chanceDeAcerto <= 100) {
				System.out.println("CHUÁÁÁ!");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
