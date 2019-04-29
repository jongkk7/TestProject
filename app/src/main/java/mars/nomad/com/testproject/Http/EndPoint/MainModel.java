package mars.nomad.com.testproject.Http.EndPoint;

import mars.nomad.com.testproject.DataModel.Base.BaseResponseDataModel;
import mars.nomad.com.testproject.DataModel.Response.RoomResponseDataModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by YJK on 2019-04-29
 **/
public interface MainModel {

    @GET("/user/roomList")
    Call<RoomResponseDataModel> getRoomList();

    @FormUrlEncoded
    @POST("/user/roomList")
    Call<BaseResponseDataModel> shopLogin(@Field("loginId") String loginId, @Field("password") String password,
                                           @Field("osType") String osType, @Field("osVersion") String osVersion, @Field("appVersion") String appVersion,
                                           @Field("deviceName") String deviceName, @Field("deviceId") String deviceId,
                                           @Field("pushKey") String pushKey);
}
