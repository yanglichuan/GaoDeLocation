package com.example.administrator.mygaode;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;

public class MainActivity extends AppCompatActivity  implements AMapLocationListener {

    TextView dingwei;
    private LocationManagerProxy mAMapLocationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dingwei = (TextView) findViewById(R.id.dingwei);
        if (mAMapLocationManager == null) {
            mAMapLocationManager = LocationManagerProxy.getInstance(this);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用removeUpdates()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用destroy()方法
            // 其中如果间隔时间为-1，则定位只定一次
            // 在单次定位情况下，定位无论成功与否，都无需调用removeUpdates()方法移除请求，定位sdk内部会移除
            mAMapLocationManager.requestLocationData(
                    LocationProviderProxy.AMapNetwork, 60 * 1000, 10, this);
        }
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        dingwei.setText(aMapLocation.getAddress());
    }

    @Override
    public void onLocationChanged(Location location) {



    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
