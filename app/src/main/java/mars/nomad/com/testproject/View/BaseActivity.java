package mars.nomad.com.testproject.View;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import mars.nomad.com.testproject.Util.ErrorController;

/**
 * Created by YJK on 2019-04-29
 **/
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

    }

    @Override
    protected void onStart() {
        super.onStart();
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    }

    /**
     * 모든 findViewById, 혹은 View 클래스로의 위임, 프리젠터의 선언이 이곳에서 이뤄진다.
     */
    protected abstract void initView();

    /**
     * 순수 View이벤트를 제외한 presenter인터렉션이 필요한 이벤트 콜백이 여기서 선언된다.
     */
    protected abstract void setEvent();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected Activity getActivity() {
        return this;
    }

    protected Context getContext() {
        return this;
    }

    /**
     * statusbar를 밝게하고, 그 위에 표현되는 모든 것을 어둡게 한다.
     *
     * @param view
     * @param activity
     */
    public static void setLightStatusBar(View view, Activity activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    public static void setLightStatusBar(View view, Activity activity, int color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(color);
        }
    }

    /**
     * statusbar를 어둡게하고, 그 위에 표현되는 모든 것을 밝게 한다.
     *
     * @param view
     * @param activity
     */
    public static void setDarkStatusBar(View view, Activity activity) {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int flags = view.getSystemUiVisibility();
            flags = 0;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.GRAY);
        }
    }

    /**
     * 간단한 message + 확인 조합의 얼러트 다이얼로그를 출력한다.
     *
     * @param message
     */
    protected void showSimpleAlertDialog(String message) {

        try {

            if (mContext == null) {

                ErrorController.showMessage("[BaseActivity] showSimpleAlertDialog- context is null.");
                return;
            }

            AlertDialog dialog = new AlertDialog.Builder(mContext)
                    .setMessage(message)
                    .setPositiveButton("확인", null)
                    .create();

            if (mContext != null && getActivity() != null) {

                dialog.show();
            }

        } catch (Exception e) {
            ErrorController.showError(e);
        }
    }
}
