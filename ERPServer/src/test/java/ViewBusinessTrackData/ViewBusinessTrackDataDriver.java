package ViewBusinessTrackData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.ViewReportData.ViewBusinessTrackData.ViewBusinessTrackDataImpl;
import po.popublic.NotePO;
import po.potreasurer.*;

public class ViewBusinessTrackDataDriver {

	public ViewBusinessTrackDataDriver() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		ViewBusinessTrackDataDriver d = new ViewBusinessTrackDataDriver();
		d.test();
	}
	
	public void test() {
		ViewBusinessTrackDataImpl s = new ViewBusinessTrackDataImpl();
		
		List<List<NotePO>> allNoteList = new ArrayList<List<NotePO>>();
		
		allNoteList.add(new ArrayList<NotePO>());
		allNoteList.add(new ArrayList<NotePO>());
		allNoteList.add(new ArrayList<NotePO>());
		allNoteList.add(new ArrayList<NotePO>());
		
		allNoteList.add(this.createDebitNoteList());
		allNoteList.add(this.createCreditNoteList());
		allNoteList.add(this.createCashBillList());
		
		allNoteList.add(new ArrayList<NotePO>());
		allNoteList.add(new ArrayList<NotePO>());
		allNoteList.add(new ArrayList<NotePO>());
		
		try {
			s.exportBusinessTrack(allNoteList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  List<NotePO> createDebitNoteList(){
		List<NotePO> list = new ArrayList<NotePO>();
		
		String[] a = {"xaccount1", "xaccount2"};
		double[] b = {20.3, 65.4};
		String[] c = {"xremark1", "xremark2"};
		list.add(new DebitNotePO("SKD##-20000101-010101", "seller1", "user1", 2, 
				a, b , c, (20.3+65.4), true, true));
		
		String[] d = {"yaccount1", "yaccount2"};
		double[] e = {205.3, 659.4};
		String[] f = {"yremark1", "yremark2"};
		list.add(new DebitNotePO("SKD##-20100202-020202", "seller2", "user2", 2, 
				d, e , f, (205.3+659.4), true, true));
		
		return list;
	}
	public List<NotePO> createCreditNoteList(){
		List<NotePO> list = new ArrayList<NotePO>();
		
		String[] a = {"xaccount1", "xaccount2"};
		double[] b = {563.2, 85.2};
		String[] c = {"xremark1", "xremark2"};
		list.add(new CreditNotePO("FKD##-20000101-010101", "supplier1", "user1", 2, 
				a, b , c, (563.2 + 85.2), true, true));
		
		String[] d = {"yaccount1", "yaccount2"};
		double[] e = {52.3, 63.2};
		String[] f = {"yremark1", "yremark2"};
		list.add(new CreditNotePO("FKD##-20100202-020202", "supplier2", "user2", 2, 
				d, e , f, (52.3 + 63.2), true, true));
		
		return list;
	}
	public List<NotePO> createCashBillList(){
		List<NotePO> list = new ArrayList<NotePO>();
		
		String[] x = {"xitem1", "xitem1"};
		double[] y = {5.5, 10.0};
		String[] z = {"xremark1", "xremark2"};		
		list.add(new CashBillPO("XJFYD-20000101-010101", "user1", "acount1", 2, 
				x , y, z, (5.5 + 10.1), true, true));
		
		String[] p = {"yitem1", "yitem2"};
		double[] o = {23.2, 56.3};
		String[] i = {"yremark1", "yreamrk2"};
		list.add(new CashBillPO("XJFYD-20100101-020202", "user2", "account2", 2, 
				p, o, i, (23.2 + 56.3), true, true));
		
		return list;
	}

}
