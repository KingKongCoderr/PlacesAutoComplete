package com.randomaspirer.randomtechsolutions.placesautocomplete

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.location.places.Place




class AutoCompleteActivity : AppCompatActivity() {


    lateinit var autocompleteFragment : PlaceAutocompleteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete)
        autocompleteFragment =
                fragmentManager.findFragmentById(R.id.place_autocomplete_fragment) as PlaceAutocompleteFragment //as keyword is unsafe type cast operator
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                // TODO: Get info about the selected place.
                Log.i("defaultAutoComplete", "Place: " + place.name)
            }

            override fun onError(status: Status) {
                // TODO: Handle the error.
                Log.i("defaultAutoComplete", "An error occurred: " + status)
            }
        })

    }

    override fun onStart() {
        super.onStart()
    }

}
