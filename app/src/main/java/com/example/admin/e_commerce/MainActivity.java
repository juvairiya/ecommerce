package com.example.admin.e_commerce;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
public class MainActivity extends ActionBarActivity {
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle = getTitle();
       // mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        LayoutInflater inflater = getLayoutInflater();

        View listHeaderView = inflater.inflate(R.layout.header,null, false);

        mDrawerList.addHeaderView(listHeaderView);
        setupToolbar();
        // toolbar.setLogo(R.drawable.ic_photo);
        DataModel[] drawerItem = new DataModel[12];

        drawerItem[0] = new DataModel(R.drawable.ic_home_black_24dp,"Home");
        drawerItem[1] = new DataModel( R.drawable.ic_shopping_cart_black_24dp,"Cart");
        drawerItem[2] = new DataModel( R.drawable.wish,"Wishlist");
        drawerItem[3] = new DataModel( R.drawable.order,"Orders");
        drawerItem[4] = new DataModel( R.drawable.ic_notifications_black_24dp,"Notifications");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        setupDrawerToggle();
    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {



       /* switch (position) {
            case 0:
                Intent i=new Intent(MainActivity.this,TerminalReport.class);
                i.putExtra("name","Terminal Report");
                startActivity(i);
                break;
            case 1:
                Intent i1=new Intent(MainActivity.this,GroupwiseReport.class);
                i1.putExtra("name","Groupwise Report");
                startActivity(i1);
                break;
            case 2:
                Intent i2=new Intent(MainActivity.this,Modewise.class);
                startActivity(i2);
                break;
            case 3:
                Intent i3=new Intent(MainActivity.this,ProductwiseReport.class);
                startActivity(i3);
                break;
            case 4:
                Intent i4=new Intent(MainActivity.this,SaleswiseReport.class);
                startActivity(i4);
                break;
            case 5:
                Intent i5=new Intent(MainActivity.this,GuestReport.class);
                startActivity(i5);
                break;
            case 6:
                Intent i6=new Intent(MainActivity.this,CancelledReport.class);
                startActivity(i6);
                break;
            case 7:
                Intent i7=new Intent(MainActivity.this,MonthlyReport.class);
                startActivity(i7);
                break;
            case 8:
                Intent i8=new Intent(MainActivity.this,DiscountReport.class);
                startActivity(i8);
                break;
            case 9:
                Intent i9=new Intent(MainActivity.this,CompanyMonthly.class);
                startActivity(i9);
                break;
            case 10:
                Intent i10=new Intent(MainActivity.this,HourBill.class);
                startActivity(i10);
                break;
            case 11:
                Intent i11=new Intent(MainActivity.this,CashBill.class);
                startActivity(i11);
                break;
            default:
                break;
        }*/


    }




    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }



    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        MainActivity.this.finish();
    }

    @Override
    protected void onRestart() {

        // TODO Auto-generated method stub
        super.onRestart();
        Intent i = new Intent(MainActivity.this, MainActivity.class);  //your class
        startActivity(i);
        finish();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
