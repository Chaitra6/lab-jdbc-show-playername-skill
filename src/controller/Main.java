package controller;

import java.sql.SQLException;
import java.util.List;

//import dao.SkillDAO;
import dao.PlayerDAO;
//import model.Skill;
import model.Player;

public class Main {

	public static void main(String[] args) throws Exception {

		PlayerDAO playerDAO = new PlayerDAO();

		List<Player> players;

		try {
			players = playerDAO.getAllPlayers();
			for (Player player : players) {
				System.out.println(" ID\t NAME\t COUNTRY\t SKILL\t");
				System.out.println(player.getPlayerld() + "\t" + player.getName() + "\t" + player.getCountry() + "\t"
						+ player.getSkill().getSkillName());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
