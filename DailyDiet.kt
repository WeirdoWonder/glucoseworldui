package com.example.glucoseworld3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import com.example.glucoseworld3.ui.theme.ui.theme.GlucoseWorld3Theme

class DailyDiet : ComponentActivity() {
    @ExperimentalWearMaterialApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlucoseWorld3Theme {
                // A surface container using the 'background' color from the theme
                val scalingLazyListState: ScalingLazyListState = rememberScalingLazyListState()
                val myLuckyFont = FontFamily(Font(R.font.luckiestguyregular));

                ScalingLazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        top = 10.dp,
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 40.dp
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    state = scalingLazyListState
                ) {

                    item {
                        Chip(
                            modifier = Modifier
                                .width(160.dp)
                                .padding(top = 10.dp),

                            label = {
                                androidx.wear.compose.material.Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    color = androidx.wear.compose.material.MaterialTheme.colors.onPrimary,
                                    text = "Breakfast",

                                )
                            },
                            onClick = {
                                Toast.makeText(
                                    getApplicationContext(),
                                    "Geiaaa!!",
                                    Toast.LENGTH_SHORT
                                ).show();

                            }
                        )
                    }
                    item{
                        Chip(
                            modifier = Modifier
                                .width(160.dp)
                                .padding(top = 10.dp),

                            label = {
                                androidx.wear.compose.material.Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    color = androidx.wear.compose.material.MaterialTheme.colors.onPrimary,
                                    text = "Lunch"
                                )
                            },
                            onClick = {
                                Toast.makeText(getApplicationContext(), "Geiaaa!!", Toast.LENGTH_SHORT).show();

                            }
                        )
                    }
                    item{
                        Chip(
                            modifier = Modifier
                                .width(160.dp)
                                .padding(top = 10.dp),

                            label = {
                                androidx.wear.compose.material.Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    color = androidx.wear.compose.material.MaterialTheme.colors.onPrimary,
                                    text = "Snack"
                                )
                            },
                            onClick = {
                                Toast.makeText(getApplicationContext(), "Geiaaa!!", Toast.LENGTH_SHORT).show();

                            }
                        )
                    }
                    item{
                        Chip(
                            modifier = Modifier
                                .width(160.dp)
                                .padding(top = 10.dp),

                            label = {
                                androidx.wear.compose.material.Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    color = androidx.wear.compose.material.MaterialTheme.colors.onPrimary,
                                    text = "Statistics"

                                )
                            },
                            onClick = {
                                Toast.makeText(getApplicationContext(), "Geiaaa!!", Toast.LENGTH_SHORT).show();

                            }
                        )
                    }

                }

            }
        }
    }
}

