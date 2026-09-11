package EjercicioVentanas;

public class comprobar {
	String nombre;
	int cedula;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public comprobar(String nombre, int cedula) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre + " " + cedula;
	}
}
