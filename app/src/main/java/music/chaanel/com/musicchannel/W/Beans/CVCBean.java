package music.chaanel.com.musicchannel.W.Beans;

import java.util.List;

/**
 * /**
 * <p>
 * ----------Dragon be here!----------/
 * 　　　 ┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 */


public class CVCBean implements BaseBean {



    private String code;
    private String msg;
    private long now;
    private DataBean data;
    private String cost;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public static class DataBean {
        private String year;
        private String dateCode;
        private String periods;
        private String beginDateText;
        private String endDateText;
        private String preDateCode;
        private String nextDateCode;


        private List<VideosBean> videos;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getDateCode() {
            return dateCode;
        }

        public void setDateCode(String dateCode) {
            this.dateCode = dateCode;
        }

        public String getPeriods() {
            return periods;
        }

        public void setPeriods(String periods) {
            this.periods = periods;
        }

        public String getBeginDateText() {
            return beginDateText;
        }

        public void setBeginDateText(String beginDateText) {
            this.beginDateText = beginDateText;
        }

        public String getEndDateText() {
            return endDateText;
        }

        public void setEndDateText(String endDateText) {
            this.endDateText = endDateText;
        }

        public String getPreDateCode() {
            return preDateCode;
        }

        public void setPreDateCode(String preDateCode) {
            this.preDateCode = preDateCode;
        }

        public String getNextDateCode() {
            return nextDateCode;
        }

        public void setNextDateCode(String nextDateCode) {
            this.nextDateCode = nextDateCode;
        }

        public List<VideosBean> getVideos() {
            return videos;
        }

        public void setVideos(List<VideosBean> videos) {
            this.videos = videos;
        }

        public static class VideosBean implements BaseBean{
            private String videoId;
            private String type;
            private String title;
            private String desc;
            private String posterPic;
            private String albumImg;
            private String totalView;
            private String regdate;
            private boolean isVchart;
            /**
             * number : 1
             * bestPosition : 1
             * historyCount : 4
             * score : 99.50
             * prePosition : 1
             */

            private ExtendBean extend;
            private boolean ad;
            /**
             * artistId : 39072
             * artistName : 王青
             */

            private List<ArtistsBean> artists;
            private List<Integer> videoTypes;

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPosterPic() {
                return posterPic;
            }

            public void setPosterPic(String posterPic) {
                this.posterPic = posterPic;
            }

            public String getAlbumImg() {
                return albumImg;
            }

            public void setAlbumImg(String albumImg) {
                this.albumImg = albumImg;
            }

            public String getTotalView() {
                return totalView;
            }

            public void setTotalView(String totalView) {
                this.totalView = totalView;
            }

            public String getRegdate() {
                return regdate;
            }

            public void setRegdate(String regdate) {
                this.regdate = regdate;
            }

            public boolean isIsVchart() {
                return isVchart;
            }

            public void setIsVchart(boolean isVchart) {
                this.isVchart = isVchart;
            }

            public ExtendBean getExtend() {
                return extend;
            }

            public void setExtend(ExtendBean extend) {
                this.extend = extend;
            }

            public boolean isAd() {
                return ad;
            }

            public void setAd(boolean ad) {
                this.ad = ad;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public List<Integer> getVideoTypes() {
                return videoTypes;
            }

            public void setVideoTypes(List<Integer> videoTypes) {
                this.videoTypes = videoTypes;
            }

            public static class ExtendBean {
                private String number;
                private String bestPosition;
                private String historyCount;
                private String score;
                private String prePosition;

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getBestPosition() {
                    return bestPosition;
                }

                public void setBestPosition(String bestPosition) {
                    this.bestPosition = bestPosition;
                }

                public String getHistoryCount() {
                    return historyCount;
                }

                public void setHistoryCount(String historyCount) {
                    this.historyCount = historyCount;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getPrePosition() {
                    return prePosition;
                }

                public void setPrePosition(String prePosition) {
                    this.prePosition = prePosition;
                }
            }

            public static class ArtistsBean {
                private String artistId;
                private String artistName;

                public String getArtistId() {
                    return artistId;
                }

                public void setArtistId(String artistId) {
                    this.artistId = artistId;
                }

                public String getArtistName() {
                    return artistName;
                }

                public void setArtistName(String artistName) {
                    this.artistName = artistName;
                }
            }
        }
    }
}
