package com.jefersonhernandez.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefersonhernandez.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color(0xFFd2e8d4))
                    ) {
                        ProfileInfo(
                            name = stringResource(R.string.profile_name),
                            title = stringResource(R.string.profile_title),
                        )
                        ContactInformation(
                            phone = stringResource(R.string.phone),
                            email = stringResource(R.string.email),
                            account = stringResource(R.string.account)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfilePhoto(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)

    Image(
        painter = image,
        contentDescription = stringResource(R.string.profile_photo),
        modifier = modifier
            .size(100.dp)
            .background(Color(0xFF073042))
    )
}

@Composable
fun ProfileInfo(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f)
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        ProfilePhoto(modifier = Modifier.padding(bottom = 16.dp))
        Text(
            text = name,
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color(0xFF006d3b)
        )
    }
}


@Composable
fun ContactInformation(
    phone: String,
    account: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.Rounded.Call,
                contentDescription = null,
                tint = Color(0xFF006d3b),
                modifier = Modifier
                    .width(24.dp)
                    .fillMaxWidth(0.3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = phone, modifier = Modifier.fillMaxWidth(0.7f),
                color = Color.Black
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = null,
                tint = Color(0xFF006d3b),
                modifier = Modifier
                    .width(24.dp)
                    .fillMaxWidth(0.3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = account, modifier = Modifier.fillMaxWidth(0.7f),
                color = Color.Black
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = null,
                tint = Color(0xFF006d3b),
                modifier = Modifier
                    .width(24.dp)
                    .fillMaxWidth(0.3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = email, modifier = Modifier.fillMaxWidth(0.7f),
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Column(modifier = Modifier.background(Color(0xFFd2e8d4))) {
            ProfileInfo(
                name = stringResource(R.string.profile_name),
                title = stringResource(R.string.profile_title)
            )
            ContactInformation(
                phone = stringResource(R.string.phone),
                email = stringResource(R.string.email),
                account = stringResource(R.string.account)
            )
        }

    }
}