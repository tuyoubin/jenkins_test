package po.posale_purchase_client;

import java.io.Serializable;
import po.popublic.NotePO;
import vo.vosale_purchase_client.PurchaseNoteVO;


public class PurchaseNotePO extends NotePO implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//判定是销售还是销售退货
	private String state;
	private String ListNumbering;
	private String provider;
	private String storehouse;
	private String operator_id;
	//list of adding store
	//private List ListOfStorehouseChange;
	private ListOfGoodsPO po;
	private String remark;
	private double total;
	public PurchaseNotePO(String a,String b,String c,String d,String e,double t,String state,ListOfGoodsPO p){
		super("Purchase"+state+"Note");
		this.ListNumbering = a;
		this.provider = b;
		this.storehouse = c;
		this.operator_id = d;
		this.remark = e;
		this.state= state;
		//ListOfStorehouseChange =list;
		this.po=p;
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
	public List get_ListOfStorehouseChange(){
		return ListOfStorehouseChange;
	}*/
	
	public ListOfGoodsPO get_ListOfGoodsPO(){
		return po;
	}
	public String get_remark(){
		return remark;
	}
	
	public double get_total(){
		return total;
	}
	public PurchaseNoteVO toVO(){
		PurchaseNoteVO vo = new PurchaseNoteVO(ListNumbering,provider,storehouse,operator_id,remark,total,state,po.toVO());
				return vo;
	}
	
}
