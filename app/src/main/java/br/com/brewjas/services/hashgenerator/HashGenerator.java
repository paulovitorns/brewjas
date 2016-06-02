package br.com.brewjas.services.hashgenerator;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by PauloSales on 02/06/2016.
 */
public class HashGenerator extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        printHashKey();
    }

    private void printHashKey() {

        try{

            PackageInfo info = getPackageManager().getPackageInfo(
                    "br.com.brewjas",
                    PackageManager.GET_SIGNATURES
            );

            for(Signature signature : info.signatures){

                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                Log.d("HASHKEY", Base64.encodeToString(messageDigest.digest(), Base64.DEFAULT));
            }

        }catch (PackageManager.NameNotFoundException pn){

        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }
}
