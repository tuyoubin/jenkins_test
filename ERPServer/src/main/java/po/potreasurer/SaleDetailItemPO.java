package po.potreasurer;

import java.io.Serializable;

import vo.votreasurer.SaleDetailItemVO;

/**
 * 销售明细表项目
 * @author CharlieLei
 *
 */
public class SaleDetailItemPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//时间
	private String time;
	//商品编号
	private String goodsNumber;
	//商品名
	private String goodsName;
	//型号
	private String typeName;
	//数量
	private int amount;
	//单价
	private double unitPrice;
	//总额
	private double totalPrice;

	public SaleDetailItemPO(String time, String goodsNumber, String goodsname, String typename, double unitprice) {
		this.time = time;
		this.goodsNumber = goodsNumber;
		this.goodsName = goodsname;
		this.typeName = typename;
		this.amount = 0;
		this.unitPrice = unitprice;
		this.totalPrice = 0;
	}
	public SaleDetailItemPO(String time, String goodsNumber, String goodsname, String typename, int amount, double unitprice, double totalPrice) {
		this.time = time;
		this.goodsNumber = goodsNumber;
		this.goodsName = goodsname;
		this.typeName = typename;
		this.amount = amount;
		this.unitPrice = unitprice;
		this.totalPrice = totalPrice;
	}
	
	public SaleDetailItemVO toVO() {
		SaleDetailItemVO vo = new SaleDetailItemVO(this.time, this.goodsNumber, this.goodsName, this.typeName, this.unitPrice);
		vo.setAmount(this.amount);
		vo.setTotalPrice(this.totalPrice);
		return vo;
	}
	
	public void setAmount(int amount) {this.amount = amount;}
	public void addAmount(int addAmount) {this.amount += addAmount;}
	public void deleteAmount(int deleteAmount) {this.amount -= deleteAmount;}
	public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}
	public void setTotalPrice(double totalPrice) {this.totalPrice = totalPrice;}
	public void addTotalPrice(double addTotalPrice) {this.totalPrice += addTotalPrice;}
	public void deleteTotalPrice(double deleteTotalPrice) {this.totalPrice -= deleteTotalPrice;}

	public String getTime() {return this.time;}
	public String getGoodsNumber() {return this.goodsNumber;}
	public String getGoodsName() {return this.goodsName;}
	public String getTypeName() {return this.typeName;}
	public int getAmount() {return this.amount;}
	public double getUnitPrice() {return this.unitPrice;}
	public double getTotalPrice() {return this.totalPrice;}
}
