package music.chaanel.com.musicchannel.W.Beans;

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


public interface Urls {
    String[] requestHead = {"Authorization:Basic MTAyMDE6ODZmMjYyOWFlMjMwMzhkZTI3ZGE1NjI5MTgxZjE3OTM=" ,
            "DeviceInfo:%7B%22aid%22%3A%2210201043%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%3A%22m3%22%2C%22cr%22%3A%2246001%22%2C%22as%22%3A%22WIFI%22%2C%22uid%22%3A%227e34fd0cfae2d89b57bdd728106b4f01%22%2C%22clid%22%3A110011000%7D" ,
            "App-Id:10201043",
            "Device-Id:7e34fd0cfae2d89b57bdd728106b4f01",
            "Device-N:JUU0JUI4JUFEJUU1JTlCJUJEJUU4JTgxJTk0JUU5JTgwJTlBXyUyMldJRkklMjJfJTIyMzYwJUU1JTg1JThEJUU4JUI0JUI5V2lGaS1CTiUyMg==" ,
            "Device-V:QW5kcm9pZF81LjFfNzIwKjEyODBfMTEwMDExMDAw"};
    String BaseUrl="http://mapiv2.yinyuetai.com";
    String VChartUrl="/vchart/trend.json?&size=20";
    String ml="ML";//内地
    String gangtai="HT";//港台
    String us="US";//欧美
    String kr="KR";//韩国
    String jp="JP";//日本
    String AlbumUrl="/album/trend_rank.json?";
    String AlbumUrl_2="/album/trend_rank.json?&offset=%d&size=20&type=ml";//内地
    String jinkou="im";//进口
    String neidi="ml";
    String cvc="/cvc/trend.json?&offset=0&size=30";//top30
    String bb="/bb/trend.json?&size=20";//billboardtop100
}
