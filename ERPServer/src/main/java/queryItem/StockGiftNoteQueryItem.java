package queryItem;

import java.io.Serializable;

/**
 * 库存赠送单查询类
 * @author CharlieLei
 *
 */
public class StockGiftNoteQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//操作员
	public String userID;
	
	public StockGiftNoteQueryItem() {
		super();
		this.userID = "";
	}
	
	public StockGiftNoteQueryItem(String startdate, String endDate, String userid) {
		super(startdate, endDate);
		this.userID = userid;
	}

}
