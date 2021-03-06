package businessLogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import dataService.hotelDataService.HotelDataService;
import po.hotelPO.CommentPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;
import rmi.RemoteHelper;
import vo.hotelVO.hotelblVO.CommentVO;
import vo.hotelVO.hotelblVO.HotelConditionVO;
import vo.hotelVO.hotelblVO.HotelVO;
import vo.hotelVO.hotelblVO.RoomVO;
import vo.hotelVO.hoteluiVO.HotelSearchVO;
import vo.hotelVO.hoteluiVO.RoomInfoVO;
import vo.orderVO.orderblVO.OrderVO;
import businessLogic.orderbl.Order;
import businessLogic.TimeFormTrans;

/**
 * 
 * @author 武秀峰
 *
 */
public class Hotel {
	private HotelDataService hoteldataservice;
	Order order=new Order();
	
	/**
	 * 酒店工作人员或网站管理人员，根据酒店名称，获取酒店信息
	 * @param Hotelname 酒店名
	 * @return 酒店信息
	 */
	public HotelVO getHotelInfoByHotelworkerOrManager(String Hotelname) throws RemoteException{
		HotelPO hotelpo=hoteldataservice.showHotelinfo(Hotelname);
		HotelVO hotelvo=new HotelVO(hotelpo);
		return hotelvo;
	}
	
	/**
	 * 客户根据酒店名称，获取酒店信息
	 * @param Hotelname 酒店名
	 * @return 酒店信息
	 */
	public HotelVO getHotelInfoByPerson(String Hotelname)  throws RemoteException {
		HotelPO hotelpo=hoteldataservice.showHotelinfo(Hotelname);
		HotelVO hotelvo=new HotelVO(hotelpo);
		if(hotelvo.getRoom().size()==0){
			return null;
		}
		return hotelvo;
	}
	
	/**
	 * 修改酒店信息
	 * @param hotelinfo
	 * @return 是否修改成功（成功则返回true,不能则返回false）
	 * @throws RemoteException 
	 */
	public boolean modifyHotelInfo(HotelVO hotelinfo) throws RemoteException{
		HotelPO PO=new HotelPO(hotelinfo);
		return hoteldataservice.modify(PO);
	}
	
	/**
	 * 客户评论
	 * @param commentvo 评价内容
	 * @return 是否增加评论成功
	 * @throws RemoteException 
	 */
	public boolean addComment(CommentVO commentvo) throws RemoteException{
		//增加评论
		CommentPO commentpo=new CommentPO(commentvo);
		Calendar c=Calendar.getInstance();
		commentpo.setTime(c);
		boolean isComment=hoteldataservice.addComment(commentpo);
		
		String hotelname=commentvo.getHotelname();
		HotelVO hotelvo=getHotelInfoByHotelworkerOrManager(hotelname);
		
		//改变酒店评分
		int personScore=commentvo.getScore();
		double afterScore;
		if(hotelvo.getComment()==null){
			afterScore=(double)personScore;
		}else{
			double oriScore=hotelvo.getScore();
			int size=hotelvo.getComment().size();
			afterScore=(size*oriScore+personScore)/(size+1);
		}
		hotelvo.setScore(afterScore);
		
		//增加评论
		ArrayList<CommentVO> commentvolist=hotelvo.getComment();
		commentvolist.add(commentvo);
		hotelvo.setComment(commentvolist);
		
		//数据库同步
		HotelPO hotelpo=new HotelPO(hotelvo);
		boolean isHotelModify=hoteldataservice.modify(hotelpo);
		
		return isComment&&isHotelModify;
	}
	
	/**
	 * 房间内容修改
	 * @param hotelname 酒店名称
	 * @param roomvoList 房间的信息
	 * @return 是否修改房间信息成功
	 * @throws RemoteException 
	 */
	public boolean roomModify(String hotelname, ArrayList<RoomVO> roomvoList) throws RemoteException{
		ArrayList<RoomPO> roompoList=new ArrayList<RoomPO>();
		if(roomvoList.size()==0){
			return false;
		}
		for(int i=0; i<roomvoList.size(); i++){
			RoomPO roompo=new RoomPO(roomvoList.get(i));
			roompoList.add(roompo);
		}
		return hoteldataservice.roomModify(hotelname, roompoList);
	}
	
