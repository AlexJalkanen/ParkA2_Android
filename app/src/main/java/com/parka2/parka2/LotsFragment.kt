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
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory


class LotsFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    companion object {
        var mapFragment : SupportMapFragment?=null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_lots, container, false)

        mapFragment = childFragmentManager.findFragmentById(R.id.lotsMap) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!

        val startLocation = LatLng(42.281285, -83.743932)
        val zoom = 14.5f
        mMap.moveCamera(CameraUpdateFactory.newLatLng(startLocation))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(zoom))


        val southashley = LatLng(42.2793726, -83.7498497)
        mMap.addMarker(MarkerOptions().position(southashley).title("South Ashley Lot").icon(setColor(-1)))

        val firstandwilliam = LatLng(42.279587, -83.751292)
        mMap.addMarker(MarkerOptions().position(firstandwilliam).title("First and William Lot").icon(setColor(-1)))

        val palio = LatLng(42.278120, -83.748300)
        mMap.addMarker(MarkerOptions().position(palio).title("Palio Lot").icon(setColor(-1)))

        val washington = LatLng(42.280266, -83.752322)
        mMap.addMarker(MarkerOptions().position(washington).title("415 W. Washington Lot").icon(setColor(-1)))

        val annandmain = LatLng(42.282183, -83.748727)
        mMap.addMarker(MarkerOptions().position(annandmain).title("Ann and Main Lot").icon(setColor(-1)))

        val fourthandcatherine = LatLng(42.283579, -83.747332)
        mMap.addMarker(MarkerOptions().position(fourthandcatherine).title("Fourth and Catherine Lot").icon(setColor(-1)))

        val farmer = LatLng(42.2839314,-83.7466843)
        mMap.addMarker(MarkerOptions().position(farmer).title("Farmer's Market Lot").icon(setColor(-1)))

        val community = LatLng(42.283727, -83.745398)
        mMap.addMarker(MarkerOptions().position(community).title("Community High Lot").icon(setColor(-1)))

        val kerrytown = LatLng(42.284477, -83.746819)
        mMap.addMarker(MarkerOptions().position(kerrytown).title("Kerrytown Lot").icon(setColor(-1)))

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
