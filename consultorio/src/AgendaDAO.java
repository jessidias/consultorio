import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

public class AgendaDAO {
	private String selectFindAgenda = "select * from agenda where nome_paciente = ? and nome_medico = ?";

	public Agenda findAgenda(String nome_paciente, String nome_medico) {
		if (nome_paciente == null) {
			throw new IllegalArgumentException(
					"O nome do paciente não pode ser null.");
		}
		if (nome_medico == null) {
			throw new IllegalArgumentException(
					"O nome do medico não pode ser null.");
		}
		Agenda c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/consultorio", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(selectFindAgenda);
			stmt.setString(1, nome_paciente);
			stmt.setString(2, nome_medico);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String np = rs.getString("nome_paciente");
				String nm = rs.getString("nome_medico");
				int id_agenda = rs.getInt("id_agenda");
				Date data_consulta = rs.getDate("data_consulta");
				Time hora_consulta = rs.getTime("hora_consulta");
				c = new Agenda(id_agenda, np, nm, data_consulta, hora_consulta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void main(String[] args) {
		AgendaDAO ag = new AgendaDAO();
		Agenda c = ag.findAgenda("Jessica Dias", "Joao");
		if (c == null) {
			System.out.println("Agenda não encontrada!");
		} else {
			System.out.println(c);
		}
	}

}
