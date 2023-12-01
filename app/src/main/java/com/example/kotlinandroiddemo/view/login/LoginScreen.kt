package com.example.kotlinandroiddemo.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.kotlinandroiddemo.R
import com.example.kotlinandroiddemo.ui.theme.Body01
import com.example.kotlinandroiddemo.ui.theme.Body02Light
import com.example.kotlinandroiddemo.ui.theme.Header01ExtraBold
import com.example.kotlinandroiddemo.ui.theme.LightGrey05
import com.example.kotlinandroiddemo.ui.theme.LightRed
import com.example.kotlinandroiddemo.ui.theme.PlaceHolderText
import com.example.kotlinandroiddemo.viewmodel.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController = rememberNavController()) {
    val userViewModel = hiltViewModel<UserViewModel>()

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hello))
    val progress by animateLottieCompositionAsState(composition)
    var userNameInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightGrey05)
            .padding(24.dp, 15.dp, 24.dp, 0.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Login \uD83D\uDC4B",
                style = Header01ExtraBold
            )
            Text(
                text = "Welcome Back",
                style = Body02Light
            )
        }

        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .width(240.dp)
                .height(270.dp)
        )


        TextField(
            value = userNameInput,
            onValueChange = { userNameInput = it },
            placeholder = { Text("UserName", style = PlaceHolderText) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                containerColor = colorResource(id = R.color.white),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )

        )
        TextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            placeholder = { Text("UserName", style = PlaceHolderText) },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(0.dp, 20.dp),
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                containerColor = colorResource(id = R.color.white),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )

        )
        Button(
            onClick = { userViewModel.login(userNameInput, passwordInput) }, modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 25.dp),

            colors = ButtonDefaults.buttonColors(containerColor = LightRed)
        ) {
            Text("Login", style = Body01.merge(TextStyle(color = Color.White)))
        }
    }
}