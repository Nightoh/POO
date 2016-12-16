package pt.europeia.SmartCar.models;

import pt.europeia.SmartCar.controllers.Coordinates;

public class Soldier implements Coordinates{

	private String nome;
	private String local;
	private String dnsc;
	private String sexo;
	private String email;
	private String password;
	private String patente;
	private int id;
	int salario;
	double coordX = 50;
	double coordY = 50;
	
	public Soldier(String nome, String local, String dnsc, String sexo, String email, int salario) {

		this.nome = nome;
		this.local = local;
		this.dnsc = dnsc;
		this.sexo = sexo;
		this.email = email;
		this.salario = salario;
	}
	
	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDnsc() {
		return dnsc;
	}

	public void setDnsc(String dnsc) {
		this.dnsc = dnsc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	
	public void addX(double x) {
		coordX += x;
	}

	public void addY(double y) {
		coordY += y;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public double getX() {

		return coordX;
	}

	@Override
	public void setX(double x) {
		coordX = x;
	}

	@Override
	public double getY() {

		return coordY;
	}

	@Override
	public void setY(double y) {
		coordY = y;
	}


}