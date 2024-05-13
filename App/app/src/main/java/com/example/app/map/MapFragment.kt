package com.example.app.map

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.app.R
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.json.JSONObject
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.Polyline

class MapFragment : Fragment() {

    companion object {
        fun newInstance() = MapFragment()
    }

    private lateinit var map: MapView

    private val bus12GeoJson = """
        {
          "type": "FeatureCollection",
          "features": [
            {
              "type": "Feature",
              "properties": {},
              "geometry": {
                "coordinates": [
                  [
                    -8.653163023384081,
                    40.630849510740205
                  ],
                  [
                    -8.65206867578604,
                    40.6312682605996
                  ],
                  [
                    -8.65140556536096,
                    40.62689677805653
                  ],
                  [
                    -8.647667393538057,
                    40.627233688091195
                  ],
                  [
                    -8.648730360082595,
                    40.63466323981254
                  ],
                  [
                    -8.648753682565768,
                    40.634655579320025
                  ],
                  [
                    -8.64576836112272,
                    40.63670781827693
                  ],
                  [
                    -8.644152775401636,
                    40.63593490451615
                  ],
                  [
                    -8.643766439685777,
                    40.63694768624512
                  ],
                  [
                    -8.644258139687793,
                    40.63756067824835
                  ],
                  [
                    -8.643274739682653,
                    40.640012589976834
                  ],
                  [
                    -8.642502068250849,
                    40.64089205810882
                  ],
                  [
                    -8.635828996791275,
                    40.64067885477738
                  ],
                  [
                    -8.635758753933857,
                    40.642491061389705
                  ],
                  [
                    -8.639551868237447,
                    40.64366363945044
                  ],
                  [
                    -8.639411382522582,
                    40.64406337726359
                  ],
                  [
                    -8.637655311085666,
                    40.64366363945044
                  ],
                  [
                    -8.637936282515398,
                    40.64315730145128
                  ]
                ],
                "type": "LineString"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "ISCAA"},
              "geometry": {
                "coordinates": [
                  -8.653159285568023,
                  40.630873452191224
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "R. Nova"},
              "geometry": {
                "coordinates": [
                  -8.65187163426691,
                  40.62972149717788
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Mercado Santiago"},
              "geometry": {
                "coordinates": [
                  -8.650642235696154,
                  40.62699411743404
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "R. Dr. Mário Sacramento"},
              "geometry": {
                "coordinates": [
                  -8.647994300314622,
                  40.629488238792646
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Av. de Oita 5"},
              "geometry": {
                "coordinates": [
                  -8.648098483733662,
                  40.63515240663682
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "R. de Sebastião Magalhães de Lima"},
              "geometry": {
                "coordinates": [
                  -8.645086894283537,
                  40.63641670758844
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Cais da Fonte Nova"},
              "geometry": {
                "coordinates": [
                  -8.643725571429911,
                  40.638978868786666
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Alameda Silva Rocha"},
              "geometry": {
                "coordinates": [
                  -8.63758137884139,
                  40.64071906936056
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Terminal Rodoviário"},
              "geometry": {
                "coordinates": [
                  -8.63857435460892,
                  40.643894367826704
                ],
                "type": "Point"
              }
            }
          ]
        }
    """.trimIndent()

