package consultorio;

public class Pacientes {
	private int id_paciente;
	private String nome_paciente;
	private int telefone;
	
	
	public Pacientes(int id_paciente, String nome_paciente, int telefone){
		this.id_paciente=id_paciente;
		this.nome_paciente=nome_paciente;
		this.telefone=telefone;
	}


	private int getId_paciente() {
		return id_paciente;
	}


	public String getNome_paciente() {
		return nome_paciente;
	}


	private int getTelefone() {
		return telefone;
	}


	@Override
	public String toString() {
		return String.format(
				"Pacientes [id_paciente=%s, nome_paciente=%s, telefone=%s]",
				id_paciente, nome_paciente, telefone);
	}
	
}
