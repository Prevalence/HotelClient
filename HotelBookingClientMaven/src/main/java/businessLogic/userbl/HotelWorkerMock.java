package businessLogic.userbl;

import java.util.ArrayList;

import po.HotelWorkerPO;
import po.MarketPO;
import po.PersonPO;

public class HotelWorkerMock extends HotelWorker{
	HotelWorkerPO pp=new HotelWorkerPO();

	@Override
	public HotelWorkerPO getHotelWorkerInfo(String hotelWorkername) {
		HotelWorkerPO pp1=new HotelWorkerPO();
		pp1.setUsername("xiamutian");
		HotelWorkerPO pp2=new HotelWorkerPO();
		pp2.setUsername("xiekailian");
		pp1.setPassword("123");
		pp2.setPassword("456");
		ArrayList<HotelWorkerPO> List = new ArrayList<HotelWorkerPO>(); 
		List.add(pp1);
		List.add(pp2);
		for(int i=0;i<List.size();i++){
			if(List.get(i).getUsername().equals(hotelWorkername)){
				System.out.print("find");

				return List.get(i);

			}
		}
		return null;
	}


}
