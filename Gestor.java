package EjercicioVentanas;

import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

public class Gestor {
	SQL sql = new SQL();
	mainin bd = new mainin();

	public static void main(String[] args) {
		dosven dosven = new dosven();
		dosven.setVisible(true);
		// clase clase = new clase();

		// clase.setVisible(true);

	}

	public boolean listarUsuarios(DefaultTableModel modelo) {
		boolean exitoso = false;
		if (sql.actualizarusuario(modelo)) {
			exitoso = true;
		}

		return exitoso;
	}

	public boolean altaUsuario(int c, String n) {
		boolean exitoso = false;
		if (n.length() < 3) {
			exitoso = false;
		} else {
			if (sql.altaUsuario(c, n)) {
				exitoso = true;
			}
		}
		return exitoso;
	}

	public boolean altaObjeto(String n, String lugarencontrado, String lugarguardado, boolean valioso,
			DefaultTableModel modelo) {
		boolean exitoso = false;
		if (n.length() < 2) {
			exitoso = false;
		} else {
			sql.altaObjeto(n, lugarencontrado, lugarguardado, valioso);
			exitoso = true;
		}
		listarObjetos(modelo);
		return exitoso;
	}

	public boolean listarObjetos(DefaultTableModel modelo) {

		boolean ext = false;

		if (sql.actualizarObjeto(modelo)) {
			ext = true;
		}

		return ext;
	}

	public boolean bajaObjeto(Object valor) {
		boolean verdadero=false;
		
		if(sql.bajaObjeto(valor)) {
			verdadero=true;
		}
		return verdadero;
	}

	public boolean login(int cedula, String nombre) {
		boolean exitoso = false;
		if (sql.login(cedula, nombre)) {
			exitoso = true;
		}
		return exitoso;
	}

	public boolean borrarusuario(int cedula, String nombre) {
		boolean correcto = false;
		if (sql.borrarusuario(cedula, nombre)) {
			correcto = true;
		}
		return correcto;
	}
}
