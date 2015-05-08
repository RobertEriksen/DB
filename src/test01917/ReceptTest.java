package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daoimpl01917.MySQLReceptDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;
import dto01917.ReceptDTO;

public class ReceptTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		System.out.println("Vi forsøger at finde recept nr 4, der ikke findes endnu (Via getrecept)");
		MySQLReceptDAO recept = new MySQLReceptDAO();
		
		try { System.out.println(recept.getRecept(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi ser hvad listen indeholder (Via getreceptlist)");
		try { System.out.println(recept.getReceptList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi forsøger at indsætte en fjerde recept: Kødvulkanen (Via createrecept)");
		ReceptDTO Kødvulkan = new ReceptDTO(4, "Kødvulkanen");
		try {recept.createRecept(Kødvulkan); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi ser nu listen af recepter (Via getreceptlist)");
		try { System.out.println(recept.getReceptList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi forsøger at se om der nu er et fjerde element (Via getrecept)");
		try { System.out.println(recept.getRecept(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi prøver at give Kødvulkanen et pænere navn: Meatpei (Via update)");
		ReceptDTO Meatpei = new ReceptDTO(4, "Meatpei");
		try { recept.updateRecept(Meatpei); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi ser om det fjerde element har ændret navn fra Kødvulkanen til Meatpei (Via getrecept)");
		try { System.out.println(recept.getRecept(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println(" ");
		
		System.out.println("Vi ser om listen er opdateret (Via getreceptlist)");
		try { System.out.println(recept.getReceptList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		
	}
}
