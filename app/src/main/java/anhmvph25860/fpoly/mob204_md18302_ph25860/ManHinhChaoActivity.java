package anhmvph25860.fpoly.mob204_md18302_ph25860;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ManHinhChaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);


        ImageView ivLogo = findViewById(R.id.ivLogo);
        Glide.with(this).load(R.mipmap.welcome).into(ivLogo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(ManHinhChaoActivity.this, DangNhapActivity.class));
            }
        }, 5000);
    }
}