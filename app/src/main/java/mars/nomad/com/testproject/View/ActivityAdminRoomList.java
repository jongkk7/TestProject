package mars.nomad.com.testproject.View;

import android.graphics.Color;
import android.os.Bundle;

import mars.nomad.com.testproject.R;

/**
 * Created by YJK on 2019-04-29
 **/
public class ActivityAdminRoomList extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        setLightStatusBar(getWindow().getDecorView(), this, Color.WHITE);
        initView();
        setEvent();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setEvent() {

    }
}
