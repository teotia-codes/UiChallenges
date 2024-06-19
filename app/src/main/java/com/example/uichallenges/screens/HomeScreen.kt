package com.example.uichallenges.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uichallenges.BottomMenuData
import com.example.uichallenges.Feature
import com.example.uichallenges.R
import com.example.uichallenges.ui.theme.AquaBlue
import com.example.uichallenges.ui.theme.Beige1
import com.example.uichallenges.ui.theme.Beige2
import com.example.uichallenges.ui.theme.Beige3
import com.example.uichallenges.ui.theme.BlueViolet1
import com.example.uichallenges.ui.theme.BlueViolet2
import com.example.uichallenges.ui.theme.BlueViolet3
import com.example.uichallenges.ui.theme.ButtonBlue
import com.example.uichallenges.ui.theme.DarkerButtonBlue
import com.example.uichallenges.ui.theme.DeepBlue
import com.example.uichallenges.ui.theme.LightGreen1
import com.example.uichallenges.ui.theme.LightGreen2
import com.example.uichallenges.ui.theme.LightGreen3
import com.example.uichallenges.ui.theme.LightRed
import com.example.uichallenges.ui.theme.OrangeYellow1
import com.example.uichallenges.ui.theme.OrangeYellow2
import com.example.uichallenges.ui.theme.OrangeYellow3
import com.example.uichallenges.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.systemBarsPadding()
        ) {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )



        }
        BottomMenu(
            items = listOf(
                BottomMenuData("Home", R.drawable.ic_home),
                BottomMenuData("Meditate", R.drawable.ic_bubble),
                BottomMenuData("Sleep", R.drawable.ic_moon),
                BottomMenuData("Music", R.drawable.ic_music),
                BottomMenuData("Profile", R.drawable.ic_profile)
            ), modifier = Modifier.align(Alignment.BottomCenter))
    }


}

@Composable
fun GreetingSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = "Good Morning",
                color = TextWhite,
                style = MaterialTheme.typography.headlineLarge,
            )
            Text(
                text = "We wish you have a good day",
                color = TextWhite,
                style = MaterialTheme.typography.bodySmall,

            )
        }
        Spacer(modifier = Modifier.width(100.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun ChipSection(
    chips: List<String>,
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it)
                            ButtonBlue
                        else
                            DarkerButtonBlue
                    )
                    .padding(15.dp)
            )
            {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }

}

@Composable
fun CurrentMeditation(color: Color = LightRed) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()

    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Daily Thought",
                color = TextWhite,
                fontSize = 24.sp
            )
            Text(
                text = "Meditation * 3-10 min",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(DeepBlue)
                .size(40.dp)



        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

    }
}

@Composable
fun FeatureSection(
    features: List<Feature>,
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            color = TextWhite,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        )
        {
            items(features.size) {
                FeatureItem(feature = features[it])
            }

        }
    }


}


@Composable
fun FeatureItem(feature: Feature) {
    Box(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor.copy(alpha = 0.6f))
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Start,
                color = TextWhite,
                modifier = Modifier.padding(15.dp)
            )
        }

        Icon(
            painter = painterResource(id = feature.iconId), contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart)
        )
        Text(text = "Start",
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { }
                .padding(16.dp)
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(10.dp))
                .background(ButtonBlue)
                .padding(vertical = 5.dp, horizontal = 15.dp))
    }
}


@Composable
fun BottomMenu(
    items: List<BottomMenuData>,
    modifier: Modifier = Modifier,
    activeColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveColor: Color = AquaBlue,
    iconIndex: Int = 0,
) {
    var selectedItemindex by remember {
        mutableStateOf(iconIndex)
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items.forEachIndexed { index, item ->
BottomMenuItem(item = item,
    isSelected = index == selectedItemindex,
    activeColor = activeColor,
    activeTextColor = activeTextColor,
    inactiveColor = inactiveColor,) {

    selectedItemindex = index
}
        }

    }
}

@Composable
fun BottomMenuItem(item : BottomMenuData,
                   isSelected:Boolean = false,
                   activeColor: Color = ButtonBlue,
                   activeTextColor: Color = Color.White,
                   inactiveColor: Color = AquaBlue,
                   onItemClick: ()->Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable { onItemClick() }
    ) {
Box (
    contentAlignment = Alignment.Center,
    modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .background(
            if (isSelected)
                activeColor
            else
                Color.Transparent
        )
        .padding(10.dp)
){
Icon(painter = painterResource(id = item.icon),
    contentDescription ="",
    tint = if (isSelected)activeTextColor else inactiveColor,
    modifier = Modifier.size(20.dp))

}
        Text(text = item.title,
            color = if (isSelected)activeTextColor else inactiveColor)
    }

}
