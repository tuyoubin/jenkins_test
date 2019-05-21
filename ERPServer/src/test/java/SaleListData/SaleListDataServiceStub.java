package SaleListData;

import java.rmi.RemoteException;


import dataservice.SaleListDataService.SaleListDataService;
import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.SaleListPO;
import queryItem.SaleListQueryItem;
import queryItem.SaleReturnListQueryItem;
import vo.vosale_purchase_client.SaleListVO;

public class SaleListDataServiceStub implements SaleListDataService{

	public double Caculate(SaleListVO vo) throws RemoteException {
		
		return 10;
	}

	public double[] CaculateEach(SaleListVO vo) throws RemoteException {
		double[] result =new double[10];
		for(int i=0;i<10;i++){
			result[i] =10;
		}
		return result;
		
	}

	public double CaculateBeforeDiscount(SaleListVO vo) throws RemoteException {
		
		return 0;
	}

	@Override
	public void commit(SaleListPO po) throws RemoteException {
		System.out.println("commited");
		
	}

	public boolean DiscountIsValid(double d, String potence) throws RemoteException {
		
		return true;
	}

	public void deal(SaleListPO po) throws RemoteException {
		
		System.out.println("dealt");
	}

	public void save(SaleListPO Po) throws RemoteException {
		System.out.println("saved");
		
	}

	@Override
	public SaleListPO[] GetAllSaleList() throws RemoteException {
		String[] state ={""};
		 String[] numbering ={"0001"};
		 String[] NameOfGoods = {"崩坏三台灯"};
		 String[] type = {"small"};
		  int[] num = {2};  
		  double[] unit_price={33.8};
		  double[] total = {0};
		 String[] remark ={"hehe"};
		 double all_total = 67.6;
		ListOfGoodsPO goods = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		ListOfGoodsPO gifts = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		 String state1 ="";
		 String ListNumbering = "XXD##-20171222-102346";
		 String client = "李四";
		 String storehouse ="1";
		 String merchandiser = "12138";
		 String operator_id  = "233";
		 String  remark1  = "没有";
		 double Total_Before_Discount =67.6;
		 double discount = 1;
		 double voucher  = 1;
		 double Total = 64.6;
		 
		 
		 double dis = 1;
		 SaleListPO po =new SaleListPO(state1,ListNumbering,client,storehouse, merchandiser,operator_id,
				remark1,Total_Before_Discount,discount, voucher,Total,goods,gifts,dis);
		 
		 SaleListPO[] result =new SaleListPO[1];
		 result[0] = po;
		 return result;
	}

	@Override
	public SaleListPO[] GetAllSaleReturnList() throws RemoteException {
		String[] state ={""};
		 String[] numbering ={"0001"};
		 String[] NameOfGoods = {"崩坏三台灯"};
		 String[] type = {"small"};
		  int[] num = {2};  
		  double[] unit_price={33.8};
		  double[] total = {0};
		 String[] remark ={"hehe"};
		 double all_total = 67.6;
		ListOfGoodsPO goods = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		ListOfGoodsPO gifts = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		 String state1 ="";
		 String ListNumbering = "XXD##-20171222-102346";
		 String client = "李四";
		 String storehouse ="1";
		 String merchandiser = "12138";
		 String operator_id  = "233";
		 String  remark1  = "没有";
		 double Total_Before_Discount =67.6;
		 double discount = 1;
		 double voucher  = 1;
		 double Total = 64.6;
		 
		 
		 double dis = 1;
		 SaleListPO po =new SaleListPO(state1,ListNumbering,client,storehouse, merchandiser,operator_id,
				remark1,Total_Before_Discount,discount, voucher,Total,goods,gifts,dis);
		 
		 SaleListPO[] result =new SaleListPO[1];
		 result[0] = po;
		 return result;
	}

	@Override
	public SaleListPO[] CheckSaleList(String start, String end) throws RemoteException {
		String[] state ={""};
		 String[] numbering ={"0001"};
		 String[] NameOfGoods = {"崩坏三台灯"};
		 String[] type = {"small"};
		  int[] num = {2};  
		  double[] unit_price={33.8};
		  double[] total = {0};
		 String[] remark ={"hehe"};
		 double all_total = 67.6;
		ListOfGoodsPO goods = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		ListOfGoodsPO gifts = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		 String state1 ="";
		 String ListNumbering = "XXD##-20171222-102346";
		 String client = "李四";
		 String storehouse ="1";
		 String merchandiser = "12138";
		 String operator_id  = "233";
		 String  remark1  = "没有";
		 double Total_Before_Discount =67.6;
		 double discount = 1;
		 double voucher  = 1;
		 double Total = 64.6;
		 
		 
		 double dis = 1;
		 SaleListPO po =new SaleListPO(state1,ListNumbering,client,storehouse, merchandiser,operator_id,
				remark1,Total_Before_Discount,discount, voucher,Total,goods,gifts,dis);
		 
		 SaleListPO[] result =new SaleListPO[1];
		 result[0] = po;
		 return result;
	}

