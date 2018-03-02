package cn.qiyu.magicalcrue_patient.utils;

import android.media.*;
import android.media.AudioManager;

import java.io.IOException;

/**
 * Created by lt on 2016/8/7.
 */
public class MediaManager {

    public static MediaPlayer mMediaPlayer;
    private static boolean isPause;
    public static   String amrPath;
    public static void playSound(String filePath, MediaPlayer.OnCompletionListener onCompletionListener){
        amrPath=filePath;
        if(mMediaPlayer == null){
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    mMediaPlayer.reset();
                    return false;
                }
            });
        }else{
            mMediaPlayer.reset();
        }
        try {
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setOnCompletionListener(onCompletionListener);
            mMediaPlayer.setDataSource("http://qiyuji-amr.oss-cn-hangzhou.aliyuncs.com/"+filePath);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //判断音频地址是否一样
    public static boolean  isPlaying(String newAmrPath){
    if(amrPath==null){
        return false;
     }else {
        if(amrPath.equals(newAmrPath))
            return true;
        else
            return false;
        }
    }
    public static void pause(){
        if(mMediaPlayer != null && mMediaPlayer.isPlaying()){
            mMediaPlayer.pause();
            isPause = true;
        }
    }

    public static void resume(){
        if(mMediaPlayer != null && isPause){
            mMediaPlayer.start();
            isPause = false;
        }
    }

    public static void release(){
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }



}
