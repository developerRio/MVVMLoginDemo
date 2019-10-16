package com.originalstocks.mvvmdemo.ui.home


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.originalstocks.mvvmdemo.R
import com.originalstocks.mvvmdemo.ui.auth.LoginActivity
import com.originalstocks.mvvmdemo.utils.toast
import kotlinx.android.synthetic.main.fragment_home.view.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        view.logout_button.setOnClickListener {
            context?.toast("Logged out")

            // Sending user to login page
            val intent = Intent()
            intent.setClass(activity!!, LoginActivity::class.java!!)
            activity!!.startActivity(intent)
            activity!!.finish()
        }

        return view
    }


}
