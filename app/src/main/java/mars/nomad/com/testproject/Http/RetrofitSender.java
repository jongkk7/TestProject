package mars.nomad.com.testproject.Http;

import android.content.Context;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import mars.nomad.com.testproject.Util.SSLUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YJK on 2019-04-29
 **/
public class RetrofitSender {

    public static String BASE_URL = "http://183.111.125.16:16162";


    private static Retrofit retrofit = null;

    private static OkHttpClient httpClient = null;
    private static Context context = null;

    public static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static <T> T initAndGetBaseEndPoint(Class<T> classType) {

        T result = null;

        initHttpClient();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClient)
                .build();

        result = (T) retrofit.create(classType);
        return result;
    }


    /**
     * Client init
     */
    private static void initHttpClient() {
        try {
            if (httpClient == null) {
                if (context != null) {

                    OkHttpClient.Builder tempOkhttp = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).
                            addInterceptor(new Interceptor() {
                                @Override
                                public okhttp3.Response intercept(Chain chain) throws IOException {

                                    Request request = chain.request();

                                    Request.Builder newRequest = request.newBuilder().header("Content-Type", "application/json");

                                    HttpErrorController.showMessage("URL : " + request.url().toString());

                                    return chain.proceed(newRequest.build());
                                }
                            });

                    tempOkhttp.sslSocketFactory(SSLUtil.getSSLSocketFactory(context));

                    httpClient = tempOkhttp.build();
                } else {
                    httpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
                }
            }


        } catch (Exception e) {
            HttpErrorController.showError(e);
        }
    }
}
