package queryItem;

import java.io.Serializable;

/**
 * 进货退货单查询类
 * @author CharlieLei
 *
 */
public class PurchaseReturnNoteQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//供应商
	public String provider;
	//仓库
	public String storehouse;
	//操作员
	public String operator_id;
	
	public PurchaseReturnNoteQueryItem() {
		super();
		this.provider = "";
		this.storehouse = "";
		this.operator_id = "";
	}
	
	public PurchaseReturnNoteQueryItem(String startdate, String enddate, String provider, String storeHouse, String operatorid) {
		super(startdate, enddate);
		this.provider = provider;
		this.storehouse = storeHouse;
		this.operator_id = operatorid;
	}

}
