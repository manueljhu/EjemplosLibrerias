package modelo;

import java.util.Objects;


public class Almacen {
	private int id; 
	private String nom;
	private String ser;
	private String se2;
	private String age;
	
	
	public Almacen() {
		this.nom="";
		this.ser="";
		this.se2="";
		this.age="";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSer() {
		return ser;
	}
	public void setSer(String ser) {
		this.ser = ser;
	}
	public String getSe2() {
		return se2;
	}
	public void setSe2(String se2) {
		this.se2 = se2;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Almacen other = (Almacen) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Almacen [id=" + id + ", nom=" + nom + ", ser=" + ser + ", se2=" + se2 + ", age=" + age + "]";
	}
}
