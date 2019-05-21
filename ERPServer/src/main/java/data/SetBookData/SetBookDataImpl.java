package data.SetBookData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.utility.DataStringHelper;
import data.utility.FileAttributeIndex;
import dataservice.SetBookDataService.SetBookDataService;
import po.posale_purchase_client.ClientPO;
import po.postock.GoodsClassPO;
import po.postock.GoodsPO;
import po.potreasurer.BookPO;
import po.potreasurer.CompanyAccountPO;

/**
 * 期初建账DATA
 * @author CharlieLei
 *
 */
public class SetBookDataImpl implements SetBookDataService {

	private File file;
	private BufferedReader reader;
	private BufferedWriter writer;
	private static final String fileFolderName = "期初账单";
	
	public SetBookDataImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean doesBookExist() throws RemoteException {
		file = new File(fileFolderName + File.separator + DataStringHelper.getlastYear() + "期初账单.txt");
		return file.exists();
	}

	@Override
	public boolean newBook(BookPO bookInfo) throws RemoteException {
		if(bookInfo == null) return false;
		
		file = new File(fileFolderName + File.separator + DataStringHelper.getThisYear() + "期初账单.txt");
		
		ArrayList<GoodsClassPO> goodsClassInfo = bookInfo.getGoodsClass();
		ArrayList<GoodsPO> goodsInfo = bookInfo.getGoodsInfo();
		ArrayList<ClientPO> clientInfo = bookInfo.getClientInfo();
		ArrayList<CompanyAccountPO> companyAccountInfo = bookInfo.getCompanyAccountInfo();
		
		try {
			file.createNewFile();
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			
			writer.append("GoodsClass" + System.lineSeparator() + 
					Integer.toString(goodsClassInfo.size()) + System.lineSeparator());
			this.writeGoodsClass(goodsClassInfo);
			
			writer.append("Goods" + System.lineSeparator() + 
					Integer.toString(goodsInfo.size()) + System.lineSeparator());
			this.writeGoods(goodsInfo);
			
			writer.append("Client" + System.lineSeparator() + 
					Integer.toString(clientInfo.size()) + System.lineSeparator());
			this.writeClient(clientInfo);
			
			writer.append("CompanyAccount" + System.lineSeparator() + 
					Integer.toString(companyAccountInfo.size()) + System.lineSeparator());
			this.writeAccount(companyAccountInfo);
			
			writer.close();
			return true;
		} catch (IOException e) {
			System.out.println("setBookData_IOException");
			e.printStackTrace();
		}
			
		return false;
	}
	private void writeGoodsClass(List<GoodsClassPO> goodsClassInfo) throws IOException {
		String ID = null;
		String name = null;
		String parentID = null;
		int level = 0;
		ArrayList<String> GoodsIDList = null;
		String tempGoodsIDListString = null;
		
		String outputString = null;
		
		for(int i = 0; i < goodsClassInfo.size(); i++) {
			ID = goodsClassInfo.get(i).getID();
			name = goodsClassInfo.get(i).getName();
			parentID = goodsClassInfo.get(i).getParentID();
			level = goodsClassInfo.get(i).getLevel();
			GoodsIDList = goodsClassInfo.get(i).getGoodsIDList();
			
			tempGoodsIDListString = "";
			if(GoodsIDList.size() == 0) tempGoodsIDListString = DataStringHelper.getSeparator();
			for(int j = 0; j < GoodsIDList.size(); j++) {
				tempGoodsIDListString = tempGoodsIDListString + 
						GoodsIDList.get(j) + DataStringHelper.getSeparator();
			}
			
			outputString = ID + DataStringHelper.getAttributeSeparator() + 
					name + DataStringHelper.getAttributeSeparator() + 
					parentID + DataStringHelper.getAttributeSeparator() + 
					Integer.toString(level) + DataStringHelper.getAttributeSeparator() +
					tempGoodsIDListString + DataStringHelper.getAttributeSeparator() +
					System.lineSeparator();
			
			writer.append(outputString);
		}
	}
	private void writeGoods(List<GoodsPO> goodsInfo) throws IOException {
		String ID = null;
		String name = null;
		String type = null;
		int amount = 0;
		double purchasePrice = 0;
		double recentPurchasePrice = 0;
		double salePrice = 0;
		double recentSalePrice = 0;
		int warningValue = 0;
		String classID = null;
				
		String outputString = null;
		for(int i = 0; i < goodsInfo.size(); i++) {
			ID = goodsInfo.get(i).getID();
			name = goodsInfo.get(i).getName();
			type = goodsInfo.get(i).getType();
			amount = goodsInfo.get(i).getAmount();
			purchasePrice = goodsInfo.get(i).getPurchasePrice();
			recentPurchasePrice = goodsInfo.get(i).getRecentPurchasePrice();
			salePrice = goodsInfo.get(i).getSalePrice();
			recentSalePrice = goodsInfo.get(i).getRecentSalePrice();
			warningValue = goodsInfo.get(i).getWarningValue();
			classID = goodsInfo.get(i).getClassID();
			
			outputString = ID + DataStringHelper.getAttributeSeparator() + 
					name + DataStringHelper.getAttributeSeparator() +
					type + DataStringHelper.getAttributeSeparator() + 
					Integer.toString(amount) + DataStringHelper.getAttributeSeparator() +
					Double.toString(purchasePrice) + DataStringHelper.getAttributeSeparator() + 
					Double.toString(recentPurchasePrice) + DataStringHelper.getAttributeSeparator() + 
					Double.toString(salePrice) + DataStringHelper.getAttributeSeparator() +
					Double.toString(recentSalePrice) + DataStringHelper.getAttributeSeparator() +
					Integer.toString(warningValue) + DataStringHelper.getAttributeSeparator() +
					classID + DataStringHelper.getAttributeSeparator() +
					System.lineSeparator();
			
			writer.append(outputString);
 		}
	}
	private void writeClient(List<ClientPO> clientInfo) throws IOException {
		String numbering = null;
		String classification = null;
		String level = null;
		String name = null;
		String phone_number = null;
		String address = null;
		String postcode = null;
		String email = null;
		double receivable_amount = 0;
		double receivables = 0;
		double should_pay = 0;
		String acquiescence_merchandiser = null;
		
		String outputString = null;
		for(int i = 0; i < clientInfo.size(); i++) {
			numbering = clientInfo.get(i).get_numbering();
			classification = clientInfo.get(i).get_classification();
			level = clientInfo.get(i).get_level();
			name = clientInfo.get(i).get_name();
			phone_number = clientInfo.get(i).get_phone_number();
			address = clientInfo.get(i).get_address();
			postcode = clientInfo.get(i).get_postcode();
			email = clientInfo.get(i).get_email();
			receivable_amount = clientInfo.get(i).get_receivalbe_amount();
			receivables = clientInfo.get(i).get_receivables();
			should_pay = clientInfo.get(i).get_should_pay();
			acquiescence_merchandiser = clientInfo.get(i).get_acquiescence_merchandiser();
			
			outputString = numbering + DataStringHelper.getAttributeSeparator() + 
					classification + DataStringHelper.getAttributeSeparator() +
					level + DataStringHelper.getAttributeSeparator() + 
					name + DataStringHelper.getAttributeSeparator() +
					phone_number + DataStringHelper.getAttributeSeparator() +
					address + DataStringHelper.getAttributeSeparator() +
					postcode + DataStringHelper.getAttributeSeparator() +
					email + DataStringHelper.getAttributeSeparator() + 
					Double.toString(receivable_amount) + DataStringHelper.getAttributeSeparator() +
					Double.toString(receivables) + DataStringHelper.getAttributeSeparator() +
					Double.toString(should_pay) + DataStringHelper.getAttributeSeparator() +
					acquiescence_merchandiser + DataStringHelper.getAttributeSeparator() +
					System.lineSeparator();
			
			writer.append(outputString);
 		}
	}
	private void writeAccount(List<CompanyAccountPO> companyAccountInfo) throws IOException {
		String accountName = null;
		double accountBalance = 0;
		
		String outputString = null;
		for(int i = 0; i < companyAccountInfo.size(); i++) {
			accountName = companyAccountInfo.get(i).getAccountName();
			accountBalance = companyAccountInfo.get(i).getAccountBalance();
			
			outputString = accountName + DataStringHelper.getAttributeSeparator() +
					accountBalance + DataStringHelper.getAttributeSeparator() +
					System.lineSeparator();
			
			writer.append(outputString);
		}
	}

