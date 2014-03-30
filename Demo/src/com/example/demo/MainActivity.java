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

	public static MainActivity Main;
	private LayoutInflater  inflater;
	private View clientPage;
	private View companyPage;
	private View chatPage;
	private ClientPageControl clientPageControl;
	private CompanyPageControl companyPageControl;
	private PageChatControl pageChatControl;
	private View mainPage;
	private RadioGroup EnterType;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Main = this;
        super.onCreate(savedInstanceState);
        
        inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        clientPage = (View)inflater.inflate(R.layout.client, null);
        companyPage = (View)inflater.inflate(R.layout.company, null);
        chatPage = (View)inflater.inflate(R.layout.page2_chat, null);
        mainPage = (View)inflater.inflate(R.layout.activity_main, null);
        
        clientPageControl = new ClientPageControl(clientPage);
        companyPageControl = new CompanyPageControl(companyPage);

        pageChatControl  = new PageChatControl (chatPage);

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
    	setContentView(EnterType.getCheckedRadioButtonId() == R.id.radioClient? chatPage:companyPage);
    }
    
    public void BackToMain(View v){
    	setContentView(mainPage);
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
