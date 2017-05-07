package com.equality.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;


/**
 * 欢迎界面
 * @author
 *
 */
public class WelcomeActivity extends AppCompatActivity {

    private RelativeLayout rl_welcome_root;
    private ImageView image_logo;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                //跳转到登录界面
                Intent intent=new Intent(WelcomeActivity.this,LoginActivity.class);
                startActivity(intent);
                //关闭自己
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ActionBar actionBar=getSupportActionBar();
        if (null!=actionBar){
            actionBar.setTitle("AppDemo");
        }

        rl_welcome_root=(RelativeLayout)findViewById(R.id.rl_welcome_root);
        image_logo=(ImageView)findViewById(R.id.image_logo);

        ShowAnimation();

        handler.sendEmptyMessageDelayed(1,3000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);//避免内存泄漏
    }

    /**
     * 显示动画
     */
    private void ShowAnimation(){

        //代码创建
        /*//旋转动画  RotateAnimation: 0-->360 视图的中心点 2s
        RotateAnimation rotateAnimation=new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);
        //透明度动画 AlphaAnimation: 0-->1 2s
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setDuration(4000);



        //缩放动画 ScaleAnimation: 0-->1 视图的中心点 2s
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);
        //创建复合动画
        AnimationSet animationSet=new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);*/

        //加载配置文件
        //AlphaAnimation alphaAnimation= (AlphaAnimation)AnimationUtils.loadAnimation(this,R.anim.welcome_alpha);
        //ScaleAnimation scaleAnimation=(ScaleAnimation)AnimationUtils.loadAnimation(this,R.anim.welcome_scale);
        Animation animation=AnimationUtils.loadAnimation(this,R.anim.welcome_set);

        image_logo.setAnimation(animation);

        //rl_welcome_root.setAnimation(scaleAnimation);

        //rl_welcome_root.setAnimation(rotateAnimation);
    }





}
