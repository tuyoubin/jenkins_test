package vo.vosale_purchase_client;

import po.posale_purchase_client.SaleListPO;
import vo.vopublic.NoteVO;

public class SaleListVO extends NoteVO {
	String state;
	String ListNumbering;
	String client;
	String storehouse;
	//业务员
	String merchandiser;
	//操作员
	String operator_id;
	
	//销售员给出的折扣
	double dis;
	
	ListOfGoodsVO vo;
	ListOfGoodsVO gift;
	
	double Total_Before_Discount;
	//总经理给出的折扣
	double discount;
	double voucher;
	double Total;
	String  remark;
	
	
	public SaleListVO(String state,String ListNumbering,String client,
			String storehouse ,String merchandiser,String operator_id,
			String remark,double T_B_D,double discount,double voucher,double Total,
			ListOfGoodsVO VO,ListOfGoodsVO gift,double dis)
	{
		super("Sale"+state+"List");
		this.state = state;
		this.ListNumbering = ListNumbering;
		this.client = client;
		this.storehouse = storehouse;
		this.merchandiser = merchandiser;
		this.operator_id =  operator_id;
		this.remark =remark;
		
		Total_Before_Discount = T_B_D;
		this.discount = discount;
		this.voucher = voucher;
		this.Total = Total;
		this.vo = VO;
		this.gift = gift;
		this.dis = dis;
	}
	

	public void salelist(){
		state = "";
	}
	public void salereturnlist(){
		state = "Return";
	}
	
	public String get_state(){
		return state;
	}
	public String get_ListNumbering(){
		return ListNumbering;
	}
	
	public String get_client(){
		return client;
	}
	
	public String storehouse(){
		return storehouse;
	}
	
	public String get_merchandiser(){
		return merchandiser;
	}
	
	public String get_operator_id(){
		return operator_id;
	}
	
	public String get_remark(){
		return remark;
	}
	
	
	public ListOfGoodsVO get_ListOfGoodsVO(){
		return vo;
	}
	
	public ListOfGoodsVO get_gift(){
		return gift;
	}
	
	public double get_total_Before_Discount(){
		return Total_Before_Discount;
	}
	public double get_discount(){
		return discount;
	}
	public double get_voucher(){
		return voucher;
	}
	
	public double get_Total(){
		return Total;
	}
	public double get_dis(){
		return dis;
	}
	public void  setModified(){
		this.ListNumbering = this.ListNumbering+"Modified";	
	}
	
	
	public SaleListPO toPO(){
		SaleListPO p=new SaleListPO(state,ListNumbering,client,storehouse ,merchandiser,operator_id,remark, Total_Before_Discount,discount, voucher,Total,vo.toPO(),gift.toPO(),dis);
			return p;
	}
		
}
