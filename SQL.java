package EjercicioVentanas;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SQL {
	private final String DB_URL = "jdbc:mysql://localhost:3306/ObjetosPerdidos?useSSL=false";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	public static void main(String[] args) {

	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public boolean actualizarusuario(DefaultTableModel modelo) {
		boolean exitoso = false;
		String sentencia = "SELECT cedula, nombre FROM usuario";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			modelo.setRowCount(0);
			while (rs.next()) {
				int ci = rs.getInt(1);
				String nombre = rs.getString(2);
				Object[] fila = { ci, nombre };
				modelo.addRow(fila);
				exitoso = true;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());
		}
		return exitoso;
	}

	public boolean altaUsuario(int c, String n) {
		boolean exitoso = false;
		String sentencia = "INSERT INTO usuario VALUES (" + c + ", " + "'" + n + "'" + ");";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			exitoso = true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());
		}
		return exitoso;
	}

	public boolean actualizarObjeto(DefaultTableModel modelo) {
		boolean ext = true;
		String sentencia = "SELECT idobjeto, nombre, lugarencontrado, lugarguardado, valioso FROM objeto";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();
			modelo.setRowCount(0);
			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String lugarenc = rs.getString(3);
				String lugarguar = rs.getString(4);
				boolean valor = rs.getBoolean(5);
				Object[] fila = { id, nombre, lugarenc, lugarguar, valor };
				modelo.addRow(fila);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());
			ext = false;
		}
		return ext;
	}

	public void altaObjeto(String n, String lugarencontrado, String lugarguardado, boolean valioso) {
		String sentencia = "INSERT INTO Objeto (nombre,lugarencontrado,lugarguardado,valioso)VALUES (" + "'" + n + "'"
				+ "," + "'" + lugarencontrado + "'" + "," + "'" + lugarguardado + "'" + "," + valioso + ");";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());
		}
	}

	public boolean bajaObjeto(Object valor) {
		boolean verdadero = false;
		String sentencia = "DELETE FROM Objeto WHERE idobjeto= " + valor + ";";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
			verdadero = true;
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());
		}
		return verdadero;
	}

	public boolean login(int ced, String nom) {
		boolean ext = false;
		String sentencia = "SELECT cedula, nombre FROM usuario WHERE cedula=" + ced + " AND " + "nombre=" + "'" + nom
				+ "';";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			ResultSet rs = declaracionSQL.executeQuery();

			if (rs.next()) {
				ext = true;
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());

		}

		return ext;
	}

	public boolean borrarusuario(int ced, String nom) {
		boolean ext = true;
		String sentencia = "DELETE FROM usuario WHERE cedula= " + ced + " AND " + "nombre =" + "'" + nom + "'";
		try {
			Connection conexion = getConnection();
			PreparedStatement declaracionSQL = conexion.prepareStatement(sentencia);
			declaracionSQL.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "ERROR:" + ex.getMessage());
			ext = false;
		}
		return ext;
	}
}
