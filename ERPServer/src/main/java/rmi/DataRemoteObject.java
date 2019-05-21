package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import data.ClientData.ClientDataServiceImpl;
import data.PurchaseNoteData.PurchaseNoteDataServiceImpl;
import data.SaleListData.SaleListDataServiceImpl;
import data.utility.DataObjectFactory;
import dataservice.ClientDataService.ClientDataService;
import dataservice.CompanyAccountDataService.*;
import dataservice.DocumentDataService.DocumentDataService;
import dataservice.FinanceNoteDataService.*;
import dataservice.GoodsClassDataService.GoodsClassDataService;
import dataservice.GoodsDataService.GoodsDataService;
import dataservice.LogDataService.*;
import dataservice.PurchaseNoteDataService.PurchaseNoteDataService;
import dataservice.SaleListDataService.SaleListDataService;
import dataservice.SetBookDataService.*;
import dataservice.StockNoteDataService.StockGiftNoteDataService;
import dataservice.StockNoteDataService.StockLossNoteDataService;
import dataservice.StockNoteDataService.StockOverflowNoteDataService;
import dataservice.StockNoteDataService.StockWarningNoteDataService;
import dataservice.StrategyDataService.GetStrategyService;
import dataservice.StrategyDataService.NewStrategyService;
import dataservice.StrategyDataService.StrategyService;
import dataservice.UserDataService.AdminisDataService;
import dataservice.UserDataService.UserService;
import dataservice.ViewReportDataService.*;

import po.poLog.LogPO;
import po.poMangaer.BusinessSituationPO;
import po.poMangaer.StrategyFPO;
import po.poMangaer.StrategyPO;
import po.poMangaer.StrategySPO;
import po.poMangaer.StrategyTPO;
import po.poUser.AdministratorPO;
import po.poUser.UserPO;
import po.popublic.NotePO;
import po.posale_purchase_client.ClientPO;
import po.posale_purchase_client.PurchaseNotePO;
import po.posale_purchase_client.SaleListPO;
import po.postock.GoodsClassPO;
import po.postock.GoodsPO;
import po.postock.StockGiftNotePO;
import po.postock.StockLossNotePO;
import po.postock.StockOverflowNotePO;
import po.postock.StockWarningNotePO;
import po.potreasurer.BookPO;
import po.potreasurer.CashBillPO;
import po.potreasurer.CompanyAccountPO;
import po.potreasurer.CreditNotePO;
import po.potreasurer.DebitNotePO;
import po.potreasurer.SaleDetailItemPO;
import queryItem.CashBillQueryItem;
import queryItem.CreditNoteQueryItem;
import queryItem.DebitNoteQueryItem;
import queryItem.PurchaseNoteQueryItem;
import queryItem.PurchaseReturnNoteQueryItem;
import queryItem.SaleListQueryItem;
import queryItem.SaleReturnListQueryItem;
import queryItem.StockGiftNoteQueryItem;
import queryItem.StockLossNoteQueryItem;
import queryItem.StockOverflowNoteQueryItem;


