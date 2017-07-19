package example.com.trackside;




import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.Transition;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import example.com.trackside.fragments.HorizontalDriverFragment;
import example.com.trackside.fragments.HorizontalDriverTeamFragment;
import example.com.trackside.fragments.DriverAndTeamFragment;
import example.com.trackside.fragments.LiveRaceFragment;
import example.com.trackside.fragments.VerticalDriverFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView imageView;
    DrawerLayout drawerLayout;
    View menu_view;
    FrameLayout framelay;
    TextView live_race,team,driver;
    private Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        typeface = Typeface.createFromAsset(this.getApplicationContext().getAssets(),
                String.format(Locale.US, "fonts/%s", "1MuseoSans_100Italic.otf"));
        KenBurnsView kbv = (KenBurnsView) findViewById(R.id.image);

        kbv.setTransitionListener(new KenBurnsView.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }
            @Override
            public void onTransitionEnd(Transition transition) {

            }
        });

        live_race=(TextView)findViewById(R.id.live_race);
        TextView placeTV=(TextView)findViewById(R.id.placeTV);

       placeTV.setTypeface(typeface);
        team=(TextView)findViewById(R.id.teams);

        driver=(TextView)findViewById(R.id.driver);
        imageView = (ImageView) findViewById(R.id.menu);
        imageView.setOnClickListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        menu_view = (View) findViewById(R.id.Menu_view);
        framelay = (FrameLayout) findViewById(R.id.framelay);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HorizontalDriverFragment(), "Driver");
        adapter.addFragment(new HorizontalDriverTeamFragment(), "Team");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (v == imageView) {
            if (!drawerLayout.isDrawerOpen(menu_view))
                drawerLayout.openDrawer(Gravity.LEFT);
            else
                drawerLayout.closeDrawer(menu_view);
        } else if (v == framelay) {
            if (drawerLayout.isDrawerOpen(menu_view))
                drawerLayout.closeDrawer(menu_view);
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void LIVE_RACE(View v){
            live_race.setSelected(true);
            team.setSelected(false);
            driver.setSelected(false);
            Fragment liveRaceFragment= new LiveRaceFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelay,liveRaceFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        drawerLayout.closeDrawers();
    }

    public void TEAMS(View view){
        live_race.setSelected(false);
        team.setSelected(true);
        driver.setSelected(false);
        Fragment liveRaceFragment=new DriverAndTeamFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelay,liveRaceFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        drawerLayout.closeDrawers();
    }

    public void DRIVER(View view){
        live_race.setSelected(false);
        team.setSelected(false);
        driver.setSelected(true);
        Fragment liveRaceFragment=new DriverAndTeamFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelay,liveRaceFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        drawerLayout.closeDrawers();
    }



}
