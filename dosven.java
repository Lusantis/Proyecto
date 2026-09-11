package EjercicioVentanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class dosven extends JFrame {
	private static final String Arial = null;

	public dosven() {
		this.setLayout(new BorderLayout());
		this.setTitle("Ventana");
		this.setSize(1368, 769);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		ImageIcon imagen1 = new ImageIcon("descargar.png");
		JLabel containima1 = new JLabel(imagen1);
		containima1.setBounds(1000, 1, 500, 400);
		JPanel panel1 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel2 = new JPanel();
		panel3.setLayout(new GridLayout(2, 3));
		panel1.setLayout(new GridLayout(2, 1));
		panel2.setLayout(new GridLayout(0, 1));
		JLabel hola = new JLabel("Bienvenido al  Programa");
		hola.setForeground(new Color(85, 65, 35));
		hola.setFont(new Font(Arial, Font.PLAIN, 40));
		JLabel bien = new JLabel("Gestión De Objetos Perdidos");
		bien.setForeground(new Color(85, 65, 35));
		bien.setFont(new Font(Arial, Font.PLAIN, 30));
		JLabel hola2 = new JLabel("");
		JLabel bien2 = new JLabel("");
		JLabel hola3 = new JLabel("");
		JLabel bien3 = new JLabel("");
		panel1.add(hola2);
		panel1.add(hola);
		panel1.add(containima1);
		panel1.add(bien2);
		panel1.add(bien);
		panel1.add(bien3);
		JButton boton = new JButton("Salir");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?") == 0) {
					setVisible(false);
				}
			}
		});
		JButton boton4 = new JButton("Iniciar Sesión");
		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crud crud = new crud();
				crud.setVisible(true);
				setVisible(false);
			}
		});
		JButton boton3 = new JButton("Registrar Usuario");
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				registro regis = new registro();
				regis.setVisible(true);
				setVisible(false);

			}
		});
		JButton boton2 = new JButton("Borrar Usuario");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				borrar borrar = new borrar();
				borrar.setVisible(true);
				setVisible(false);

			}
		});
		boton.setForeground(new Color(85, 65, 35));
		boton2.setForeground(new Color(85, 65, 35));
		boton3.setForeground(new Color(85, 65, 35));
		boton4.setForeground(new Color(85, 65, 35));
		panel1.setBackground(new Color(142, 160, 90));
		boton.setFont(new Font(Arial, Font.PLAIN, 40));
		boton.setBackground(new Color(235, 216, 70));
		boton2.setBackground(new Color(235, 216, 70));
		boton3.setBackground(new Color(235, 216, 70));
		boton4.setBackground(new Color(235, 216, 70));
		boton2.setFont(new Font(Arial, Font.PLAIN, 40));
		boton3.setFont(new Font(Arial, Font.PLAIN, 40));
		boton4.setFont(new Font(Arial, Font.PLAIN, 40));
		panel2.add(boton4);
		panel2.add(boton3);
		panel2.add(boton2);
		panel2.add(boton);
		panel3.add(panel1);
		panel3.add(panel2);
		this.add(panel3);

	}
}
