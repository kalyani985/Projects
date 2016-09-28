package dao;

import java.sql.SQLException;
import java.util.ArrayList;

//import model.onloanitems;
import model.studtranhist;

public interface studtranhistDAO {
	public abstract ArrayList<studtranhist> getStudTranHist(String aUserID) throws SQLException;
}
