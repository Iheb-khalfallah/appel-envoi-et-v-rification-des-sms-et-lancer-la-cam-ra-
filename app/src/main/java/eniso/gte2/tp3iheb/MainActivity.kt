package eniso.gte2.tp3iheb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import eniso.gte2.tp3iheb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_mainactivity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val num = resources.getString(R.string.num)
        return when (item.itemId) {
            R.id.item_smsN-> {
                val i = Intent(this,WriteSMS::class.java)
                startActivity(i)
                true
            }
            R.id.item_smsU-> {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.SEND_SMS),1)
                else {
                    val smsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(num,null,resources.getString(R.string.msg),null,null)
                }
                true
            }
            R.id.item_appelN-> {
                val i = Intent(this,CallActivity::class.java)
                startActivity(i)
                true
            }
            R.id.item_appelU-> {
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.CALL_PHONE),1)
                else {
                    val uri = Uri.parse("tel:$num")
                    val i = Intent(Intent.ACTION_CALL, uri)
                    startActivity(i)
                }
                true
            }
            R.id.item_camera-> {
                val i = Intent(this,CameraActivity::class.java)
                startActivity(i)
                true
            }
            R.id.item_quit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}