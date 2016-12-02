package vo.hotelVO.hoteluiVO;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class HotelSearchVO {
	private final SimpleStringProperty hotelName;
    private final SimpleStringProperty star;
    private final SimpleStringProperty area;
    private final SimpleStringProperty location;
    private Button select;

    private HotelSearchVO(String hotelName, String star, String area, String location) {
        this.hotelName = new SimpleStringProperty(hotelName);
        this.star = new SimpleStringProperty(star);
        this.area = new SimpleStringProperty(area);
        this.location = new SimpleStringProperty(location);
        this.select = new Button("select");
        initSelect();
    }

    private void initSelect(){
    	select.setOnAction((ActionEvent e) -> {
            
        });
    }
    
    public String hotelName() {
        return hotelName.get();
    }

    public void setHotelName(String content) {
        hotelName.set(content);
    }

    public String getStar() {
        return star.get();
    }

    public void setStar(String content) {
        star.set(content);
    }

    public String getArea() {
        return area.get();
    }

    public void setArea(String content) {
        area.set(content);
    }
    
    public String getLocation() {
        return location.get();
    }

    public void setLocation(String content) {
        location.set(content);
    }
}
