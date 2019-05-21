package vo.vostock;

public class StockViewVO {
    
    //入库数量
    int inAmounts;
    
    //入库金额
    double inMoney;
    
    //出库数量
    int outAmounts;
    
    //出库金额
    double outMoney;
    
    //进货数量
    int purchaseAmounts;

	//进货金额
    double purchaseMoney;
    
    //销售数量
    int saleAmounts;
    
    //销售金额
    double saleMoney;
    
    //合计
    int sum;
    
    public int getInAmounts() {
		return inAmounts;
	}

	public double getInMoney() {
		return inMoney;
	}

	public int getOutAmounts() {
		return outAmounts;
	}

	public double getOutMoney() {
		return outMoney;
	}

	public int getPurchaseAmounts() {
		return purchaseAmounts;
	}

	public double getPurchaseMoney() {
		return purchaseMoney;
	}

	public int getSaleAmounts() {
		return saleAmounts;
	}

	public double getSaleMoney() {
		return saleMoney;
	}

	public int getSum() {
		return sum;
	}
	
	public StockViewVO(int inAmounts, double inMoney, int outAmounts, double outMoney,
			int purchaseAmounts, double purchaseMoney,  int saleAmounts, double saleMoney){
		this.inAmounts = inAmounts;
		this.inMoney = inMoney;
		this.outAmounts = outAmounts;
		this.outMoney = outMoney;
		this.purchaseAmounts = purchaseAmounts;
		this.purchaseMoney = purchaseMoney;
		this.saleAmounts = saleAmounts;
		this.saleMoney = saleMoney;
	}

}
