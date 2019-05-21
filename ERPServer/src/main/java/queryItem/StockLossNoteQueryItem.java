package queryItem;

import java.io.Serializable;

/**
 * 库存报损单查询类
 * @author CharlieLei
 *
 */
public class StockLossNoteQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//操作员
	public String userID;
	
	public StockLossNoteQueryItem() {
		super();
		this.userID = "";
	}
	
	public StockLossNoteQueryItem(String startdate, String enddate, String userid) {
		super(startdate, enddate);
		this.userID = userid;
	}

}
