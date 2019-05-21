package queryItem;

import java.io.Serializable;

public class SaleReturnListQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//客户
	public String client;
	//业务员
	public String merchandiser;
	//操作员
	public String operator_id;
	//仓库
	public String storehouse;
	
	public SaleReturnListQueryItem() {
		super();
		this.client = "";
		this.merchandiser = "";
		this.operator_id = "";
		this.storehouse = "";
	}
	
	public SaleReturnListQueryItem(String startdate, String endDate,String Client, String Merchandiser, String operatorid, String Storehouse) {
		super(startdate, endDate);
		this.client = Client;
		this.merchandiser = Merchandiser;
		this.operator_id = operatorid;
		this.storehouse = Storehouse;
	}

}
