package vo.voManager;

import po.poMangaer.StrategyTPO;

public class StrategyTVO {
	private String ID;
	
	private String type;
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
	
	public StrategyTVO(StrategyTPO T){
		this.ID = T.getID();
		this.type = T.gettype();
		this.FDate = T.getFDate();
		this.EDate = T.getEDate();
		this.dprice = T.getdprice();
		this.gprice = T.getGprice();
		this.discount = T.getdiscount();
		this.give = T.getgive();
	}
	
	public StrategyTVO(String Id,String Type,String Fdate,String Edate,int Dprice,int Gprice,double Discount,String Give){
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

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
	public int getDprice() {
		return dprice;
	}
	public void setDprice(int dprice) {
		this.dprice = dprice;
	}
}
