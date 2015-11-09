package com.turkcell.loginsdktest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

    setContentView(com.turkcell.loginsdktest.R.layout.activity_main);
    Intent intent = new Intent(this, com.turkcell.loginsdk.activity.LoginSDKMainActivity.class);
//intent.putExtra("isLogout", "true");
    intent.putExtra("fontPath","fonts/LDFComicSans.ttf");
//intent.putExtra("Env", "PROD");//Default test
    intent.putExtra("appId", "123");// zorunlu
	intent.putExtra("dll", "false");// zorunlu
	intent.putExtra("loginForce", "false");// zorunlu
	intent.putExtra("isDirectLogin", "true");// direk wifi login sayfasi acar
    intent.putExtra("pageBackgroundColor", R.color.white);//Sayfanin arka plan rengi icin
    intent.putExtra("pageTextColor", R.color.lsdk_gray1);//Sayfadaki textlerin renkleri
    intent.putExtra("headerBackgroundColor", R.color.flatBlue);//Headerdaki background rengi
    intent.putExtra("headerTextBackgroundColor", R.color.flatBlue);//Headerdaki textin arka plan rengi
    intent.putExtra("headerTextColor", R.color.white);//Headerdaki textin rengi
//	intent.putExtra("headerTitle", "Turkcell Platinum");//Headerdaki text
    intent.putExtra("positiveButtonColor", R.color.flatBlue);//Positif button renkleri
    intent.putExtra("positiveButtonTextColor", R.color.white);//Positif button text renkleri
    intent.putExtra("negativeButtonColor", R.color.white);//Negatif button renkleri
    intent.putExtra("negativeButtonTextColor", R.color.lsdk_gray1);//Negatif button text renkleri
    intent.putExtra("inputBackgroundColor", R.color.lsdk_gray_background);//Edittextler icin background rengi
	intent.putExtra("showFreeText", "true");//Free Texti goster
//	intent.putExtra("freeText", "bla blab blab bla bla bla");//free text alandaki text
//intent.putExtra("exitButtonDrawable", com.turkcell.loginsdktest.R.drawable.a);
//intent.putExtra("backButtonDrawable", com.turkcell.loginsdktest.R.drawable.b);
//intent.putExtra("checkedCheckBoxButtonDrawable", com.turkcell.loginsdktest.R.drawable.custom_icon);
//intent.putExtra("turkcellLogoDrawable", com.turkcell.loginsdktest.R.drawable.d);
//	intent.putExtra("hidePreloader", "true");//Preloader ˝ gizle
	intent.putExtra("hintTextColor", R.color.lsdk_yellow1);//Edittext hintlerin rengi
//	intent.putExtra("captchaButtonDrawable", R.drawable.lsdk_icon_refresh);

	startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	String resultMessage = data.getStringExtra("authToken") == null ? data.getStringExtra("code") + "_" + data.getStringExtra("message") : data.getStringExtra("authToken");
	if (100 == requestCode) {
	    if (resultCode == Activity.RESULT_OK) {
		Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();
	    } else {
		Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();
	    }
	}
	super.onActivityResult(requestCode, resultCode, data);
    }
}
