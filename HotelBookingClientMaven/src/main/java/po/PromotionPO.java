package po;

import java.io.Serializable;
import java.util.*;


/**
 * @author xiamutian
 */
public class PromotionPO implements Serializable {
	private String name;
	private String type;
	private ArrayList <String> hotel;
	public PromotionPO(String name, Calendar start, Calendar end, String type,
			double discount, ArrayList<String> hotel) {
		super();
		this.name = name;
		this.type = type;
		this.hotel = hotel;
	}
	public PromotionPO(){
		name=null;
		type=null;
		hotel=null;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getHotel() {
		return hotel;
	}
	public void setHotel(ArrayList<String> hotel) {
		this.hotel = hotel;
	}
	}
