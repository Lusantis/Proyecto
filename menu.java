package EjercicioVentanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class menu extends JFrame {
	private static final String Arial = null;
	public ArrayList<Objeto> listaObjeto = new ArrayList<>();

	public menu() {
		System.out.println("menu");
		this.setLayout(new GridLayout(1, 2));
		this.setTitle("Ventana");
		this.setSize(1368, 769);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		ImageIcon ico = new ImageIcon("salir.png");
		Image imagenEscalada = ico.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
		JButton añadir = new JButton("Añadir Objeto");
		añadir.setFont(new Font(Arial, Font.PLAIN, 40));
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadir crear = new añadir();
				crear.setVisible(true);
				setVisible(false);
			}
		});
		JButton eliminar = new JButton("Eliminar Objeto");
		eliminar.setFont(new Font(Arial, Font.PLAIN, 40));
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				eliminar eliminar = new eliminar();
				eliminar.setVisible(true);
				setVisible(false);

			}
		});
		JButton cerrar = new JButton("Cerrar Sesión");
		cerrar.setFont(new Font(Arial, Font.PLAIN, 40));
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar sesión?") == 0) {
					dosven volver = new dosven();
					volver.setVisible(true);
					setVisible(false);
				}
			}
		});
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel32 = new JPanel();
		JPanel panel31 = new JPanel();
		panel32.setLayout(new GridLayout(3, 1));
		panel3.setLayout(new GridLayout(2, 1));
		String[] columnas = { "NRO", "OBJETO", "lugar encontrado", "lugar guardado", "¿es valioso?" };
		DefaultTableModel model = new DefaultTableModel(columnas, 0);
		JTable tabla = new JTable(model);
		JScrollPane scrollpanel = new JScrollPane(tabla);
		JTableHeader header = tabla.getTableHeader();
		scrollpanel.getViewport().setBackground(new Color(235, 216, 70));
		header.setFont(new Font(Arial, Font.PLAIN, 20));
		header.setBackground(new Color(235, 216, 70));
		header.setForeground(new Color(85, 65, 35));
		tabla.setBackground(new Color(235, 216, 70));
		tabla.setForeground(new Color(85, 65, 35));
		tabla.setFont(new Font(Arial, Font.PLAIN, 20));
		JPanel esquina = new JPanel();
		esquina.setBackground(new Color(235, 216, 70));
		scrollpanel.setCorner(JScrollPane.UPPER_RIGHT_CORNER, esquina);
		panel2.setLayout(null);
		JButton salir = new JButton();
		salir.setIcon(iconoFinal);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar sesión?") == 0) {
					dosven volver = new dosven();
					volver.setVisible(true);
					setVisible(false);
				}
			}
		});
		añadir.setBackground(new Color(235, 216, 70));
		añadir.setForeground(new Color(85, 65, 35));
		eliminar.setBackground(new Color(235, 216, 70));
		eliminar.setForeground(new Color(85, 65, 35));
		cerrar.setBackground(new Color(235, 216, 70));
		cerrar.setForeground(new Color(85, 65, 35));
		scrollpanel.setBounds(1, 200, 650, 525);
		panel2.setBackground(new Color(142, 160, 90));
		panel31.setBackground(new Color(142, 160, 90));
		salir.setBounds(100, 1, 100, 90);
		ImageIcon imagen1 = new ImageIcon("descargar.png");
		JLabel containima1 = new JLabel(imagen1);
		containima1.setBounds(1000, 1, 500, 400);
		panel32.add(añadir);
		panel32.add(eliminar);
		panel32.add(cerrar);
		panel31.add(containima1);
		panel3.add(panel31);
		panel3.add(panel32);
		panel2.add(salir);
		panel2.add(scrollpanel);
		this.add(panel2);
		this.add(panel3);

	}

	public void actualizarObjeto(DefaultTableModel modelo, ArrayList<Objeto> listaObjetos) {
		System.out.println("entro");
		for (Objeto o : listaObjetos) {
			Object[] fila = { o.getNombre(), o.getLugarseencontro(), o.getLugarguardado(), o.isValioso() };
			modelo.addRow(fila);
		}
	}
}