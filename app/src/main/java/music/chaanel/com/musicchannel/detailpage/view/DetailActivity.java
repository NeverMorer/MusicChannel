package music.chaanel.com.musicchannel.detailpage.view;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import music.chaanel.com.musicchannel.R;
import music.chaanel.com.musicchannel.detailpage.beans.DetailVideoBean;
import music.chaanel.com.musicchannel.detailpage.presenter.DetailPresenter;
import music.chaanel.com.musicchannel.detailpage.presenter.IDetailPresenter;
import music.chaanel.com.musicchannel.utils.MyTextUtil;

public class DetailActivity extends AppCompatActivity implements IDetailView<DetailPresenter>, SurfaceHolder.Callback, MediaPlayer.OnPreparedListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.surface_detail)
    SurfaceView surfaceView;
    @BindView(R.id.iv_load_play)
    ImageView iv_load;
    @BindView(R.id.container_player)
    ViewGroup container_player;
    @BindView(R.id.tv_current_play)
    TextView tv_current;
    @BindView(R.id.tv_total_play)
    TextView tv_total;
    @BindView(R.id.rb_play_play)
    RadioButton rb_play;
    @BindView(R.id.sb_play)
    SeekBar seekBar;

    private MediaPlayer mediaPlayer;
    private String url;
    private String id;
    private DetailPresenter presenter;
    private boolean isLoaded;
    private boolean isVideoLoaded = false;

    public static final String TAG = "sunchao";
    private SurfaceHolder holder;

    private ObjectAnimator alphaShow;
    private ObjectAnimator alphaGone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acticity);

        ButterKnife.bind(this);

        initView();
        initData();

    }

    private void initData() {

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        presenter = getPresenter();
        presenter.bingView(this);
        presenter.handleData(id);

        startAnim();
    }

    public void startAnim(){
        ObjectAnimator rotateX = ObjectAnimator.ofFloat(iv_load, "rotation", 360f, 0f)
                .setDuration(1000);
        rotateX.setRepeatCount(100);
        rotateX.start();

        alphaShow = ObjectAnimator.ofFloat(container_player,"alpha",0,100).setDuration(1000);
        alphaGone = ObjectAnimator.ofFloat(container_player,"alpha",100,0).setDuration(1000);

    }

    private void initView() {

        container_player.setTag(1);

        rb_play.setOnCheckedChangeListener(this);
        rb_play.setEnabled(false);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);

        surfaceView = (SurfaceView) findViewById(R.id.surface_detail);

        holder = surfaceView.getHolder();
        holder.addCallback(this);
    }


    @Override
    public void showData(DetailVideoBean detailVideoBean) {

        url = detailVideoBean.getData().getUrl();
        if (TextUtils.isEmpty(url)) {
            Toast.makeText(this, "返回数据错误", Toast.LENGTH_SHORT).show();
        }
        if(isLoaded){
            startPlay(holder);
        }
    }

    @Override
    public void failedToShow(Throwable t) {
        Log.e(TAG, "failedToShow: ");
    }

    @Override
    public DetailPresenter getPresenter() {
        return new DetailPresenter();
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        isLoaded = true;
        if (!TextUtils.isEmpty(url)) {
            startPlay(surfaceHolder);
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    public void startPlay(SurfaceHolder surfaceHolder){
        mediaPlayer.reset();
        mediaPlayer.setDisplay(surfaceHolder);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        iv_load.setVisibility(View.GONE);
        mediaPlayer.start();
        isVideoLoaded = true;
        rb_play.setEnabled(true);
        rb_play.setChecked(true);

        int duration = mediaPlayer.getDuration();
        seekBar.setMax(duration);
        tv_total.setText("/" + MyTextUtil.getPlayTime(duration));
        handler.sendEmptyMessage(100);
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    tv_current.setText(MyTextUtil.getPlayTime(currentPosition));
                    seekBar.setProgress(currentPosition);
                    sendEmptyMessageDelayed(100,500);
                    break;
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.unBindView();
        }
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        handler.removeMessages(100);
    }

    @Override
    @OnClick(R.id.surface_detail)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.surface_detail:
                switch (((int) container_player.getTag())) {
                    case 1:
                        alphaGone.start();
//                        container_player.startAnimation(alphaAnimationGone);
                        container_player.setTag(0);
                        break;
                    case 0:
                        alphaShow.start();
//                        container_player.startAnimation(alphaAnimationShow);
                        container_player.setTag(1);
                        break;
                }

                break;
            case R.id.rb_play_play:

        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                rb_play.setChecked(false);
                handler.removeMessages(100);
            }
        }else{
            if(isVideoLoaded){
                mediaPlayer.start();
                rb_play.setChecked(true);
                handler.sendEmptyMessage(100);
            }
        }
    }
}