	@Override
	public SaleListPO[] CheckSaleReturnList(String start, String end) throws RemoteException {
		String[] state ={""};
		 String[] numbering ={"0001"};
		 String[] NameOfGoods = {"崩坏三台灯"};
		 String[] type = {"small"};
		  int[] num = {2};  
		  double[] unit_price={33.8};
		  double[] total = {0};
		 String[] remark ={"hehe"};
		 double all_total = 67.6;
		ListOfGoodsPO goods = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		ListOfGoodsPO gifts = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		 String state1 ="";
		 String ListNumbering = "XXD##-20171222-102346";
		 String client = "李四";
		 String storehouse ="1";
		 String merchandiser = "12138";
		 String operator_id  = "233";
		 String  remark1  = "没有";
		 double Total_Before_Discount =67.6;
		 double discount = 1;
		 double voucher  = 1;
		 double Total = 64.6;
		 
		 
		 double dis = 1;
		 SaleListPO po =new SaleListPO(state1,ListNumbering,client,storehouse, merchandiser,operator_id,
				remark1,Total_Before_Discount,discount, voucher,Total,goods,gifts,dis);
		 
		 SaleListPO[] result =new SaleListPO[1];
		 result[0] = po;
		 return result;
	}

	@Override
	public SaleListPO[] CheckSaleList(SaleListQueryItem item) throws RemoteException {
		String[] state ={""};
		 String[] numbering ={"0001"};
		 String[] NameOfGoods = {"崩坏三台灯"};
		 String[] type = {"small"};
		  int[] num = {2};  
		  double[] unit_price={33.8};
		  double[] total = {0};
		 String[] remark ={"hehe"};
		 double all_total = 67.6;
		ListOfGoodsPO goods = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		ListOfGoodsPO gifts = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		 String state1 ="";
		 String ListNumbering = "XXD##-20171222-102346";
		 String client = "李四";
		 String storehouse ="1";
		 String merchandiser = "12138";
		 String operator_id  = "233";
		 String  remark1  = "没有";
		 double Total_Before_Discount =67.6;
		 double discount = 1;
		 double voucher  = 1;
		 double Total = 64.6;
		 
		 
		 double dis = 1;
		 SaleListPO po =new SaleListPO(state1,ListNumbering,client,storehouse, merchandiser,operator_id,
				remark1,Total_Before_Discount,discount, voucher,Total,goods,gifts,dis);
		 
		 SaleListPO[] result =new SaleListPO[1];
		 result[0] = po;
		 return result;
	}

	@Override
	public SaleListPO[] CheckSaleReturnList(SaleReturnListQueryItem item) throws RemoteException {
		String[] state ={""};
		 String[] numbering ={"0001"};
		 String[] NameOfGoods = {"崩坏三台灯"};
		 String[] type = {"small"};
		  int[] num = {2};  
		  double[] unit_price={33.8};
		  double[] total = {0};
		 String[] remark ={"hehe"};
		 double all_total = 67.6;
		ListOfGoodsPO goods = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		ListOfGoodsPO gifts = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		 String state1 ="";
		 String ListNumbering = "XXD##-20171222-102346";
		 String client = "李四";
		 String storehouse ="1";
		 String merchandiser = "12138";
		 String operator_id  = "233";
		 String  remark1  = "没有";
		 double Total_Before_Discount =67.6;
		 double discount = 1;
		 double voucher  = 1;
		 double Total = 64.6;
		 
		 
		 double dis = 1;
		 SaleListPO po =new SaleListPO(state1,ListNumbering,client,storehouse, merchandiser,operator_id,
				remark1,Total_Before_Discount,discount, voucher,Total,goods,gifts,dis);
		 
		 SaleListPO[] result =new SaleListPO[1];
		 result[0] = po;
		 return result;
	}

	@Override
	public SaleListPO[] GetAllPendingSaleList() throws RemoteException {
		String[] state ={""};
		 String[] numbering ={"0001"};
		 String[] NameOfGoods = {"崩坏三台灯"};
		 String[] type = {"small"};
		  int[] num = {2};  
		  double[] unit_price={33.8};
		  double[] total = {0};
		 String[] remark ={"hehe"};
		 double all_total = 67.6;
		ListOfGoodsPO goods = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		ListOfGoodsPO gifts = new ListOfGoodsPO(state, numbering, NameOfGoods, type, num, unit_price, total, remark, all_total);
		
		 String state1 ="";
		 String ListNumbering = "XXD##-20171222-102346";
		 String client = "李四";
		 String storehouse ="1";
		 String merchandiser = "12138";
		 String operator_id  = "233";
		 String  remark1  = "没有";
		 double Total_Before_Discount =67.6;
		 double discount = 1;
		 double voucher  = 1;
		 double Total = 64.6;
		 
		 
		 double dis = 1;
		 SaleListPO po =new SaleListPO(state1,ListNumbering,client,storehouse, merchandiser,operator_id,
				remark1,Total_Before_Discount,discount, voucher,Total,goods,gifts,dis);
		 
		 SaleListPO[] result =new SaleListPO[1];
		 result[0] = po;
		 return result;
	}

	@Override
	public void deletePendingSaleList(SaleListPO po) throws RemoteException {
		System.out.println("deleted");
		
	}

	@Override
	public void insert(SaleListPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
