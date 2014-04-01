package com.example.demo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	public enum Role{
		Client, Company;
	}
	
	public static BasePageControl CurrentViewControl;
	
	public static Role role;
	public static MainActivity Main;
	public View mainPage;
	public View page1;
	public View page5;
	public View chatPage;
	public View productPage6;
	public Page1Control page1Control;
	public Page5Control_Company page5Control_Company;
	public Page5Control_Client page5Control_Client;
	public PageChatControl pageChatControl;
	public Page6ProductControl pageProductControl;
	
	private RadioGroup EnterType;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Main = this;
        super.onCreate(savedInstanceState);
        
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        page1 = (View)inflater.inflate(R.layout.page1_list, null);
        page5 = (View)inflater.inflate(R.layout.page5_advertize, null);
        chatPage = (View)inflater.inflate(R.layout.page2_chat, null);
        productPage6 = (View)inflater.inflate(R.layout.page6_product, null);
        mainPage = (View)inflater.inflate(R.layout.activity_main, null);
        
        page1Control = new Page1Control(page1);
        page5Control_Company = new Page5Control_Company(page5);
        page5Control_Client = new Page5Control_Client(page5);

        pageChatControl  = new PageChatControl (chatPage);
        pageProductControl = new Page6ProductControl(productPage6);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(mainPage);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    public void Enter(View v){
    	if(EnterType == null)
    		EnterType = (RadioGroup) this.findViewById(R.id.radioGroupSelection);
    	//setContentView(EnterType.getCheckedRadioButtonId() == R.id.radioClient? clientPage:companyPage);
    	
    	role = EnterType.getCheckedRadioButtonId() == R.id.radioClient?Role.Client:Role.Company;
    	SwitchToPage(role == Role.Client? page1:page5, role == Role.Client?page1Control:page5Control_Company);
    }
    
    public void SwitchToPage(View v, BasePageControl viewControl)
    {
    	if(CurrentViewControl != null)
    		CurrentViewControl.exit();
    	CurrentViewControl = viewControl;
    	if(CurrentViewControl != null)
    		CurrentViewControl.init();
    	
    	setContentView(v);
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
