package queryItem;

import java.io.Serializable;

/**
 * 付款单查询类
 * @author CharlieLei
 *
 */
public class CreditNoteQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//供应商
	public String supplierName;
	//操作员
	public String userID;
	
	public CreditNoteQueryItem() {
		super();
		this.supplierName = "";
		this.userID = "";
	}
	
	public CreditNoteQueryItem(String startdate, String endDate, String suppliername, String userid) {
		super(startdate, endDate);
		this.supplierName = suppliername;
		this.userID = userid;
	}
}