public class DataRemoteObject extends UnicastRemoteObject implements 
ClientDataService,PurchaseNoteDataService,SaleListDataService,
CompanyAccountDataService, DebitNoteDataService, CreditNoteDataService, CashBillDataService, ViewSaleDetailDataService, ViewBusinessTrackDataService, ViewBusinessSituationDataService, SetBookDataService,
GoodsClassDataService, GoodsDataService, StockGiftNoteDataService, StockOverflowNoteDataService, StockLossNoteDataService, StockWarningNoteDataService,
LogDataService, DocumentDataService, GetStrategyService, NewStrategyService, StrategyService, AdminisDataService, UserService {
	
	private static final long serialVersionUID = 1L;
	private DataObjectFactory dataObjectFactory;
	
	/*财务人员部分*/
	private CompanyAccountDataService companyAccountData;
	private DebitNoteDataService debitNoteData;
	private CreditNoteDataService creditNoteData;
	private CashBillDataService cashBillData;
	private ViewSaleDetailDataService viewSaleDetailData;
	private ViewBusinessTrackDataService viewBusinessTrackData;
	private ViewBusinessSituationDataService viewBusinessSituationData;
	private SetBookDataService setBookData;
	//进存销售人员部分
	private ClientDataService clientData;
	private PurchaseNoteDataService purchaseNoteData;
	private SaleListDataService saleData;
	/*库存管理人员部分*/
	private GoodsClassDataService goodsClassData;
	private GoodsDataService goodsData;
	private StockGiftNoteDataService giftNoteData;
	private StockOverflowNoteDataService overflowNoteData;
	private StockLossNoteDataService lossNoteData;
	private StockWarningNoteDataService warningNoteData;
	/*管理员部分*/
	private LogDataService logData;
	private AdminisDataService adminsData;
	private UserService userService;
	/*总经理部分*/
	private DocumentDataService documentDataService;
	private GetStrategyService getStrategyService;
	private StrategyService strategyService;
	private NewStrategyService newStrategyService;
	
	
	
	public DataRemoteObject() throws RemoteException {
		
		dataObjectFactory = new DataObjectFactory();
		
		companyAccountData = dataObjectFactory.getCompanyAccountDataObject();
		debitNoteData = dataObjectFactory.getDebitNoteDataObject();
		creditNoteData = dataObjectFactory.getCreditNoteDataObject();
		cashBillData = dataObjectFactory.getCashBillDataObject();
		viewSaleDetailData = dataObjectFactory.getViewSaleDetailDataObject();
		viewBusinessTrackData = dataObjectFactory.getViewBusinessTrackDataObject();
		viewBusinessSituationData = dataObjectFactory.getViewBusinessSituationObject();
		setBookData = dataObjectFactory.getSetBookDataObject();
		
		clientData =new ClientDataServiceImpl();
		purchaseNoteData = new PurchaseNoteDataServiceImpl();
		saleData =new SaleListDataServiceImpl();
		
		goodsClassData = dataObjectFactory.getGoodsClassDataObject();
		goodsData = dataObjectFactory.getGoodsDataObject();
		giftNoteData = dataObjectFactory.getStockGiftNoteDataObject();
		overflowNoteData = dataObjectFactory.getStockOverflowNoteDataObject();
		lossNoteData = dataObjectFactory.getStockLossNoteDataObject();
		warningNoteData = dataObjectFactory.getStockWarningNoteDataObject();
		
		logData = dataObjectFactory.getLogDataObject();
		
		adminsData = dataObjectFactory.getAdminsData();
		userService = dataObjectFactory.getUserData();
		
		documentDataService = dataObjectFactory.getDocumentData();
		getStrategyService = dataObjectFactory.getGetStrategy();
		strategyService = dataObjectFactory.getStrategy();
		newStrategyService = dataObjectFactory.getNewStartegy();
		

	}
	
	
	/**
	 * 财务人员
	 */
	/*账户管理*/
	@Override
	public boolean isExist(CompanyAccountPO account) throws RemoteException {
		return companyAccountData.isExist(account);
	}
	@Override
	public boolean addCompanyAccount(CompanyAccountPO account) throws RemoteException {
		return companyAccountData.addCompanyAccount(account);
	}
	@Override
	public boolean deleteCompanyAccount(CompanyAccountPO account) throws RemoteException {
		return companyAccountData.deleteCompanyAccount(account);
	}
	@Override
	public boolean modifyCompanyAccount(CompanyAccountPO oldAccountState, CompanyAccountPO newAccountState) throws RemoteException {
		return companyAccountData.modifyCompanyAccount(oldAccountState, newAccountState);
	}
	@Override
	public List<CompanyAccountPO> inquiryCompanyAccount(String inquiryInput) throws RemoteException {
		return companyAccountData.inquiryCompanyAccount(inquiryInput);
	}
	@Override
	public CompanyAccountPO getOneCompanyAccount(String accountName) throws RemoteException {
		return companyAccountData.getOneCompanyAccount(accountName);
	}
	/*制定收款单*/
	@Override
	public boolean saveDebitNote(DebitNotePO debitnote) throws RemoteException {
		return debitNoteData.saveDebitNote(debitnote);
	}
	@Override
	public List<DebitNotePO> inquiryDebitNote(DebitNoteQueryItem debitNoteQueryItem) throws RemoteException {
		return debitNoteData.inquiryDebitNote(debitNoteQueryItem);
	}
	@Override
	public List<DebitNotePO> getAllPassedButNotInformedDebitNote() throws RemoteException {
		return debitNoteData.getAllPassedButNotInformedDebitNote();
	}
	@Override
	public boolean setDebitNoteInformed(DebitNotePO debitNote) throws RemoteException {
		return debitNoteData.setDebitNoteInformed(debitNote);
	}
	/*制定付款单*/
	@Override
	public boolean saveCreditNote(CreditNotePO creditnote) throws RemoteException {
		return creditNoteData.saveCreditNote(creditnote);
	}
	@Override
	public List<CreditNotePO> inquiryCreditNote(CreditNoteQueryItem creditNoteQueryitem) throws RemoteException {
		return creditNoteData.inquiryCreditNote(creditNoteQueryitem);
	}
	@Override
	public List<CreditNotePO> getAllPassedButNotInformedCreditNote() throws RemoteException {
		return creditNoteData.getAllPassedButNotInformedCreditNote();
	}
	@Override
	public boolean setCreditNoteInformed(CreditNotePO creditNote) throws RemoteException {
		return creditNoteData.setCreditNoteInformed(creditNote);
	}
	/*制定现金费用单*/
	@Override
	public boolean saveCashBill(CashBillPO cashbill) throws RemoteException {
		return cashBillData.saveCashBill(cashbill);
	}
	@Override
	public List<CashBillPO> inquiryCashBill(CashBillQueryItem cashBillQueryItem) throws RemoteException {
		return cashBillData.inquiryCashBill(cashBillQueryItem);
	}
	@Override
	public List<CashBillPO> getAllPassedButNotInformedCashBill() throws RemoteException {
		return cashBillData.getAllPassedButNotInformedCashBill();
	}
	@Override
	public boolean setCashBillInformed(CashBillPO cashBill) throws RemoteException {
		return cashBillData.setCashBillInformed(cashBill);
	}
	/*查看销售明细表*/
	@Override
	public boolean exportSaleDetail(List<SaleDetailItemPO> saleDetailItemPOList) throws RemoteException {
		return viewSaleDetailData.exportSaleDetail(saleDetailItemPOList);
	}
	/*查看经营历程表*/
	@Override
	public boolean exportBusinessTrack(List<List<NotePO>> allNoteList) throws RemoteException {
		return viewBusinessTrackData.exportBusinessTrack(allNoteList);
	}
	/*查看经营情况表*/
	@Override
	public boolean exportBS(BusinessSituationPO BusinessSituation) throws RemoteException {
		return viewBusinessSituationData.exportBS(BusinessSituation);
	}
	/*期初建账*/
	@Override
	public boolean doesBookExist() throws RemoteException {
		return setBookData.doesBookExist();
	}
	@Override
	public boolean newBook(BookPO bookInfo) throws RemoteException {
		return setBookData.newBook(bookInfo);
	}
	@Override
	public BookPO inquiryBook() throws RemoteException {
		return setBookData.inquiryBook();
	}
	
	/*查看日志*/
	@Override
	public boolean addLog(String date, String activity) throws RemoteException {
		return logData.addLog(date, activity);
	}
	@Override
	public LogPO getLogOfERP() throws RemoteException {
		return logData.getLogOfERP();
	}
	
	
	//客户管理
	public boolean Find(String input) throws RemoteException{
		return clientData.Find(input);
	}
	
	
	public ClientPO ClientInfo(String input)throws RemoteException{
		return clientData.ClientInfo(input);
	}
	
	public  void ClientChange(ClientPO po) throws RemoteException{
		clientData.ClientChange(po);
	}
	
	public void ClientDelete(String id) throws RemoteException{
		clientData.ClientDelete(id);
		
	}
	public void ClientAdd(ClientPO po) throws RemoteException{
		
		clientData.ClientAdd(po);
	}
	
	public ClientPO[] GetAll() throws RemoteException{
		return clientData.GetAll();
	}
	
	//进货单
	public void insert(PurchaseNotePO po) throws RemoteException{
		purchaseNoteData.insert(po);
	}
	
	public void commit(PurchaseNotePO po)throws RemoteException{
		purchaseNoteData.commit(po);
	}
	public PurchaseNotePO[] GetAllPurchaseNote()throws RemoteException{
		return purchaseNoteData.GetAllPurchaseNote();
	}
	public PurchaseNotePO[] GetAllPurchaseReturnNote()throws RemoteException{
		return purchaseNoteData.GetAllPurchaseReturnNote();
	}
	public PurchaseNotePO[] CheckPurchaseNote(String start,String end)throws RemoteException{
		return purchaseNoteData.CheckPurchaseNote(start, end);
	}
	public PurchaseNotePO[] CheckPurchaseReturnNote(String start,String end)throws RemoteException{
		return purchaseNoteData.CheckPurchaseReturnNote(start, end);
	}
	
	public PurchaseNotePO[] CheckPurchaseNote(PurchaseNoteQueryItem item)throws RemoteException{
		
		return purchaseNoteData.CheckPurchaseNote(item);
	}
	
	
	public PurchaseNotePO[] CheckPurchaseReturnNote(PurchaseReturnNoteQueryItem item)throws RemoteException{
		
		return purchaseNoteData.CheckPurchaseReturnNote(item);
	}
	
	//销售单
	public void insert(SaleListPO po) throws RemoteException{
		saleData.insert(po);
	}
	//提交审批
	public void commit(SaleListPO po) throws RemoteException{
		saleData.commit(po);
	}
	//所有已审批过的单据
	public SaleListPO[] GetAllSaleList()throws RemoteException{
		return saleData.GetAllSaleList();
	}
	public SaleListPO[] GetAllSaleReturnList()throws RemoteException{
		return saleData.GetAllSaleReturnList();
	}
	//查询特定时间单据
	public SaleListPO[] CheckSaleList(String start,String end)throws RemoteException{
		return saleData.CheckSaleList(start, end);
	}
	public SaleListPO[] CheckSaleReturnList(String start,String end)throws RemoteException{
		return saleData.CheckSaleReturnList(start, end);
	}
	
	public SaleListPO[] CheckSaleList(SaleListQueryItem  item) throws RemoteException{
		return saleData.CheckSaleList(item);
	}
	public SaleListPO[] CheckSaleReturnList(SaleReturnListQueryItem item) throws RemoteException{
		return saleData.CheckSaleReturnList(item);
	}

	
	//商品分类管理
	@Override
	public List<GoodsClassPO> getAllGoodsClass() throws RemoteException {
		return goodsClassData.getAllGoodsClass();
	}
	@Override
	public GoodsClassPO getClassByID(String ClassID) throws RemoteException {
		return goodsClassData.getClassByID(ClassID);
	}
	@Override
	public boolean newClass(GoodsClassPO classification) throws RemoteException {
		return goodsClassData.newClass(classification);
	}
	@Override
	public boolean modifyClass(GoodsClassPO classification) throws RemoteException {
		return goodsClassData.modifyClass(classification);
	}
	@Override
	public boolean deleteClass(String ClassID) throws RemoteException {
		return goodsClassData.deleteClass(ClassID);
	}

	//商品信息管理
	@Override
	public boolean newGoods(GoodsPO Goods) throws RemoteException {
		return goodsData.newGoods(Goods);
	}
	@Override
	public boolean modifyGoods(GoodsPO Goods) throws RemoteException {
		return goodsData.modifyGoods(Goods);
	}
	@Override
	public boolean deleteGoods(String GoodsID) throws RemoteException {
		return goodsData.deleteGoods(GoodsID);
	}
	@Override
	public List<GoodsPO> getAllGoods() throws RemoteException {
		return goodsData.getAllGoods();
	}
	@Override
	public boolean setStockWarningValue(String ID, int warningValue) throws RemoteException {
		return goodsData.setStockWarningValue(ID, warningValue);
	}
	
	
	//库存赠送单管理
	@Override
	public List<StockGiftNotePO> getAllStockGiftNote() throws RemoteException {
		return giftNoteData.getAllStockGiftNote();
	}
	@Override
	public List<StockGiftNotePO> inquiryStockGiftNote(StockGiftNoteQueryItem stockGiftNoteQueryItem) throws RemoteException{
		return giftNoteData.inquiryStockGiftNote(stockGiftNoteQueryItem);
	}
	@Override
	public boolean saveStockGiftNote(StockGiftNotePO giftNote) throws RemoteException {
		return giftNoteData.saveStockGiftNote(giftNote);
	}		
	
	//库存报溢单管理
	@Override
	public List<StockOverflowNotePO> getAllStockOverflowNote() throws RemoteException {
		return overflowNoteData.getAllStockOverflowNote();
	}
	@Override
	public List<StockOverflowNotePO> inquiryStockOverflowNote(StockOverflowNoteQueryItem stockOverflowNoteQueryItem) throws RemoteException{
		return overflowNoteData.inquiryStockOverflowNote(stockOverflowNoteQueryItem);
	}
	@Override
	public boolean saveStockOverflowNote(StockOverflowNotePO overflowNote) throws RemoteException {
		return overflowNoteData.saveStockOverflowNote(overflowNote);
	}
	
	//库存报损单管理
	@Override
	public List<StockLossNotePO> getAllStockLossNote() throws RemoteException {
		return lossNoteData.getAllStockLossNote();
	}
	@Override
	public List<StockLossNotePO> inquiryStockLossNote(StockLossNoteQueryItem stockLossNoteQueryItem) throws RemoteException{
		return lossNoteData.inquiryStockLossNote(stockLossNoteQueryItem);
	}
	@Override
	public boolean saveStockLossNote(StockLossNotePO lossNote) throws RemoteException {
		return lossNoteData.saveStockLossNote(lossNote);
	}
	
	//库存报警单管理
	@Override
	public List<StockWarningNotePO> getAllStockWarningNote() throws RemoteException {
		return warningNoteData.getAllStockWarningNote();
	}
	@Override
	public boolean saveStockWarningNote(StockWarningNotePO warningNote) throws RemoteException {
		return warningNoteData.saveStockWarningNote(warningNote);
	}


	@Override
	public SaleListPO[] GetAllPendingSaleList() throws RemoteException {
		return saleData.GetAllPendingSaleList();
	}


	@Override
	public void deletePendingSaleList(SaleListPO po) throws RemoteException {
		saleData.deletePendingSaleList(po);
	}


	@Override
	public PurchaseNotePO[] GetAllPendingPurchaseNote() throws RemoteException {
		
		return purchaseNoteData.GetAllPendingPurchaseNote();
	}


	@Override
	public void deletePendingPurchaseNote(PurchaseNotePO po) throws RemoteException {
		purchaseNoteData.deletePendingPurchaseNote(po);
	}


	@Override
	public boolean newUser(UserPO User) throws RemoteException {
		return userService.newUser(User);
	}


	@Override
	public boolean deleteUser(String ID) throws RemoteException {
		return userService.deleteUser(ID);
	}


	@Override
	public ArrayList<UserPO> getAllUser() throws RemoteException {
		return userService.getAllUser();
	}


	@Override
	public UserPO Login(String ID, String PassWord) throws RemoteException {
		return userService.Login(ID, PassWord);
	}


	@Override
	public AdministratorPO getADPO() throws RemoteException {
		return adminsData.getADPO();
	}


	@Override
	public boolean reviseAD(AdministratorPO ADPO) throws RemoteException {
		return adminsData.reviseAD(ADPO);
	}


	@Override
	public ArrayList<StrategyFPO> getStrategyF(String Time) throws RemoteException {
		return strategyService.getStrategyF(Time);
	}


	@Override
	public ArrayList<StrategySPO> getStrategyS(String Time) throws RemoteException {
		return strategyService.getStrategyS(Time);
	}


	@Override
	public ArrayList<StrategyTPO> getStrategyT(String Time) throws RemoteException {
		return strategyService.getStrategyT(Time);
	}


	@Override
	public boolean newFStrategy(StrategyFPO Strategy) throws RemoteException {
		return newStrategyService.newFStrategy(Strategy);
	}


	@Override
	public boolean newSStrategy(StrategySPO Strategy) throws RemoteException {
		return newStrategyService.newSStrategy(Strategy);
	}


	@Override
	public boolean newTStrategy(StrategyTPO Strategy) throws RemoteException {
		return newStrategyService.newTStrategy(Strategy);
	}


	@Override
	public ArrayList<String> getAllStrategy() throws RemoteException {
		return getStrategyService.getAllStrategy();
	}


	@Override
	public StrategyPO getStrategy(String ID) throws RemoteException {
		return getStrategyService.getStrategy(ID);
	}


	@Override
	public boolean deleteStrategy(String ID) throws RemoteException {
		return getStrategyService.deleteStrategy(ID);
	}



	@Override
	public ArrayList<NotePO> getAll() throws RemoteException {
		return documentDataService.getAll();
	}



	@Override
	public boolean submitDoc(NotePO Note) throws RemoteException {
		return documentDataService.submitDoc(Note);
	}


	@Override
	public boolean AdminLogin(String ID, String PassWord) throws RemoteException {
		return adminsData.AdminLogin(ID, PassWord);
	}


	@Override
	public boolean ApprovalDoc(NotePO Note) throws RemoteException {
		// TODO Auto-generated method stub
		return documentDataService.ApprovalDoc(Note);
	}


	@Override
	public boolean NoPassDoc(NotePO Note) throws RemoteException {
		// TODO Auto-generated method stub
		return documentDataService.NoPassDoc(Note);
	}

}
