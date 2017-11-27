package cn.qiyu.magicalcrue_patient.adapter;

import android.content.Context;;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;



import cn.qiyu.magicalcrue_patient.R;


/**
 * Created by Administrator on 2017/8/17.
 */
public class AppAdapter extends BaseAdapter {


    private static final String TAG = "AppAdapter";

    private final LayoutInflater mInflater;
    private int [] lists;
    public AppAdapter(Context context, int []   lists) {
        this.lists = lists;
        // 在构造函数中初始化对象 减少创建次数
        mInflater = LayoutInflater.from(context);
    }

    /**
     * 获取装载数据源的数量
     *
     * @return
     */
    @Override
    public int getCount() {
        return lists.length;
    }

    /**
     * 获取当前数据源中的每一项
     *
     * @param i 当前数据源的下标
     * @return
     */
    @Override
    public Integer getItem(int i) {
        return lists[i];
    }

    /**
     * 获取数据源中每一项的id
     *
     * @param i
     * @return
     */
    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * 当前这一行显示的布局文件
     *
     * @param i         下标
     * @param view      转换视图 值的是当前这一行的控件对象
     * @param viewGroup 当前的容器控件（ListView）
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // 1. 声明 holder对象
        ViewHolder holder;
        // 2. 判断view是否为空
        if (null == view) {
            Log.d(TAG, "getView: ");
            // 如果为空
            // 将布局文件转换成 view 对象
            view = mInflater.inflate(R.layout.adpter_home_more, null);
            // 创建 holder 对象
            holder = new ViewHolder(view);
            // 3. 设置view已经加载 holder已经创建的标记
            view.setTag(holder);
        } else {
            // 4. 获取 标记对象
            holder = (ViewHolder) view.getTag();
        }
        // 5. 获取数据源中的每一项数据
        int item = getItem(i);

        // 6. 设置holder中每一行的数据
        holder.setItem(item);

        // 7. 刷新每一行显示的数据
        holder.refreshView();

        // 8. 返回加载好数据的视图
        return view;
    }

    /**
     * 视图持有者
     * <p>
     * 持有当前这一项 item 布局文件中所有用于显示数据的控件
     */
    class ViewHolder {
        ImageView icon;
        // 声明当前这一项需要的数据
        int item;

        /**
         * 在构造函数中加载控件对象
         *
         * @param view 加载的转换视图
         */
        ViewHolder(View view) {
            // 查找当前这一项布局文件中的控件对象
            icon = (ImageView) view.findViewById(R.id.adapter_iv_item);

        }

        /**
         * 给当前这一项的数据赋值
         *
         * @param item
         */
        void setItem(int item) {
            this.item = item;
        }

        /**
         * 刷新每一行显示的数据
         */
        void refreshView() {
            // 将数据源与控件进行绑定
            icon.setImageResource(item);
        }
    }
}
