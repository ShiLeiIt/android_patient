package cn.qiyu.magicalcrue_patient.Api;

import java.io.File;
import java.util.List;

import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Administrator on 2017/11/13.
 */

public interface ApiService {
    /**
     * 每一个 api 地址都以 / 结尾
     */
    String BASE_URL = "http://api2.mircalcure.com/zlapi/";
    String IMAGE_BASE_URL = "http://upload2.mircalcure.com/tumourfile/";

    String IMAGE_URL = BASE_URL + "image/";
    String API_INDEX = "api/index/";
    String API_LOGIN = "api/login/";
    //首页数目获取
    String API_HOME_NUM = "patientInfo/getUserMessageInfo";
    String API_HOME_DOCTOR = "doctorinfoTeam/getDoctorTeamUserListByPatientId";
    //患者关系
    String API_PATIENT_RELATION = "dictionaries/getDictionariesList";
    //注册 登录
    String API_REGISTER_LOGIN = "login/patientLoginByAccountAndVerCode";

    //注册，登录验证码发送
    String IMPLEMENTATION_NOTES = "login/verificationCode";
    //用户基本信息修改
    String API_USER_INFOR_EDITOR = "patientInfo/uplodeUserInfo";
    //城市
    String API_CITIY = "common/getNativeList";

    //单张图片
    String API_SINGLE_IMAGE_UP_LOAD = "fileUpload/singleUpload";



    /**
     * @param patientId
     * @return 首页数字信息
     */
    @POST(API_HOME_NUM)
    @FormUrlEncoded
    Call<ResultModel<HomeNumBean>> getUserMessageInfo(@Field("patientId") String patientId);

    @POST(API_HOME_DOCTOR)
    @FormUrlEncoded
    Call<ResultModel<HomeNumBean>> getDoctorInfo(@Field("patientId") String patientId);

    /**
     * 验证码
     *
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
    Call<ResultModel<List<PatientRelationBean>>> getPatientRelation(@Field("bianma") String bianma, @Field("type") String type);

    /**
     * 注册登录
     */
    @POST(API_REGISTER_LOGIN)
    @FormUrlEncoded
    Call<ResultModel<RegisterLoginBean>> getRegisterLogin(@Field("account") String account, @Field("verCode") String verCode, @Field("jpush_id") String jpushId);

    /**
     * 用户信息修改
     */
    @POST(API_USER_INFOR_EDITOR)
    @FormUrlEncoded
    Call<ResultModel> getUserInforEdt(@Field("id") String id, @Field("photoPath") String photoPath, @Field("user_name") String user_name,
                                      @Field("birthday") String birthday, @Field("sex") String sex, @Field("native_place_cd") String native_place_cd);

    /**
     * 城市
     */
    @POST(API_CITIY)
    @FormUrlEncoded
    Call<ResultModel<List<CityBean>>> getCitiyInfor(@Field("parent_code") String parent_code, @Field("levelId") String levelId);

    /**
     * 单张图片，头像
     */
    @POST(API_SINGLE_IMAGE_UP_LOAD)
    @Multipart
    Call<ImageUpLoadBean> getUpSingleImage(@Part("myfile\"; filename=\"test.jpg\"") RequestBody myIconFile);

}
