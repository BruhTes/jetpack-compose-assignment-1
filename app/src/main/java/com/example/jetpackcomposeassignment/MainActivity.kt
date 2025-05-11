package com.example.jetpackcomposeassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeassignment.data.Course
import com.example.jetpackcomposeassignment.ui.CourseListScreen
import com.example.jetpackcomposeassignment.ui.theme.JetpackcomposeassignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackcomposeassignmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val courses = listOf(
                        Course(
                            title = "Introduction to Computer Science",
                            code = "CS101",
                            creditHours = 3,
                            description = "An introduction to the fundamental concepts of computer science, including algorithms, programming, and data structures.",
                            prerequisites = "None"
                        ),
                        Course(
                            title = "Data Structures & Algorithms",
                            code = "CS201",
                            creditHours = 4,
                            description = "Covers essential data structures (lists, stacks, queues, trees, graphs) and algorithms for manipulating them.",
                            prerequisites = "CS101"
                        ),
                        Course(
                            title = "Operating Systems",
                            code = "CS301",
                            creditHours = 3,
                            description = "Explores the design and implementation of modern operating systems, including process management, memory management, and file systems.",
                            prerequisites = "CS201"
                        ),
                        Course(
                            title = "Database Systems",
                            code = "CS305",
                            creditHours = 3,
                            description = "Introduction to database concepts, relational models, SQL, and database design.",
                            prerequisites = "CS201"
                        ),
                        Course(
                            title = "Software Engineering",
                            code = "CS401",
                            creditHours = 3,
                            description = "Principles of software engineering, project management, and software development life cycle.",
                            prerequisites = "CS201, CS305"
                        ),
                        Course(
                            title = "Computer Networks",
                            code = "CS310",
                            creditHours = 3,
                            description = "Study of computer networking principles, protocols, and architectures including TCP/IP, routing, and security.",
                            prerequisites = "CS201"
                        ),
                        Course(
                            title = "Artificial Intelligence",
                            code = "CS420",
                            creditHours = 3,
                            description = "Introduction to AI concepts, search algorithms, knowledge representation, and machine learning basics.",
                            prerequisites = "CS201, CS301"
                        ),
                        Course(
                            title = "Web Development",
                            code = "CS330",
                            creditHours = 3,
                            description = "Covers web technologies, HTML, CSS, JavaScript, and backend integration for building modern web applications.",
                            prerequisites = "CS101"
                        ),
                        Course(
                            title = "Mobile Application Development",
                            code = "CS350",
                            creditHours = 3,
                            description = "Design and development of mobile applications for Android and iOS platforms.",
                            prerequisites = "CS201"
                        ),
                        Course(
                            title = "Discrete Mathematics",
                            code = "MATH210",
                            creditHours = 3,
                            description = "Mathematical reasoning, combinatorics, graph theory, and discrete structures for computer science.",
                            prerequisites = "None"
                        )
                    )
                    CourseListScreen(
                        courses = courses,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}