    private val bus28GeoJson = """
        {
          "type": "FeatureCollection",
          "features": [
            {
              "type": "Feature",
              "properties": {},
              "geometry": {
                "coordinates": [
                  [
                    -8.657842569500701,
                    40.63197740565701
                  ],
                  [
                    -8.657321612231073,
                    40.63162366278601
                  ],
                  [
                    -8.657074842997957,
                    40.631769321841944
                  ],
                  [
                    -8.65490875750686,
                    40.630083819044444
                  ],
                  [
                    -8.654027889038417,
                    40.63057686084463
                  ],
                  [
                    -8.65632201863184,
                    40.63431860560962
                  ],
                  [
                    -8.655716325138542,
                    40.635047458260374
                  ],
                  [
                    -8.655361223087482,
                    40.635266232744414
                  ],
                  [
                    -8.65526162026805,
                    40.63550071809041
                  ],
                  [
                    -8.658363526770302,
                    40.63784510224863
                  ],
                  [
                    -8.659679629346869,
                    40.63849010126458
                  ],
                  [
                    -8.65893932164758,
                    40.64090359068143
                  ],
                  [
                    -8.65915867207724,
                    40.64138211701035
                  ],
                  [
                    -8.659401965985921,
                    40.64187491001121
                  ],
                  [
                    -8.658837263150929,
                    40.642046292155385
                  ],
                  [
                    -8.658329009135173,
                    40.64170345918458
                  ],
                  [
                    -8.657651346055843,
                    40.64140346644891
                  ],
                  [
                    -8.656860655172153,
                    40.64067483150325
                  ],
                  [
                    -8.656352393168333,
                    40.64076043772377
                  ],
                  [
                    -8.655392382732543,
                    40.64110308155361
                  ],
                  [
                    -8.653980641818066,
                    40.64123140809872
                  ],
                  [
                    -8.653664509130806,
                    40.6411621688996
                  ],
                  [
                    -8.653386988789379,
                    40.64114111055352
                  ],
                  [
                    -8.65285970014179,
                    40.64071994223238
                  ],
                  [
                    -8.6518051228459,
                    40.64044618139897
                  ],
                  [
                    -8.650473025209266,
                    40.639372185748186
                  ],
                  [
                    -8.65341474082399,
                    40.6370556657138
                  ],
                  [
                    -8.655246375074285,
                    40.63556041464162
                  ],
                  [
                    -8.655691753123278,
                    40.6357034190402
                  ],
                  [
                    -8.655967927960262,
                    40.635265572449754
                  ],
                  [
                    -8.656855993051607,
                    40.63503390981364
                  ],
                  [
                    -8.657660802040652,
                    40.63438103806061
                  ],
                  [
                    -8.658659875268114,
                    40.633454370417155
                  ],
                  [
                    -8.65879863543887,
                    40.63305421450397
                  ],
                  [
                    -8.658687627301958,
                    40.632696178233886
                  ],
                  [
                    -8.65785506627904,
                    40.63200116116937
                  ]
                ],
                "type": "LineString"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 1"},
              "geometry": {
                "coordinates": [
                  -8.65775203513374,
                  40.63193208098116
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 2"},
              "geometry": {
                "coordinates": [
                  -8.655153067637599,
                  40.63035415951836
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 3"},
              "geometry": {
                "coordinates": [
                  -8.656227307535659,
                  40.63414110838633
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 4"},
              "geometry": {
                "coordinates": [
                  -8.658098564132871,
                  40.637638585644424
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 5"},
              "geometry": {
                "coordinates": [
                  -8.65601939013601,
                  40.64089922646568
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 6"},
              "geometry": {
                "coordinates": [
                  -8.653073893640709,
                  40.64089922646568
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 7"},
              "geometry": {
                "coordinates": [
                  -8.651306595743335,
                  40.64003149083189
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 8"},
              "geometry": {
                "coordinates": [
                  -8.651999653741598,
                  40.6381645062269
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 9"},
              "geometry": {
                "coordinates": [
                  -8.656989671335225,
                  40.63498262341233
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 10"},
              "geometry": {
                "coordinates": [
                  -8.658271828632962,
                  40.6339570255609
                ],
                "type": "Point"
              }
            }
          ]
        }
    """.trimIndent()

    private val bus51GeoJson = """
        {
          "type": "FeatureCollection",
          "features": [
            {
              "type": "Feature",
              "properties": {},
              "geometry": {
                "coordinates": [
                  [
                    -8.63801460471376,
                    40.64321388714484
                  ],
                  [
                    -8.637629562195912,
                    40.643944293469474
                  ],
                  [
                    -8.63929816960328,
                    40.64428507806764
                  ],
                  [
                    -8.639683207761891,
                    40.64365208503622
                  ],
                  [
                    -8.641223430970484,
                    40.64413900045855
                  ],
                  [
                    -8.652903705730893,
                    40.64170449509359
                  ],
                  [
                    -8.653415400941583,
                    40.64145548976052
                  ],
                  [
                    -8.653835797825593,
                    40.64145548976052
                  ],
                  [
                    -8.653784367721016,
                    40.641477230552766
                  ],
                  [
                    -8.653994566162993,
                    40.64121139905862
                  ],
                  [
                    -8.655746219846748,
                    40.64099873310201
                  ],
                  [
                    -8.656551980541394,
                    40.64062656604642
                  ],
                  [
                    -8.657252642015095,
                    40.64089239986882
                  ],
                  [
                    -8.657918270414427,
                    40.641689894984864
                  ],
                  [
                    -8.658548865740443,
                    40.64190255874027
                  ],
                  [
                    -8.659214494139775,
                    40.642008890363485
                  ],
                  [
                    -8.659354626435118,
                    40.641583562853526
                  ],
                  [
                    -8.659004295697798,
                    40.64107848291533
                  ],
                  [
                    -8.659109394918772,
                    40.64006831157286
                  ],
                  [
                    -8.659739990244816,
                    40.63852644163052
                  ],
                  [
                    -8.65826860115078,
                    40.6377554933041
                  ],
                  [
                    -8.655676153700028,
                    40.635814790863236
                  ],
                  [
                    -8.655991451363008,
                    40.63536283836035
                  ],
                  [
                    -8.655816285994376,
                    40.63499063988422
                  ],
                  [
                    -8.656376815172706,
                    40.63445892417624
                  ],
                  [
                    -8.656271715951732,
                    40.63392720423454
                  ],
                  [
                    -8.654309863826,
                    40.63073679565747
                  ],
                  [
                    -8.652608681914472,
                    40.62813268106561
                  ],
                  [
                    -8.651940916594128,
                    40.626023177824806
                  ],
                  [
                    -8.65038674907521,
                    40.62484406716595
                  ],
                  [
                    -8.650561325610965,
                    40.624911397213054
                  ],
                  [
                    -8.649851369787086,
                    40.62441336311164
                  ],
                  [
                    -8.647610764712113,
                    40.6268198381635
                  ],
                  [
                    -8.647283018196418,
                    40.62723442004625
                  ],
                  [
                    -8.636794854390047,
                    40.634820701803164
                  ],
                  [
                    -8.631988956235631,
                    40.64029200770591
                  ],
                  [
                    -8.631388169864806,
                    40.64045777816008
                  ],
                  [
                    -8.631115247021029,
                    40.64091361422058
                  ],
                  [
                    -8.63226210669086,
                    40.641245261652955
                  ],
                  [
                    -8.635375335615208,
                    40.64236442912653
                  ],
                  [
                    -8.6357576118358,
                    40.64277896066173
                  ],
                  [
                    -8.636249120313238,
                    40.64265470775797
                  ],
                  [
                    -8.6381060821748,
                    40.64323525746164
                  ]
                ],
                "type": "LineString"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Terminal Rodoviário"},
              "geometry": {
                "coordinates": [
                  -8.638379313547716,
                  40.644146944780715
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Av. Dr. Lourenço Peixinho"},
              "geometry": {
                "coordinates": [
                  -8.645098066835715,
                  40.643359559631875
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 3"},
              "geometry": {
                "coordinates": [
                  -8.650233544162006,
                  40.64228272678881
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 4"},
              "geometry": {
                "coordinates": [
                  -8.6561351441064,
                  40.64079100704845
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 5"},
              "geometry": {
                "coordinates": [
                  -8.658430178105533,
                  40.63780590415354
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 6"},
              "geometry": {
                "coordinates": [
                  -8.655204991710207,
                  40.63208434760827
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 7"},
              "geometry": {
                "coordinates": [
                  -8.648703481319728,
                  40.62561707222844
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 8"},
              "geometry": {
                "coordinates": [
                  -8.643841704586322,
                  40.62980522744303
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 9"},
              "geometry": {
                "coordinates": [
                  -8.638762101828348,
                  40.63349438977687
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 10"},
              "geometry": {
                "coordinates": [
                  -8.63324528287879,
                  40.63892422412141
                ],
                "type": "Point"
              }
            },
            {
              "type": "Feature",
              "properties": {"name": "Stop 11"},
              "geometry": {
                "coordinates": [
                  -8.632699032353628,
                  40.64145251486039
                ],
                "type": "Point"
              }
            }
          ]
        }
    """.trimIndent()

