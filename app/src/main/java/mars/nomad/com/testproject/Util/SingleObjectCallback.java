package mars.nomad.com.testproject.Util;

/**
 * Created by YJK on 2019-04-29
 **/
public interface SingleObjectCallback<T> {

    void onSuccess(T result);

    void onFailed(String fault);
}
