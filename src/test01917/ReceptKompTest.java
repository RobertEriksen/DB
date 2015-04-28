package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;

public class ReceptKompTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		MySQLReceptKompDAO rk = new MySQLReceptKompDAO();

		System.out.println("Vi undersøger om element med recept_id 10 og raavare_id 10:");
		System.out.println(" ");
		try { System.out.println(rk.getReceptKomp(10,10)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi undersøger om listen indeholder dette element:");
		try { System.out.println(rk.getReceptKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		for (int i = 0; i < 10; i++) {
			System.out.println(" ");
		}
		
		
		
	}
}
