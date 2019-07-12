package com.parka2.parka2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng


class TheRideFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    companion object {
        var mapFragment : SupportMapFragment?=null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_the_ride, container, false)

        mapFragment = childFragmentManager.findFragmentById(R.id.theRideMap) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!

        val startLocation = LatLng(42.281285, -83.743932)
        val zoom = 14.5f
        mMap.moveCamera(CameraUpdateFactory.newLatLng(startLocation))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(zoom))


    }


}
