package com.example.glucoseworld3

import android.app.Activity
import android.bluetooth.BluetoothGatt
import android.content.Context
import android.content.IntentFilter
import android.graphics.Typeface
import android.net.wifi.p2p.WifiP2pManager
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.wear.compose.foundation.CurvedTextStyle
import androidx.wear.compose.material.*
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import com.example.glucoseworld3.databinding.ActivityMainBinding
import java.util.*


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val intentFilter = IntentFilter()
    private lateinit var channel: WifiP2pManager.Channel
    private lateinit var manager: WifiP2pManager


    var bluetoothGatt: BluetoothGatt? = null



        // Indicates a change in the Wi-Fi P2P status.




    @ExperimentalWearMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // bluetoothGatt = device.connectGatt(this, false, gattCallback)

        setContent {

            //GIA WIFI PEER TO PEER
            intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)

            // Indicates a change in the list of available peers.
            intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)

            // Indicates the state of Wi-Fi P2P connectivity has changed.
            intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)

            // Indicates this device's details have changed.
            intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)

            MaterialTheme {
                val scalingLazyListState: ScalingLazyListState = rememberScalingLazyListState()
                val swipeDismissableNavController = rememberSwipeDismissableNavController()
                val typeface: Typeface? = resources.getFont(R.font.luckiestguyregular);
                val myLuckyFont = FontFamily(Font(R.font.luckiestguyregular));
                val leadingTextStyle = TimeTextDefaults.timeTextStyle(color = MaterialTheme.colors.primary)



                SwipeDismissableNavHost(

                    navController = swipeDismissableNavController,
                    startDestination = "Landing",
                    modifier = Modifier.background(Color(0xFFE1F5E1))
                ) {

                    composable("Landing") {

                        ScalingLazyColumn(

                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(
                                top = 30.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 30.dp,

                                ),

                            verticalArrangement = Arrangement.Center,
                            state = scalingLazyListState


                        ) {

                            item {

                                Chip(

                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),


                                    label = {
                                        Text(

                                            modifier = Modifier.fillMaxWidth(),
                                            textAlign = TextAlign.Center,
                                            color = Color(0xFF6BD1FD),
                                            text = "TRACK GLYCOSE",
                                            fontFamily = myLuckyFont

                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFF8F1F1)),

                                    onClick = {
                                        swipeDismissableNavController.navigate("Track")
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFFFA83E0),
                                            textAlign = TextAlign.Center,
                                            text = "Daily Diet",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("DD")
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFF5DF5A3),
                                            textAlign = TextAlign.Center,
                                            text = "Statistics",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("Detail")
                                    }
                                )
                            }
                        }
                    }

                    composable("Detail") {
                        ScalingLazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(
                                top = 28.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 30.dp
                            ),
                            verticalArrangement = Arrangement.Center,
                            state = scalingLazyListState
                        ) {
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFFF974A4),
                                            textAlign = TextAlign.Center,
                                            text = "Yesterday",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("yester")
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFFFFD28D),
                                            textAlign = TextAlign.Center,
                                            text = "This week",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("tw")
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier

                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFF9485F3),
                                            textAlign = TextAlign.Center,
                                            text = "This month",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("tm")
                                    }
                                )
                            }
                        }
                    }

                    composable("DD") {
                        ScalingLazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(
                                top = 28.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 30.dp
                            ),
                            verticalArrangement = Arrangement.Center,
                            state = scalingLazyListState
                        ) {
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFF9B8DF4),
                                            textAlign = TextAlign.Center,
                                            text = "BreakFast",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("br")
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFFF6B477),
                                            textAlign = TextAlign.Center,
                                            text = "Lunch",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("lu")
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFF84EF81),
                                            textAlign = TextAlign.Center,
                                            text = "Dinner",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("di")
                                    }
                                )
                            }
                            item {
                                Chip(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),

                                    label = {
                                        Text(
                                            modifier = Modifier.fillMaxWidth(),
                                            color = Color(0xFFFA9B9B),
                                            textAlign = TextAlign.Center,
                                            text = "Snack",
                                            fontFamily = myLuckyFont
                                        )
                                    },
                                    colors = ChipDefaults.primaryChipColors(Color(0xFFFFF1F1)),
                                    onClick = {
                                        swipeDismissableNavController.navigate("sn")
                                    }
                                )
                            }
                        }
                    }
                    composable("Track") {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    top = 60.dp,
                                    start = 8.dp,
                                    end = 8.dp
                                ),
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally),
                                color = MaterialTheme.colors.primary,
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                                text = "Your glucose levels are:",
                            )

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    top = 60.dp,
                                    start = 8.dp,
                                    end = 8.dp
                                ),
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally),
                                color = MaterialTheme.colors.primary,
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                                text = "695",
                            )

                        }
                    }
                }
            }
        }
        manager = getSystemService(Context.WIFI_P2P_SERVICE) as WifiP2pManager
        channel = manager.initialize(this, mainLooper, null)
    }


}
