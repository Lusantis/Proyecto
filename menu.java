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
	Gestor gestor = new Gestor();

	public menu() {
		this.setLayout(new BorderLayout());
		this.setTitle("Ventana");
		this.setSize(1368, 769);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		JLabel menu = new JLabel("Menú Principal");
		menu.setFont(new Font(Arial, Font.PLAIN, 40));
		menu.setBackground(new Color(235, 216, 70));
		menu.setForeground(new Color(85, 65, 35));
		ImageIcon ico = new ImageIcon("salir.png");
		Image imagenEscalada = ico.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
		ImageIcon iconoFinal = new ImageIcon(imagenEscalada);
		JButton añadir = new JButton("Añadir Objeto");
		añadir.setFont(new Font(Arial, Font.PLAIN, 40));
		JButton eliminar = new JButton("Eliminar Objeto");
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
		String[] columnas = { "ID Objeto", "Objeto", "Lugar Encontrado", "Lugar Guardado", "¿Es Valioso?" };
		DefaultTableModel model = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if (gestor.listarObjetos(model)) {
			System.out.println("Ejecutó listar");
		} else {
			System.out.println("Error en Menu");
		}

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
		model.isCellEditable(model.getRowCount(), model.getColumnCount());
		panel2.setLayout(null);
		tabla.getTableHeader().setReorderingAllowed(false);
		JButton salir = new JButton();
		salir.setIcon(iconoFinal);
		eliminar.setFont(new Font(Arial, Font.PLAIN, 40));
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres ELIMINAR este objeto?") == 0) {
					int fila = tabla.getSelectedRow();
					if (fila >= 0) {
						Object valor = model.getValueAt(fila, 0);
						if (gestor.bajaObjeto(valor)) {
							JOptionPane.showMessageDialog(null, "Objeto eliminado exitosamente");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Debes seleccionar un objeto para eliminarlo");
					}
					gestor.listarObjetos(model);
				}
			}
		});
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cerrar sesión?") == 0) {
					dosven volver = new dosven();
					volver.setVisible(true);
					setVisible(false);
				}
			}
		});
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadir crear = new añadir(model);
				crear.setVisible(true);
				dispose();
			}
		});

		añadir.setBackground(new Color(235, 216, 70));
		añadir.setForeground(new Color(85, 65, 35));
		eliminar.setBackground(new Color(235, 216, 70));
		eliminar.setForeground(new Color(85, 65, 35));
		cerrar.setBackground(new Color(235, 216, 70));
		cerrar.setForeground(new Color(85, 65, 35));
		scrollpanel.setBounds(1, 250, 1000, 600);
		panel2.setBackground(new Color(142, 160, 90));
		panel31.setBackground(new Color(142, 160, 90));
		salir.setBounds(100, 1, 100, 90);
		ImageIcon imagen1 = new ImageIcon("descargar.png");
		JLabel containima1 = new JLabel(imagen1);
		añadir.setBounds(1000, 450, 400, 100);
		eliminar.setBounds(1000, 550, 400, 100);
		cerrar.setBounds(1000, 650, 400, 100);
		containima1.setBounds(1000, -100, 500, 400);
		menu.setBounds(500, 100, 500, 100);
		panel2.add(menu);
		panel2.add(añadir);
		panel2.add(eliminar);
		panel2.add(cerrar);
		panel2.add(containima1);
		panel3.add(panel31);
		panel3.add(panel32);
		panel2.add(salir);
		panel2.add(scrollpanel);
		this.add(panel2);
		// this.add(panel3);

	}
}