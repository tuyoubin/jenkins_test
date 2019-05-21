package queryItem;

import java.io.Serializable;

/**
 * 库存报溢单查询类
 * @author CharlieLei
 *
 */
public class StockOverflowNoteQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//操作员
	public String userID;
	
	public StockOverflowNoteQueryItem() {
		super();
		this.userID = "";
	}
	
	public StockOverflowNoteQueryItem(String startdate, String enddate, String userid) {
		super(startdate, enddate);
		this.userID = userid;
	}

}
