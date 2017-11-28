package cn.qiyu.magicalcrue_patient.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.DoctorInfoBean;
import cn.qiyu.magicalcrue_patient.utils.DisplayHelper;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ShiLei on 2017/11/19.
 * 医生列表页面
 */

public class DoctorListActivity extends Activity {


    @Bind(R.id.iv_patient_relation_back)
    ImageView mIvPatientRelationBack;
    @Bind(R.id.rlv_odctor_team)
    RecyclerView mRlvOdctorTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        List<DoctorInfoBean> list = (List<DoctorInfoBean>) getIntent().getSerializableExtra("list");
        if (list != null) {
            mRlvOdctorTeam.setAdapter(new RecyclerAdpter(list));
            mRlvOdctorTeam.setLayoutManager(new LinearLayoutManager(DoctorListActivity.this));
        } else {
            Toast.makeText(this, "请关联医生", Toast.LENGTH_SHORT).show();
        }



    }

    @OnClick({R.id.iv_patient_relation_back, R.id.rlv_odctor_team})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_patient_relation_back:
                finish();
                break;
            case R.id.rlv_odctor_team:
                break;
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        TextView doctorname, hospitalName, profile, jobtitle;
        DoctorInfoBean mModel;
        CircleImageView ircleImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            doctorname = (TextView) itemView.findViewById(R.id.tv_user_doctor_name);
            jobtitle = (TextView) itemView.findViewById(R.id.tv_user_jobTitle);
            hospitalName = (TextView) itemView.findViewById(R.id.tv_user_hospitalName);
            profile = (TextView) itemView.findViewById(R.id.tv_user_profile);
            ircleImageView = (CircleImageView) itemView.findViewById(R.id.iv_user_icon);
        }


        void setItem(DoctorInfoBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            if (mModel != null) {
                doctorname.setText(mModel.getDoctor_name());
                jobtitle.setText(mModel.getJobTitle());
                hospitalName.setText(mModel.getHospitalName());
//                if(mModel.getProfile()!=null)
//                    profile.setText(mModel.getProfile());
//                else
//                    profile.setText("暂无");
                if (mModel.getPhoto_path() != null) {
                    String path = ApiService.GET_IMAGE_ICON + mModel.getPhoto_path();
                    DisplayHelper.loadGlide(DoctorListActivity.this, path, ircleImageView);
                } else {
                    ircleImageView.setImageResource(R.mipmap.ic_launcher);
                }
            }

        }
    }
        public  class RecyclerAdpter extends RecyclerView.Adapter<ViewHolder> {
            private List<DoctorInfoBean> mlist;

            public RecyclerAdpter(List<DoctorInfoBean> mlist) {
                this.mlist = mlist;
            }

            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_img, null));
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                holder.setItem(mlist.get(position));
                holder.refreshView();
            }

            @Override
            public int getItemCount() {

                    return mlist.size();


            }
        }

}
