# Dice Roller Game 🎲

A simple yet engaging dice rolling game for two players, built entirely with modern Android development tools. The first player to reach a score of 50 wins the game! This project was developed as an assignment for the Neat Roots course.

## 🎥 App Demo & Screenshots

*(Tip: Record a short GIF of your app flow and add it here. You can use a tool like Giphy Capture or ScreenToGif)*

| Splash Screen | Player Input | Game Screen | Winner Screen |
| :---: | :---: | :---: | :---: |
| ![Splash Screen](screenshots/splash_screen.png) | ![Player Input](screenshots/player_input_screen.png) | ![Game Screen](screenshots/game_screen.png) | ![Winner Screen](screenshots/winner_screen.png) |

*(To make this work, create a folder named `screenshots` in your project's main directory and add your images there with these names.)*

---

## ✨ Features

* **Splash Screen:** A beautiful animated splash screen to welcome the user.
* **Player Name Input:** A dedicated screen for players to enter their names.
* **Input Validation:**
    * Ensures both player names are different.
    * Allows only letters in names (no numbers or special characters).
* **Turn-Based Gameplay:** Players take turns rolling the dice.
* **Animated Dice Roll:** A fun rolling animation provides a realistic feel.
* **Real-time Score Updates:** Scores are accumulated and displayed instantly.
* **Winner Declaration:** A dedicated screen congratulates the winner.
* **Play Again:** Option to start a new game from the winner screen or the game screen itself.

---

## 🛠️ Tech Stack & Libraries

This project is built using 100% Kotlin and showcases a modern, single-activity architecture.

* **[Kotlin](https://kotlinlang.org/):** Official programming language for Android development.
* **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Android’s modern toolkit for building native UI.
* **[Compose Navigation (Type-safe)](https://developer.android.com/jetpack/compose/navigation):** For navigating between different screens in a type-safe manner.
* **[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel):** To store and manage UI-related data in a lifecycle-conscious way.
* **[Coroutines](https://kotlinlang.org/docs/coroutines-overview.html):** For managing background threads, especially for animations and delays.

---

## 🚀 Setup & Installation

To run this project, follow these steps:

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YogeshPrajapatii/Dice-Roller-Game.git](https://github.com/YogeshPrajapatii/Dice-Roller-Game.git)
    ```
2.  **Open in Android Studio:**
    * Open Android Studio.
    * Click on `File` > `Open`.
    * Navigate to the cloned repository folder and select it.
3.  **Build & Run:**
    * Let Android Studio sync the Gradle files.
    * Click the 'Run' button to build and install the app on an emulator or a physical device.

---

## 🧑‍💻 Author

**Yogesh Prajapati**

* GitHub: [@YogeshPrajapatii](https://github.com/YogeshPrajapatii)
