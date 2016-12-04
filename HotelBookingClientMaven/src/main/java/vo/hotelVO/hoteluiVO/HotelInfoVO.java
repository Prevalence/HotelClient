package vo.hotelVO.hoteluiVO;

import java.util.ArrayList;

/**
 * 酒店详细信息
 * @author 铠联
 *
 */
public class HotelInfoVO {
	private String hotelname;
	private int star;//酒店星级
	private String feature;//特色
	private ArrayList <Boolean> service;//设施服务，需要初始化list，所有的都要设为false
	private String address;
	private String circle;
	private double score;//酒店平均评分
	private ArrayList <String> roomType;
	private ArrayList <Integer>roomnum;
	private ArrayList <Integer>roomPrice;
	private ArrayList <String> comment;//“评分_时间_用户名_评价内容”，例如“5_2016-02-06_xiamutian_酒店很好” 酒店评价中_是非法字符
}
