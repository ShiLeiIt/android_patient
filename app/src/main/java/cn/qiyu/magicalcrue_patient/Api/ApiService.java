package cn.qiyu.magicalcrue_patient.Api;
import java.util.List;

import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
/**
 * Created by Administrator on 2017/11/13.
 */

public interface ApiService {
    /**
     * 每一个 api 地址都以 / 结尾
     */
    String BASE_URL = "http://api2.mircalcure.com/zlapi/";

    String IMAGE_URL = BASE_URL + "image/";
    String API_INDEX = "api/index/";
    String API_LOGIN = "api/login/";
    //首页数目获取
    String API_HOME_NUM = "patientInfo/getUserMessageInfo";
    String API_HOME_DOCTOR = "doctorinfoTeam/getDoctorTeamUserListByPatientId";
    //患者关系
    String API_PATIENT_RELATION = "dictionaries/getDictionariesList";


    /**
     * 注册，登录验证码发送
     */
    String IMPLEMENTATION_NOTES = "login/verificationCode";

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

    /**
     *
     * @param patientId
     * @return
     * 首页数字信息
     */
    @POST(API_HOME_NUM)
    @FormUrlEncoded
    Call<ResultModel<HomeNumBean>> getUserMessageInfo(@Field("patientId") String patientId );

    @POST(API_HOME_DOCTOR)
    @FormUrlEncoded
    Call<ResultModel<HomeNumBean>> getDoctorInfo(@Field("patientId") String patientId );
    /**
     * 验证码
     * @param account
     * @return
     */
    @POST(IMPLEMENTATION_NOTES)
    @FormUrlEncoded
    Call<ResultModel<RegisterLoginVerBean>> getVerifyInformation(@Field("account") String account);

    /**
     * 患者关系
     */
    @POST(API_PATIENT_RELATION)
    @FormUrlEncoded
    Call<ResultModel<List<PatientRelationBean>>> getPatientRelation(@Field("bianma") String bianma,@Field("type") String type);


}
