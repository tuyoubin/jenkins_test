package queryItem;

import java.io.Serializable;

/**
 * 收款单查询类
 * @author CharlieLei
 *
 */
public class DebitNoteQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//销售商
	public String sellerName;
	//操作员
	public String userID;
	
	public DebitNoteQueryItem() {
		super();
		this.sellerName = "";
		this.userID = "";
	}
	
	public DebitNoteQueryItem(String startdate, String endDate, String sellername, String userid) {
		super(startdate, endDate);
		this.sellerName = sellername;
		this.userID = userid;
	}
}
