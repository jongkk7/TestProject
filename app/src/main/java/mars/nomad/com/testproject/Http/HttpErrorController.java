package mars.nomad.com.testproject.Http;

import android.util.Log;

/**
 * Created by YJK on 2019-04-29
 **/
public class HttpErrorController {

    public static final String TAG = "MarsHttp";

    /**
     * 단순히 Log.e 메세지를 로그에 출력해주는 래퍼.
     * @param msg 내용
     */
    public static void showMessage(String msg){
        Log.e(TAG, msg);
    }

    /**
     * Log.e(TAG, "MSG", e); 를 간략화한 래퍼.
     * @param e catch문에서 던져지는 Exception.
     */
    public static void showError(Exception e) {
        Log.e(TAG, "Exception.", e);
    }

    public static void showError(Throwable t) {
        Log.e(TAG, "Exception.", t);
    }

}
