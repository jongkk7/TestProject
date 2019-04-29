package mars.nomad.com.testproject.View;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import mars.nomad.com.testproject.Adapter.AdapterRoomList;
import mars.nomad.com.testproject.DataModel.RoomDataModel;
import mars.nomad.com.testproject.MVP.RoomPresenter;
import mars.nomad.com.testproject.R;
import mars.nomad.com.testproject.Util.ErrorController;
import mars.nomad.com.testproject.Util.SingleObjectCallback;

/**
 * Created by YJK on 2019-04-29
 *
 * User - 방 리스트
 **/
public class ActivityRoomList extends BaseActivity {

    private RoomPresenter mPresenter;
    private RecyclerView recyclerViewRoomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        setLightStatusBar(getWindow().getDecorView(), this, Color.WHITE);
        initView();
        setEvent();
        loadData();
    }

    @Override
    protected void initView() {

        try{

            mPresenter = new RoomPresenter();

            recyclerViewRoomList = (RecyclerView) findViewById(R.id.recyclerViewRoomList);
            recyclerViewRoomList.setLayoutManager(new LinearLayoutManager(getContext()));

        }catch (Exception e){
            ErrorController.showError(e);
        }
    }

    @Override
    protected void setEvent() {

        try{


        }catch (Exception e){
            ErrorController.showError(e);
        }

    }

    private void loadData(){

        try{

            mPresenter.getRoomList(getContext(), new SingleObjectCallback<AdapterRoomList>() {
                @Override
                public void onSuccess(AdapterRoomList result) {

                    if(result != null){

                        recyclerViewRoomList.setAdapter(result);

                    }else{

                        // TODO : 방 데이터가 하나도 없음 -> 이에따른 레이아웃 변경 ( no data )

                    }

                }

                @Override
                public void onFailed(String fault) {
                    Toast.makeText(mContext, fault, Toast.LENGTH_SHORT).show();
                    ErrorController.showMessage(fault);
                }
            }, new SingleObjectCallback<RoomDataModel>() {
                @Override
                public void onSuccess(RoomDataModel result) {

                    // TODO : 방 클릭
                    Toast.makeText(mContext, result.getTitle(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailed(String fault) {
                    Toast.makeText(mContext, fault, Toast.LENGTH_SHORT).show();
                    ErrorController.showMessage(fault);
                }
            });


        }catch (Exception e){
            ErrorController.showError(e);
        }
    }


}
