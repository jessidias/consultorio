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
	private String selectFindAgenda = "select * from pacientes where nome_paciente = ? or ?=true";
	private String insertAgenda = "insert into pacientes(nome_paciente) values (?)";


	// TODO: acrescentar insert, update ou delete

	/**
	 * Foi adicionada uma lista à classe Agenda, para ela retornar mais de uma
	 * resultado, se houver.
	 */
	public List<Pacientes> findAgenda(String nome_paciente) {

		if (nome_paciente == null) {
			throw new IllegalArgumentException(
					"O nome do paciente não pode ser null.");
		}
		

		Pacientes c = null;
		List<Pacientes> r = new ArrayList<Pacientes>();
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/consultorio", "postgres",
					"senacrs");

			PreparedStatement stmt = con.prepareStatement(selectFindAgenda);
			stmt.clearParameters();
			stmt.setString(1, nome_paciente);
			stmt.setBoolean(2, true);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id_paciente = rs.getInt("id_paciente");
				String nome = rs.getString("nome_paciente");
				int tel = rs.getInt("telefone");
				c = new Pacientes(id_paciente, nome, tel);
				r.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}
	
	public void insertAgenda(String nome_paciente) {

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
		List<Pacientes> c = ag.findAgenda("Jessica Dias");
		if (c.isEmpty()) {
			System.out.println("Agenda não encontrada!");
		} else {
			System.out.println(c);
			ag.insertAgenda("Maria Silva");
		}
	}

}
