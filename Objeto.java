package EjercicioVentanas;

public class Objeto {
	String nombre;
	String lugarseencontro;
	String lugarguardado;
	boolean valioso;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugarseencontro() {
		return lugarseencontro;
	}

	public void setLugarseencontro(String lugarseencontro) {
		this.lugarseencontro = lugarseencontro;
	}

	public String getLugarguardado() {
		return lugarguardado;
	}

	public void setLugarguardado(String lugarguardado) {
		this.lugarguardado = lugarguardado;
	}

	public boolean isValioso() {
		return valioso;
	}

	public void setValioso(boolean valioso) {
		this.valioso = valioso;
	}

	public Objeto(String nombre, String lugarseencontro, String lugarguardado, boolean valioso) {
		super();
		this.nombre = nombre;
		this.lugarseencontro = lugarseencontro;
		this.lugarguardado = lugarguardado;
		this.valioso = valioso;
	}

	@Override
	public String toString() {
		return "Objeto [nombre=" + nombre + ", lugarseencontro=" + lugarseencontro + ", lugarguardado=" + lugarguardado
				+ ", valioso=" + valioso + "]";
	}

}
