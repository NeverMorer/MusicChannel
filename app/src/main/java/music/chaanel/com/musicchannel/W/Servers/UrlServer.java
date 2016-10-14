package music.chaanel.com.musicchannel.W.Servers;

import music.chaanel.com.musicchannel.W.Beans.AlbumBean;
import music.chaanel.com.musicchannel.W.Beans.BBBean;
import music.chaanel.com.musicchannel.W.Beans.CVCBean;
import music.chaanel.com.musicchannel.W.Beans.MVBean;
import music.chaanel.com.musicchannel.W.Beans.Urls;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

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


public interface UrlServer {
    @GET(Urls.VChartUrl)
    @Headers({"Authorization:Basic MTAyMDE6ODZmMjYyOWFlMjMwMzhkZTI3ZGE1NjI5MTgxZjE3OTM=" ,
            "DeviceInfo:%7B%22aid%22%3A%2210201043%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%3A%22m3%22%2C%22cr%22%3A%2246001%22%2C%22as%22%3A%22WIFI%22%2C%22uid%22%3A%227e34fd0cfae2d89b57bdd728106b4f01%22%2C%22clid%22%3A110011000%7D" ,
            "App-Id:10201043",
            "Device-Id:7e34fd0cfae2d89b57bdd728106b4f01",
            "Device-N:JUU0JUI4JUFEJUU1JTlCJUJEJUU4JTgxJTk0JUU5JTgwJTlBXyUyMldJRkklMjJfJTIyMzYwJUU1JTg1JThEJUU4JUI0JUI5V2lGaS1CTiUyMg==" ,
            "Device-V:QW5kcm9pZF81LjFfNzIwKjEyODBfMTEwMDExMDAw"})
    Call<MVBean> getMV(@Query("area") String location, @Query("offset") int offset);
    @GET(Urls.AlbumUrl)
    @Headers({"Authorization:Basic MTAyMDE6ODZmMjYyOWFlMjMwMzhkZTI3ZGE1NjI5MTgxZjE3OTM=" ,
            "DeviceInfo:%7B%22aid%22%3A%2210201043%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%3A%22m3%22%2C%22cr%22%3A%2246001%22%2C%22as%22%3A%22WIFI%22%2C%22uid%22%3A%227e34fd0cfae2d89b57bdd728106b4f01%22%2C%22clid%22%3A110011000%7D" ,
            "App-Id:10201043",
            "Device-Id:7e34fd0cfae2d89b57bdd728106b4f01",
            "Device-N:JUU0JUI4JUFEJUU1JTlCJUJEJUU4JTgxJTk0JUU5JTgwJTlBXyUyMldJRkklMjJfJTIyMzYwJUU1JTg1JThEJUU4JUI0JUI5V2lGaS1CTiUyMg==" ,
            "Device-V:QW5kcm9pZF81LjFfNzIwKjEyODBfMTEwMDExMDAw"})
    Call<AlbumBean> getAlbum(@Query("area") String location, @Query("offset") int offset);
    @GET(Urls.cvc)
    @Headers({"Authorization:Basic MTAyMDE6ODZmMjYyOWFlMjMwMzhkZTI3ZGE1NjI5MTgxZjE3OTM=" ,
            "DeviceInfo:%7B%22aid%22%3A%2210201043%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%3A%22m3%22%2C%22cr%22%3A%2246001%22%2C%22as%22%3A%22WIFI%22%2C%22uid%22%3A%227e34fd0cfae2d89b57bdd728106b4f01%22%2C%22clid%22%3A110011000%7D" ,
            "App-Id:10201043",
            "Device-Id:7e34fd0cfae2d89b57bdd728106b4f01",
            "Device-N:JUU0JUI4JUFEJUU1JTlCJUJEJUU4JTgxJTk0JUU5JTgwJTlBXyUyMldJRkklMjJfJTIyMzYwJUU1JTg1JThEJUU4JUI0JUI5V2lGaS1CTiUyMg==" ,
            "Device-V:QW5kcm9pZF81LjFfNzIwKjEyODBfMTEwMDExMDAw"})
    Call<CVCBean> getCVC();
    @GET(Urls.bb)
    @Headers({"Authorization:Basic MTAyMDE6ODZmMjYyOWFlMjMwMzhkZTI3ZGE1NjI5MTgxZjE3OTM=" ,
            "DeviceInfo:%7B%22aid%22%3A%2210201043%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%3A%22m3%22%2C%22cr%22%3A%2246001%22%2C%22as%22%3A%22WIFI%22%2C%22uid%22%3A%227e34fd0cfae2d89b57bdd728106b4f01%22%2C%22clid%22%3A110011000%7D" ,
            "App-Id:10201043",
            "Device-Id:7e34fd0cfae2d89b57bdd728106b4f01",
            "Device-N:JUU0JUI4JUFEJUU1JTlCJUJEJUU4JTgxJTk0JUU5JTgwJTlBXyUyMldJRkklMjJfJTIyMzYwJUU1JTg1JThEJUU4JUI0JUI5V2lGaS1CTiUyMg==" ,
            "Device-V:QW5kcm9pZF81LjFfNzIwKjEyODBfMTEwMDExMDAw"})
    Call<BBBean> getBB(@Query("offset") int offset);
}
