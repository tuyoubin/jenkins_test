package queryItem;

import java.io.Serializable;

/**
 * 单据查询类
 * @author CharlieLei
 *
 */
abstract public class NoteQueryItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//起始时间
	public String startDate;
	//结束时间
	public String endDate;
	
	public NoteQueryItem() {
		this.startDate = "";
		this.endDate = "";
	}
	
	public NoteQueryItem(String startdate, String endDate) {
		this.startDate = startdate;
		this.endDate = endDate;
	}
}
