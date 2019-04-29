package mars.nomad.com.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mars.nomad.com.testproject.Util.ErrorController;
import mars.nomad.com.testproject.View.ActivityAdminRoomList;
import mars.nomad.com.testproject.View.ActivityRoomList;
import mars.nomad.com.testproject.View.BaseActivity;

public class ActivityMain extends BaseActivity {

    private Button buttonRoomList;
    private Button buttonAdminRoomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setEvent();
    }

    @Override
    protected void initView() {

        try{

            buttonRoomList = (Button) findViewById(R.id.buttonRoomList);
            buttonAdminRoomList = (Button) findViewById(R.id.buttonAdminRoomList);

        }catch (Exception e){
            ErrorController.showError(e);
        }

    }

    @Override
    protected void setEvent() {

        try{

            // 사용자 - 방 리스트 ( 참가, 방 상세보기 )
            buttonRoomList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), ActivityRoomList.class);
                    startActivity(i);
                    overridePendingTransition(0,0); // 화면 전환 애니메이션
                }
            });


            // 관리자 - 방 리스트 ( 방 상세보기, 허가, 불가 이벤트 가능해야한다. )
            buttonAdminRoomList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), ActivityAdminRoomList.class);
                    startActivity(i);
                    overridePendingTransition(0,0); // 화면 전환 애니메이션
                }
            });

        }catch (Exception e){
            ErrorController.showError(e);
        }
    }
}
