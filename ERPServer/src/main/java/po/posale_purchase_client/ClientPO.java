package po.posale_purchase_client;

import java.io.Serializable;

import vo.vosale_purchase_client.ClientVO;


public class ClientPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numbering;
	private String classification;
	private String level;
	private String name;
	private String phone_number;
	private String address;
	private String postcode;
	private String email;
	//应收额度
	private	double receivable_amount;
	//应收
	private	double receivables;
	//应付
	private double should_pay;
	String acquiescence_merchandiser;
	
	
	public ClientPO (String a0,String a1,String a2,String a3,String a4,String a5,String a6,String a7,double b0,double b1,double b2,String a8)
	{
		 this.numbering =a0;
		 this.classification=a1;
		 this.level=a2;
		 this.name=a3;
		 this.phone_number=a4;
		 this.address=a5;
		 this.postcode=a6;
		 this.email=a7;
		 this.receivable_amount =b0;
		 this.receivables=b1;
		 this.should_pay=b2;
		 this.acquiescence_merchandiser = a8;
	}
	
	 public String get_numbering(){
		 return numbering;
	 }
	 
	 public String get_classification(){
		 return classification;
	 }
	 public String get_level(){
		 return level;
	 }
	 
	 public String get_name(){
		 return name;
	 }
	 
	 public String get_phone_number(){
		 return phone_number;
	 }
	 
	 public String get_address(){
		 return address;
	 }
	 
	 public String get_postcode(){
		 return postcode;
	 }
	 
	 
	 public String get_email(){
		 return email;
	 }
	 
	 public double get_receivalbe_amount(){
		 return receivable_amount;
	 }
	 
	 public double get_receivables(){
		 return receivables;
	 }
	 
	 public double get_should_pay(){
		 return should_pay;
	 }
	
	 public String get_acquiescence_merchandiser(){
		 return acquiescence_merchandiser;
	 }
	 
	 public void set_receivables(double rec ){
		 receivables = rec;
	 }
	 public void set_should_pay(double should){
		 should_pay = should; 
	 }
	
	public ClientVO toVO(){
		ClientVO vo =new ClientVO(numbering,classification,level,name,phone_number,address,postcode,email,receivable_amount,receivables,should_pay,acquiescence_merchandiser);
		return vo;	
	}
}
