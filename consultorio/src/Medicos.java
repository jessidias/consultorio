public class Medicos {
	private int id_medico;
	private String nome_medico;

	public Medicos(int id_medico, String nome_medico) {
		super();
		this.id_medico = id_medico;
		this.nome_medico = nome_medico;

	}

	private int getId_medico() {
		return id_medico;
	}

	private String getNome_medico() {
		return nome_medico;
	}

	@Override
	public String toString() {
		return String.format("Medicos [id_medico= %s, nome_medico= %s]",
				id_medico, nome_medico);
	}

}
