import java.sql.Date;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Teste_Conexao {

	public static void main(String[] args)throws Exception {

		Connection con = DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/consultorio", "postgres", "senacrs");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM agenda");
		ResultSet med = stmt.executeQuery("SELECT * FROM medicos");

		while (rs.next()) {
			String a = rs.getString("nome_paciente");
			String b = rs.getString("nome_medico");
			Date c = rs.getDate("data_consulta");
			Date d = rs.getDate("hora_consulta");
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);

		}
		
		while (med.next()) {
			String m = med.getString("nome_medico");
			//String b = rs.getString("nome_medico");
			//Date c = rs.getDate("data_consulta");
			//Date d = rs.getDate("hora_consulta");
			System.out.println(m);
			//System.out.println(b);
			//System.out.println(c);
			//System.out.println(d);

		}
	}
}
