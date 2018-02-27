package cn.qiyu.magicalcrue_patient.Api;

import java.util.List;

import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.CaseHistoryNumBean;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.CreateRemindBean;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.DiseasesBean;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.HospitalOfficeListBean;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.InfoUserNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InfoUserSystemMsgListBean;
import cn.qiyu.magicalcrue_patient.model.InformationBean;
import cn.qiyu.magicalcrue_patient.model.InspectionReportBean;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.PatientCourseListBean;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.PatientInforSaveBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyWaybean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.model.SymptomatographyBean;
import cn.qiyu.magicalcrue_patient.model.UserInfor;
import cn.qiyu.magicalcrue_patient.model.VersionUpdateBean;
import cn.qiyu.magicalcrue_patient.model.VisitDialogueQuizBean;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/11/13.
 */

public interface


ApiService {
    /**
     * 每一个 api 地址都以 / 结尾
     */
    //正式服务器
    String BASE_URL = "http://api2.mircalcure.com/zlapi/";
    //测试服务器
    //String BASE_URL = "http://118.178.135.207:9008/zlapi/";
//    String IMAGE_BASE_URL = "http://upload2.mircalcure.com/tumourfile/";
    String IMAGE_BASE_URL = "http://10.0.0.29:8080/zlapi/";

    String API_INDEX = "api/index/";
    String API_LOGIN = "api/login/";
    //首页数目获取
    String API_HOME_NUM = "patientInfo/getUserMessageInfo";
    //通过患者Uuid获取医生工作组
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
    String API_SINGLE_IMAGE_UP_LOAD = "media/singleUploadPic";


    //患者基本信息修改
    String API_PATIENT_INFOR_EDITOR = "healthFile/medicalRecordInfo";
    //疾病种类列表
    String API_DISEASES = "disease/diseaseList";
    //扫描医生
    String API_DOCTOR_QRCODE = "healthFile/bindingFollowDoctor";
    //医生团队的成员
    String API_DOCTOR_TEAM = "doctorinfoTeam/getDoctorTeamUserListByPatientId";
    //头像加载
//    String GET_IMAGE_ICON = "http://upload2.mircalcure.com/tumourfile/sysfile/getImage/2/";
    String GET_IMAGE_ICON = "http://qiyuji-pic.oss-cn-hangzhou.aliyuncs.com/";

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
    String API_DOCTOR_NOTICE_LIST = "message/userNoticeList";
    //消息界面，系统消息列表
    String API_SYSTEM_MESSAGE_LIST = "message/userMessageList";

    //消息列表
    String API_INFORMATION_LIST = "message/messageHome";
    //随访对话详情
    String GET_FOLLOW_UP_DIALOGUELIST = "patientInfo/getFollowUpDialogueList";
    //评论随访对话
    String API_COMMENT_VISIT_DIALOGUE = "patientInfo/setConsultationComment";
    //评论列表
    String API_COMMENT_LIST = "patientInfo/getCommentList";
    //随访对话中提问
    String API_VISITDIALOGUE_QUIZ = "patientInfo/createConsultation";
    //门诊资料信息获取
    String API_OUTPATIENT_INFORMATION_OBTAIN = "medicalRecord/getOutpatientDepartmenList";
    //出院小结信息获取
    String API_LEAVE_HOSPITAL_INFORMATION_OBTAIN = "medicalRecord/getHospitalizationHistory";
    //医院列表信息
    String API_HOSPITALLIST = "hospital/hospitalList";
    //科室列表信息
    String API_HOSPITALOFFICE_LIST = "hospital/officeList";
    //门诊信息保存
    String API_OUTPATIENT_INFO_SAVE = "medicalRecord/setOutpatientDepartmen";
    //出院小结信息保存
    String API_LEAVEHOSPITAL_INFO_SAVE = "medicalRecord/setHospitalizationHistory";
    //用药记录方案信息获取
    String API_PHARMACY_PALN_RECORD = "medicalRecord/getDurgRecord";
    //用药方案记录添加
    String API_PHARMACY_RECROD_SAVE = "medicalRecord/setDurgRecord";
    //获取用药方式
    String API_PHARMACY_WAY = "dictionaries/getDictionariesList";
    //身体症状记录列表
    String API_SYMPTOMATOGRAPHY_LIST = "medicalRecord/getSymptomRecord";
    //身体症状记录添加
    String API_SYMPTOMATOGRAPHY_SAVE = "medicalRecord/setSymptomRecord";
    //检查报告单信息获取
    String API_INSPECTION_REPORT_OBTAIN = "medicalRecord/getInspectRecord";
    //检查报告单添加
    String API_INSPECTION_REPORT_SAVE = "medicalRecord/setInspectRecord";
    //获取患者病历数统计
    String API_CASEHISTORY_NUM = "medicalRecord/getMedicalTotalByPatientId";
    //首页Banner地址
    String API_HOME_BANNER = "common/patientHomeBanner";
    //医生公告列表已读
    String API_DOCTOR_NOTICE_READ = "message/setDoctorNoticeReaded";
    //消息界面随访消息已读(Num显示为零)
    String API_FOLLOW_UP_MESSAGE_READ = "message/setUserMessageReaded";
    //消息界面系统消息已读
    String API_SYSTEMMSG_READ = "message/getMessageDetail";
    //退出登录
    String API_LOGOUT = "patientInfo/userLogout";
    //随访页面患教课堂列表
    String API_PATIENT_COURSE_LIST = "course/patentCourseList";

    //获取提醒的列表
    String API_REMIND_LIST ="event/patientEventlist";
    //删除自己创建的日程提醒
    String API_DELETE_EVENT = "event/deleteEvent";
    //创建日程提醒
    String API_CREATE_EVENT_REMIND = "event/createEvent";
    //日程提醒详情页面
    String API_EVENT_REMIND_DETAILS = "event/getEventDetail";
    //版本号更新
    String API_VERSION_UPDATE = "common/getAppLatestVersion";









    /**
     * @param userUuid
     * @return 首页数字信息
     */
    @POST(API_HOME_NUM)
    @FormUrlEncoded
    Call<ResultModel<HomeNumBean>> getUserMessageInfo(@Field("userId") String userUuid);

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
    Call<ImageUpLoadBean> getUpSingleImage(@Part("myfile\"; filename=\"image.png") RequestBody imgs);

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
    Call<ResultModel<List<InfoUserNoticeListBean>>> getUserNoticeList(@Field("userUUid") String userUuid,
                                                                      @Field("page") String page,
                                                                      @Field("pagecount") String pagecount);

    /**
     * 消息，系统消息列表
     */
    @POST(API_SYSTEM_MESSAGE_LIST)
    @FormUrlEncoded
    Call<ResultModel<List<InfoUserSystemMsgListBean>>> getSystemMessageList(@Field("userUUid") String userUuid,
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
     *
     * @param
     * @return
     */
    @POST(GET_FOLLOW_UP_DIALOGUELIST)
    @FormUrlEncoded
    Call<ResultModel<List<FollowUpMessageDetaild>>> getFollowUpDialogueList(@Field("userId") String userUuid,
                                                                            @Field("userType") String userType,
                                                                            @Field("page") String page,
                                                                            @Field("pagecount") String pagecount);

    /**
     * 评论随访对话
     *
     * @param
     * @return
     */
    @POST(API_COMMENT_VISIT_DIALOGUE)
    @FormUrlEncoded
    Call<ResultModel> getCommentVisitDialogue(@Field("userId") String userUuid,
                                              @Field("consultation_id") String consultationUuid,
                                              @Field("user_role") String userRole,
                                              @Field("content") String content, @Field("parent_id") String parentId, @Field("type") String type);

    /**
     * 评论列表
     *
     * @param
     * @return
     */
    @POST(API_COMMENT_LIST)
    @FormUrlEncoded
    Call<ResultModel<List<Comment>>> getCommentList(
            @Field("consultation_id") String consultationUuid,
            @Field("page") String page,
            @Field("pagecount") String pagecount);


    /**
     * 随访对话提问带图片（imageArray）
     *
     * @param
     * @return
     */

    @POST(API_VISITDIALOGUE_QUIZ)
    @FormUrlEncoded
    Call<ResultModel<VisitDialogueQuizBean>> getVisitDialogueQuiz(
            @Field("doctorId") String doctorUuid,
            @Field("userId") String userUuid,
            @Field("userType") String userType,
            @Field("complaint") String complaint,
            @Field("imageArray") String imageArray
    );

    /**
     * 随访对话提问不带图片（imageArray）
     *
     * @param
     * @return
     */

    @POST(API_VISITDIALOGUE_QUIZ)
    @FormUrlEncoded
    Call<ResultModel<VisitDialogueQuizBean>> getVisitDialogueQuizText(
            @Field("doctorId") String doctorUuid,
            @Field("userId") String userUuid,
            @Field("userType") String userType,
            @Field("complaint") String complaint

    );

    /**
     * 门诊资料信息获取显示
     */
    @POST(API_OUTPATIENT_INFORMATION_OBTAIN)
    @FormUrlEncoded
    Call<ResultModel<List<DischargeBean>>> getOutpatientInfo(
            @Field("patientId") String patientUuid,
            @Field("page") String page,
            @Field("pagecount") String pageCount);

    /**
     * 出院小结信息获取
     */
    @POST(API_LEAVE_HOSPITAL_INFORMATION_OBTAIN)
    @FormUrlEncoded
    Call<ResultModel<List<DischargeBean>>> getLeaveHospitalInfo(
            @Field("patientId") String patientUuid,
            @Field("page") String page,
            @Field("pagecount") String pageCount);

    /**
     * 医院列表信息
     */
    @POST(API_HOSPITALLIST)
    @FormUrlEncoded
    Call<ResultModel<List<HospitalListBean>>> getHospitalList(
            @Field("keywords") String keywords,
            @Field("page") String page,
            @Field("pagecount") String pageCount);


    /**
     * 科室列表信息
     */
    @POST(API_HOSPITALOFFICE_LIST)
    @FormUrlEncoded
    Call<ResultModel<List<HospitalOfficeListBean>>> getHospitalOfficeList(
            @Field("page") String page,
            @Field("pagecount") String pageCount);

    /**
     * 添加门诊信息保存带图片
     */
    @POST(API_OUTPATIENT_INFO_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getOutPatientSave(
            @Field("patientId") String patientUuid,
            @Field("diagnosis_date") String diagnosisDate,
            @Field("hospital_id") String hospitalId,
            @Field("office_id") String officeId,
            @Field("doctor_name") String doctorName,
            @Field("summary") String summary,
            @Field("imageList") String imageList);

    /**
     * 添加门诊信息保存不带图片
     */
    @POST(API_OUTPATIENT_INFO_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getOutPatientSaveText(
            @Field("patientId") String patientUuid,
            @Field("diagnosis_date") String diagnosisDate,
            @Field("hospital_id") String hospitalId,
            @Field("office_id") String officeId,
            @Field("doctor_name") String doctorName,
            @Field("summary") String summary);

    /**
     * 添加出院小结信息带图片
     */
    @POST(API_LEAVEHOSPITAL_INFO_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getLeaveHospitalSave(
            @Field("patientId") String patientUuid,
            @Field("be_hospitalized_date") String beHospitalizedDate,
            @Field("leave_hospital_date") String leaveHospitalDate,
            @Field("hospital_id") String hospitalId,
            @Field("hospitalization_office_id") String hospitalizationOfficeId,
            @Field("doctor_name") String doctorName,
            @Field("summary") String summary,
            @Field("imageList") String imageList);

    /**
     * 添加出院小结信息不带图片
     */
    @POST(API_LEAVEHOSPITAL_INFO_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getLeaveHospitalSaveText(
            @Field("patientId") String patientUuid,
            @Field("be_hospitalized_date") String beHospitalizedDate,
            @Field("leave_hospital_date") String leaveHospitalDate,
            @Field("hospital_id") String hospitalId,
            @Field("hospitalization_office_id") String hospitalizationOfficeId,
            @Field("doctor_name") String doctorName,
            @Field("summary") String summary
    );


    /**
     * 用药方案记录信息获取
     */
    @POST(API_PHARMACY_PALN_RECORD)
    @FormUrlEncoded
    Call<ResultModel<List<PharmacyBean>>> getPharmacyRecordInfo(
            @Field("patientId") String patientUuid,
            @Field("page") String page,
            @Field("pagecount") String pageCount);

    /**
     * 添加用药方案记录带图片
     */
    @POST(API_PHARMACY_RECROD_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getPharmacyRecordSave(
            @Field("patientId") String patientUuid,
            @Field("drug_name") String drugName,
            @Field("usaged") String usaged,
            @Field("amount") String amount,
            @Field("remarks") String remarks,
            @Field("imageList") String imageList);


    /**
     * 添加用药方案记录带图片
     */
    @POST(API_PHARMACY_RECROD_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getPharmacyRecordSaveText(
            @Field("patientId") String patientUuid,
            @Field("drug_name") String drugName,
            @Field("usaged") String usaged,
            @Field("amount") String amount,
            @Field("remarks") String remarks);

    /**
     * 获取用药方式
     */
    @POST(API_PHARMACY_WAY)
    @FormUrlEncoded
    Call<ResultModel<List<PharmacyWaybean>>> getPharmacyWay(@Field("bianma") String bianma, @Field("type") String type);


    /**
     * 身体症状记录列表
     */
    @POST(API_SYMPTOMATOGRAPHY_LIST)
    @FormUrlEncoded
    Call<ResultModel<List<SymptomatographyBean>>> getSymptomatographyList(
            @Field("patientId") String PatientUuid,
            @Field("page") String page,
            @Field("pagecount") String pageCount);


    /**
     * 添加症状记录带图片
     */
    @POST(API_SYMPTOMATOGRAPHY_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getSymptomatographySave(
            @Field("patientId") String PatientUuid,
            @Field("symptom_code") String symptomCode,
            @Field("symptom") String symptom,
            @Field("remarks") String remarks,
            @Field("imageList") String imageList);


    /**
     * 添加症状记录不带图片
     */
    @POST(API_SYMPTOMATOGRAPHY_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getSymptomatographySaveText(
            @Field("patientId") String PatientUuid,
            @Field("symptom_code") String symptomCode,
            @Field("symptom") String symptom,
            @Field("remarks") String remarks);


    /**
     * 检查报告单信息获取
     */
    @POST(API_INSPECTION_REPORT_OBTAIN)
    @FormUrlEncoded
    Call<ResultModel<List<InspectionReportBean>>> getInspectionReportInfo(
            @Field("patientId") String patientUuid,
            @Field("page") String page,
            @Field("pagecount") String pageCount);

    /**
     * 添加检查报告单带图片
     */
    @POST(API_INSPECTION_REPORT_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getInspectionReportSave(
            @Field("patientId") String PatientUuid,
            @Field("inspection_date") String inspectionDate,
            @Field("type_id") String typeId,
            @Field("inspection_description") String inspectionDescription,
            @Field("imageList") String imageList);

    /**
     * 添加检查报告单不带图片
     */
    @POST(API_INSPECTION_REPORT_SAVE)
    @FormUrlEncoded
    Call<ResultModel<AddOutPatientDataSaveBean>> getInspectionReportSaveText(
            @Field("patientId") String PatientUuid,
            @Field("inspection_date") String inspectionDate,
            @Field("type_id") String typeId,
            @Field("inspection_description") String inspectionDescription
    );


    /**
     * 统计患者病历数目
     */
    @POST(API_CASEHISTORY_NUM)
    @FormUrlEncoded
    Call<ResultModel<CaseHistoryNumBean>> getCaseHistoryNum(
            @Field("patientId") String patientUuid);

    /**
     * 首页Banner
     */
    @POST(API_HOME_BANNER)
    @FormUrlEncoded
    Call<ResultModel<List<HomeBannerBean>>> getHomeBanner(
            @Field("type") String type);

    /**
     * 医生公告已读
     */
    @POST(API_DOCTOR_NOTICE_READ)
    @FormUrlEncoded
    Call<ResultModel> getDoctorNoticeRead(
            @Field("userId") String userUuid,
            @Field("messageId") String messageUuid
    );

    /**
     * 随访对话已读（num为零）
     */
    @POST(API_FOLLOW_UP_MESSAGE_READ)
    @FormUrlEncoded
    Call<ResultModel> getFollowUpMsgRead(
            @Field("userId") String userUuid);


    /**
     * 系统消息已读
     */
    @POST(API_SYSTEMMSG_READ)
    @FormUrlEncoded
    Call<ResultModel<InfoUserSystemMsgListBean>> getSystemMsgRead(
            @Field("messageId") String messageId);

    /**
     * 退出登录
     */
    @POST(API_LOGOUT)
    @FormUrlEncoded
    Call<ResultModel> getLogout(
            @Field("uuid") String userUuid, @Field("type") String type);


    /**
     * 随访患教课堂列表
     */
    @POST(API_PATIENT_COURSE_LIST)
    @FormUrlEncoded
    Call<ResultModel<List<PatientCourseListBean>>> getPatientCoureseList(
            @Field("patient_id") String patientUuid, @Field("page") String page,@Field("pagecount") String pagecount);


    /**
     * 随访提醒列表
     */
    @POST(API_REMIND_LIST)
    @FormUrlEncoded
    Call<ResultModel<List<RemindListBean>>> getVisitRemindList(
            @Field("patientId") String patientUuid, @Field("page") String page,@Field("pagecount") String pagecount);

    /**
     * 删除自己创建的日程提醒
     */
    @POST(API_DELETE_EVENT)
    @FormUrlEncoded
    Call<ResultModel> deleteOneselfRemindEvent( @Field("uuid") String remindUuid, @Field("userId") String patientUuid);

    /**
     * 患者创建的日程提醒
     */
    @POST(API_CREATE_EVENT_REMIND)
    @FormUrlEncoded
    Call<ResultModel<CreateRemindBean>> CreatRemindEvent(@Field("uuid") String remindUuid,
                                                         @Field("event_name") String eventName,
                                                         @Field("event_detail") String eventRemark,
                                                         @Field("event_time") String remindTime,
                                                         @Field("repeat_num") String repeatNum,
                                                         @Field("repeat_type") String repeatType,
                                                         @Field("event_create_user") String patientUuid,
                                                         @Field("event_create_user_role") String userRoleType,
                                                         @Field("event_implement_user") String eventReception,
                                                         @Field("enent_create_user_status") String userStatus,
                                                         @Field("event_implement_user_status") String receptionUserStatus
                                                            );



    /**
     * 日程提醒详情
     */
    @POST(API_EVENT_REMIND_DETAILS)
    @FormUrlEncoded
    Call<ResultModel<CreateRemindBean>> getEventRemindDetails( @Field("uuid") String remindUuid);


    /**
     * 版本对应升级
     */
    @POST(API_VERSION_UPDATE)
    @FormUrlEncoded
    Call<ResultModel<VersionUpdateBean>> getAppVersionIsUpdate(@Field("code") String patient,@Field("platform")String platform,
                                                               @Field("channel")String channel,@Field("current_version")String current_version);

}
