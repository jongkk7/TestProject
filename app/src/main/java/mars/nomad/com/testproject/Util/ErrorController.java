package mars.nomad.com.testproject.Util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by YJK on 2019-04-29
 **/
public class ErrorController {


    public static final String TAG = "Mars";

    private static boolean DEBUG = true;

    /**
     * 단순히 Log.e 메세지를 로그에 출력해주는 래퍼.
     *
     * @param msg 내용
     */
    public static void showMessage(String msg) {

        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    /**
     * Log.e(TAG, "MSG", e); 를 간략화한 래퍼.
     *
     * @param e catch문에서 던져지는 Exception.
     */
    public static void showError(Exception e) {
        Log.e(TAG, "Exception.", e);
    }

    /**
     * Log.e(TAG, "MSG", e); 를 간략화한 래퍼.
     *
     * @param t catch문에서 던져지는 Exception.
     */
    public static void showError(Throwable t) {
        Log.e(TAG, "Exception.", t);
    }



}
