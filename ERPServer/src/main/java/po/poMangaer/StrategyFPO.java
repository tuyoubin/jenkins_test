package po.poMangaer;

import java.io.Serializable;

import vo.voManager.StrategyFVO;

public class StrategyFPO extends StrategyPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public StrategyFPO(StrategyFVO F){
		this.setID(F.getID());
		this.setType(F.gettype());
		this.setFDate(F.getFDate());
		this.setEDate(F.getEDate());
		this.setlevel(F.getlevel());
		this.setdiscount(F.getdiscount());
		this.setgive(F.getgive());
		this.setcoupon(F.getcoupon());
	}
	
	public StrategyFPO(String Id,String Type,String Fdate,String Edate,String Level,double Discount,String Give,int Coupon){
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

	public void setID(String iD) {
		ID = iD;
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

	public void setFDate(String fDate) {
		FDate = fDate;
	}

	public String getEDate() {
		return EDate;
	}

	public void setEDate(String eDate) {
		EDate = eDate;
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