	/**
	 * 客户给出要求的房间条件区间，筛选符合条件的酒店，返回酒店列表
	 * @param worstCondition 最坏酒店条件
	 * @param bestCondition 最好酒店条件
	 * @return 符合条件的酒店清单
	 * @throws RemoteException 
	 * 注意：浏览酒店详细信息时，需要先明确地址和商圈，才能进行查看
	 */
	public ArrayList<HotelSearchVO> findWithReq(HotelConditionVO worstCondition, HotelConditionVO bestCondition) throws RemoteException {
		ArrayList<HotelVO> resulthotelvolist=new ArrayList<HotelVO>();//resulthotelvoList将转化为HotelSearchVO
		ArrayList<HotelVO> hotelvoList=new ArrayList<HotelVO>();//hotelvoList为中间值
		boolean isConditionRight=(worstCondition.getCircle().equals(bestCondition.getCircle()))&&
				(worstCondition.isBooked()==bestCondition.isBooked());//最坏和最好条件的地址、商圈、是否预订过需要相等
		boolean isConditionComplete=(worstCondition.getCircle()!=null);//需要先明确商圈，才能进行查看
		if(isConditionRight&&isConditionComplete){//当输入的条件正确时，进行酒店搜索
			HotelPO worstConditionPO=new HotelPO(worstCondition.toHotelVO(worstCondition));
			HotelPO bestConditionPO=new HotelPO(bestCondition.toHotelVO(bestCondition));
			ArrayList<HotelPO> hotelpoList= hoteldataservice.findWithReq(worstConditionPO, bestConditionPO);
			
			if(hotelpoList!=null){
				System.out.println("-----------");
				for(int i=0; i<hotelpoList.size(); i++){
					if(hotelpoList.get(i).getRoom()!=null){
						HotelVO hotelvo=new HotelVO(hotelpoList.get(i));
						hotelvoList.add(hotelvo);
						System.out.println("name:"+hotelvo.getHotelname());
					}
				}	
			}
			
		}else{
			System.out.println("=============");
			return null;//需要提醒客户先明确商圈
		}
		
		//做是否预订过的筛选
		if(!worstCondition.isBooked()){//如果没有限制是自己已预订过的，直接返回hotelvoList
			resulthotelvolist= hotelvoList;
		}else{//如果限制是自己已预订过的，则对hotelvoList进行筛选
			ArrayList<OrderVO> ordervoList=order.personOrders(worstCondition.getPersonname());
			if(ordervoList!=null){
				for(int i=0; i<ordervoList.size(); i++){
					String hotelname=ordervoList.get(i).getHotelname();//客户已预订过的酒店名称
					for(int j=0; j<hotelvoList.size(); j++){
						if(hotelvoList.get(j).getHotelname().equals(hotelname)){
							resulthotelvolist.add(hotelvoList.get(j));
						}
					}
				}
			}
			
		}
		/*String hotelName, String star, String area, String location*/
		ArrayList<HotelSearchVO> hotelSearchVOList=new ArrayList<HotelSearchVO>();
		for(int i=0; i<resulthotelvolist.size(); i++){
			HotelVO hotel=resulthotelvolist.get(i);
			HotelSearchVO hotelSearchVO=new HotelSearchVO(hotel.getHotelname(), 
					Integer.toString(hotel.getStar()), String.valueOf(hotel.getScore()), 
					hotel.getCircle(), hotel.getAddress());
			hotelSearchVOList.add(hotelSearchVO);
		}
		return hotelSearchVOList;
	}
	
