package cn.qiyu.magicalcrue_patient.Api;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
/**
 * Created by Administrator on 2017/11/13.
 */

public interface ApiService {
    /**
     * 每一个 api 地址都以 / 结尾
     */
    String BASE_URL = "http://api2.mircalcure.com/";

    String IMAGE_URL = BASE_URL + "image/";

    String API_INDEX = "api/index/";

    String API_BOOK = "api/book/";

    String API_LOGIN = "api/login/";
    String API_HOME_NUM = "zlapi/patientInfo/getUserMessageInfo";


    /**
     * 发起一个 get 请求
     * <p>
     * 服务响应的数据全部存储在 Call<ResponseBody>
     * <p>
     * get 请求使用 ? 传参时  使用 @Query
     *
     * @return
     */
    @GET(API_INDEX)
    Call<ResponseBody> test(@Query("name") String a);

    /**
     * 传递 RESTful 风格api 的参数 使用 @Path
     *
     * @param i
     * @return
     */
    @GET(API_BOOK + "{position}")
    Call<ResponseBody> getBook(@Path("position") int i);

//    @GET(API_BOOK + "{position}")
//    Call<ResultModel<Book>> getBook2(@Path("position") int i);

    /**
     * 获取所有的书籍信息
     *
     * @return
     */
//    @GET(ApiService.API_BOOK)
//    Call<ResultModel<List<Book>>> getBooks();
//
//    @PUT(ApiService.API_BOOK)
//    Call<ResultModel> update(@Query("id") int id, @Query("name") String name,
//                             @Query("author") String author, @Query("price") double price);
//
//    @DELETE(API_BOOK + "{position}")
//    Call<ResultModel> delete(@Path("position") int position);

    /**
     * post 传递参数使用 @Field
     * <p>
     * 使用 post 请求数据时  必须加上 @FormUrlEncoded
     *
     * @param name
     * @param password
     * @return
     */
//    @POST(API_LOGIN)
//    @FormUrlEncoded
//    Call<ResultModel> login(@Field("name") String name, @Field("pwd") String password);
//
    @POST(API_HOME_NUM)
    @FormUrlEncoded
    Call<HomeNumBean> getUserMessageInfo(@Field("patientId") String patientId );

}
