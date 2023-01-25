package com.example.composeuipracticing

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeuipracticing.ui.theme.GoogleBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen()
        }
    }
}

@Composable
fun Screen() {
    Column() {
        val context = LocalContext.current
        var textInput by remember { mutableStateOf("") }

        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = null,
            Modifier
                .height(80.dp)
                .width(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp)
        )
        Text(
            text = "Sign in",
            Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            fontSize = 26.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "with your Google Account.  ")
            Text(text = "Learn more", fontWeight = FontWeight.Bold, color = GoogleBlue)
        }
        TextField(
            value = textInput, onValueChange = { textInput = it },
            label = { Text("Email or phone") },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 10.dp)
                .border(0.4.dp, GoogleBlue, RoundedCornerShape(1.dp)),
            singleLine = true

        )
        Text(
            text = "Forgot email?",
            color = GoogleBlue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 20.dp)
                .clickable {
                    Toast
                        .makeText(context, "Sorry for you!", Toast.LENGTH_LONG)
                        .show()
                }
        )

        Spacer(modifier = Modifier.height(450.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Create account",
                color = GoogleBlue,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable {
                    Toast.makeText(context, "Why did you forget ? ", Toast.LENGTH_LONG).show()
                })
            Button(
                onClick = {
                    Toast.makeText(context, "Button clicked", Toast.LENGTH_LONG).show()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GoogleBlue, contentColor = Color.White,
                    Color.Yellow, Color.Magenta
                )
            ) {
                Text(text = "Next")

            }
        }


    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ScreenPreview() {
    Screen()
}