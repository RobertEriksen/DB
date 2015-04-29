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

		System.out.println("Vi undersøger om element med recept_id 4 og raavare_id 1 (med get):");
		try { System.out.println(rk.getReceptKomp(4,1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi undersøger om listen indeholder dette element (med getlist):");
		try { System.out.println(rk.getReceptKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		
		System.out.println("Vi forsøger at oprette en ny receptkomponent, med Recept_ID 4, Raavare_id 1, nom_netto 10.0, tolerance 10.0, kalder nyrecept");
		ReceptKompDTO nyrecept = new ReceptKompDTO(4,1,10.0,10.0);
		
		System.out.println(" ");
		
		System.out.println("Vi forsøger at indsætte denne nye recept i vores database");
		try { rk.createReceptKomp(nyrecept); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("vi ser om vi kan finde den med get");
		try { System.out.println(rk.getReceptKomp(4,1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi ser om listen er opdateret (med getlist)");
		try { System.out.println(rk.getReceptKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi prøver at opdatere den nye recept, så dens nem_netto er af dobbelt størrelse (med update)");
		ReceptKompDTO nyrecept2 = new ReceptKompDTO(4,1,20.0,10.0);
		try { rk.updateReceptKomp(nyrecept2); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("vi ser om vi kan finde den med get");
		try { System.out.println(rk.getReceptKomp(4,1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi ser om listen er opdateret (med getlist)");
		try { System.out.println(rk.getReceptKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		
		System.out.println(" ");
		
		
	}
}
