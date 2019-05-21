package ViewBusinessTrackData;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.ViewReportDataService.ViewBusinessTrackDataService;
import po.popublic.NotePO;

public class ViewBusinessTrackDataStub implements ViewBusinessTrackDataService {

	@Override
	public boolean exportBusinessTrack(List<List<NotePO>> allNoteList) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
