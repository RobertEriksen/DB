package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connector01917.Connector;
import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.OperatoerDTO;
import dto01917.ProduktBatchKompDTO;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO {

	@Override
	public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId)
			throws DALException {
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE "
				+ "pb_id = " + pbId + " AND rb_id = " + rbId);
		try {
			if (!rs.first()) throw new DALException("Produktbatchkomponent " + pbId + " findes ikke!");
			return new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
		}  catch (SQLException e) { throw new DALException(e); }
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId)
			throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId);
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public List<ProduktBatchKompDTO> getProduktBatchKompList()
			throws DALException {
		List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
		ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
		try
		{
			while (rs.next()) 
			{
				list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
			}
		}
		catch (SQLException e) { throw new DALException(e); }
		return list;
	}

	@Override
	public void createProduktBatchKomp(ProduktBatchKompDTO pbk)
			throws DALException {
		Connector.doUpdate(
				"INSERT INTO produktbatchkomponent(pb_id, rb_id, opr_id, tara, netto) VALUES " +
				"(" + pbk.getPbId() + ", '" + pbk.getRbId() + "', '" + pbk.getOprId() + "', '" + 
				pbk.getTara() + "', '" + pbk.getNetto() + "')"
			);
	}

	@Override
	public void updateProduktBatchKomp(ProduktBatchKompDTO pbk)
			throws DALException {
		// 
//		Connector.doUpdate(
//				"UPDATE produktbatchkomponent SET  pb_id = '" + pbk.getPbId() + "', rb_id =  '" + pbk.getRbId() + 
//				"', opr_id = '" + pbk.getOprId() + "', tara = '" + pbk.getTara() + "', netto = '" + pbk.getNetto() + 
//				"' WHERE pbk_id = " + pbk.getOprId()
//		);
		
		// Opdaterer ikke pb_id og rb_id da de er fremmednøgler?
		Connector.doUpdate(
				"UPDATE produktbatchkomponent SET opr_id = '" + pbk.getOprId() + "', tara =  '" + pbk.getTara() + 
				"', netto = '" + pbk.getNetto() + "' WHERE pb_id = " + pbk.getPbId() + " AND rb_id = " + pbk.getRbId()
		);
	}

}
