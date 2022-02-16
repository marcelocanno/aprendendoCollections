package aprendendoCollections;

import java.util.Objects;

public class Celular {

		private String nome;
		private String IMEI;	
		
		
		@Override
		public int hashCode() {
			return Objects.hash(IMEI, nome);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Celular other = (Celular) obj;
			return Objects.equals(IMEI, other.IMEI) && Objects.equals(nome, other.nome);
		}


		public Celular() {
			super();
			
		}


		public Celular(String nome, String iMEI) {
			super();
			this.nome = nome;
			IMEI = iMEI;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getIMEI() {
			return IMEI;
		}


		public void setIMEI(String iMEI) {
			IMEI = iMEI;
		}


		@Override
		public String toString() {
			return "CelularTest [nome=" + nome + ", IMEI=" + IMEI + "]";
		}
		
		
		
		}
		
		
		
		
	


