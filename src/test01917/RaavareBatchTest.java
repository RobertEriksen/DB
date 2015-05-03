package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLRaavareBatchDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;
import dto01917.RaavareBatchDTO;

public class RaavareBatchTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		System.out.println("vi undersøger om en raavarebatch med id 8 findes (med get):");
		MySQLRaavareBatchDAO rb = new MySQLRaavareBatchDAO();
		try { System.out.println(rb.getRaavareBatch(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi undersøger om listen indeholder dette element (med getlist)");
		try { System.out.println(rb.getRaavareBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi opretter en ny Raavarebatch med id 8, raavare_id 8 og maengde 1000");
		RaavareBatchDTO hej = new RaavareBatchDTO(8,7,1000);
		try { rb.createRaavareBatch(hej); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi prøver at finde den nye Raavare batch med id 8 (med get)");
		try { System.out.println(rb.getRaavareBatch(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi ser om listen har dette element (med getlist)");
		try { System.out.println(rb.getRaavareBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi prøver at update den nye raavarebatch, så mængden bliver fordoblet");
		RaavareBatchDTO hej2 = new RaavareBatchDTO(8,7,2000);
		try { rb.updateRaavareBatch(hej2); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi prøver at finde den nye Raavare batch med id 8 (med get)");
		try { System.out.println(rb.getRaavareBatch(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi ser om listen har dette element (med getlist)");
		try { System.out.println(rb.getRaavareBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
	}
}
