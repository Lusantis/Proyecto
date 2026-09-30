package EjercicioVentanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class crud extends JFrame {
	private static final String Arial = null;
	ArrayList<usuario> listausuario = new ArrayList<>();

	public crud() {
		comprobar[] asd = new comprobar[1];
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
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				dosven volver = new dosven();
				volver.setVisible(true);
				setVisible(false);

			}
		});
		JLabel relleno = new JLabel("");
		JLabel relleno2 = new JLabel("");
		salir.setFont(new Font(Arial, Font.PLAIN, 40));
		salir.setBounds(100, 1, 100, 90);
		JLabel ini = new JLabel("Iniciar Sesión");
		ini.setHorizontalAlignment(SwingConstants.CENTER);
		ini.setForeground(new Color(85, 65, 35));
		ini.setFont(new Font(Arial, Font.PLAIN, 30));
		ini.setBounds(600, 150, 200, 100);
		panel1.setLayout(new GridLayout(3, 2));
		JLabel nom = new JLabel("Nombre");
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setForeground(new Color(85, 65, 35));
		nom.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res1 = new JTextField();
		res1.setFont(new Font(Arial, Font.PLAIN, 40));
		res1.setForeground(new Color(85, 65, 35));
		JLabel ced = new JLabel("Cédula");
		ced.setHorizontalAlignment(SwingConstants.CENTER);
		ced.setForeground(new Color(85, 65, 35));
		ced.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res3 = new JTextField();
		res3.setFont(new Font(Arial, Font.PLAIN, 40));
		res3.setForeground(new Color(85, 65, 35));
		JButton boton = new JButton("Acceder");
		boton.setFont(new Font(Arial, Font.PLAIN, 40));
		boton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				menu menu = new menu();
				menu.setVisible(true);
				setVisible(false);

				/*
				 * if (res1.getText().length() != 0 && res3.getText().length() != 0) { String
				 * nombre; nombre = res1.getText(); String cedula2 = res3.getText(); int cedula
				 * = Integer.parseInt(cedula2);
				 * 
				 * if (registro(asd, nombre, cedula)) { menu.setVisible(true);
				 * setVisible(false); } else { System.out.println("falla al autenticar"); }
				 * 
				 * } else { System.out.println("hay campos vacios");
				 * 
				 * }
				 */
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
		panel2.add(containima1);

		panel2.add(ini);

		panel3.add(panel2);
		panel3.add(panel1);
		this.add(panel3);
		this.add(boton, BorderLayout.SOUTH);

	}

	public boolean registro(comprobar[] asd, String nombre, int cedula) {
		boolean registro = false;
		asd[0] = new comprobar(nombre, cedula);
		for (usuario u : listausuario) {
			if (asd[0].equals(u)) {
				registro = true;
				System.out.println("correcto");
			}
		}
		return registro;
	}
}