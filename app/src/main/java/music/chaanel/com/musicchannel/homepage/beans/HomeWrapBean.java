package music.chaanel.com.musicchannel.homepage.beans;

import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */

public class HomeWrapBean {
    /**
     * {
     "type":1,
     "title":"首图轮播",
     "showTitle":false,
     "size":10,
     "moreData":{
     "supportPage":false,
     "supportTransverseSlider":false,
     "show":false
     },
     "data":Array[10],
     "pathKey":"CAROUSEL"
     }
     */

    private int type;
    private String title;
    private String showTitle;
    private int size;
    private MoreData moreData;
    private List<HomeDataBean> data;
    private String pathKey;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MoreData getMoreData() {
        return moreData;
    }

    public void setMoreData(MoreData moreData) {
        this.moreData = moreData;
    }

    public List<HomeDataBean> getData() {
        return data;
    }

    public void setData(List<HomeDataBean> data) {
        this.data = data;
    }

    public String getPathKey() {
        return pathKey;
    }

    public void setPathKey(String pathKey) {
        this.pathKey = pathKey;
    }

    public static class MoreData{
        /**
         * "supportPage":false,
         "supportTransverseSlider":false,
         "show":false
         */

        private boolean supportPage;
        private boolean supportTransverseSlider;
        private boolean show;

        public boolean isSupportPage() {
            return supportPage;
        }

        public void setSupportPage(boolean supportPage) {
            this.supportPage = supportPage;
        }

        public boolean isSupportTransverseSlider() {
            return supportTransverseSlider;
        }

        public void setSupportTransverseSlider(boolean supportTransverseSlider) {
            this.supportTransverseSlider = supportTransverseSlider;
        }

        public boolean isShow() {
            return show;
        }

        public void setShow(boolean show) {
            this.show = show;
        }
    }

}
