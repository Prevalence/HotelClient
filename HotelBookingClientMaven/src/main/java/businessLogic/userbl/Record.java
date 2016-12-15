package businessLogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataService.userDataService.UserDataService;
import po.personPO.RecordPO;
import rmi.RemoteHelper;
import vo.personVO.RecordVO;

public class Record {
	UserDataService userDataService;
	public Record(){
		userDataService=RemoteHelper.getInstance().getUserDataService();
	}
	
	/**
	 * 写入客户信用记录
	 * @param personname
	 * @param record
	 * @return
	 */
	public boolean writeRecord(String personname, RecordVO record) throws RemoteException{
		// TODO Auto-generated method stub
		RecordPO po=new RecordPO(record);
		return userDataService.writeRecord(personname, po);
	}

	/**
	 * 获取客户信用记录
	 * @param personID
	 * @return
	 */
	public ArrayList<RecordVO> getRecord(String personname) throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<RecordPO> polist=userDataService.getRecord(personname);
		ArrayList<RecordVO> volist=new 		ArrayList<RecordVO>();
		if(polist!=null){
			for(int i=0;i<polist.size();i++){
				RecordVO vo=new RecordVO(polist.get(i));
				volist.add(vo);
			}
			
		}
		return volist;
	}

}








