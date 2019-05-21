package vo.voManager;

import po.poMangaer.StrategyFPO;

public class StrategyFVO {
	private String ID;
	
	private String type;
	//起止时间
	private String FDate;
	private String EDate;
	
	//客户等级
	private String level;
	
	//价格折让
	private double discount;
		
	//赠品
	private String give;
		
	//代金券
	private int coupon;
	
	public StrategyFVO(StrategyFPO F){
		this.ID = F.getID();
		this.type = F.getType();
		this.FDate = F.getFDate();
		this.EDate = F.getEDate();
		this.level = F.getlevel();
		this.discount = F.getdiscount();
		this.give = F.getgive();
		this.coupon = F.getcoupon();
	}
	
	public StrategyFVO(String Id,String Type,String Fdate,String Edate,String Level,double Discount,String Give,int Coupon){
		ID = Id;
		type = Type;
		FDate = Fdate;
		EDate = Edate;
		level = Level;
		discount = Discount;
		give = Give;
		coupon = Coupon;
		
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

	public String getlevel() {
		return level;
	}

	public void setlevel(String level) {
		this.level = level;
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

	public int getcoupon() {
		return coupon;
	}

	public void setcoupon(int coupon) {
		this.coupon = coupon;
	}
	
}
