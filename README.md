# Timetable Android App

Timetable is a simple Android application designed to help students organize their class schedules at the KNRTU-KAI university. It pulls information from the official university website to display class schedules, making it easy for students to keep track of their classes.

## Features

- Display class schedules based on information from the official university website.
- Designed with Material Design principles for a modern and intuitive user experience.
- Utilizes custom views, Dagger 2 for dependency injection, and RxJava for reactive programming.

## Planned Features

- Ability to choose study group to display relevant class schedule.
- Ability to choose other universities as well.
- Further enhancements for improved usability and functionality.

## Installation

There is currently no UI for choosing a study group, so you will need to manually change the group number from '4206' to your group number in the ```MainViewModel.kt``` file. After making this change, you can build and install the app on your phone yourself.

## Usage

Once installed, open the Timetable app on your Android device. The app will automatically display your class schedule based on the information provided by the official university website. Use the navigation features to view different days and times.

## Contributing

Contributions are welcome! If you have any ideas for new features, enhancements, or bug fixes, please submit a pull request. For major changes, please open an issue first to discuss the proposed changes.

## Acknowledgements

- [Material Design](https://material.io/) - Design paradigm used for creating modern and intuitive user interfaces.
- [Dagger 2](https://dagger.dev/) - Dependency injection framework used for managing dependencies in the app.
- [RxJava](https://github.com/ReactiveX/RxJava) - Reactive programming library used for asynchronous and event-based programming.
