package mars.nomad.com.testproject.Util;

import mars.nomad.com.testproject.Http.HttpErrorController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by YJK on 2019-04-29
 **/
public class HttpCallback<T> implements Callback<T> {

    private SingleObjectCallback<T> mCallback;

    public HttpCallback(SingleObjectCallback<T> callback) {
        this.mCallback = callback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        try {
            T res = response.body();

            if (res != null) {

                HttpErrorController.showMessage(res.toString());

                mCallback.onSuccess(res);

            } else {
                mCallback.onFailed("서버로 부터 재대로된 응답을 받지 못했습니다.");
            }
        } catch (Exception e) {
            HttpErrorController.showError(e);
            mCallback.onFailed("Exception during processing network.");
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        HttpErrorController.showError(t);
        mCallback.onFailed("Exception during processing network.");
    }

    public interface SingleObjectCallback<T> {

        void onSuccess(T result);

        void onFailed(String fault);
    }
}
