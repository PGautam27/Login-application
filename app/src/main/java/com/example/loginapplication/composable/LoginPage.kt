package com.example.loginapplication.composable

import android.view.View
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.compose.rememberNavController
import com.example.loginapplication.R
import com.example.loginapplication.ui.theme.primaryColor
import com.example.loginapplication.ui.theme.whiteBackground
import org.intellij.lang.annotations.JdkConstants


@Composable
fun LoginPage(navController: NavController) {
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    val passwordVisbility = remember {
        mutableStateOf(false)
    }
    val focusRequestor:FocusRequester = remember{ FocusRequester()}

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.register_page),
                contentDescription = null,
                modifier = Modifier.size(325.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(topStartPercent = 30, topEndPercent = 30))
                .background(whiteBackground)
                .padding(10.dp)
    
        ){
            ScrollableColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Sign in",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp,
                    ),
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = {emailValue.value = it},
                        label = { Text(text = "Email Address")},
                        placeholder = {Text(text = "Email Address")},
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = {passwordValue.value = it},
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
                        label = { Text(text = "Password")},
                        placeholder = { Text(text = "Password")},
                        singleLine = true,
                        visualTransformation = if(passwordVisbility.value) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = {},
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(58.dp)
                    ) {
                        Text(text = "Sign In", fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "Create An Account",
                        modifier = Modifier.clickable(onClick = {
                           navController.navigate("regiter_page"){
                               popUpTo = navController.graph.startDestinationId
                               launchSingleTop = true
                           }

                        })
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }

        }
    }
}

@Composable
fun scrollableColumn(
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