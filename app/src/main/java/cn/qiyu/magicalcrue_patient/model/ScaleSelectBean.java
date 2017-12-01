package cn.qiyu.magicalcrue_patient.model;

import java.io.Serializable;

/**
 * Created by ShiLei on 2017/12/1.
 */

public class ScaleSelectBean  implements Serializable{

    /**
     * optionsTag : A
     * optionID : d3c895d197e442e1b173d9cdacd8ae6d
     * content : 0
     * 量表详情 选择
     */

    private String optionsTag;
    private String optionID;
    private String content;

    public String getOptionsTag() {
        return optionsTag;
    }

    public void setOptionsTag(String optionsTag) {
        this.optionsTag = optionsTag;
    }

    public String getOptionID() {
        return optionID;
    }

    public void setOptionID(String optionID) {
        this.optionID = optionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
