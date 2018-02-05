package com.randomaspirer.randomtechsolutions.placesautocomplete

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.location.places.Place
import com.randomaspirer.randomtechsolutions.placesautocomplete.databinding.ActivityAutoCompleteBinding


class AutoCompleteActivity : AppCompatActivity() {


    lateinit var activityAutoCompleteBinding: ActivityAutoCompleteBinding
    lateinit var autocompleteFragment : PlaceAutocompleteFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAutoCompleteBinding = DataBindingUtil.setContentView(this,R.layout.activity_auto_complete)
        autocompleteFragment =
                fragmentManager.findFragmentById(R.id.place_autocomplete_fragment) as PlaceAutocompleteFragment //as keyword is unsafe type cast operator
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                // TODO: Get info about the selected place.
                Log.i("defaultAutoComplete", "Place: " + place.address)
                val splitAddress = place.address.split(",")
                val splitStateZip = splitAddress.get(splitAddress.size-2).trim().split(" ")
                activityAutoCompleteBinding.streetAddressLabel.setText(splitAddress.get(0).trim())
                activityAutoCompleteBinding.cityAddressLabel.setText(splitAddress.get(1).trim())
                activityAutoCompleteBinding.stateAddressLabel.setText(splitStateZip.get(0).trim())
                activityAutoCompleteBinding.zipAddressLabel.setText(splitStateZip.get(1).trim())

            }

            override fun onError(status: Status) {
                // TODO: Handle the error.
                Log.i("defaultAutoComplete", "An error occurred: " + status)
            }
        })
        autocompleteFragment.setFilter(AutocompleteFilter.Builder().setTypeFilter(Place.TYPE_STREET_ADDRESS).build())
        autocompleteFragment.setFilter(AutocompleteFilter.Builder().setCountry("US").build())
    }

    override fun onStart() {
        super.onStart()
    }

}
