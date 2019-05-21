package data.utility;

public enum SQLAttributeIndex {
	CompanyAccount_AccountName(1), CompanyAccount_AccountBalance(2),
	
	DebitNote_NoteNumber(1), DebitNote_SellerName(2), DebitNote_UserID(3), DebitNote_TransferListItemNum(4), DebitNote_AccountNameList(5),
	DebitNote_TransferAmountList(6), DebitNote_RemarkList(7), DebitNote_TotalAmount(8), DebitNote_IsPassed(9), DebitNote_IsInformed(10),
	
	CreditNote_NoteNumber(1), CreditNote_SupplierName(2), CreditNote_UserID(3), CreditNote_TransferListItemNum(4), CreditNote_AccountNameList(5),
	CreditNote_TransferAmountList(6), CreditNote_RemarkList(7), CreditNote_TotalAmount(8), CreditNote_IsPassed(9), CreditNote_IsInformed(10),
	
	CashBill_NoteNumber(1), CashBill_UserID(2), CashBill_AccountName(3), CashBill_ExpenseAccountItemNum(4), CashBill_ItemNameList(5), 
	CashBill_AmountList(6), CashBill_RemarkList(7), CashBill_TotalAmount(8), CashBill_IsPassed(9), CashBill_IsInformed(10),
	
	
	StockOverflowNote_NoteNumber(1), StockOverflowNote_UserID(2), StockOverflowNote_GoodsListItemNum(3) , StockOverflowNote_GoodsIDList(4), 
	StockOverflowNote_GoodsNameList(5), StockOverflowNote_StockAmounts(6), StockOverflowNote_RealAmounts(7), StockOverflowNote_IsPassed(8),
	
	StockLossNote_NoteNumber(1), StockLossNote_UserID(2), StockLossNote_GoodsListItemNum(3), StockLossNote_GoodsIDList(4), 
	StockLossNote_GoodsNameList(5), StockLossNote_StockAmounts(6), StockLossNote_RealAmounts(7), StockLossNote_IsPassed(8),
	
	StockGiftNote_NoteNumber(1), StockGiftNote_UserID(2), StockGiftNote_GoodsListItemNum(3), StockGiftNote_GoodsIDList(4),
	StockGiftNote_GoodsNameList(5), StockGiftNote_TypeList(6), StockGiftNote_Amounts(7), StockGiftNote_State(8),
	
	StockWarningNote_NoteNumber(1), StockWarningNote_GoodsID(2), StockWarningNote_GoodsName(3), StockWarningNote_WarningNum(4),
	
	
	PurchaseNote_State(1), PurchaseNote_ListNumbering(2), PurchaseNote_Provider(3), PurchaseNote_Storehouse(4),
	PurchaseNote_OperatorID(5), PurchaseNote_Remark(6), PurchaseNote_Total(7),
	
	SaleList_State(1), SaleList_ListNumbering(2), SaleList_Client(3), SaleList_Storehouse(4), SaleList_Merchandiser(5), SaleList_OperatorID(6),
	SaleList_Remark(7), SaleList_TBD(8), SaleList_Discount(9), SaleList_Voucher(10), SaleList_Total(11), SaleList_Dis(12),
	
	ListOfGoods_StateList(1), ListOfGoods_NumberingList(2), ListOfGoods_NameList(3), ListOfGoods_TypeList(4), ListOfGoods_NumList(5),
	ListOfGoods_UnitPriceList(6), ListOfGoods_TotalPriceList(7), ListOfGoods_RemarkList(8), ListOfGoods_AllTotal(9),
	
	
	Log_Date(1), Log_Activity(2);
	
	private int value;
	
	private SQLAttributeIndex(int index) {
		this.value = index;
	}
	
	public int index() {return this.value;}
}
