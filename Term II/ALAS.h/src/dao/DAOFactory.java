package dao;

public class DAOFactory  {

	public static itemsDAO getitemsDAO() {
		itemsDAO itemdao = new ItemDataAccess();
		return itemdao;
	}
	public static TransactionDAO gettransactonDAO(){
		TransactionDAO tdao = new TransactionDataAccess();
		return tdao;
	}

	public static onloanitemsDAO getonloanitemsDAO() {
		onloanitemsDAO onloanitemdao = new OnLoanItemsDataAccess();
		return onloanitemdao;
	}
	public static studtranhistDAO getstudtranhistDAO() {
		studtranhistDAO studtranhistdao = new StudTranHistDataAccess();
		return studtranhistdao;
	}

	public static userdao getUserDAO() {
		userdao userdao1 = new userdataaccess();
		return userdao1;
	}

	public static userdao createNewUserDAO() {
		userdao dao = new userdataaccess();
		return dao;
	}
	
	public static userdao getNewUserIDDAO() {
		userdao dao = new userdataaccess();
		return dao;
	}
	
}

	
	


