package vo.vosale_purchase_client;

import po.posale_purchase_client.ClientPO;

public class ClientVO {
	
	String numbering;
	String classification;
	String level;
	String name;
	String phone_number;
	String address;
	String postcode;
	String email;
	//应收额度
	private	double receivable_amount;
	//应收
	private	double receivables;
	//应付
	private double should_pay;
	String acquiescence_merchandiser;
	
	public ClientVO (String a,String a1,String a2,String a3,String a4,String a5,String a6,String a7,double b,double b1,double b2,String a8)
	{
		numbering =a;
		 classification=a1;
		 level=a2;
		 name=a3;
		 phone_number=a4;
		 address=a5;
		 postcode=a6;
		 email=a7;
		 receivable_amount =b;
		 receivables=b1;
		 should_pay=b2;
		 acquiescence_merchandiser = a8;
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
	
	 public ClientPO toPO(){
		 ClientPO po = new ClientPO(numbering,classification,level,name,phone_number,address,postcode,email,receivable_amount,receivables,should_pay,acquiescence_merchandiser);
		 return po;
	 }
	 

}