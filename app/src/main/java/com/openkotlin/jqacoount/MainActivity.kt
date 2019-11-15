package com.openkotlin.jqacoount

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.openkotlin.jqacoount.adapters.AccountAdapter
import com.openkotlin.jqacoount.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var accountAdapter: AccountAdapter? = null
    private var homeViewModel: UserViewModel? = null

    companion object {
        private val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_account_list.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

        // If we want to the parameters, This line should be added factor.
        homeViewModel = ViewModelProviders.of(this@MainActivity).get(UserViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()
        homeViewModel!!.userAccountRsps.observe(this) {
            Log.d(TAG, "The data has been changed")
            if (accountAdapter == null) {
                accountAdapter = AccountAdapter(this@MainActivity, it)
                rv_account_list.adapter = accountAdapter
//                TODO("First time logic should be handled in this block")
            } else {
//                TODO("Just notify the item if there are items changed")
            }
        }
    }
}
