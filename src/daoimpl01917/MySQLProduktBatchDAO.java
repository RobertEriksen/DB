package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO {

	@Override
	public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
		// TODO Auto-generated method stub
		
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pb_id = " + pbId);
	    try {
	    	if (!rs.first()) throw new DALException("Produktbatch " + pbId + " findes ikke");
	    	return new ProduktBatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
	    }
	    catch (SQLException e) {throw new DALException(e); }
		
		
	}

	@Override
	public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
		// TODO Auto-generated method stub
		
		List<ProduktBatchDTO> list = new ArrayList<ProduktBatchDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
		
	}

	@Override
	public void createProduktBatch(ProduktBatchDTO pb) throws DALException {
		// TODO Auto-generated method stub
		Connector.doUpdate(
				"INSERT INTO produktbatch(pb_id, status, recept_id) VALUES " +
				"(" + pb.getPbId() + ", '" + pb.getStatus() + "', '" + pb.getReceptId() + "')");}

	@Override
	public void updateProduktBatch(ProduktBatchDTO produktbatch) throws DALException {
		// TODO Auto-generated method stub
		Connector.doUpdate(
		"UPDATE produktbatch "
		+ "SET status = "+ produktbatch.getStatus() + " WHERE pb_id = " + produktbatch.getPbId());

	}

}
