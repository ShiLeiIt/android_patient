package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/5.
 * 图片
 */

public class EncloSure implements Serializable {


    /**
     * picPath3 : http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260_3.jpg
     * picPath1 : http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260_1.jpg
     * picPath2 : http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260_2.jpg
     * filePath : http://file.mircalcure.com/formalFile/20171205/0b6b648084254b95b08be1b3d4e4c260.jpg
     * id : 0b6b648084254b95b08be1b3d4e4c260
     */

    private String picPath3;
    private String picPath1;
    private String picPath2;
    private String filePath;
    private String id;

    public String getPicPath3() {
        return picPath3;
    }

    public void setPicPath3(String picPath3) {
        this.picPath3 = picPath3;
    }

    public String getPicPath1() {
        return picPath1;
    }

    public void setPicPath1(String picPath1) {
        this.picPath1 = picPath1;
    }

    public String getPicPath2() {
        return picPath2;
    }

    public void setPicPath2(String picPath2) {
        this.picPath2 = picPath2;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
