package com.randomaspirer.randomtechsolutions.placesautocomplete

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.randomaspirer.randomtechsolutions.placesautocomplete.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

    }

    fun openAutoCompleteFragment(view : View) {
        if(view.id == R.id.defaultAutocomplete){
            //call fragment
            var defaultAutocompleteIntent : Intent = Intent(this,AutoCompleteActivity::class.java)
            startActivity(defaultAutocompleteIntent)
        }
    }

}