	@Override
	public BookPO inquiryBook() throws RemoteException {
		file = new File(fileFolderName + File.separator + DataStringHelper.getThisYear() + "期初账单.txt");
		
		ArrayList<GoodsClassPO> goodsClassInfo = new ArrayList<GoodsClassPO>();
		ArrayList<GoodsPO> goodsInfo = new ArrayList<GoodsPO>();
		ArrayList<ClientPO> clientInfo = new ArrayList<ClientPO>();
		ArrayList<CompanyAccountPO> companyAccountInfo = new ArrayList<CompanyAccountPO>();
		
		try {
			if(file.exists()) {
				reader = new BufferedReader(new FileReader(file));
				
				String line = null;
				while((line = reader.readLine()) != null) {
					switch(line) {
					case "GoodsClass": goodsClassInfo = this.readGoodsClass(); break;
					case "Goods": goodsInfo = this.readGoods(); break;
					case "Client": clientInfo = this.readClient(); break;
					case "CompanyAccount": companyAccountInfo = this.readAccount(); break;
					default: break;
					}
				}				
			}
		} catch (IOException e) {
			System.out.println("setBookData_IOException");
			e.printStackTrace();
		}
		
		return new BookPO(goodsClassInfo, goodsInfo, clientInfo, companyAccountInfo);
	}
	private ArrayList<GoodsClassPO> readGoodsClass() throws IOException {
		ArrayList<GoodsClassPO> goodsClassInfo = new ArrayList<GoodsClassPO>();
		
		String ID = null;
		String name = null;
		String parentID = null;
		int level = 0;
		ArrayList<String> GoodsIDList = null;

		String[] inputString = null;
		String[] tempGoodsIDList = null;
		int num = Integer.parseInt(reader.readLine());
		for(int i = 0; i < num; i++) {
			inputString = reader.readLine().split(DataStringHelper.getAttributeSeparator());
			
			ID = inputString[FileAttributeIndex.GoodsClass_ID.index()];
			name = inputString[FileAttributeIndex.GoodsClass_Name.index()];
			parentID = inputString[FileAttributeIndex.GoodsClass_ParentID.index()];
			level = Integer.parseInt(inputString[FileAttributeIndex.GoodsClass_Level.index()]);
			tempGoodsIDList = inputString[FileAttributeIndex.GoodsClass_GoodsIDList.index()].split(DataStringHelper.getSeparator());
			
			GoodsIDList = new ArrayList<String>();
			for(int j = 0; j < tempGoodsIDList.length; j++) GoodsIDList.add(tempGoodsIDList[j]);
			
			goodsClassInfo.add(new GoodsClassPO(ID, name, parentID, level, GoodsIDList));
		}
		
		return goodsClassInfo;
	}
	private ArrayList<GoodsPO> readGoods() throws IOException {
		ArrayList<GoodsPO> goodsInfo = new ArrayList<GoodsPO>();
		
		String ID = null;
		String name = null;
		String type = null;
		int amount = 0;
		double purchasePrice = 0;
		double recentPurchasePrice = 0;
		double salePrice = 0;
		double recentSalePrice = 0;
		int warningValue = 0;
		String classID = null;
		
		String[] inputString = null;
		int num = Integer.parseInt(reader.readLine());
		for(int i =0; i < num; i++) {
			inputString = reader.readLine().split(DataStringHelper.getAttributeSeparator());
			
			ID = inputString[FileAttributeIndex.Goods_ID.index()];
			name = inputString[FileAttributeIndex.Goods_Name.index()];
			type = inputString[FileAttributeIndex.Goods_Type.index()];
			amount = Integer.parseInt(inputString[FileAttributeIndex.Goods_Amount.index()]);
			purchasePrice = Double.parseDouble(inputString[FileAttributeIndex.Goods_PurchasePrice.index()]);
			recentPurchasePrice = Double.parseDouble(inputString[FileAttributeIndex.Goods_RecentPurchasePrice.index()]);
			salePrice = Double.parseDouble(inputString[FileAttributeIndex.Goods_SalePrice.index()]);
			recentSalePrice = Double.parseDouble(inputString[FileAttributeIndex.Goods_RecentSalePrice.index()]);
			warningValue = Integer.parseInt(inputString[FileAttributeIndex.Goods_WarningValue.index()]);
			classID = inputString[FileAttributeIndex.Goods_ClassID.index()];
			
			goodsInfo.add(new GoodsPO(ID, name, type, amount, purchasePrice, recentPurchasePrice, salePrice, recentSalePrice, 
					warningValue, classID));
		}
		
		return goodsInfo;
	}
	private ArrayList<ClientPO> readClient() throws IOException {
		ArrayList<ClientPO> clientInfo = new ArrayList<ClientPO>();
		
		String numbering = null;
		String classification = null;
		String level = null;
		String name = null;
		String phone_number = null;
		String address = null;
		String postcode = null;
		String email = null;
		double receivable_amount = 0;
		double receivables = 0;
		double should_pay = 0;
		String acquiescence_merchandiser = null;
		
		String[] inputString = null;
		int num = Integer.parseInt(reader.readLine());
		for(int i = 0; i < num; i++) {
			inputString = reader.readLine().split(DataStringHelper.getAttributeSeparator());
			
			numbering = inputString[FileAttributeIndex.Client_Numbering.index()];
			classification = inputString[FileAttributeIndex.Client_Classification.index()];
			level = inputString[FileAttributeIndex.Client_Level.index()];
			name = inputString[FileAttributeIndex.Client_Name.index()];
			phone_number = inputString[FileAttributeIndex.Client_PhoneNumber.index()];
			address = inputString[FileAttributeIndex.Client_Address.index()];
			postcode = inputString[FileAttributeIndex.Client_Postcode.index()];
			email = inputString[FileAttributeIndex.Client_Email.index()];
			receivable_amount = Double.parseDouble(inputString[FileAttributeIndex.Client_ReceivableAmount.index()]);
			receivables = Double.parseDouble(inputString[FileAttributeIndex.Client_Receivables.index()]);
			should_pay = Double.parseDouble(inputString[FileAttributeIndex.Client_ShouldPay.index()]);
			acquiescence_merchandiser = inputString[FileAttributeIndex.Client_AcquiescenceMerchandiser.index()];
			
			clientInfo.add(new ClientPO(numbering, classification, level, name, phone_number, address, postcode,
					email, receivable_amount, receivables, should_pay, acquiescence_merchandiser));
		}
		
		return clientInfo;
	}
	private ArrayList<CompanyAccountPO> readAccount() throws IOException {
		ArrayList<CompanyAccountPO> companyAccountInfo = new ArrayList<CompanyAccountPO>();
		
		String accountName = null;
		double accountBalance = 0;
		
		String[] inputString = null;
		int num = Integer.parseInt(reader.readLine());
		for(int i = 0; i < num; i++) {
			inputString = reader.readLine().split(DataStringHelper.getAttributeSeparator());
			
			accountName = inputString[FileAttributeIndex.CompanyAccount_AccountName.index()];
			accountBalance = Double.parseDouble(inputString[FileAttributeIndex.CompanyAccount_AccountBalance.index()]);
			
			companyAccountInfo.add(new CompanyAccountPO(accountName, accountBalance));
		}
		
		return companyAccountInfo;
	}

}
