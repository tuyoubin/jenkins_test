package data.utility;

public enum FileAttributeIndex {
	GoodsClass_ID(0), GoodsClass_Name(1), GoodsClass_ParentID(2), GoodsClass_Level(3),GoodsClass_GoodsIDList(4),
	
	Goods_ID(0), Goods_Name(1), Goods_Type(2), Goods_Amount(3), Goods_PurchasePrice(4), Goods_RecentPurchasePrice(5), 
	Goods_SalePrice(6), Goods_RecentSalePrice(7), Goods_WarningValue(8), Goods_ClassID(9),
	
	Client_Numbering(0), Client_Classification(1), Client_Level(2), Client_Name(3), Client_PhoneNumber(4), 
	Client_Address(5), Client_Postcode(6), Client_Email(7), Client_ReceivableAmount(8), Client_Receivables(9), 
	Client_ShouldPay(10), Client_AcquiescenceMerchandiser(11),
	
	CompanyAccount_AccountName(0), CompanyAccount_AccountBalance(1);
	
	private int value;
	
	private FileAttributeIndex(int index) {
		this.value = index;
	}
	
	public int index() {return this.value;}
}
