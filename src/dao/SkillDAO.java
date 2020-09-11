package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import utility.ConnectionManager;
import model.Skill;

public class SkillDAO {

	public Skill getSkillBylD(Long id) throws SQLException, Exception {
		String query = "SELECT * FROM SKILL";
		ConnectionManager con = new ConnectionManager();

		Skill skill = null;
		ResultSet rs = null;

		try { 
			Statement st = con.getConnection().createStatement();
			rs = st.executeQuery(query);
			//skill = 
			while (rs.next()) {
				
				
				if(rs.getLong("SKILL_ID") == id ) {
					
					skill = new Skill(rs.getLong("SKILL_ID"),rs.getString("SKILL_NAME"));
					
//					skill.setSkillid(rs.getLong("SKILL_ID"));
//					skill.setSkillName(rs.getString("SKILL_NAME"));
					return skill;
				}
			    			 
			}
			
			return null;

		} finally {
			con.getConnection().close();
		}

		

	}

}

