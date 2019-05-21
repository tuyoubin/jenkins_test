package vo.voManager;
import java.util.ArrayList;

import po.poMangaer.StrategySPO;


public class StrategySVO {
	private String ID;
	
	private String type;
	//起止时间
	private String FDate;
	private String EDate;
	
	private ArrayList<String> pack;
	private double price;
	
	public StrategySVO(StrategySPO S){
		this.ID = S.getID();
		this.type = S.gettype();
		this.FDate = S.getFDate();
		this.EDate = S.getEDate();
		this.pack = S.getpack();
		this.price = S.getprice();
	}
	
	public StrategySVO(String Id,String Type,String Fdate,String Edate,ArrayList<String> Pack,double Price){
		ID = Id;
		type = Type;
		FDate = Fdate;
		EDate = Edate;
		pack = Pack;
		price = Price;
		
	}
	
	public ArrayList<String> getPack() {
		return pack;
	}
	public void setpack(ArrayList<String> pack) {
		this.pack = pack;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	public String getFDate() {
		return FDate;
	}
	public void setFDate(String FDate) {
		this.FDate = FDate;
	}
	public String getEDate() {
		return EDate;
	}
	public void setEDate(String EDate) {
		this.EDate = EDate;
	}
	public double getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
}
