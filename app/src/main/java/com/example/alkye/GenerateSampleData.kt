package com.example.alkye

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.random.Random

fun generateSampleData(): List<CarsModel> {
    val titles = listOf(
        "Exploring the Future of AI",
        "Advancements in Augmented Reality",
        "The Rise of Quantum Computing",
        "Innovations in Autonomous Vehicles",
        "Breakthroughs in 5G Technology",
        "Revolutionizing Healthcare with Tech",
        "The Next Generation of Smart Cities",
        "The Impact of Blockchain on Finance",
        "Understanding the Metaverse",
        "Trends in Spatial Computing"
    )

    val descriptions = listOf(
        "A deep dive into the latest advancements and their implications for the future.",
        "How AR is changing the way we interact with the world around us.",
        "The potential of quantum computing to revolutionize various industries.",
        "The role of autonomous vehicles in shaping the future of transportation.",
        "What 5G technology means for connectivity and beyond.",
        "How technology is transforming healthcare and patient care.",
        "The development of smart cities and their impact on urban living.",
        "The use of blockchain technology in various sectors, including finance.",
        "Exploring the concept of the metaverse and its potential.",
        "Recent innovations in spatial computing and their applications."
    )

    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    val calendar = Calendar.getInstance()
    val sampleData = mutableListOf<CarsModel>()

    for (i in 1..10) {
        // Generate random title and description
        val title = titles[Random.nextInt(titles.size)]
        val description = descriptions[Random.nextInt(descriptions.size)]

        // Generate a random date within the next year
        calendar.add(Calendar.DAY_OF_YEAR, Random.nextInt(365))
        val date = dateFormat.format(calendar.time)
        calendar.add(Calendar.DAY_OF_YEAR, -calendar.get(Calendar.DAY_OF_YEAR)) // Reset calendar

        // Create a new CarsModel instance and add it to the list
        sampleData.add(CarsModel(title, description, date))
    }

    return sampleData
}
