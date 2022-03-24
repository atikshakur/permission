package com.example.rajeshvhai

import android.Manifest
import android.Manifest.permission.READ_CONTACTS
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rajeshvhai.databinding.ActivityMainBinding
import com.vmadalin.easypermissions.EasyPermissions
import java.util.function.Consumer

class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var list = listOf<Product>(
            Product("Potato Crackers", "Chips"),
            Product("Lays", "Chips"),
            Product("Pran juice", "Mango Juice"),
            Product("Potato Crackers", "Chips"),
            Product("Lays", "Chips"),
            Product("Pran juice", "Mango Juice"),
            Product("Potato Crackers", "Chips"),
            Product("Lays", "Chips"),
            Product("Pran juice", "Mango Juice")
        )


        listAdapter = RecyclerAdapter()

        binding.recyclerview.adapter = listAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        listAdapter.setData(list)


        binding.button.setOnClickListener {
            if (binding.tv.editText?.text?.length!! < 10){
                binding.tv.error = "Invalid Phone Number"
            } else if(binding.tv.editText?.text?.length!! == 10) {
                binding.tv.isErrorEnabled = false
            }
        }


        binding.apply {
            requestButton.setOnClickListener {
                if(EasyPermissions.hasPermissions(this@MainActivity, READ_CONTACTS)){
                    permissionText.text = "Permission Granted"
                } else {
                    EasyPermissions.requestPermissions(
                        this@MainActivity,
                        "You need to grant this permission",
                        51,
                        Manifest.permission.READ_CONTACTS
                    )
                }
            }
        }


    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        binding.permissionText.text = "Permission denied"
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        binding.permissionText.text = "Permission Granted"
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }


}