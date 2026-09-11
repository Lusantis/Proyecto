package EjercicioVentanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class borrar extends JFrame {

	private static final String Arial = null;
	usuario ar[];
	comprobar asd[];

	public borrar() {
		// usuario usu[]=new usuario[5];//
		this.setLayout(new BorderLayout());
		this.setTitle("Ventana");
		this.setSize(1368, 768);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		ImageIcon imagen1 = new ImageIcon("descargar.png");
		ImageIcon ico = new ImageIcon("salir.png");
		Image imagenEscalada = ico.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
		JLabel containima1 = new JLabel(imagen1);
		containima1.setBounds(1000, 1, 500, 400);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2, 1));
		panel2.setLayout(null);
		JButton salir = new JButton();
		salir.setIcon(iconoFinal);
		salir.setFont(new Font(Arial, Font.PLAIN, 40));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent r) {
				dosven volve = new dosven();
				volve.setVisible(true);
				setVisible(false);

			}
		});
		JLabel relleno = new JLabel("");
		JLabel relleno2 = new JLabel("");
		salir.setBounds(100, 1, 100, 90);
		JLabel ini = new JLabel("Borrar Usuario");
		ini.setForeground(new Color(85, 65, 35));
		ini.setFont(new Font(Arial, Font.PLAIN, 30));
		ini.setBounds(600, 150, 200, 100);
		panel1.setLayout(new GridLayout(3, 2));
		JLabel nom = new JLabel("Nombre");
		nom.setForeground(new Color(85, 65, 35));
		nom.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res1 = new JTextField();
		res1.setFont(new Font(Arial, Font.PLAIN, 40));
		res1.setForeground(new Color(85, 65, 35));
		JLabel ced = new JLabel("Cédula");
		ced.setForeground(new Color(85, 65, 35));
		ced.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res3 = new JTextField();
		res3.setFont(new Font(Arial, Font.PLAIN, 40));
		res3.setForeground(new Color(85, 65, 35));
		JButton boton = new JButton("Borrar");
		boton.setFont(new Font(Arial, Font.PLAIN, 40));
		boton.addActionListener(new ActionListener() {
			/*
			 * public void actionPerformed(ActionEvent a) { String usuario=res1.getText();
			 * String cedula2=res3.getText();
			 * 
			 * if ((usuario.equals("santiago"))&&(cedula2.equals("12345"))) { dosven ven=new
			 * dosven(); ven.setVisible(true); setVisible(false); }else {
			 * JOptionPane.showMessageDialog(null, "Error, datos incorrectos"); } }
			 */
			public void actionPerformed(ActionEvent a) {
				usuario[] usu = new usuario[5];
				String nombre;
				if (res1.getText().length() != 0 && res3.getText().length() != 0) {
					nombre = res1.getText();
					String cedula2 = res3.getText();
					int cedula = Integer.parseInt(cedula2);
					borrar(asd, usu, nombre, cedula);
					// if (registro(nombre, cedula)) {

					// } else {
					// System.out.println("falla al registrar");
					// }
				} else {
					System.out.println("Hay campos vacios");

				}

			}
		});
		panel1.setBackground(new Color(142, 160, 90));
		panel2.setBackground(new Color(142, 160, 90));
		boton.setBackground(new Color(235, 216, 70));
		boton.setForeground(new Color(85, 65, 35));
		panel1.add(nom);
		panel1.add(res1);
		panel1.add(relleno);
		panel1.add(relleno2);
		panel1.add(ced);
		panel1.add(res3);
		panel2.add(salir);
		panel2.add(ini);
		panel3.add(panel2);
		panel3.add(panel1);
		panel2.add(containima1);
		this.add(panel3);
		// this.add(panel2,BorderLayout.NORTH);
		// this.add(panel1, BorderLayout.CENTER);
		this.add(boton, BorderLayout.SOUTH);

	}

	public static void borrar(comprobar asd[], usuario ar[], String nombre, int cedula) {
		asd[1] = new comprobar(nombre, cedula);
		for (int i = 0; i < ar.length; i++) {
			if (asd[1].equals(ar[i])) {
				ar[i].setNombre(null);
				ar[i].setCedula(0);
			}
			System.out.println(ar[i]);
		}
	}
}
