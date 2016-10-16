package music.chaanel.com.musicchannel.homepage.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/10/13.
 */

@Entity
public  class ArtistsBean {
    @Id
    private Long artistId;
    private Long homeDataId;
    private String artistName;
    private String artistAvatar;




    @Generated(hash = 1223664823)
    public ArtistsBean(Long artistId, Long homeDataId, String artistName,
            String artistAvatar) {
        this.artistId = artistId;
        this.homeDataId = homeDataId;
        this.artistName = artistName;
        this.artistAvatar = artistAvatar;
    }

    @Generated(hash = 1706888482)
    public ArtistsBean() {
    }




    public String getArtistAvatar() {
        return artistAvatar;
    }

    public void setArtistAvatar(String artistAvatar) {
        this.artistAvatar = artistAvatar;
    }

    public Long getArtistId() {
        return this.artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public Long getHomeDataId() {
        return this.homeDataId;
    }

    public void setHomeDataId(Long homeDataId) {
        this.homeDataId = homeDataId;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }


}