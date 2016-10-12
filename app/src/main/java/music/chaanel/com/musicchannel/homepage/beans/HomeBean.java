package music.chaanel.com.musicchannel.homepage.beans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomeBean {
    /**
     * {
     "code":"0",
     "msg":"SUCCESS",
     "now":1476235356810,
     "data":Array[9],
     "cost":46
     }
     */

    private int code;
    private String msg;
    private String now;
    private List<HomeWrapBean> data;
    private int cost;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public List<HomeWrapBean> getData() {
        return data;
    }

    public void setData(List<HomeWrapBean> data) {
        this.data = data;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
