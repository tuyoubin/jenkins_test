package queryItem;

import java.io.Serializable;

/**
 * 现金收款单查询类
 * @author CharlieLei
 *
 */
public class CashBillQueryItem extends NoteQueryItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//操作员
	public String userID;
	//银行账户
	public String companyAccountName;
	
	public CashBillQueryItem() {
		super();
		this.userID = "";
		this.companyAccountName = "";
	}
	
	public CashBillQueryItem(String startdate, String endDate, String userid, String accountname) {
		super(startdate, endDate);
		this.userID = userid;
		this.companyAccountName = accountname;
	}

}
