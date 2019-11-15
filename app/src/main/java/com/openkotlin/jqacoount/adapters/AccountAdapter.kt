package com.openkotlin.jqacoount.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openkotlin.jqacoount.R
import com.openkotlin.jqacoount.data.rsp.UserAccountRsp
import kotlinx.android.synthetic.main.item_account.view.*

/**
 *
 *  Current name : AccountAdapter in `JQAcoount`
 *
 *  Created by Tanck on 2019-11-15 16:35.
 *
 *  Note : N/A
 *
 */
class AccountAdapter(private val context: Context, private val accountList: List<UserAccountRsp>) :
    RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        return AccountViewHolder(LayoutInflater.from(context).inflate(R.layout.item_account, parent, false))
    }

    override fun getItemCount(): Int {
        return accountList.size
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.itemView.tv_game_name.text = accountList[position].gameName
        holder.itemView.tv_online_state.text = if(accountList[position].isOnline) "在线" else "离线"
    }


    // Inner class for view holder
    class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}