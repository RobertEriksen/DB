package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchKompDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchKompDTO;

public class ProduktBatchKompTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		System.out.println("Produkt Batch Komponent 1 med raavarebatch id 1:");
		MySQLProduktBatchKompDAO pbk = new MySQLProduktBatchKompDAO();
		try { System.out.println(pbk.getProduktBatchKomp(1, 1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Indsaettelse af ny produktbatch med pb_id =  6 og rb_id = 1:");
		ProduktBatchKompDTO pbk1 = new ProduktBatchKompDTO(6, 1, 0.5, 1.4, 4);
		try { pbk.createProduktBatchKomp(pbk1); }
		catch (DALException e) { System.out.println(e.getMessage()); }	

		System.out.println("Produkt batch komponent 6 med rb_id = 1:");
		try { System.out.println(pbk.getProduktBatchKomp(6, 1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Produkt Batch Komponent 4 med raavarebatch id 1:");
		ProduktBatchKompDTO pbk2 = null;
		try {
			pbk2 = pbk.getProduktBatchKomp(4, 1);
			System.out.println(pbk2); 
			}
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		System.out.println("Opdatering af netto for produkt batch komponent 4 med rb_id = 1");
		pbk2.setNetto(2.3);
		try { pbk.updateProduktBatchKomp(pbk2); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Produkt batch komponent 4 med rb_id = 1:");
		try { System.out.println(pbk.getProduktBatchKomp(4, 1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Alle produktbatch komponenter:");
		try { System.out.println(pbk.getProduktBatchKompList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Alle komponenter i produkt batch 1:");
		try { System.out.println(pbk.getProduktBatchKompList(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

	}
}
