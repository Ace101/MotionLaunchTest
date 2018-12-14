package com.aroutertest.motionlaunchtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.aroutertest.biometriclibrary.BiometricPromptManager;
import com.wangnan.library.GestureLockView;
import com.wangnan.library.listener.OnGestureLockListener;

/**
 * @author zhangshihao
 * @date 2018/12/14 0014
 */
public class LaunchActivity extends AppCompatActivity implements OnGestureLockListener {

    private BiometricPromptManager mManager;
    GestureLockView glv;

    @RequiresApi(api = 28)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_launch);

        glv = findViewById(R.id.rl_motion);
        glv.setPainter(new MyPainter());
        glv.setGestureLockListener(this);

        mManager = BiometricPromptManager.from(this);

        if (mManager.isBiometricPromptEnable()) {
            glv.setVisibility(View.GONE);
            mManager.authenticate(new BiometricPromptManager.OnBiometricIdentifyCallback() {
                @Override
                public void onUsePassword() {
                    Toast.makeText(LaunchActivity.this, "onUsePassword", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSucceeded() {
                    Toast.makeText(LaunchActivity.this, "onSucceeded", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                    finish();
                }

                @Override
                public void onFailed() {
                    Toast.makeText(LaunchActivity.this, "onFailed", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(int code, String reason) {
                    Toast.makeText(LaunchActivity.this, "onError", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancel() {
                    Toast.makeText(LaunchActivity.this, "onCancel", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            glv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onProgress(String progress) {

    }

    @Override
    public void onComplete(String result) {
        if (TextUtils.equals("012345678", result)) {
            startActivity(new Intent(LaunchActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(LaunchActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
            glv.showErrorStatus(600);
        }
    }
}
