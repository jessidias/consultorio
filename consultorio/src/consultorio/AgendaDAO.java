package consultorio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

// TODO: fazer comentários 
/**
 * Classe AgendaDAO
 * 
 * @author jessib.dias@gmail.com
 * 
 */

public class AgendaDAO {
	private String selectFindAgenda = "select * from agenda where nome_paciente = ? and nome_medico = ?";
	private String insertAgenda = "insert into pacientes(nome_paciente, telefone) values (?, ?)";


	// TODO: acrescentar insert, update ou delete

	/**
	 * Foi adicionada uma lista à classe Agenda, para ela retornar mais de uma
	 * resultado, se houver.
	 */
	public List<Agenda> findAgenda(String nome_paciente, String nome_medico) {

		if (nome_paciente == null) {
			throw new IllegalArgumentException(
					"O nome do paciente não pode ser null.");
		}
		if (nome_medico == null) {
			throw new IllegalArgumentException(
					"O nome do medico não pode ser null.");
		}

		Agenda c = null;
		List<Agenda> r = new ArrayList<Agenda>();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/consultorio", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(selectFindAgenda);
			stmt.clearParameters();
			stmt.setString(1, nome_paciente);
			stmt.setString(2, nome_medico);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String np = rs.getString("nome_paciente");
				String nm = rs.getString("nome_medico");
				int id_agenda = rs.getInt("id_agenda");
				Date data_consulta = rs.getDate("data_consulta");
				Time hora_consulta = rs.getTime("hora_consulta");
				c = new Agenda(id_agenda, np, nm, data_consulta, hora_consulta);
				r.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}
	
	public void insertAgenda(String nome_paciente, int telefone) {

		if (nome_paciente == null) {
			throw new IllegalArgumentException(
					"O nome do paciente não pode ser null.");
		}
		
		
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/consultorio", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(insertAgenda);
			stmt.clearParameters();
			stmt.setString(1, nome_paciente);
			stmt.setInt(2, telefone);
			int in = stmt.executeUpdate();
			if (in != 1) {
				throw new RuntimeException("Erro ao inserir operação");
				}
				} catch (Exception e) {
				// FIXME: comunicar erro ao programa
				e.printStackTrace();
				}
				// FIXME: fechar conexões
				}
			
			

	public static void main(String[] args) {
		AgendaDAO ag = new AgendaDAO();
		List<Agenda> c = ag.findAgenda("Jessica Dias", "Joao");
		if (c.isEmpty()) {
			System.out.println("Agenda não encontrada!");
		} else {
			System.out.println(c);
			ag.insertAgenda("Maria Silva", 32680800);
		}
	}

}
