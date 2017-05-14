package com.equality.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.equality.comm.MyApplication;
import com.equality.comm.model.Module;
import com.equality.frameworklibrary.tools.model.OnlineUserInfo;
import com.equality.frameworklibrary.tools.util.IdentityHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawer_layout;

    private Module[] modules={new Module("模块1",R.drawable.apple),
            new Module("模块2",R.drawable.banana),
            new Module("模块3",R.drawable.orange),
            new Module("模块4",R.drawable.pear),
            new Module("模块5",R.drawable.grape),
            new Module("模块6",R.drawable.pineapple),
            new Module("模块7",R.drawable.strawberry),
            new Module("模块8",R.drawable.cherry),
            new Module("模块9",R.drawable.mango)};

    private List<Module> moduleList=new ArrayList<>();

    private ModuleAdapter moduleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnlineUserInfo user= IdentityHelper.getUser();
        drawer_layout = (DrawerLayout)findViewById(R.id.drawer_layout);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_menu);
        //toolbar.setTitle("主界面");//不指定则默认加载此activity中android:label
        setSupportActionBar(toolbar);
        /*ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }*/

        NavigationView nav_view=(NavigationView)findViewById(R.id.nav_view);
        nav_view.setCheckedItem(R.id.nav_call);//设置默认选项

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //return false;
                Toast.makeText(MyApplication.getContext(),item.getTitle(),Toast.LENGTH_LONG).show();
                item.setChecked(true);//设置自己被选中
                //drawer_layout.closeDrawers();//关闭
                return true;
            }
        });

        FloatingActionButton fab =(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyApplication.getContext(),"fab",Toast.LENGTH_LONG).show();
                Snackbar.make(view,"fab",Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MyApplication.getContext(),"Undo",Toast.LENGTH_LONG).show();
                    }
                }).show();

            }
        });

        initModules();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);//设置显示的列数
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        moduleAdapter=new ModuleAdapter(moduleList);
        recyclerView.setAdapter(moduleAdapter);

    }

    /**
     * 初始化模块数据
     */
    private void initModules(){
        moduleList.clear();
        for (int i=0;i<20;i++){
            Random random =new Random();
            int index=random.nextInt(modules.length);
            moduleList.add(modules[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);

        switch (item.getItemId())
        {
            case R.id.backup:
                Toast.makeText(MyApplication.getContext(),"backup",Toast.LENGTH_LONG).show();
                break;
            case R.id.delete:
                Toast.makeText(MyApplication.getContext(),"delete",Toast.LENGTH_LONG).show();
                break;
            case R.id.settings:
                Toast.makeText(MyApplication.getContext(),"settings",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }
}
