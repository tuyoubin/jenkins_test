package po.posale_purchase_client;


import java.io.Serializable;


import po.popublic.NotePO;
import vo.vosale_purchase_client.SaleListVO;

public class SaleListPO extends NotePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String state;
	private String ListNumbering;
	private String client;
	private String storehouse;
	private String merchandiser;
	private String operator_id;
	private String  remark;
	
	double dis;
	ListOfGoodsPO po;
	ListOfGoodsPO gift;
	
	double Total_Before_Discount;
	double discount;
	double voucher;
	double Total;
	
	public SaleListPO(String state,String ListNumbering,String client,String storehouse ,
			String merchandiser,String operator_id,String remark,double T_B_D,
			double discount,double voucher,double Total,ListOfGoodsPO PO,ListOfGoodsPO gift,double dis)
	{
		super("Sale"+state+"List");
		this.state = state;
		this.ListNumbering = ListNumbering;
		this.client = client;
		this.storehouse = storehouse;
		this.merchandiser = merchandiser;
		this.operator_id =  operator_id;
		this.remark =remark;
		this.po = PO;
		Total_Before_Discount = T_B_D;
		this.discount = discount;
		this.voucher = voucher;
		this.Total = Total;
		this.gift = gift;
		this.dis =dis;
	}
	
	public void salelist(){
		state = "";
	}
	public void salereturnlist(){
		state = "Return";
	}
	public String get_ListNumbering(){
		return ListNumbering;
	}
	
	public String get_state(){
		return state;
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
	public double get_dis(){
		return dis;
	}
	
	public ListOfGoodsPO get_ListOfGoodsPO(){
		return po;
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
	public ListOfGoodsPO get_gift(){
		return gift;
	}
	public SaleListVO toVO(){
		SaleListVO vo =new SaleListVO(state,ListNumbering,client,storehouse ,merchandiser,operator_id,remark, Total_Before_Discount,discount, voucher,Total,po.toVO(),gift.toVO(),dis);
			return vo;
	}
	
	
	
}
