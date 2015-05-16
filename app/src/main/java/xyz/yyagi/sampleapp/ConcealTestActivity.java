package xyz.yyagi.sampleapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.crypto.Crypto;
import com.facebook.crypto.Entity;
import com.facebook.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.crypto.util.SystemNativeCryptoLibrary;


public class ConcealTestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conceal_test);
        displayConcealValue();
    }

    private void displayConcealValue() {
        String plainText = "この文字列を暗号化したいのだ";

        // encrypt/decryptのときに同じ文字列を渡す必要がある
        String name = "hoge";

        Crypto crypto = new Crypto(
                new SharedPrefsBackedKeyChain(this),
                new SystemNativeCryptoLibrary());
        if (!crypto.isAvailable()) {
            return;
        }
        try {
            // UTF8でbyte[]に変換して、暗号化する
            byte[] cipherText = crypto.encrypt(plainText.getBytes("utf-8"), new Entity(name));
            Toast.makeText(this, "encrypt data: " + cipherText, Toast.LENGTH_SHORT).show();

            // 暗号化されたbyte[]を復号化して、UTF8で文字列に戻す
            byte[] decrypted = crypto.decrypt(cipherText, new Entity(name));
            String data = new String(decrypted, "utf-8");
            Toast.makeText(this, "decrypt data: " + data, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
