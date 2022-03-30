package mySqlConection;

import java.util.Objects;

public class Carro {
	
	private int id;
	private String nome;
	private String placa;
	private Comprador comprador;
	
	public Carro() {
		super();
	}
	public Carro(int id, String nome, String placa, Comprador comprador) {
		super();
		this.id = id;
		this.nome = nome;
		this.placa = placa;
		this.comprador = comprador;
	}
	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", placa=" + placa + ", comprador=" + comprador + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	@Override
	public int hashCode() {
		return Objects.hash(comprador, id, nome, placa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(comprador, other.comprador) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(placa, other.placa);
	}
	
	
	
	
	
	
	
	

}
