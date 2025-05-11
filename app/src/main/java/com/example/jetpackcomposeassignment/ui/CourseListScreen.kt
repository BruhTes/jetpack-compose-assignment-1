package com.example.jetpackcomposeassignment.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeassignment.data.Course
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeassignment.ui.theme.JetpackcomposeassignmentTheme

@Composable
fun CourseListScreen(
    courses: List<Course>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        // Header with blue gradient background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF1565C0), // Strong blue
                            Color(0xFF42A5F5)  // Lighter blue
                        )
                    )
                )
                .padding(vertical = 18.dp, horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Course List",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Browse and expand to see course details",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White.copy(alpha = 0.85f)
                )
            }
        }
        // List
        LazyColumn(modifier = Modifier.weight(1f).padding(vertical = 8.dp)) {
            items(courses) { course ->
                CourseCard(course = course)
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    JetpackcomposeassignmentTheme {
        CourseListScreen(
            courses = listOf(
                Course(
                    title = "Sample Course 1",
                    code = "CS101",
                    creditHours = 3,
                    description = "Intro to CS.",
                    prerequisites = "None"
                ),
                Course(
                    title = "Sample Course 2",
                    code = "CS102",
                    creditHours = 4,
                    description = "Advanced CS.",
                    prerequisites = "CS101"
                )
            )
        )
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CourseListScreenDarkPreview() {
    JetpackcomposeassignmentTheme {
        CourseListScreen(
            courses = listOf(
                Course(
                    title = "Sample Course 1",
                    code = "CS101",
                    creditHours = 3,
                    description = "Intro to CS.",
                    prerequisites = "None"
                ),
                Course(
                    title = "Sample Course 2",
                    code = "CS102",
                    creditHours = 4,
                    description = "Advanced CS.",
                    prerequisites = "CS101"
                )
            )
        )
    }
} 