package vo.hotelVO.hoteluiVO;

import java.util.ArrayList;

/**
 * 酒店详细信息
 * @author 铠联
 *
 */
public class HotelInfoVO {
	@SuppressWarnings("unused")
	private String hotelname;
	@SuppressWarnings("unused")
	private int star;//酒店星级
	@SuppressWarnings("unused")
	private String feature;//特色
	@SuppressWarnings("unused")
	private ArrayList <Boolean> service;//设施服务，需要初始化list，所有的都要设为false
	@SuppressWarnings("unused")
	private String address;
	@SuppressWarnings("unused")
	private String circle;
	@SuppressWarnings("unused")
	private double score;//酒店平均评分
	@SuppressWarnings("unused")
	private ArrayList <String> roomType;
	@SuppressWarnings("unused")
	private ArrayList <Integer>roomnum;
	@SuppressWarnings("unused")
	private ArrayList <Integer>roomPrice;
	@SuppressWarnings("unused")
	private ArrayList <String> comment;//“评分_时间_用户名_评价内容”，例如“5_2016-02-06_xiamutian_酒店很好” 酒店评价中_是非法字符
}
