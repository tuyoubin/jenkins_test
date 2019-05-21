package data.DocumentData;

import java.util.List;

import data.noteSQLModule.noteSQLDeleter.CashBillSQLDeleter;
import data.noteSQLModule.noteSQLDeleter.CreditNoteSQLDeleter;
import data.noteSQLModule.noteSQLDeleter.DebitNoteSQLDeleter;
import data.noteSQLModule.noteSQLDeleter.StockLossNoteSQLDeleter;
import data.noteSQLModule.noteSQLDeleter.StockOverflowNoteSQLDeleter;
import data.noteSQLModule.noteSQLGetter.CashBillSQLGetter;
import data.noteSQLModule.noteSQLGetter.CreditNoteSQLGetter;
import data.noteSQLModule.noteSQLGetter.DebitNoteSQLGetter;
import data.noteSQLModule.noteSQLGetter.StockLossNoteSQLGetter;
import data.noteSQLModule.noteSQLGetter.StockOverflowNoteSQLGetter;
import data.noteSQLModule.noteSQLWriter.CashBillSQLWriter;
import data.noteSQLModule.noteSQLWriter.CreditNoteSQLWriter;
import data.noteSQLModule.noteSQLWriter.DebitNoteSQLWriter;
import data.noteSQLModule.noteSQLWriter.StockLossNoteSQLWriter;
import data.noteSQLModule.noteSQLWriter.StockOverflowNoteSQLWriter;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DocumentDataService.DocumentDataService;
import po.popublic.NotePO;
import po.postock.StockLossNotePO;
import po.postock.StockOverflowNotePO;
import po.potreasurer.CashBillPO;
import po.potreasurer.CreditNotePO;
import po.potreasurer.DebitNotePO;

public class DocumentDataImpl implements DocumentDataService{
	

	//数据库名
	private String ManagerDataBaseName = "Manager";
	
	//获取单据数据
	private CreditNoteSQLGetter Credit = new CreditNoteSQLGetter(ManagerDataBaseName);
	private DebitNoteSQLGetter Debit = new DebitNoteSQLGetter(ManagerDataBaseName);
	private StockLossNoteSQLGetter StockLoss = new StockLossNoteSQLGetter(ManagerDataBaseName);
	private StockOverflowNoteSQLGetter StockOverflow = new StockOverflowNoteSQLGetter(ManagerDataBaseName);
	private CashBillSQLGetter Cash = new CashBillSQLGetter(ManagerDataBaseName);
	
	//删除单据数据
	private CreditNoteSQLDeleter DeCredit = new CreditNoteSQLDeleter(ManagerDataBaseName);
	private DebitNoteSQLDeleter DeDebit = new DebitNoteSQLDeleter(ManagerDataBaseName);
	private StockLossNoteSQLDeleter DeStockLoss = new StockLossNoteSQLDeleter(ManagerDataBaseName);
	private StockOverflowNoteSQLDeleter DeStockOverflow = new StockOverflowNoteSQLDeleter(ManagerDataBaseName);
	private CashBillSQLDeleter DeCash = new CashBillSQLDeleter(ManagerDataBaseName);
	
	//提交单据数据
	private CreditNoteSQLWriter SuCredit = new CreditNoteSQLWriter(ManagerDataBaseName);
	private DebitNoteSQLWriter SuDebit = new DebitNoteSQLWriter(ManagerDataBaseName);
	private StockLossNoteSQLWriter SuStockLoss = new StockLossNoteSQLWriter(ManagerDataBaseName);
	private StockOverflowNoteSQLWriter SuStockOver = new StockOverflowNoteSQLWriter(ManagerDataBaseName);
	private CashBillSQLWriter SuCash = new CashBillSQLWriter(ManagerDataBaseName);
	@Override
	public ArrayList<NotePO> getAll() throws RemoteException {
		//获取所有单据
		// TODO Auto-generated method stub
		ArrayList<NotePO> result = new ArrayList<NotePO>();
		
		List<NotePO> credit = Credit.getNoteList();
		for(int i = 0;i < credit.size();i++)
			result.add(credit.get(i));
		
		List<NotePO> debit = Debit.getNoteList();
		for(int i = 0;i < debit.size();i++)
			result.add(debit.get(i));
		
		List<NotePO> stockLoss = StockLoss.getNoteList();
		for(int i = 0;i < stockLoss.size();i++)
			result.add(stockLoss.get(i));
		
		List<NotePO> stockOverflow = StockOverflow.getNoteList();
		for(int i = 0;i < stockOverflow.size();i++)
			result.add(stockOverflow.get(i));
		
		List<NotePO> cash = Cash.getNoteList();
		for(int i = 0;i < cash.size();i++)
			result.add(cash.get(i));
		return result;
	}

	@Override
	public boolean ApprovalDoc(NotePO Note) throws RemoteException {
		//通过审批、保存单据、更改库存等数据
		// TODO Auto-generated method stub
		boolean result = false;
		if(Note instanceof CreditNotePO){
			boolean a = (DeCredit.delete(Note));
			((CreditNotePO) Note).passTheApproval();
			result = a;
		}
		else if(Note instanceof DebitNotePO){
			boolean a = DeDebit.delete(Note);
			((DebitNotePO) Note).passTheApproval();
			result = a;
		}
		else if(Note instanceof StockLossNotePO){
			boolean a = DeStockLoss.delete(Note);
			((StockLossNotePO) Note).setisPassed();
			result = a;
		}
		else if(Note instanceof StockOverflowNotePO){
			boolean a = DeStockOverflow.delete(Note);
			((StockOverflowNotePO) Note).setisPassed();
			result = a;
		}
		else if(Note instanceof CashBillPO){
			boolean a = DeCash.delete(Note);
			((CashBillPO)Note).isPassed();
			result = a;
		}
		
		return result;
	}

	@Override
	public boolean submitDoc(NotePO Note) throws RemoteException {
		//提交单据
		// TODO Auto-generated method stub
		boolean result = false;
		if(Note instanceof CreditNotePO){
			result = SuCredit.saveNote(Note);
		}
		else if(Note instanceof DebitNotePO){
			result = SuDebit.saveNote(Note);
		}
		else if(Note instanceof StockLossNotePO){
			result = SuStockLoss.saveNote(Note);
		}
		else if(Note instanceof StockOverflowNotePO){
			result = SuStockOver.saveNote(Note);
		}
		else if(Note instanceof CashBillPO){
			result = SuCash.saveNote(Note);
		}
		return result;
	}

	@Override
	public boolean NoPassDoc(NotePO Note) throws RemoteException {
		//不通过审批
		// TODO Auto-generated method stub
		boolean result = false;
		if(Note instanceof CreditNotePO){
			boolean a = (DeCredit.delete(Note));
			result = a;
		}
		else if(Note instanceof DebitNotePO){
			boolean a = DeDebit.delete(Note);
			result = a;
		}
		else if(Note instanceof StockLossNotePO){
			boolean a = DeStockLoss.delete(Note);
			((StockLossNotePO) Note).setisPassed();
			result = a;
		}
		else if(Note instanceof StockOverflowNotePO){
			boolean a = DeStockOverflow.delete(Note);
			result = a;
		}
		else if(Note instanceof CashBillPO){
			boolean a = DeCash.delete(Note);
			result = a;
		}
		
		return result;
	}

}
