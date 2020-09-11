package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.ConnectionManager;
import model.Player;
//import model.Skill;

public class PlayerDAO {

	public List<Player> getAllPlayers() throws SQLException, Exception {
		String query = "SELECT * FROM PLAYER";                                                     
		ConnectionManager con = new ConnectionManager();

		List<Player> list = new ArrayList<Player>();
		//Skill skill = new Skill();
		SkillDAO skilldao = new SkillDAO();
		Player player = null;
		ResultSet rs = null;
		long skillid;

		try { 
			Statement st = con.getConnection().createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
											
				skillid = rs.getLong("PLAYER_SKILL_ID");
				
				if(skilldao.getSkillBylD(skillid) != null) {
					
					player = new Player(rs.getLong("PLAYER_ID"),rs.getString("PLAYER_NAME"),rs.getString("PLAYER_COUNTRY"),skilldao.getSkillBylD(rs.getLong("PLAYER_SKILL_ID")));
					
//					player.setPlayerld(rs.getLong("PLAYER_ID"));
//					player.setName(rs.getString("PLAYER_NAME"));
//					player.setCountry(rs.getString("PLAYER_COUNTRY"));
//					player.setSkill(skilldao.getSkillBylD(rs.getLong("PLAYER_SKILL_ID")));
					
				}	
				
				//player.setSkill(skilldao.getSkillBylD("PLAYER_SKILL_ID"));			

				// add each PLAYER to the list
				list.add(player);
			}

		} finally {
			con.getConnection().close();
		}

		return list;

	}

}


