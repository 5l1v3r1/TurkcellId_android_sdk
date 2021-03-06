TurkcellId Android SDK
======================

Turkcell ID SDK provides an authentication mechanism for Android applications by using Turkcell user info.

Application ID could be get from sabri.elci@turkcell.com.tr

## Sample Code

```java 
 package com.example.app;
 
  import tr.com.turkcell.turkcellid.TurkcellIdManager;
  import android.support.v4.app.FragmentActivity;
  import android.os.Bundle;
  import android.widget.Toast;
 
 
  public class ExampleActivity extends FragmentActivity implements TurkcellIdManager.TurkcellIdListener {
 
         private TurkcellIdManager turkcellIdManager;
		 private boolean isTestServer;
 
         @Override
         protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 turkcellIdManager = new TurkcellIdManager(this, YOUR_APPLICATION_ID, isTestServer);
                 turkcellIdManager.showLoginDialog(this, true);
         }
 
         @Override
         public void onTurkcellIdAuthorized(String authToken) {
                 Toast.makeText(this, "Authorized successfully, authToken: " + authToken, Toast.LENGTH_LONG).show();
         }
 
         @Override
         public void onTurkcellIdDialogDismissed() {
                 Toast.makeText(this, "dialog closed", Toast.LENGTH_SHORT).show();
         }
 
  }
```

Also, you have to add these code to your activity declaration at the AndroidManifest.xml which host TurkcellId Dialog.

```java
android:configChanges="orientation|screenSize" 
```
