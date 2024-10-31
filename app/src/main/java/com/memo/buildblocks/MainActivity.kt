package com.memo.buildblocks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memo.buildblocks.ui.theme.BuildBlocksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}
@Preview
@Composable
fun MyBoxLayout() {
    Box(
        modifier = Modifier.size(120.dp).
        background(Color.Black).
        padding(10.dp).
        clip(RoundedCornerShape(size = 10.dp)).
        background(Color.LightGray)
    ) {
        Text(text = "Hello", Modifier.align(Alignment.TopStart), color = Color.White)
        Text(text = "Android", Modifier.align(Alignment.Center), color = Color.White)
        Text(text = "Cookies", Modifier.align(Alignment.BottomEnd), color = Color.White)
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyLayout() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MyText()
        MyButton()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Logo: ")
            MyImage()
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun MyText() {
    Text(
        text = "Elephants can sense storm",
        style = TextStyle(
            color = Color.Red,
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
        ),
        maxLines = 2
    )
}


//@Preview(showBackground = true)
@Composable
fun MyButton() {
    var buttonIsEnabled by remember { mutableStateOf(true) }
    Button(
        onClick = { buttonIsEnabled = false },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black,
            contentColor = Color.White,
            disabledContainerColor = Color.LightGray,
        ),
        enabled = buttonIsEnabled
    ) {
        Text(text = if (buttonIsEnabled) "Click me" else "I'm disabled")
    }
}

//@Preview(showBackground = true)
@Composable
fun MyTextField() {
    var emailAddress by remember { mutableStateOf("") }
    TextField(
        value = emailAddress,
        onValueChange = {
            emailAddress = it
        },
        label = {
            Text("Email Address")
        }
    )
}

//@Preview(showBackground = true)
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.compose),
        contentDescription = "Jetpack Compose Logo"
    )
}