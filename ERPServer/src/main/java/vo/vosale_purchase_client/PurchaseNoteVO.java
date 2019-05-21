package vo.vosale_purchase_client;

import po.posale_purchase_client.PurchaseNotePO;
import vo.vopublic.NoteVO;

public class PurchaseNoteVO extends NoteVO {
	String state;
	String ListNumbering;
	String provider;
	String storehouse;
	String operator_id;
	//list of adding store
	//List ListOfStorehouseChange;
	public ListOfGoodsVO vo;
	String remark;
	double total;
	public PurchaseNoteVO(String a,String b,String c,String d,String e,double t,String state,ListOfGoodsVO vo){
		super("Purchase"+state+"Note");
		this.ListNumbering = a;
		this.provider = b;
		this.storehouse = c;
		this.operator_id = d;
		this.remark = e;
		this.state= state;
		//ListOfStorehouseChange =list;
		this.vo= vo;
		total = t;
	}
	
	
	public void PurchaseNote_increase(){
		this.state = "";
	}
	
	public void PurchaseNote_decrease(){
		this.state = "Return";
	}
	
	public String get_state(){
		return state;
	}
	
	public String get_ListNumbering(){
		return ListNumbering;
	}
	
	public String get_provider(){
		return provider;
	}
	
	public String get_storehouse(){
		return  storehouse;
	}
	public String operator_id(){
		return operator_id;
	}
/*
	public List get_ListOfAddStorehouse(){
		return ListOfStorehouseChange;
	}*/
	
	public ListOfGoodsVO get_ListOfGoodsVO(){
		return vo;
	}
	public String get_remark(){
		return remark;
	}
	
	public double get_total(){
		return total;
	}
	public void  setModified(){
		this.ListNumbering = this.ListNumbering+"Modified";	
	}
	

	
	
	public PurchaseNotePO toPO(){
		PurchaseNotePO po =new PurchaseNotePO(ListNumbering,provider,storehouse,operator_id,remark,total,state,vo.toPO());
				return po;
		
	}
}
