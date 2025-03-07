package com.jefersonhernandez.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jefersonhernandez.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonTree(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            onClick = onClick,
            modifier = Modifier
                .clip(RoundedCornerShape(16))
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = stringResource(R.string.lemon_tree),
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .background(Color(0xffc3ecd2))
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = stringResource(R.string.tap_lemon_tree),
            fontSize = 18.sp
        )
    }
}

@Composable
fun SqueezeLemon(modifier: Modifier = Modifier, onClick: () -> Unit) {

    val tapTimes = (2..4).random()
    var countTimes by remember { mutableIntStateOf(1) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            onClick = {
                if (countTimes == tapTimes) {
                    onClick()
                } else {
                    countTimes++
                }
            },
            modifier = Modifier
                .clip(RoundedCornerShape(16))
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_squeeze),
                contentDescription = stringResource(R.string.tap_lemon_tree),
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .background(Color(0xffc3ecd2))
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = stringResource(R.string.keep_tapping_lemon),
            fontSize = 18.sp
        )
    }
}

@Composable
fun LemonadeGlass(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            onClick = onClick,
            modifier = Modifier
                .clip(RoundedCornerShape(16))
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_drink),
                contentDescription = stringResource(R.string.glass_lemonade),
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .background(Color(0xffc3ecd2))
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = stringResource(R.string.tap_lemonade_drink),
            fontSize = 18.sp
        )
    }
}

@Composable
fun EmptyGlass(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        Surface(
            onClick = onClick,
            modifier = Modifier
                .clip(RoundedCornerShape(16))
        ) {
            Image(
                painter = painterResource(R.drawable.lemon_restart),
                contentDescription = stringResource(R.string.empty_glass),
                modifier = Modifier
                    .size(width = 200.dp, height = 200.dp)
                    .background(Color(0xffc3ecd2))
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = stringResource(R.string.tap_empty_glass),
            fontSize = 18.sp
        )
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var step by remember { mutableStateOf(AppStep.TREE) }

    when (step) {
        AppStep.TREE -> LemonTree(modifier = modifier, onClick = {
            step = AppStep.SQUEEZE
        })

        AppStep.SQUEEZE -> SqueezeLemon(modifier = modifier, onClick = {
            step = AppStep.DRINK
        })

        AppStep.DRINK -> LemonadeGlass(modifier = modifier, onClick = {
            step = AppStep.EMPTY
        })

        AppStep.EMPTY -> EmptyGlass(modifier = modifier, onClick = {
            step = AppStep.TREE
        })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}