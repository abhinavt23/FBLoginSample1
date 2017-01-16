package nerd.abhi.com.fbloginsample;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by erabh on 12-01-2017.
 */

public class HashKeyGenerator extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        printHashKey();
    }

    public void printHashKey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "nerd.abhi.com.fbloginsample",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                System.out.println("*************************************");
                System.out.println("*************************************");
                System.out.println("*************************************");
                System.out.println("*************************************");
                System.out.println("*************************************");
                Log.d("NERD:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
                System.out.println("*************************************");
                System.out.println("*************************************");
                System.out.println("*************************************");
                System.out.println("*************************************");

            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
