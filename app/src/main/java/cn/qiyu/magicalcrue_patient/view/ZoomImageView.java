package cn.qiyu.magicalcrue_patient.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/12/6.
 */

public class ZoomImageView extends ImageView implements ViewTreeObserver.OnGlobalLayoutListener
        ,View.OnTouchListener, ScaleGestureDetector.OnScaleGestureListener {
    private boolean mOnce;
    private float minScale;
    private float maxScale;
    private float mTouchScale;
    private Matrix mMatrix;
    /**捕获多指触摸的手势*/
    private ScaleGestureDetector mScaleGestureDetector;
    private Object rectF;



    /**------------------------------------------------
     * 自由移动*/
    private float mLastX;
    private float mLastY;

    private boolean isMoveX;
    private boolean isMoveY;

    private boolean isMove;

    private int mPointCount;
    private int mTouchslop;



    /**------------------------------------------------
     * 双击放大+缩小*/
    private GestureDetector mGes;
    private boolean isClick;

    public ZoomImageView(Context context) {
        this(context,null);
    }

    public ZoomImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ZoomImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {


        mMatrix = new Matrix();
        setScaleType(ScaleType.MATRIX);
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), this);
        setOnTouchListener(this);
        mTouchslop = ViewConfiguration.get(getContext()).getScaledTouchSlop();

        mGes = new GestureDetector(getContext(),new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                float x = e.getX();
                float y = e.getY();
                float scale = getScale();

                if (scale < mTouchScale){

                    Log.i("==currScale",String.valueOf(mTouchScale) + ":::" + String.valueOf(scale));
                    //放大的逻辑---注意要渐变
                    if (!isClick){
                        isClick = true;
                        postDelayed(new ChangeRunnable(mTouchScale,x,y),16);
                    }

                }else {

                    Log.i("==currScale2",String.valueOf(minScale) + ":::" + String.valueOf(scale));
                    if (!isClick){
                        isClick = true;
                        //缩小的逻辑---注意要渐变
                        postDelayed(new ChangeRunnable(minScale,x,y),16);
                    }



                }


                return true;
            }
        });

    }

    public class ChangeRunnable implements Runnable{

        //目标值
        private float mTargetScale;
        //放缩的中心
        private float x;
        private float y;
        //放缩的梯度
        private float mTemp;
        private final float UP = 1.1f;
        private final float DOWN = 0.6f;

        public ChangeRunnable(float mTargetScale,float x,float y) {
            this.mTargetScale = mTargetScale;
            this.x = x;
            this.y = y;
            float scale = getScale();
            if (scale < mTargetScale){
                mTemp = UP;
            }
            if (scale > mTargetScale){
                mTemp = DOWN;
            }
        }

        @Override
        public void run() {
            if (!isClick)
                return;


            float currScale = getScale();

            if ((mTemp > 1.0f && currScale < mTargetScale) || (mTemp < 1.0f && currScale > mTargetScale)){
                //scale是在原图基础上来计算的
                mMatrix.postScale(mTemp,mTemp,x,y);
                transBoderAndCenter();
                setImageMatrix(mMatrix);

                postDelayed(this,16);
            }else if ((mTemp > 1.0f && currScale >= mTargetScale) || (mTemp < 1.0f && currScale <= mTargetScale)){
                mMatrix.postScale(mTargetScale/currScale,mTargetScale/currScale,x,y);
                transBoderAndCenter();
                setImageMatrix(mMatrix);

                isClick = false;
            }




        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //注册监听 绘制完成设置图片
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);

    }

    @Override
    public void onGlobalLayout() {

        if (!mOnce){
            float scale = 1;
            //获取控件的宽和高
            int width = getWidth();
            int height = getHeight();
            //获取图片 及其宽和高
            Drawable drawable = getDrawable();
            if (drawable == null)
                return;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();

            //控件的宽高和img比较确定缩放的比例
            if (intrinsicWidth > width && intrinsicHeight < height){
                scale = width * 1.0f / intrinsicWidth;
            }
            if (intrinsicHeight > height && intrinsicWidth < width){
                scale = height * 1.0f / intrinsicHeight;
            }
            if ((intrinsicHeight > height && intrinsicWidth > width) || (intrinsicHeight < height && intrinsicWidth < width)){
                scale =  Math.min(height * 1.0f / intrinsicHeight ,width * 1.0f / intrinsicWidth);
            }

            minScale = scale;
            maxScale = 4 * minScale;
            mTouchScale = 2 * minScale;
            float dx = width/2 - intrinsicWidth/2;
            float dy = height/2 - intrinsicHeight/2;
            mMatrix.postTranslate(dx,dy);
            mMatrix.postScale(minScale,minScale,width/2,height/2);

            setImageMatrix(mMatrix);




            mOnce =true;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {


        if (mGes.onTouchEvent(motionEvent)){
            return true;
        }

        mScaleGestureDetector.onTouchEvent(motionEvent);

        /**-------------------------------------------
         * 设置自由移动*/

        float x = 0;
        float y = 0;

        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            x += motionEvent.getX(i);
            y += motionEvent.getY(i);
        }

        x /= pointerCount;
        y /= pointerCount;


        if (mPointCount != pointerCount){
            mLastX = x;
            mLastY = y;
            isMove = false;
        }

        mPointCount = pointerCount;

        RectF rect = getRectF();


        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:

                if (rect.width() > getWidth()){
                    if (getParent() instanceof ViewPager){
                        //请求父类不拦截
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }

                break;


            case MotionEvent.ACTION_MOVE:


                if (rect.width() > getWidth()){
                    if (getParent() instanceof ViewPager){
                        //请求父类不拦截
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }

                    isMoveX = true;
                    isMoveY = true;
                    float mx = 0;
                    float my = 0;


                    int count = motionEvent.getPointerCount();
                    for (int i = 0; i < count; i++) {
                        mx += motionEvent.getX(i);
                        my += motionEvent.getY(i);
                    }
                    mx /= count;
                    my /= count;
                    float dx = mx - mLastX;
                    float dy = my - mLastY;


                    if (!isMove){
                        isMove = isMoveZoom(dx, dy);
                    }

                    if (isMove){
                        RectF rectF = getRectF();
                        float w = rectF.width();
                        float h = rectF.height();
                        int width = getWidth();
                        int height = getHeight();

                        if (getDrawable() != null){
                            if (w < width){
                                isMoveX = false;
                                dx = 0;
                            }
                            if (h < height){
                                isMoveY = false;
                                dy = 0;
                            }
                            mMatrix.postTranslate(dx,dy);

                            transBoder();
                            setImageMatrix(mMatrix);
                        }

                    }

                    mLastX = x;
                    mLastY = y;

                }

                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mPointCount = 0;
                break;

        }


        //这不会拦截么?
        return true;
    }

    private void transBoder() {
        //设置x和y的边界值
        float Dx = 0;
        float Dy = 0;
        RectF rectF = getRectF();
        int width = getWidth();
        int height = getHeight();

        float l = rectF.left;
        float r = rectF.right;
        float t = rectF.top;
        float b = rectF.bottom;


        float w = rectF.width();
        float h = rectF.height();

        if (l > 0 && isMoveX){
            Dx = -l;
        }
        if (r < width && isMoveX){
            Dx = width - r;
        }

        if (t > 0 && isMoveY){
            Dy = -t;
        }
        if (b < height && isMoveY){
            Dy = height - b;
        }

        mMatrix.postTranslate(Dx,Dy);
    }

    private boolean isMoveZoom(float dx, float dy) {
        return Math.sqrt(dx * dx + dy * dy) > mTouchslop;
    }


    //放缩过程中
    @Override
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {

        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();

        //判断drawable是否为空
        if (getDrawable() == null)
            return true;
        //判断范围
        if ((scale < maxScale && scale >= 1.0f) || (scale > minScale && scale <= 1.0f)){
            //Log.i("==onScale",String.valueOf(scale) + ":::" + String.valueOf(scaleFactor) + ":::" + String.valueOf(maxScale));
            if (scale * scaleFactor > maxScale){
                //Log.i("==scaleFactor",String.valueOf(scale * scaleFactor));
                scaleFactor = maxScale/scale;
            }
            if (scale * scaleFactor < minScale){
                scaleFactor = minScale/scale;
            }
        }
        /**
         * 限定图片放缩的最大值和最小值
         * */
        else if (scale >= maxScale && scaleFactor > 1.0f){
            scaleFactor = maxScale/scale;
        }else if (scale <= minScale/2 && scaleFactor < 1.0f){
            //Log.i("==scale",String.valueOf(scaleFactor));
            scaleFactor = minScale/(2*scale);
        }

        //Log.i("==scaleFactor 333",String.valueOf(scale * scaleFactor));

        //注意这里要以手势中心为缩放中心
        mMatrix.postScale(scaleFactor,scaleFactor,
                scaleGestureDetector.getFocusX(),scaleGestureDetector.getFocusY());

        transBoderAndCenter();

        setImageMatrix(mMatrix);

        return true;
    }


    //在缩放时候进行边界控制和中心点的控制
    private void transBoderAndCenter() {
        //设置x和y的边界值
        float Dx = 0;
        float Dy = 0;
        RectF rectF = getRectF();
        int width = getWidth();
        int height = getHeight();

        float l = rectF.left;
        float r = rectF.right;
        float t = rectF.top;
        float b = rectF.bottom;


        float w = rectF.width();
        float h = rectF.height();

        if (w >= width){
            if (l > 0){
                Dx = -l;
            }
            if (r < width){
                Dx = width - r;
            }
        }

        if (h >= height){
            if (t > 0){
                Dy = -t;
            }
            if (b < height){
                Dy = height - b;
            }
        }

        if (w < width){
            Dx = width/2 - r + w/2;
        }
        if (h < height){
            Dy = height/2 - b + h/2;
        }

        mMatrix.postTranslate(Dx,Dy);


    }

    private float getScale() {
        float[] values = new float[9];
        mMatrix.getValues(values);
        float value = values[Matrix.MSCALE_X];
        return value;
    }

    //放缩开始时候
    @Override
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }


    //放缩结束时候
    @Override
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

    }


    //实时获取drawable尺寸的监听
    public RectF getRectF() {

        Matrix matrix = mMatrix;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null){
            rectF.set(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }


        return rectF;
    }
}
