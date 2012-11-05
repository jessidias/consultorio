import java.sql.Date;
import java.sql.Time;

public class Agenda {
	private int id_agenda;
	private String nome_paciente;
	private String nome_medico;
	private Date data_consulta;
	private Time hora_consulta;

	public Agenda(int id_agenda, String nome_paciente, String nome_medico,
			Date data_consulta, Time hora_consulta) {

		this.id_agenda = id_agenda;
		this.nome_paciente = nome_paciente;
		this.nome_medico = nome_medico;
		this.data_consulta = data_consulta;
		this.hora_consulta = hora_consulta;
	}

	private int getId_agenda() {
		return id_agenda;
	}

	private String getNome_paciente() {
		return nome_paciente;
	}

	private String getNome_medico() {
		return nome_medico;
	}

	private Date getData_consulta() {
		return data_consulta;
	}

	private Time getHora_consulta() {
		return hora_consulta;
	}

	@Override
	public String toString() {
		return String
				.format("Agenda [id_agenda=%s, nome_paciente=%s, nome_medico=%s, data_consulta=%s, hora_consulta=%s]",
						id_agenda, nome_paciente, nome_medico, data_consulta,
						hora_consulta);
	}

	
}
