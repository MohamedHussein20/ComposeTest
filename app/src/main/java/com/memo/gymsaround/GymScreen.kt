package com.memo.gymsaround;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.memo.buildblocks.ui.theme.Purple80


@Composable
fun GymScreen() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        listOfGyms.forEach{
            GymItem(it)
        }
    }
}

@Composable
fun GymItem(gym: Gym) {
    ElevatedCard(modifier = Modifier.padding(8.dp)) {
        Row(
            Modifier.padding(all = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GymIcon(Icons.Filled.Place, modifier = Modifier.weight(0.05f))
            GymDetails(gym, Modifier.weight(0.95f))
        }
    }
}

@Composable
fun GymIcon(place: ImageVector, modifier: Modifier) {
    Image(
        imageVector = place,
        contentDescription = "Gym Icon",
        modifier = modifier,
        colorFilter = ColorFilter.tint(
            Color.DarkGray
        )
    )
}

@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column (modifier = Modifier){
        Text(
            text = gym.name,
            style = MaterialTheme.typography.headlineMedium,
            color = Purple80)

        Text(
            text = gym.place,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black

        )
    }
}

