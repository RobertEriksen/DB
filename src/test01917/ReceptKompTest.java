package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;
import dto01917.ReceptKompDTO;

public class ReceptKompTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		MySQLReceptKompDAO rk = new MySQLReceptKompDAO();

		System.out.println("Vi undersøger om get kan finde en receptkomponent med receptid 4 og raavareid 1. Vi forventer at den ikke findes endnu.");
		String fail = "Receptkomponent med receptId 4 og raavareId 1 findes ikke!";
		try { rk.getReceptKomp(4,1); }
		catch (DALException e) { System.out.println(false); }
//		
//		System.out.println(" ");
//		
//		System.out.println("Vi undersøger om listen indeholder dette element (med getlist):");
//		try { System.out.println(rk.getReceptKompList()); }
//		catch (DALException e) { System.out.println(e.getMessage()); }
//		
//		System.out.println(" ");
//		
//		
//		System.out.println("Vi forsøger at oprette en ny receptkomponent, med Recept_ID 4, Raavare_id 1, nom_netto 10.0, tolerance 10.0, kalder nyrecept");
//		ReceptKompDTO nyrecept = new ReceptKompDTO(4,1,10.0,10.0);
		
		
	}
}