    private val routesGeoJson = mapOf(
        "Bus 12" to bus12GeoJson,
        "Bus 28" to bus28GeoJson,
        "Bus 51" to bus51GeoJson
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_map, container, false)
        val items = listOf("Bus 12", "Bus 28", "Bus 51")

        Configuration.getInstance().userAgentValue = BuildConfig.APPLICATION_ID
        map = view.findViewById(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.controller.setCenter(GeoPoint(40.636600755508994, -8.645728265933004))
        map.controller.setZoom(15.5)

        val autocomplete : AutoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        autocomplete.setAdapter(adapter)
        autocomplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val selectedRoute = adapterView.getItemAtPosition(i) as String
            val geoJson = routesGeoJson[selectedRoute]
            if (geoJson != null) {
                updateMap(geoJson)
            }
        }

        return view
    }

    fun updateMap(geoJson: String) {
        val jsonObject = JSONObject(geoJson)
        val features = jsonObject.getJSONArray("features")
        val vectorDrawable = resources.getDrawable(R.drawable.marker_icon, null)
        val bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth, vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        val scaledIconBitmap = Bitmap.createScaledBitmap(bitmap, 75, 75, false)
        val scaledIconDrawable = BitmapDrawable(resources, scaledIconBitmap)

        map.overlays.clear()

        for (i in 0 until features.length()) {
            val feature = features.getJSONObject(i)
            val geometry = feature.getJSONObject("geometry")
            if (geometry.has("coordinates")) {
                if (geometry.getString("type") == "Point") {
                    val coordinates = geometry.getJSONArray("coordinates")
                    if (coordinates.length() >= 2) {
                        val lon = coordinates.getDouble(0)
                        val lat = coordinates.getDouble(1)
                        val geoPoint = GeoPoint(lat, lon)

                        val marker = Marker(map)
                        marker.position = geoPoint
                        marker.title = feature.getJSONObject("properties").getString("name")
                        marker.setIcon(scaledIconDrawable)

                        map.overlays.add(marker)
                    }
                } else if (geometry.getString("type") == "LineString") {
                    val polyline = Polyline()
                    val lineCoordinates = geometry.getJSONArray("coordinates")
                    for (j in 0 until lineCoordinates.length()) {
                        val point = lineCoordinates.getJSONArray(j)
                        if (point.length() >= 2) {
                            val lon = point.getDouble(0)
                            val lat = point.getDouble(1)
                            polyline.addPoint(GeoPoint(lat, lon))
                        }
                    }
                    map.overlays.add(polyline)
                }
            }
        }

        map.invalidate()
        map.controller.setCenter(GeoPoint(40.636600755508994, -8.645728265933004))
        map.controller.setZoom(15.5)
    }

}