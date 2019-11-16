package com.openkotlin.jqacoount

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.openkotlin.jqacoount.adapters.AccountAdapter
import com.openkotlin.jqacoount.utils.SpacesItemDecoration
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

        srl_header.isRefreshing = false

        srl_header.setColorSchemeResources(android.R.color.holo_blue_light,
            android.R.color.holo_red_light,
            android.R.color.holo_orange_light)

        srl_header.setProgressBackgroundColorSchemeResource(android.R.color.white)

        srl_header.setOnRefreshListener {
            homeViewModel!!.updateAllAccount()
        }

        // If we want to the parameters, This line should be added factor.
        homeViewModel = ViewModelProviders.of(this@MainActivity).get(UserViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()

        homeViewModel!!.userAccountRsps.observe(this) {
            Log.d(TAG, "The data has been changed")
            srl_header.isRefreshing = false
            if (it == null) return@observe
            if (accountAdapter == null) {
                accountAdapter = AccountAdapter(this@MainActivity, it)
                rv_account_list.addItemDecoration(SpacesItemDecoration(20))
                rv_account_list.adapter = accountAdapter
            } else {
                val oldDatas = accountAdapter!!.accountList
                val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                    override fun areItemsTheSame(
                        oldItemPosition: Int,
                        newItemPosition: Int
                    ): Boolean {
                        return oldDatas[oldItemPosition].gameAccount == it[newItemPosition].gameAccount
                    }

                    override fun getOldListSize(): Int {
                        return oldDatas.size
                    }

                    override fun getNewListSize(): Int {
                        return it.size
                    }

                    override fun areContentsTheSame(
                        oldItemPosition: Int,
                        newItemPosition: Int
                    ): Boolean {
                        return oldDatas[oldItemPosition].online == it[newItemPosition].online
                    }

                }, true)
                accountAdapter!!.notifyDataChanged(it)
                diffResult.dispatchUpdatesTo(accountAdapter!!)
            }
        }
    }
}
