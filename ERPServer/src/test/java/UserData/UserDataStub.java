package UserData;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.UserDataService.UserService;
import po.poUser.UserPO;

public class UserDataStub implements UserService{

	@Override
	public boolean newUser(UserPO User) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteUser(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<UserPO> getAllUser() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> userlist = new ArrayList<UserPO>();
		userlist.add(new UserPO("库存管理人员", "123456", "Stock", "1"));
		userlist.add(new UserPO("销售管理人员", "123456", "Salesman", "1"));
		userlist.add(new UserPO("财务人员1", "123456", "Treasurer", "1"));
		userlist.add(new UserPO("财务人员2", "123456", "Treasurer", "2"));
		userlist.add(new UserPO("总经理", "123456", "Manager", "1"));
		return userlist;
	}

	@Override
	public UserPO Login(String ID, String PassWord) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> userlist = new ArrayList<UserPO>();
		userlist.add(new UserPO("库存管理人员", "123456", "Stock", "1"));
		userlist.add(new UserPO("销售管理人员", "123456", "Salesman", "1"));
		userlist.add(new UserPO("财务人员1", "123456", "Treasurer", "1"));
		userlist.add(new UserPO("财务人员2", "123456", "Treasurer", "2"));
		userlist.add(new UserPO("总经理", "123456", "Manager", "1"));
		for(int i = 0;i < userlist.size();i++){
			if(ID.equals(userlist.get(i).getID())&&(PassWord.equals(userlist.get(i).getPassWord())))
				return userlist.get(i);
		}
		return null;
	}

}
