package com.song.frame.base;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.song.frame.OverAppLocation;
import com.song.frame.utils.Bind;
import com.song.frame.utils.OpactivityUtils;

/**
 * Song Wenjun
 * Created by dell on 2019/2/23 16:10
 * Created prepare
 * package is com.example.frame.base
 * <p>
 * This class is used to do:
 */
public class BaseActivity extends AppCompatActivity {

    protected boolean eee = true;
    protected boolean www = true;
    protected boolean vvv = true;
    protected boolean ddd = true;
    protected boolean iii = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void bindView(Activity activity) {
        Bind.InjectView(activity);
    }

    public void showToast(final String content) {
        e(content);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, content, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showLongToast(final String content) {
        e(content);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, content, Toast.LENGTH_LONG).show();
            }
        });
    }

    protected void e(String msg) {
        if (eee) {
            Log.e(this.getLocalClassName(), msg);
        }
    }

    protected void d(String msg) {
        if (ddd) {
            Log.d(this.getLocalClassName(), msg);
        }
    }

    protected void w(String msg) {
        if (www) {
            Log.w(this.getLocalClassName(), msg);
        }
    }

    protected void i(String msg) {
        if (iii) {
            Log.i(this.getLocalClassName(), msg);
        }
    }

    protected void v(String msg) {
        if (vvv) {
            Log.v(this.getLocalClassName(), msg);
        }
    }

    //eclipse获取versionCode和versionName 这两个参数是写在manifest.xml文件中
    public Version getEclipseVersionInfo() {
        Version version = new Version();
        PackageManager pm = OverAppLocation.getOverAppLocation().context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(OverAppLocation.getOverAppLocation().context.getPackageName(), 0);
            version.versionCode = packageInfo.versionCode;
            version.versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return version;
    }

    public class Version {
        public int versionCode = 0;
        public String versionName = "";
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    public String getTime() {
        //获取时间戳
        long timeStamp = System.currentTimeMillis();
        return String.valueOf(timeStamp);
    }

    /**
     * 个别动画要求
     */
    public void finishAnimation(@DrawableRes int end) {
        finish();
        if (end == -1) {
            return;
        }
        overridePendingTransition(0, end);
    }

    /**
     * 统一风格退场动画
     */
    public void finishAnimation() {
        finish();
        if (OverAppLocation.getEndActivity() == -1) {
            return;
        }
        overridePendingTransition(0, OverAppLocation.getEndActivity());
    }

    public void openActivity(Class<?> tClass, Bundle bundle) {
        OpactivityUtils.openActivity(this, tClass, bundle);
    }

    public void openActivity(Class<?> tClass, Bundle bundle, Uri uri) {
        OpactivityUtils.openActivity(this, tClass, bundle, uri);
    }

    public void openActivity(Class<?> tClass) {
        OpactivityUtils.openActivity(this, tClass, null, null);
    }
}
