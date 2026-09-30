package EjercicioVentanas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class añadir extends JFrame {
	private static final String Arial = null;
	public ArrayList<Objeto> listaObjeto = new ArrayList<>();

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
		containima1.setBounds(230, 1, 500, 400);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel41 = new JPanel();
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1, 2));
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
		salir.setBounds(50, 1, 100, 90);
		JLabel ini = new JLabel("Añadir Objeto");
		ini.setForeground(new Color(85, 65, 35));
		ini.setFont(new Font(Arial, Font.PLAIN, 30));
		ini.setBounds(100, 150, 200, 100);
		panel1.setLayout(new GridLayout(4, 2));
		JLabel nom = new JLabel("Nombre");
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setForeground(new Color(85, 65, 35));
		nom.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res1 = new JTextField();
		res1.setFont(new Font(Arial, Font.PLAIN, 40));
		res1.setForeground(new Color(85, 65, 35));
		JLabel ced = new JLabel("Lugar donde se encontro");
		ced.setHorizontalAlignment(SwingConstants.CENTER);
		ced.setForeground(new Color(85, 65, 35));
		ced.setFont(new Font(Arial, Font.PLAIN, 40));
		JTextField res3 = new JTextField();
		res3.setFont(new Font(Arial, Font.PLAIN, 40));
		res3.setForeground(new Color(85, 65, 35));
		JLabel lug = new JLabel("Lugar guardado");
		lug.setHorizontalAlignment(SwingConstants.CENTER);
		lug.setForeground(new Color(85, 65, 35));
		lug.setFont(new Font(Arial, Font.PLAIN, 40));
		ced.setForeground(new Color(85, 65, 35));
		JTextField res4 = new JTextField();
		res4.setFont(new Font(Arial, Font.PLAIN, 40));
		res4.setForeground(new Color(85, 65, 35));
		JLabel val = new JLabel("¿Es valioso?");
		val.setHorizontalAlignment(SwingConstants.CENTER);
		val.setForeground(new Color(85, 65, 35));
		val.setFont(new Font(Arial, Font.PLAIN, 40));
		String valo[] = { "SI", "NO" };
		JComboBox valor = new JComboBox(valo);
		valor.setFont(new Font(Arial, Font.PLAIN, 40));
		valor.setForeground(new Color(85, 65, 35));
		JButton boton = new JButton("Guardar");
		boton.setFont(new Font(Arial, Font.PLAIN, 40));
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre;

				if (res1.getText().length() != 0 && res3.getText().length() != 0 && res4.getText().length() != 0) {
					nombre = res1.getText();
					String lugarencontrado = res3.getText();
					String lugarguardado = res4.getText();
					boolean valioso = false;
					if (valor.getSelectedIndex() == 0) {
						valioso = true;
					} else {
						valioso = false;
					}
					altaObjeto(model, nombre, lugarencontrado, lugarguardado, valioso);
					actualizarObjeto(model);

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
		panel4.add(panel3);
		panel41.add(scrollpanel);
		panel4.add(panel41);
		this.add(panel4);
		this.add(boton, BorderLayout.SOUTH);

	}

	public void actualizarObjeto(DefaultTableModel model) {
		model.setRowCount(0);
		for (Objeto o : listaObjeto) {
			Object[] fila = { o.getNombre(), o.getLugarseencontro(), o.getLugarguardado(), o.isValioso() };
			model.addRow(fila);
		}
	}

	public void altaObjeto(DefaultTableModel modelo, String nombre, String lugarseencontro, String lugarguardado,
			boolean valioso) {
		Objeto o = new Objeto(nombre, lugarseencontro, lugarguardado, valioso);
		listaObjeto.add(o);

	}
}
