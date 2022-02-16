package aprendendoCollectionsOne;

public class Estudante implements Comparable<Estudante> {
	
	private final String nome;
	private final Integer idade;
	
	public String getNome() {
		return nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public Estudante(String nome, Integer idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	@Override
	public int compareTo(Estudante o) {
		return this.getIdade() - o.getIdade();
	}
	@Override
	public String toString() {
		return "Estudante [nome=" + nome + ", idade=" + idade + "]";
	}
	
	
	
	

}
