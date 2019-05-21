package queryItem;

import java.io.Serializable;

/**
 * 进货单查询类
 * @author CharlieLei
 *
 */
public class PurchaseNoteQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//供应商
	public String provider;
	//操作员
	public String operator_id;
	//仓库
	public String storehouse;
	
	public PurchaseNoteQueryItem() {
		super();
		this.provider = "";
		this.operator_id = "";
		this.storehouse = "";		
	}
	
	public PurchaseNoteQueryItem(String startdate, String enddate, String provider, String operatorid, String storeHouse) {
		super(startdate, enddate);
		this.provider = provider;
		this.operator_id = operatorid;
		this.storehouse = storeHouse;	
	}

}
