package po.poMangaer;

import java.io.Serializable;

import vo.voManager.StrategyTVO;

public class StrategyTPO extends StrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//起止时间
	private String FDate;
	private String EDate;
	
	//总价
	private int dprice;
	private int gprice;
	
	//价格折让
	private double discount;
	
	//赠品
	private String give;
	
	public StrategyTPO(StrategyTVO T){
		this.setID(T.getID());
		this.settype(T.getType());
		this.setFDate(T.getFDate());
		this.setEDate(T.getEDate());
		this.setdprice(T.getDprice());
		this.setGprice(T.getGprice());
		this.setdiscount(T.getdiscount());
		this.setgive(T.getgive());
	}
	
	public StrategyTPO(String Id,String Type,String Fdate,String Edate,int Dprice,int Gprice,double Discount,String Give){
		ID = Id;
		type = Type;
	    FDate = Fdate;
	    EDate = Edate;
	    dprice = Dprice;
	    gprice = Gprice;
	    discount = Discount;
	    give = Give;
	    
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

	public int getdprice() {
		return dprice;
	}

	public void setdprice(int zprice) {
		this.dprice = zprice;
	}

	public double getdiscount() {
		return discount;
	}

	public void setdiscount(double discount) {
		this.discount = discount;
	}

	public String getgive() {
		return give;
	}

	public void setgive(String give) {
		this.give = give;
	}

	public int getGprice() {
		return gprice;
	}

	public void setGprice(int gprice) {
		this.gprice = gprice;
	}
}
