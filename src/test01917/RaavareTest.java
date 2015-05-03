package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLRaavareDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;
import dto01917.RaavareBatchDTO;
import dto01917.RaavareDTO;

public class RaavareTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		System.out.println("Vi undersøger om vi kan finde raavare med id nr 8 (med get):");
		MySQLRaavareDAO r = new MySQLRaavareDAO();
		try { System.out.println(r.getRaavare(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi undersøger om vi kan finde denne i listen (med getlist)");
		try { System.out.println(r.getRaavareList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi opretter en ny raavare, med id 8, navn Ananas og Leverandoer Martin's special");
		RaavareDTO hej = new RaavareDTO(8,"Ananas","Martins Special");
		try { r.createRaavare(hej); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi undersøger om vi kan finde denne (med get):");
		try { System.out.println(r.getRaavare(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi undersøger om vi kan finde denne i listen (med getlist)");
		try { System.out.println(r.getRaavareList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi opdatere raavaren med id 8, så navnet nu er Pepperoni");
		RaavareDTO hej2 = new RaavareDTO(8,"Pepperoni","Martins Special");
		try { r.updateRaavare(hej2); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi undersøger om vi kan finde denne (med get):");
		try { System.out.println(r.getRaavare(8)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Vi undersøger om vi kan finde denne i listen (med getlist)");
		try { System.out.println(r.getRaavareList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
	}
}
