package test01917;

import java.sql.SQLException;

import connector01917.Connector;
import daoimpl01917.MySQLProduktBatchDAO;
import daointerfaces01917.DALException;
import dto01917.ProduktBatchDTO;

public class ReceptTest {
	public static void main(String[] args) {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }

		System.out.println("produktbatch nummer 1:");
		MySQLProduktBatchDAO pb = new MySQLProduktBatchDAO();
		try { System.out.println(pb.getProduktBatch(1)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Indsaettelse af ny produktbatch med pb_id =  6");
		ProduktBatchDTO pb1 = new ProduktBatchDTO(6,2,3);
		try { pb.createProduktBatch(pb1); }
		catch (DALException e) { System.out.println(e.getMessage()); }	

		System.out.println("Operatoer nummer 6:");
		try { System.out.println(pb.getProduktBatch(6)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Opdatering af initialer for operatoer nummer 6");
		pb1.setStatus(10);
		try { pb.updateProduktBatch(pb1); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("ProduktBatch nummer 6:");
		try { System.out.println(pb.getProduktBatch(6)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Alle operatoerer:");
		try { System.out.println(pb.getProduktBatchList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 5:");
		try { System.out.println(pb.getProduktBatch(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

	}
}