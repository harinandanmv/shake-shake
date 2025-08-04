# 🎨 Shake to Color

**Shake to Color** is a fun and simple Android app that changes the background color of the screen when the user shakes the device. It uses the accelerometer sensor to detect motion and responds instantly with a randomly generated color.

---

## ✅ Why This Project?

This project is built as an introduction to working with hardware sensors in Android. It demonstrates how user gestures like shaking can trigger fun and dynamic visual changes — making it both educational and interactive.

---

## 📱 Features

- 🎯 Detects shake motion using the built-in accelerometer.
- 🌈 Changes background to a **random RGB color** on each shake.
- ⚡ Lightweight and responsive with real-time updates.
- 👶 Beginner-friendly implementation using native Android APIs.

---

## 🧠 How It Works

1. The app registers a **SensorEventListener** for the accelerometer.
2. It tracks the speed of movement by calculating the difference in acceleration values.
3. If the movement speed exceeds a certain threshold, it:
   - Generates a random color using RGB values.
   - Sets it as the background color of the main layout.

---

## 📂 Project Structure

```
shake-to-color/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/shakeshake/MainActivity.java
│           └── res/layout/activity_main.xml
└── AndroidManifest.xml
```

---

## 🛠️ Tech Stack

- **Java**
- **Android SDK**
- **SensorManager API**
- **Accelerometer Sensor**

---

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/harinandanmv/shake-to-color.git
   ```

2. Open the project in **Android Studio**.

3. Connect your Android device or start an emulator.

4. Run the app and **shake your phone** to see the magic!

---

## 📬 Connect

Feel free to reach out on [LinkedIn](https://www.linkedin.com/in/harinandanmv) or check out more projects on [GitHub](https://github.com/harinandanmv).
