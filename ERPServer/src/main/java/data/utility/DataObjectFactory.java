package data.utility;

import java.rmi.RemoteException;

import data.CompanyAccountData.CompanyAccountDataImpl;
import data.DocumentData.DocumentDataImpl;
import data.FinanceNoteData.CashBillDataImpl;
import data.FinanceNoteData.CreditNoteDataImpl;
import data.FinanceNoteData.DebitNoteDataImpl;
import data.GoodsClassData.GoodsClassDataImpl;
import data.GoodsData.GoodsDataImpl;
import data.LogData.LogDataImpl;
import data.SetBookData.SetBookDataImpl;
import data.StockNoteData.StockGiftNoteDataImpl;
import data.StockNoteData.StockLossNoteDataImpl;
import data.StockNoteData.StockOverflowNoteDataImpl;
import data.StockNoteData.StockWarningNoteDataImpl;
import data.StrategyData.GetStrategyImpl;
import data.StrategyData.NewStrategyImpl;
import data.StrategyData.StrategyImpl;
import data.UserData.AdministratorDataImpl;
import data.UserData.UserImpl;
import data.ViewReportData.ViewBusinessSituation.ViewBusinessSituationDataImpl;
import data.ViewReportData.ViewBusinessTrackData.ViewBusinessTrackDataImpl;
import data.ViewReportData.ViewSaleDetailData.ViewSaleDetailDataImpl;
import dataservice.CompanyAccountDataService.CompanyAccountDataService;
import dataservice.DocumentDataService.DocumentDataService;
import dataservice.FinanceNoteDataService.CashBillDataService;
import dataservice.FinanceNoteDataService.CreditNoteDataService;
import dataservice.FinanceNoteDataService.DebitNoteDataService;
import dataservice.GoodsClassDataService.GoodsClassDataService;
import dataservice.GoodsDataService.GoodsDataService;
import dataservice.LogDataService.LogDataService;
import dataservice.SetBookDataService.SetBookDataService;
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

/**
 * Data对象工厂
 * @author CharlieLei
 *
 */
public class DataObjectFactory {

	public DataObjectFactory() {}
	
	
	/*财务人员*/
	public CompanyAccountDataService getCompanyAccountDataObject() {
//		return new CompanyAccountDataStub();
		return new CompanyAccountDataImpl();
	}
	public DebitNoteDataService getDebitNoteDataObject(){
//		return new DebitNoteDataStub();
		return new DebitNoteDataImpl();
	}
	public CreditNoteDataService getCreditNoteDataObject() {
//		return new CreditNoteDataStub();
		return new CreditNoteDataImpl();
	}
	public CashBillDataService getCashBillDataObject() {
//		return new CashBillDataStub();
		return new CashBillDataImpl();
	}
	public ViewSaleDetailDataService getViewSaleDetailDataObject() {
//		return new ViewSaleDetailDataStub();
		return new ViewSaleDetailDataImpl();
	}
	public ViewBusinessTrackDataService getViewBusinessTrackDataObject() {
//		return new ViewBusinessTrackDataStub();
		return new ViewBusinessTrackDataImpl();
	}
	public ViewBusinessSituationDataService getViewBusinessSituationObject() {
		return new ViewBusinessSituationDataImpl();
	}
	public SetBookDataService getSetBookDataObject() {
//		return new SetBookDataStub();
		return new SetBookDataImpl();
	}
	
	
	/* 库存管理人员*/
	public GoodsClassDataService getGoodsClassDataObject() throws RemoteException{
		return new GoodsClassDataImpl();
	}	
	public GoodsDataService getGoodsDataObject(){
		return new GoodsDataImpl();
	}	
	public StockGiftNoteDataService getStockGiftNoteDataObject(){
		return new StockGiftNoteDataImpl();
	}	
	public StockOverflowNoteDataService getStockOverflowNoteDataObject(){
		return new StockOverflowNoteDataImpl();
	}	
	public StockLossNoteDataService getStockLossNoteDataObject(){
		return new StockLossNoteDataImpl();
	}
	public StockWarningNoteDataService getStockWarningNoteDataObject(){
		return new StockWarningNoteDataImpl();
	}
	
	
	
	/*管理员部分*/
	public LogDataService getLogDataObject(){
//		return new LogDataStub();
		return new LogDataImpl();
	}
	public AdminisDataService getAdminsData(){
		return new AdministratorDataImpl();
	}
	public UserService getUserData(){
		return new UserImpl();
	}
	
	/*总经理部分*/
	public DocumentDataService getDocumentData(){
		return new DocumentDataImpl();
	}
	public GetStrategyService getGetStrategy(){
		return new GetStrategyImpl();
	}
	public NewStrategyService getNewStartegy(){
		return new NewStrategyImpl();
	}
	public StrategyService getStrategy(){
		return new StrategyImpl();
	}
	
	

}
