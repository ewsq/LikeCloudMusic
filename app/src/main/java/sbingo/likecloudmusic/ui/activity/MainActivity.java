package sbingo.likecloudmusic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import sbingo.likecloudmusic.R;
import sbingo.likecloudmusic.utils.RemindUtils;

/**
 * Author: Sbingo
 * Date:   2016/12/11
 */

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.setting)
    TextView setting;
    @BindView(R.id.quit)
    TextView quit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    ImageView avatar;
    TextView name;
    TextView level;
    TextView signIn;

    TextView grade;
    TextView theme;
    SwitchCompat nightSwitch;

    RadioGroup radioGroup;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initInjector() {

    }

    @Override
    public void initViews() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
        navView.setItemIconTintList(null);
        navView.getChildAt(0).setVerticalScrollBarEnabled(false);

        //HeaderView内的控件
        avatar = (ImageView) navView.getHeaderView(0).findViewById(R.id.avatar);
        name = (TextView) navView.getHeaderView(0).findViewById(R.id.name);
        level = (TextView) navView.getHeaderView(0).findViewById(R.id.level);
        signIn = (TextView) navView.getHeaderView(0).findViewById(R.id.sign_in);

        avatar.setOnClickListener(this);
        name.setOnClickListener(this);
        level.setOnClickListener(this);
        signIn.setOnClickListener(this);

        //Menu内的控件
        grade = (TextView) MenuItemCompat.getActionView(navView.getMenu().findItem(R.id.shop));
        theme = (TextView) MenuItemCompat.getActionView(navView.getMenu().findItem(R.id.theme));
        nightSwitch = (SwitchCompat) MenuItemCompat.getActionView(navView.getMenu().findItem(R.id.night_mode));

        grade.setText("100积分");
        theme.setText("典雅黑");
        nightSwitch.setOnCheckedChangeListener(this);
    }


    @Override
    public void customToolbar() {
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        radioGroup = (RadioGroup) LayoutInflater.from(this).inflate(R.layout.main_radio_group, null);
        radioGroup.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);
        actionBar.setCustomView(radioGroup, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    protected boolean hasToolbar() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            moveTaskToBack(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            RemindUtils.makeSnackbar(fab, "搜搜搜", "取消", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.message) {

        } else if (id == R.id.member_center) {

        } else if (id == R.id.shop) {

        } else if (id == R.id.listen_online) {

        } else if (id == R.id.identify_song) {

        } else if (id == R.id.theme) {

        } else if (id == R.id.night_mode) {
            nightSwitch.setChecked(nightSwitch.isChecked() ? false : true);
            return true;
        } else if (id == R.id.timing_stop) {

        } else if (id == R.id.scan) {

        } else if (id == R.id.music_box) {

        } else if (id == R.id.music_clock) {

        } else if (id == R.id.driving_mode) {

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.setting, R.id.quit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                RemindUtils.showToast("设置");
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.quit:
                drawerLayout.closeDrawer(GravityCompat.START);
                finish();
                break;
            case R.id.avatar:
                RemindUtils.showToast("头像");
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.name:
                RemindUtils.showToast("昵称");
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.level:
                RemindUtils.showToast("等级");
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.sign_in:
                RemindUtils.showToast("签到");
                signIn.setEnabled(false);
                signIn.setText("已签到");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            switchToNight();
        } else {
            switchToDay();
        }
    }

    void switchToNight() {
        RemindUtils.showToast("我是黑土");
    }

    void switchToDay() {
        RemindUtils.showToast("我是白云");
    }
}
