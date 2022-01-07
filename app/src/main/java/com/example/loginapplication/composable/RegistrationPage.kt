package com.example.loginapplication.composable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginapplication.R
import com.example.loginapplication.ui.theme.primaryColor
import com.example.loginapplication.ui.theme.whiteBackground

@Composable
fun RegistrationPage(navController: NavController){
    val scrollState = rememberScrollState()
    val passwordVisbility = remember {
        mutableStateOf(false)
    }
    val ConfirmPasswordVisbility = remember {
        mutableStateOf(false)
    }
    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.register_page),
                null,
                modifier = Modifier.size(325.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(topEndPercent = 30, topStartPercent = 30))
                .background(whiteBackground)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            scrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Sign up",
                    fontSize = 30.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it },
                        label = { Text(text = "Name") },
                        placeholder = { Text(text = "Name") },
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email Address") },
                        placeholder = { Text(text = "Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = phoneValue.value,
                        onValueChange = { phoneValue.value = it },
                        label = { Text(text = "Phone Number") },
                        placeholder = { Text(text = "Phone Number") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisbility.value = !passwordVisbility.value
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password),
                                    contentDescription = null,
                                    tint = if (passwordVisbility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisbility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it },
                        label = { Text(text = "Confirm Password") },
                        trailingIcon = {
                            IconButton(onClick = {
                                ConfirmPasswordVisbility.value = !ConfirmPasswordVisbility.value
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.password),
                                    contentDescription = null,
                                    tint = if (ConfirmPasswordVisbility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        placeholder = { Text(text = "Confirm Password") },
                        singleLine = true,
                        visualTransformation = if (ConfirmPasswordVisbility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(text = "Sign Up", fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Button(
                        onClick = {
                                  navController.navigate("login_page"){
                                      popUpTo = navController.graph.startDestinationId
                                      launchSingleTop = true
                                  }
                                  },
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .height(50.dp)
                    ) {
                        Text(text = "Login Instead", fontSize = TextUnit.Unspecified)
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                }

            }
        }
    }
}@Composable
fun ScrollableColumn(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(0),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    reverseScrollDirection: Boolean = false,
    isScrollEnabled: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .verticalScroll(
                scrollState,
                isScrollEnabled,
                reverseScrolling = reverseScrollDirection
            )
            .padding(contentPadding),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment,
        content = content
    )
}