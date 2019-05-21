package queryItem;

import java.io.Serializable;

public class SaleListQueryItem extends NoteQueryItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//客户
	public String client;
	//业务员
	public String merchandiser;
	//操作员
	public String operator_id;
	//仓库
	public String storehouse;
	//商品名
	public String goodsName;
	
	public SaleListQueryItem(){
		super();
		this.client = "";
		this.merchandiser = "";
		this.operator_id = "";
		this.storehouse = "";
		this.goodsName = "";
	}
	
	public SaleListQueryItem(String startdate, String endDate,String Client, String Merchandiser, String operatorid, String Storehouse, String goodsname) {
		super(startdate, endDate);
		this.client = Client;
		this.merchandiser = Merchandiser;
		this.operator_id = operatorid;
		this.storehouse = Storehouse;
		this.goodsName = goodsname;
	}
	
	
	
}