	/**
	 * 增加酒店
	 * @param hotelvo 待增加酒店信息
	 * @return 是否增加成功
	 * @throws RemoteException 
	 */
	public boolean addHotel(HotelVO hotelvo) throws RemoteException{
		try {
			HotelPO hotelpo=new HotelPO(hotelvo);
			hotelpo.setHotelID(-1);
			return hoteldataservice.addHotel(hotelpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 返回符合条件的对应酒店的房间
	 * @param hotelname
	 * @param roomtype
	 * @param starttime
	 * @param endtime
	 * @return 符合条件的对应酒店的房间
	 * @throws RemoteException 
	 */
	public RoomInfoVO findReqRoom(String hotelname, String roomtype, String starttime1, String endtime1)throws RemoteException {
		// TODO Auto-generated method stub
		TimeFormTrans t=new TimeFormTrans();
		Calendar starttime=t.myToCalendar(starttime1);
		Calendar endtime=t.myToCalendar(endtime1);
		
		HotelController hotelcontroller=new HotelController();
		HotelVO hotelvo=hotelcontroller.getHotelInfoByHotelworkerOrManager(hotelname);
		ArrayList<RoomVO> rooms=hotelvo.getRoom();
		if(rooms==null){
			return null;
		}
		
		int roomPrice=0;
		for(int i=0; i<rooms.size(); i++){
			if(rooms.get(i).getRoomType().equals(roomtype)){//当roomtype符合时
				roomPrice=rooms.get(i).getRoomPrice();
				ArrayList<Calendar> roomStarttime=rooms.get(i).getCheckInTime();
				ArrayList<Calendar> roomEndtime=rooms.get(i).getCheckOutTime();
				
				boolean isEmpty=(roomStarttime.size()==0)&&(roomEndtime.size()==0);
				boolean isFreeForBooking=false;
				for(int j=0; j<roomStarttime.size()-1; j++){
					if((starttime.after(roomEndtime.get(j)))&&(endtime.before(roomStarttime.get(j+1)))){
						isFreeForBooking=true;
					}
				}
				if(roomStarttime.size()>0){
					if(starttime.after(roomEndtime.get(roomStarttime.size()-1))){
						isFreeForBooking=true;
					}
				}
				if(isEmpty||isFreeForBooking){
					RoomInfoVO roomInfoVO=new RoomInfoVO(roomtype,roomPrice);
					
					return roomInfoVO;
				}
			}
		}
		return null;
	}
	
	/**
	 * 返回符合条件的对应酒店的可用房间数量
	 * @param hotelname
	 * @param roomtype
	 * @param starttime
	 * @param endtime
	 * @return 返回对应的房间剩余数量
	 * @throws RemoteException 
	 */
	@SuppressWarnings("null")
	public int getAvailableNumber(String hotelname, String roomtype, String starttime1, String endtime1)throws RemoteException {
		// TODO Auto-generated method stub
		TimeFormTrans t=new TimeFormTrans();
		Calendar starttime=t.myToCalendar(starttime1);
		Calendar endtime=t.myToCalendar(endtime1);
		
		HotelController hotelcontroller=new HotelController();
		HotelVO hotelvo=hotelcontroller.getHotelInfoByHotelworkerOrManager(hotelname);
		ArrayList<RoomVO> rooms=hotelvo.getRoom();
		if(rooms==null){
			return 0;
		}
		
		int numOfRoom=0;
		for(int i=0; i<rooms.size(); i++){
			if(rooms.get(i).getRoomType().equals(roomtype)){//当roomtype符合时
				ArrayList<Calendar> roomStarttime=rooms.get(i).getCheckInTime();
				ArrayList<Calendar> roomEndtime=rooms.get(i).getCheckOutTime();
				
				boolean isEmpty=(roomStarttime==null)&&(roomEndtime==null);
				boolean isFreeForBooking=false;
				if(!(roomStarttime==null)&&(roomEndtime==null)){
					for(int j=0; j<roomStarttime.size()-1; j++){
						if((starttime.after(roomEndtime.get(j)))&&(endtime.before(roomStarttime.get(j+1)))){
							isFreeForBooking=true;
						}
					}
					if(roomStarttime.size()>0){
						if(starttime.after(roomEndtime.get(roomStarttime.size()-1))){
							isFreeForBooking=true;
						}
					}
				}
				
				if(isEmpty||isFreeForBooking){
					numOfRoom=numOfRoom+1;
				}
				
			}
		}
		return numOfRoom;
	}
	
	/**
	 * 根据酒店名称返回对应酒店的房间类型和价格的ArrayList
	 * @param hotelname
	 * @return ArrayList<RoomInfoVO>，若没有，返回空的ArrayList<RoomInfoVO>
	 * @throws RemoteException 
	 */
	public ArrayList<RoomInfoVO> getHotelRoomInfo(String hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<RoomInfoVO> roomInfoList=new ArrayList<RoomInfoVO>();
		
		HotelController hotelcontroller=new HotelController();
		HotelVO hotelvo=hotelcontroller.getHotelInfoByHotelworkerOrManager(hotelname);
		ArrayList<RoomVO> rooms=hotelvo.getRoom();
		if(rooms==null){
			return roomInfoList;
		}
		for(int i=0; i<rooms.size();i++){
			boolean isExist=false;
			for(int j=0;j<i;j++){
				if(rooms.get(i).getRoomType()==rooms.get(j).getRoomType()){
					isExist=true;
				}
			}
			
			if(isExist==false){
				String roomtype=rooms.get(i).getRoomType();
				int roomprice=rooms.get(i).getRoomPrice();
				RoomInfoVO roomInfoVO=new RoomInfoVO(roomtype,roomprice);
				roomInfoList.add(roomInfoVO);
			}
		}
		
		return roomInfoList;
	}
	/**
	 * 新增某酒店的某类型房间n个
	 * @param roomtype
	 * @param roomnum 新增房间类型的房间数量
	 * @param roomprice
	 * @param hotelname
	 * @return 若酒店已有此房间类型，返回false；否则添加房间并返回true
	 * @throws RemoteException 
	 */
	public boolean addRoom(String roomtype, int roomnum, int roomprice, String hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		HotelController hc=new HotelController();
		ArrayList<RoomInfoVO> roomlist=hc.getHotelRoomInfo(hotelname);
		for(int i=0;i<roomlist.size();i++){
			if(roomlist.get(i).getRoomtype().equals(roomtype)){
				return false;//若酒店已有此房间类型，返回false
			}
		}
		
		//以下进行新增房间操作
		//public boolean roomModify(String hotelname, ArrayList<RoomVO> roomvoList)
//		public HotelVO getHotelInfoByPerson(String Hotelname)
		HotelVO hotelvo=hc.getHotelInfoByPerson(hotelname);
		ArrayList<RoomVO> roomvolist=hotelvo.getRoom();
		RoomVO roomvo=new RoomVO();
		roomvo.setRoomType(roomtype);
		roomvo.setRoomPrice(roomprice);
		for(int i=0;i<roomnum;i++){
			roomvolist.add(roomvo);
		}
		boolean result=hc.roomModify(hotelname, roomvolist);
		
		return result;
	}
	
	/**
	 * 修改酒店某类型的房间数量和价格
	 * @param roomtype
	 * @param roomnum 要修改成的房间数量
	 * @param roomprice 要修改成的房间价格
	 * @param hotelname
	 * @return 是否修改成功
	 * @throws RemoteException 
	 */
	public boolean editRoom(String roomtype, int roomnum, int roomprice, String hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		HotelController hc=new HotelController();
		//public boolean roomModify(String hotelname, ArrayList<RoomVO> roomvoList)
//		public HotelVO getHotelInfoByPerson(String Hotelname)
		HotelVO hotelvo=hc.getHotelInfoByPerson(hotelname);
		ArrayList<RoomVO> roomvolist=hotelvo.getRoom();
		
		//删去之前的房间
		for(int i=0;i<roomvolist.size();i++){
			if(roomvolist.get(i).getRoomType().equals(roomtype)){
				roomvolist.remove(i);
				i--;
			}
		}
		
		//新增修改后的房间
		RoomVO roomvo=new RoomVO();
		roomvo.setRoomType(roomtype);
		roomvo.setRoomPrice(roomprice);
		for(int i=0;i<roomnum;i++){
			roomvolist.add(roomvo);
		}
		boolean result=hc.roomModify(hotelname, roomvolist);
		
		return result;
	}
	
	/**
	 * 获取某酒店中最贵的房间价格
	 * @param hotelname
	 * @return
	 * @throws RemoteException 
	 */
	public int getHighestPrice(String hotelname) throws RemoteException {
		// TODO Auto-generated method stub
		int highPrice=0;
		HotelController hc=new HotelController();
		HotelVO hotelvo=hc.getHotelInfoByPerson(hotelname);
		ArrayList<RoomVO> roomvolist=hotelvo.getRoom();
		if(roomvolist!=null){
			for(int i=0;i<roomvolist.size();i++){
				RoomVO roomvo=roomvolist.get(i);
				if(roomvo.getRoomPrice()>highPrice){
					highPrice=roomvo.getRoomPrice();
				}
			}
		}
		
		return highPrice;
	}
	
	/**
	 * 删除某酒店的某类型的所有房间
	 * @param roomtype
	 * @param hotelName
	 * @return
	 * @throws RemoteException 
	 */
	public boolean removeRoom(String roomtype, String hotelname) throws RemoteException{
		// TODO Auto-generated method stub
		HotelController hc=new HotelController();
		HotelVO hotelvo=hc.getHotelInfoByPerson(hotelname);
		ArrayList<RoomVO> roomvolist=hotelvo.getRoom();
		
		//删去房间
		for(int i=0;i<roomvolist.size();i++){
			if(roomvolist.get(i).getRoomType().equals(roomtype)){
				roomvolist.remove(i);
				i--;
			}
		}
		
		boolean result=hc.roomModify(hotelname, roomvolist);
		return result;
	}
	
	/**
	 * 构造方法
	 */
	public Hotel(){
		hoteldataservice=RemoteHelper.getInstance().getHotelDataService();
	}

}
