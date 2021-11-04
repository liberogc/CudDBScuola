package modelli;

public class Studenti {
	String nome,cognome,facolta;
	int matricola;
	
	@Override
	public String toString() {
		return "nome: " + nome + ", cognome: " + cognome + ", facolta: " + facolta + ", matricola: " + matricola;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getFacolta() {
		return facolta;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
}
