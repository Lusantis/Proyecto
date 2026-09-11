package EjercicioVentanas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class añadir extends JFrame {
	private static final String Arial = null;
	usuario ar[];
	comprobar as[];

	public añadir() {

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
			public void actionPerformed(ActionEvent a) {
				menu volver = new menu();
				volver.setVisible(true);
				setVisible(false);

			}
		});
		salir.setBounds(100, 1, 100, 90);
		JLabel ini = new JLabel("Añadir Objeto");
		ini.setForeground(new Color(85, 65, 35));
		ini.setFont(new Font(Arial, Font.PLAIN, 30));
		ini.setBounds(600, 150, 200, 100);
		panel1.setLayout(new GridLayout(4, 2));
		JLabel nom = new JLabel("Nombre");
		nom.setForeground(new Color(85, 65, 35));
		nom.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res1 = new JTextField();
		res1.setFont(new Font(Arial, Font.PLAIN, 40));
		res1.setForeground(new Color(85, 65, 35));
		JLabel ced = new JLabel("Lugar encontrado");
		ced.setForeground(new Color(85, 65, 35));
		ced.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res3 = new JTextField();
		res3.setFont(new Font(Arial, Font.PLAIN, 40));
		res3.setForeground(new Color(85, 65, 35));
		JLabel lug = new JLabel("Lugar guardado");
		lug.setForeground(new Color(85, 65, 35));
		lug.setFont(new Font(Arial, Font.PLAIN, 40));
		ced.setForeground(new Color(85, 65, 35));
		JTextField res4 = new JTextField();
		res4.setFont(new Font(Arial, Font.PLAIN, 40));
		res4.setForeground(new Color(85, 65, 35));
		JLabel val = new JLabel("¿Es valioso?");
		val.setForeground(new Color(85, 65, 35));
		val.setFont(new Font(Arial, Font.PLAIN, 40));
		String valo[] = { "SI", "NO" };
		JComboBox valor = new JComboBox(valo);
		valor.setFont(new Font(Arial, Font.PLAIN, 40));
		valor.setForeground(new Color(85, 65, 35));
		JButton boton = new JButton("Guardar");
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
			public void actionPerformed(ActionEvent e) {
				menu menu = new menu();
				String nombre;
				menu.setVisible(true);
				setVisible(false);
				if (res1.getText().length() != 0 && res3.getText().length() != 0) {
					nombre = res1.getText();
					String lugar = res3.getText();
					String pre = (String) valor.getSelectedItem();

					// if (registro(as, ar, nombre, cedula)) {

					// } else {
					// System.out.println("falla al autenticar");
					// }

				} else {
					// System.out.println("hay campos vacios");

				}

			}
		});
		panel1.setBackground(new Color(142, 160, 90));
		panel2.setBackground(new Color(142, 160, 90));
		boton.setBackground(new Color(235, 216, 70));
		boton.setForeground(new Color(85, 65, 35));
		panel1.add(nom);
		panel1.add(res1);
		panel1.add(ced);
		panel1.add(res3);
		panel1.add(lug);
		panel1.add(res4);
		panel1.add(val);
		panel1.add(valor);
		panel2.add(salir);
		panel2.add(containima1);

		panel2.add(ini);

		panel3.add(panel2);
		panel3.add(panel1);
		this.add(panel3);
		this.add(boton, BorderLayout.SOUTH);

	}

	public boolean registro(comprobar asd[], usuario ar[], String nombre, int cedula) {
		boolean registro = false;

		asd[1] = new comprobar(nombre, cedula);
		for (int i = 0; i < ar.length; i++) {
			if (asd[1].equals(ar[i])) {
				registro = true;
			}
		}
		return registro;
	}
}
