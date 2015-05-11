package test01917;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import connector01917.Connector;
import daoimpl01917.MySQLReceptKompDAO;
import daointerfaces01917.DALException;
import dto01917.ReceptKompDTO;


public class Test_af_receptkomp {

	@Test
	public void test() throws DALException {
		try { new Connector(); } 
		catch (InstantiationException e) { e.printStackTrace(); }
		catch (IllegalAccessException e) { e.printStackTrace(); }
		catch (ClassNotFoundException e) { e.printStackTrace(); }
		catch (SQLException e) { e.printStackTrace(); }
		MySQLReceptKompDAO rk = new MySQLReceptKompDAO();
		
		System.out.println("Vi undersøger om get kan finde en receptkomponent med receptid 4 og raavareid 1. Vi forventer at den ikke findes endnu.");
		try { rk.getReceptKomp(4,1); fail(); }
		catch (DALException e) { }
		
		
		System.out.println("Vi sammenligner listen af receptkomponenter med en liste der ville have dette element indsat. Vi forventer fejl");
		String nyliste = "[1	1	10.0	0.1, 1	2	2.0	0.1, 1	5	2.0	0.1, 2	1	10.0	0.1, 2	3	2.0	0.1, 2	5	1.5	0.1, 2	6	1.5	0.1, 3	1	10.0	0.1, 3	4	1.5	0.1, 3	5	1.5	0.1, 3	6	1.0	0.1, 3	7	1.0	0.1, 4	1	10.0	10.0]";
		try { 
			if (rk.getReceptKompList().equals(nyliste)) fail();  }
		catch (DALException e) {}
		
		System.out.println("Vi indsætter nu en receptkomponent med receptid 4 og raavareid 1, og de 2 andre værdier er 10.0");
		ReceptKompDTO nyrecept = new ReceptKompDTO(4,1,10.0,10.0);
		rk.createReceptKomp(nyrecept);
		
		System.out.println("Vi ser om get kan finde den nu. Vi forventer True");
		try { rk.getReceptKomp(4,1);}
		catch (DALException e) {fail(); }
		
		System.out.println("Vi ser om listen nu er opdateret. Vi forventer True");
		try {if(!rk.getReceptKompList().toString().equals(nyliste)) fail();
		} catch (Exception e) {}
		
		System.out.println("Vi ændrer i alle attributterne med set, så receptkomponenten har værdierne 5,2,11.0,12.0. Til sidst ser vi om de er ændret med get, hvor vi forventer true.");
		nyrecept.setReceptId(5);
		nyrecept.setRaavareId(2);
		nyrecept.setNomNetto(11.0);
		nyrecept.setTolerance(12);
		nyrecept.toString().equals("5	2	11.0	12.0");
		
		System.out.println("Vi undersøger alle getterne. Vi forventer true");
		assertEquals(nyrecept.getReceptId(),5);
		assertEquals(nyrecept.getRaavareId(),2);
		assertEquals((int)nyrecept.getNomNetto(),11);
		assertEquals((int) nyrecept.getTolerance(),12);
	}
	
	
	

}
