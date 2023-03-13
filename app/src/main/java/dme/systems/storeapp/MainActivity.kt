package dme.systems.storeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Fullscreen
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dme.systems.storeapp.ui.theme.StoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    val workOutCategories = listOf("Full body", "Cardio", "Cross Fit", "Cyclist", "Glutes", "Power")
    StoreAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.padding(horizontal = 18.dp),
                    elevation = 0.dp,
                    backgroundColor = Color.White,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(65.dp)
                                .clip(shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile),
                                contentDescription = " Profile picture",
                                contentScale = ContentScale.Fit
                            )
                        }

                        Text(buildAnnotatedString {
                            append("Hello, ")
                            withStyle(
                                style = SpanStyle(
                                    color = colorResource(id = R.color.black),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            ) {
                                append("Geraud")
                            }
                        }, modifier = Modifier.padding(start = 10.dp))

                        Spacer(modifier = Modifier.weight(1f))

                        BadgedBox(modifier = Modifier.padding(end = 10.dp),
                            badge = {
                                Badge(
                                    Modifier
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                        .align(Alignment.BottomEnd)
                                )
                            }) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "notification icon",
                                tint = Color.Black
                            )
                        }
                    }
                }
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                    elevation = 5.dp,
                    backgroundColor = Color.Black,
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        BottomNavigationItem(
                            selectedContentColor = Color.White,
                            unselectedContentColor = Color.LightGray,
                            selected = true,
                            onClick = { /*TODO*/ },
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "icon",
                                    modifier = Modifier.size(30.dp)
                                )
                            },
                        )

                        BottomNavigationItem(selectedContentColor = Color.Black,
                            unselectedContentColor = Color.LightGray,
                            selected = false,
                            onClick = { /*TODO*/ },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Fullscreen,
                                    contentDescription = "icon",
                                    modifier = Modifier.size(30.dp)
                                )
                            })

                        BottomNavigationItem(selectedContentColor = Color.Black,
                            unselectedContentColor = Color.LightGray,
                            selected = false,
                            onClick = { /*TODO*/ },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.Tune,
                                    contentDescription = "icon",
                                    modifier = Modifier.size(30.dp)
                                )
                            })

                        BottomNavigationItem(
                            selectedContentColor = Color.Black,
                            unselectedContentColor = Color.LightGray,
                            selected = false,
                            onClick = { /*TODO*/ },
                            icon = {
                                Icon(
                                    imageVector = Icons.Outlined.RadioButtonUnchecked,
                                    contentDescription = "icon",
                                    modifier = Modifier.size(30.dp)
                                )
                            })
                    }
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
            ) {

                Spacer(modifier = Modifier.size(15.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(workOutCategories) { workOut ->
                        WorkOutType(workOut)
                    }
                }

                Spacer(modifier = Modifier.size(30.dp))

                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(10))
                        .background(color = colorResource(id = R.color.light_purple))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 22.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Loose\nbelly fat", color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp
                            )

                            Button(
                                shape = RoundedCornerShape(20.dp),
                                contentPadding = PaddingValues(6.dp),
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = colorResource(id = R.color.purple_200)
                                )
                            ) {
                                Text(text = "Middle level", color = Color.White, fontSize = 18.sp)
                            }
                        }

                        Spacer(modifier = Modifier.size(15.dp))

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(30.dp))
                                .background(Color.White)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Spacer(modifier = Modifier.weight(0.5f))
                                Image(
                                    painter = painterResource(id = R.drawable.dumbel),
                                    contentDescription = "Dummy weight image",
                                    modifier = Modifier.size(200.dp)
                                )
                            }

                        }

                        Spacer(modifier = Modifier.size(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Schedule,
                                contentDescription = "Timer",
                                tint = Color.Black
                            )

                            Text(
                                text = "40 minutes",
                                fontSize = 18.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 5.dp)
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            TextButton(
                                onClick = { /*TODO*/ }, colors = ButtonDefaults.textButtonColors(
                                    backgroundColor = Color.Transparent
                                )
                            ) {
                                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                                    Text(
                                        text = "Start",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black,
                                    )

                                    Icon(
                                        imageVector = Icons.Filled.ArrowForward,
                                        contentDescription = "Timer",
                                        tint = Color.Black
                                    )
                                }
                            }
                        }

                    }
                }

                Spacer(modifier = Modifier.size(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(20))
                        .background(colorResource(id = R.color.orange))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Box(contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(75.dp),
                                color = Color.Black,
                                progress = 0.56f,
                                strokeWidth = 8.dp,
                            )

                            Text(
                                text = "56%",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                        }

                        Column {
                            Text(
                                text = "Great!",
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Text(
                                text = "You've lost 70% of your \ndaily calorie intake",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun WorkOutType(category: String) {
    var selected by remember { mutableStateOf(false) }
    val backgroundColor = if (selected) Color.Black else Color.White
    val textColor = if (selected) Color.White else Color.Black

    OutlinedButton(
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(6.dp),
        border = BorderStroke(width = 1.dp, color = Color.Black),
        onClick = { selected = !selected },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
        )
    ) {
        Text(text = category, color = textColor, fontSize = 18.sp)
    }
}