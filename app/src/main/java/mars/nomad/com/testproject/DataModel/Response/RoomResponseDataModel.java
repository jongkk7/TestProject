package mars.nomad.com.testproject.DataModel.Response;

import java.util.List;

import mars.nomad.com.testproject.DataModel.Base.BaseResponseDataModel;
import mars.nomad.com.testproject.DataModel.RoomDataModel;

/**
 * Created by YJK on 2019-04-29
 **/
public class RoomResponseDataModel extends BaseResponseDataModel {

    private List<RoomDataModel> roomList;

    public List<RoomDataModel> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<RoomDataModel> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return "RoomResponseDataModel{" +
                "roomList=" + roomList +
                '}';
    }
}
