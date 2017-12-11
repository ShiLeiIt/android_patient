package cn.qiyu.magicalcrue_patient.Api;

import java.io.File;
import java.util.List;

import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.DiseasesBean;
import cn.qiyu.magicalcrue_patient.model.DoctorInfoBean;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.InfoDoctorNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InformationBean;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.PatientInforSaveBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailsCommitBean;
import cn.qiyu.magicalcrue_patient.model.UserInfor;
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
    //城市列表
    String API_CITIY = "common/getNativeList";

    //单张图片
    String API_SINGLE_IMAGE_UP_LOAD = "sysfile/singleUpload";


    //患者基本信息修改
    String API_PATIENT_INFOR_EDITOR = "healthFile/medicalRecordInfo";
    //疾病种类列表
    String API_DISEASES = "disease/diseaseList";
    //扫描医生
    String API_DOCTOR_QRCODE = "healthFile/bindingFollowDoctor";
    //医生团队的成员
    String API_DOCTOR_TEAM = "doctorinfoTeam/getDoctorTeamUserListByPatientId";
    //头像加载
    String GET_IMAGE_ICON = "http://upload.mircalcure.com/tumourfile/sysfile/getImage/3/";
    //获取用户基本信息
    String API_USERINFOR = "patientInfo/getUserInfo";
    //获取患者基本信息
    String API_PATIENT_INFOR = "healthFile/getPatientInfo";
    //量表
    String API_SCALE_INFOR = "common/questionnaireList";
    //量表详情
    String API_SCALE_DETAILS = "common/questionnaireDetail";
    //量表提交
    String API_SCALE_COMMIT = "common/saveQuestionnaireOption";
    //消息界面，医生公告列表
    String API_DOCTOR_NOTICE_LIST = "message/doctorNoticeList";
    //消息列表
    String API_INFORMATION_LIST = "message/messageHome";
    //医生随访消息详情 根据患者ID
    String GET_FOLLOW_UP_DIALOGUELIST="patientInfo/getFollowUpDialogueList";


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
    Call<ImageUpLoadBean> getUpSingleImage(@Part("myfile\"; filename=\"text.jpg\"") RequestBody imgs);


    /**
     * 患者信息修改
     */
    @POST(API_PATIENT_INFOR_EDITOR)
    @FormUrlEncoded
    Call<ResultModel<PatientInforSaveBean>> getPatientInfor(@Field("uuid") String patientUuid,
                                                            @Field("userId") String userId,
                                                            @Field("name") String name,
                                                            @Field("sex") String sex,
                                                            @Field("birthday") String birthday,
                                                            @Field("IDcardNo") String idCardNo,
                                                            @Field("mobile") String mobile,
                                                            @Field("native_place_cd") String native_place_cd,
                                                            @Field("attending_doctor") String attending_doctor,
                                                            @Field("firstVisitTime") String firstVisitTime,
                                                            @Field("relationship") String relationship,
                                                            @Field("disease_id") String disease_id,
                                                            @Field("appFirstVisitTime") String appFirstVisitTime);


    /**
     * 疾病种类
     */
    @POST(API_DISEASES)
    @FormUrlEncoded
    Call<ResultModel<List<DiseasesBean>>> getDiseasesList(@Field("") String post);

    /**
     * 扫描医生二维码
     */

    @POST(API_DOCTOR_QRCODE)
    @FormUrlEncoded
    Call<ResultModel> getDoctorQRcode(@Field("uuid") String patientUuid, @Field("follow_doctor") String DoctorUuid);

    /**
     * 医生团队
     */
    @POST(API_DOCTOR_TEAM)
    @FormUrlEncoded
    Call<ResultModel<DoctorTeamBean>> getDoctorTeamInfor(@Field("patientId") String patientId);

    /**
     * 获取用户基本信息
     */
    @POST(API_USERINFOR)
    @FormUrlEncoded
    Call<ResultModel<UserInfor>> getUserInfor(@Field("uuid") String userUuid);

    /**
     * 获取患者基本信息
     */
    @POST(API_PATIENT_INFOR)
    @FormUrlEncoded
    Call<ResultModel<PatientInfor>> getPatientBasicInfor(@Field("uuid") String patientUuid);

    /**
     * 获取随访量表信息
     */
    @POST(API_SCALE_INFOR)
    @FormUrlEncoded
    Call<ResultModel<List<MyScaleBean>>> getMyScaleInfor(@Field("userID") String patientUuid,
                                                         @Field("status") String status,
                                                         @Field("page") String page,
                                                         @Field("pagecount") String pagecount);


    /**
     * 获取随访量表详情
     */
    @POST(API_SCALE_DETAILS)
    @FormUrlEncoded
    Call<ResultModel<ScaleDetailBean>> getScaleDetilsInfor(@Field("paperID") String paperId,
                                                           @Field("paperUserID") String paperUserID,
                                                           @Field("userID") String patientUuid
    );

    /**
     * 量表提交
     */
    @POST(API_SCALE_COMMIT)
    @FormUrlEncoded
    Call<ResultModel> getScaleDetilsCommit(@Field("userID") String patientUuid,
                                           @Field("questionArr") String questionArr,
                                           @Field("paperUserID") String paperUserID
    );

    /**
     * 消息，医生公告列表
     */
    @POST(API_DOCTOR_NOTICE_LIST)
    @FormUrlEncoded
    Call<ResultModel<List<InfoDoctorNoticeListBean>>> getDoctorNoticeList(@Field("doctorId") String doctorUuid,
                                                                           @Field("page") String page,
                                                                           @Field("pagecount") String pagecount);
    /**
     * 消息界面列表
     */
    @POST(API_INFORMATION_LIST)
    @FormUrlEncoded
    Call<ResultModel<InformationBean>> getInformationList(@Field("userUUid") String Uuid);

    /**
     * 随访消息列表
     * @param
     * @return
     */
    @POST(GET_FOLLOW_UP_DIALOGUELIST)
    @FormUrlEncoded
    Call<ResultModel<List<FollowUpMessageDetaild>>> getFollowUpDialogueList(@Field("userId") String userUuid,
                                                                            @Field("userType") String userType,
                                                                            @Field("page") String page,
                                                                            @Field("pagecount") String pagecount);

}
