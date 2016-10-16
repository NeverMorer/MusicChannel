package music.chaanel.com.musicchannel.utils;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface RequestInfo {
    String BASE_URL = "http://mapiv2.yinyuetai.com";
    String COMPONENT = "component/prefecture.json?&";
    String VIDEO = "video/detail.json?&";
    String COMMENT = "video/comment/list_v1.json?&offset=0&size=20&";
    String[] HEADERS = {
            "Authorization : Basic MTAyMDE6ODZmMjYyOWFlMjMwMzhkZTI3ZGE1NjI5MTgxZjE3OTM=",
            "DeviceInfo : %7B%22aid%22%3A%2210201043%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%",
            "App-Id : 10201043",
            "Device-N : JUU0JUI4JUFEJUU1JTlCJUJEJUU4JTgxJTk0JUU5JTgwJTlBXyUyMldJRkklMjJfJTIyMzYwJUU1JTg1JThEJUU4JUI0JUI5V2lGaS1CTiUyMg==",
            "Device-V : QW5kcm9pZF81LjFfNzIwKjEyODBfMTEwMDExMDAw"
    };
    String AUTHORIZATION = "Authorization:Basic MTAyMDE6ODZmMjYyOWFlMjMwMzhkZTI3ZGE1NjI5MTgxZjE3OTM=";
    String DEVICE_INFO = "DeviceInfo:%7B%22aid%22%3A%2210201043%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%3A%22m3%22%2C%22cr%22%3A%2246001%22%2C%22as%22%3A%22WIFI%22%2C%22uid%22%3A%227e34fd0cfae2d89b57bdd728106b4f01%22%2C%22clid%22%3A110011000%7D";
    String APP_ID = "App-Id:10201043";
    String DEVICE_ID = "Device-Id:7e34fd0cfae2d89b57bdd728106b4f01";
    String DEVICE_N = "Device-N:JUU0JUI4JUFEJUU1JTlCJUJEJUU4JTgxJTk0JUU5JTgwJTlBXyUyMldJRkklMjJfJTIyMzYwJUU1JTg1JThEJUU4JUI0JUI5V2lGaS1CTiUyMg==";
    String DEVICE_V = "Device-V:QW5kcm9pZF81LjFfNzIwKjEyODBfMTEwMDExMDAw";
}
