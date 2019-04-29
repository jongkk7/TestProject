package mars.nomad.com.testproject.MVP;

import android.content.Context;

import mars.nomad.com.testproject.Adapter.AdapterRoomList;
import mars.nomad.com.testproject.DataModel.Response.RoomResponseDataModel;
import mars.nomad.com.testproject.DataModel.RoomDataModel;
import mars.nomad.com.testproject.Http.EndPoint.MainModel;
import mars.nomad.com.testproject.Http.RetrofitSender;
import mars.nomad.com.testproject.Util.ErrorController;
import mars.nomad.com.testproject.Util.HttpCallback;
import mars.nomad.com.testproject.Util.SingleObjectCallback;

/**
 * Created by YJK on 2019-04-29
 * <p>
 * 서버 통신, 데이터 처리는 Presenter에서 한다.
 * Presenter에서 어댑터를 가지고 있는다. ( 페이징처리를 위해서 )
 * <p>
 * 뷰를 고치는 작업은 해당 뷰(액티비티, 프레그먼트 등)에서 처리한다.
 **/
public class RoomPresenter {

    private AdapterRoomList adapterRoomList;

    /**
     * User
     * 방 리스트를 가져온다.
     * 페이징처리는 나중에 추가하자
     *
     * @param callback 방 데이터를 성공적으로 가져온 경우 callback으로 어뎁터를 넘겨준다. null일경우는 데이터가 없는경우
     * @param listener 하나의 방을 클릭했을때의 콜백
     */
    public void getRoomList(final Context context, final SingleObjectCallback<AdapterRoomList> callback, final SingleObjectCallback<RoomDataModel> listener) {

        try {

            // 서버 통신 이 한문장으로 가능
            RetrofitSender.initAndGetBaseEndPoint(MainModel.class).getRoomList().enqueue(new HttpCallback<RoomResponseDataModel>(new HttpCallback.SingleObjectCallback<RoomResponseDataModel>() {
                @Override
                public void onSuccess(RoomResponseDataModel result) {


                    if (result.getRoomList() != null && result.getRoomList().size() > 0) {// 데이터가 있는지, 사이즈가 0보다 큰 지검사

                        adapterRoomList = new AdapterRoomList(context, result.getRoomList(), listener);
                        callback.onSuccess(adapterRoomList);

                    } else {// 방데이터가 없음

                        callback.onSuccess(null);

                    }

                }

                @Override
                public void onFailed(String fault) {
                    callback.onFailed(fault);
                }
            }));


        } catch (Exception e) {
            ErrorController.showError(e);
        }
    }
}
