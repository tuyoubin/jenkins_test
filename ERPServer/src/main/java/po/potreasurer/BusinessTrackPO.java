package po.potreasurer;

import java.io.Serializable;
import java.util.List;

import po.posale_purchase_client.PurchaseNotePO;
import po.posale_purchase_client.SaleListPO;
import po.postock.StockGiftNotePO;
import po.postock.StockLossNotePO;
import po.postock.StockOverflowNotePO;

/**
 * 经营历程表PO
 * @author CharlieLei
 *
 */
public class BusinessTrackPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public List<SaleListPO> saleListList;
	public List<SaleListPO> saleReturnListList;
	public List<PurchaseNotePO> purchaseNoteList;
	public List<PurchaseNotePO> purchaseReturnNoteList;
	
	public List<DebitNotePO> debitNoteList;
	public List<CreditNotePO> credtiNoteList;
	public List<CashBillPO> cashBillList;

	public List<StockGiftNotePO> stockGiftNoteList;
	public List<StockLossNotePO> stockLossNoteList;
	public List<StockOverflowNotePO> stockOverflowNoteList;
	
	public BusinessTrackPO() {
		// TODO Auto-generated constructor stub
	}

}
