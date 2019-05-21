package po.postock;
import java.io.Serializable;


import vo.vostock.GoodsVO;

/**
 * 商品项
 * 每一项商品仅设定一种型号，一组数据
 * 删除了商品属性：生产日期，批次，批号
 */
public class GoodsPO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8769616462410237556L;

	//编号
	private String ID;
	
	//名称
	private String name;
	
	//型号	
	private String type;
	
	//数量
	private int amount;
		
	//进价
	private double purchasePrice;
	
	//最近进价
	private double recentPurchasePrice;
	
	//售价
	private double salePrice;
	
	//最近售价
	private double recentSalePrice;
	
	//警戒值
	private int warningValue;
	
	//商品所属分类的编号
	private String classID;
	   
	
	// 下面的方法用以获取商品的各项属性
	
    public String getID(){
    	return ID;
    }
    
    public String getName(){
    	return name;
    }
    
    public String getType(){
    	return type;
    }
    
    public int getAmount(){
    	return amount;
    }
      
    public double getPurchasePrice(){
    	return purchasePrice;
    }
    
    public double getRecentPurchasePrice(){
    	return recentPurchasePrice;
    }
    
    public double getSalePrice(){
    	return salePrice;
    }
    
    public double getRecentSalePrice(){
    	return recentSalePrice;
    }
    
    public int getWarningValue(){
    	return warningValue;
    }
    
    public String getClassID(){
    	return classID;
    }
    
    // 下面的方法用于更改商品的各项属性
    
	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setRecentPurchasePrice(double recentPurchasePrice) {
		this.recentPurchasePrice = recentPurchasePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public void setRecentSalePrice(double recentSalePrice) {
		this.recentSalePrice = recentSalePrice;
	}

	public void setWarningValue(int warningValue) {
		this.warningValue = warningValue;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

    
    // 商品持续化对象的构造方法
    public GoodsPO(String ID, String name, String type, int amount, double purchasePrice,double recentPurchasePrice,
            double salePrice, double recentSalePrice, int warningValue, String classID) {
    	this.ID = ID;
    	this.name = name;
    	this.type = type;
    	this.amount = amount;
    	this.purchasePrice = purchasePrice;
    	this.recentPurchasePrice = recentPurchasePrice;
    	this.salePrice = salePrice;
    	this.recentSalePrice = recentSalePrice;
    	this.warningValue = warningValue;
    	this.classID = classID;
    	}
    
    
    public GoodsVO toVO(){
    	GoodsVO vo = new GoodsVO(ID,name,type,amount,purchasePrice,recentPurchasePrice,
    			salePrice,recentSalePrice,warningValue,classID);
    	return vo;
    }
}
