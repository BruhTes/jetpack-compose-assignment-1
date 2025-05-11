package com.example.jetpackcomposeassignment.ui

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeassignment.data.Course
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeassignment.ui.theme.JetpackcomposeassignmentTheme

@Composable
fun CourseCard(
    course: Course,
    modifier: Modifier = Modifier
) {
    // State for expand/collapse
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    // Card with modifiers for size, padding, shape, and click behavior
    Card(
        modifier = modifier
            .fillMaxWidth() // Modifier: makes card fill the width
            .padding(vertical = 8.dp, horizontal = 16.dp) // Modifier: outer spacing
            .clip(MaterialTheme.shapes.medium) // Modifier: rounded corners
            .clickable { isExpanded = !isExpanded }, // Modifier: click to expand/collapse
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        // Column: vertical arrangement of all card content
        Column(
            modifier = Modifier
                .animateContentSize() // Modifier: animates size change
                .padding(20.dp) // Modifier: inner padding
        ) {
            // Row: horizontal arrangement of main info and expand icon
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Column: vertical arrangement of title, code, and credit
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = course.title,
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    // Row: horizontal arrangement of code and credit
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = course.code,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Surface(
                            color = MaterialTheme.colorScheme.onPrimary,
                            shape = MaterialTheme.shapes.small,
                            modifier = Modifier.padding(start = 4.dp)
                        ) {
                            Text(
                                text = "${course.creditHours} Credits",
                                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
                // Icon: expand/collapse, aligned horizontally
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (isExpanded) "Show less" else "Show more",
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { isExpanded = !isExpanded }
                )
            }
            // Expanded content: description and prerequisites, stacked vertically
            if (isExpanded) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = course.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.95f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Prerequisites: ${course.prerequisites}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseCardPreview() {
    JetpackcomposeassignmentTheme {
        CourseCard(
            course = Course(
                title = "Sample Course",
                code = "CS999",
                creditHours = 3,
                description = "This is a sample course description for preview purposes.",
                prerequisites = "None"
            )
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CourseCardDarkPreview() {
    JetpackcomposeassignmentTheme {
        CourseCard(
            course = Course(
                title = "Sample Course",
                code = "CS999",
                creditHours = 3,
                description = "This is a sample course description for preview purposes.",
                prerequisites = "None"
            )
        )
    }
} 