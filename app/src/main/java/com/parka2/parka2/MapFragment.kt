package com.parka2.parka2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    companion object {
        var mapFragment : SupportMapFragment?=null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_map, container, false)

        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!

        val startLocation = LatLng(42.281285, -83.743932)
        val zoom = 14.5f
        mMap.moveCamera(CameraUpdateFactory.newLatLng(startLocation))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(zoom))

        val fourthandwashington = LatLng(42.2805163, -83.7481832)
        mMap.addMarker(MarkerOptions().position(fourthandwashington).title("Fourth and Washington").icon(setColor(-1)))

        val firstandwashington = LatLng(42.2804774, -83.7500788)
        mMap.addMarker(MarkerOptions().position(firstandwashington).title("First and Washington").icon(setColor(-1)))

        val maynard = LatLng(42.2789278, -83.7421086)
        mMap.addMarker(MarkerOptions().position(maynard).title("Maynard Structure").icon(setColor(-1)))

        val forest = LatLng(42.2743915, -83.733201)
        mMap.addMarker(MarkerOptions().position(forest).title("Forest Structure").icon(setColor(-1)))

        val fourthandwilliam = LatLng(42.2784615, -83.7477646)
        mMap.addMarker(MarkerOptions().position(fourthandwilliam).title("Fourth and William").icon(setColor(-1)))

        val libertysquare = LatLng(42.280283, -83.7428007)
        mMap.addMarker(MarkerOptions().position(libertysquare).title("Liberty Square Structure").icon(setColor(-1)))

        val annashley = LatLng(42.2826333, -83.7496376)
        mMap.addMarker(MarkerOptions().position(annashley).title("Ann Ashley Structure").icon(setColor(-1)))

        val librarylane = LatLng(42.2787552,-83.7455673)
        mMap.addMarker(MarkerOptions().position(librarylane).title("Library Lane Structure").icon(setColor(-1)))
    }

    private fun setColor(capacity: Int): BitmapDescriptor {
        if (capacity < 0) {
            return BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)
        }
        if (capacity < 50) {
            return BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
        }
        return if (capacity < 400) {
            return BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
        } else BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
    }
}