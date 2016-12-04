package businessLogic.userbl;

import java.util.ArrayList;

import po.HotelWorkerPO;
import po.MarketPO;
import vo.HotelWorkerVO;

public class HotelWorkerMock extends HotelWorker{
	HotelWorkerPO pp=new HotelWorkerPO();

	@Override
	public HotelWorkerVO getHotelWorkerInfo(String hotelWorkername) {
		HotelWorkerVO pp1=new HotelWorkerVO();
		pp1.setUsername("xiamutian");
		HotelWorkerVO pp2=new HotelWorkerVO();
		pp2.setUsername("xiekailian");
		pp1.setPassword("123");
		pp2.setPassword("456");
		ArrayList<HotelWorkerVO> List = new ArrayList<HotelWorkerVO>(); 
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
