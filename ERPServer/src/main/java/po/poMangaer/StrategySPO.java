package po.poMangaer;

import java.io.Serializable;
import java.util.ArrayList;

import vo.voManager.StrategySVO;
 
public class StrategySPO extends StrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//起止时间
	private String FDate;
	private String EDate;
	
	private ArrayList<String> pack;
	private double price;
	
	public StrategySPO(StrategySVO S){
		this.setID(S.getID());
		this.settype(S.gettype());
		this.setFDate(S.getFDate());
		this.setEDate(S.getEDate());
		this.setpack(S.getPack());
		this.setprice(S.getprice());
	}

	public StrategySPO(String Id,String Type,String Fdate,String Edate,ArrayList<String>Pack,double Price){
		ID = Id;
		type = Type;
		FDate = Fdate;
		EDate = Edate;
		pack = Pack;
		price = Price;
	}
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public void setFDate(String fDate) {
		FDate = fDate;
	}

	public String getEDate() {
		return EDate;
	}

	public void setEDate(String eDate) {
		EDate = eDate;
	}

	public ArrayList<String> getpack() {
		return pack;
	}

	public void setpack(ArrayList<String> pack) {
		this.pack = pack;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double d) {
		this.price = d;
	}
}
