package software.analysis.nju.util;

import software.analysis.nju.bean.macDataBean;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class ParseJSON {
    public static List<macDataBean> jsonToList(String json){
        return JSON.parseArray(json, macDataBean.class);
    }

    public static macDataBean jsonToObject(String json){
        return JSON.parseObject(json, macDataBean.class);
    }
}
