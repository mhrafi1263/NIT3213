# Fashion For Passion (NIT3213 Final Project)

## 📌 Overview
This is the final Android project for **NIT3213**, implementing a simple fashion showcase app.  
It demonstrates clean architecture, dependency injection (Hilt), API integration (Retrofit), and MVVM with ViewModels.

**Screens**
1. **Login** – Username (first name) + Password (student ID, without “s”).  
2. **Dashboard** – RecyclerView list from API, pull-to-refresh, Logout.  
3. **Details** – Full item details, back/up navigation to Dashboard.

---

## 🚀 Features
- Login via API (POST)
- Dashboard list via API (GET) using the **keypass** from login
- Details screen with full description
- Logout button (returns to Login)
- Dependency Injection with **Hilt**
- MVVM (Repository + ViewModel + Flows)
- Error handling via Toasts
- Material toolbar titles and clean UI

---

## 🛠 Tech Stack
- **Kotlin**, **MVVM**
- **Hilt** for DI
- **Retrofit + Gson** for networking
- **Coroutines + Flow**
- **RecyclerView**, **SwipeRefreshLayout**, **Material Components**

---

## ⚙️ Setup & Run

1. **Clone**
   ```bash
   git clone https://github.com/<your-username>/NIT3213.git
   cd NIT3213
   
🔑 Test Credentials

Username: your first name (e.g., Meheraz Hossain)

Password: your student ID without the leading s (e.g., 8131531)


📂 Project Structure
app/
 └─ src/main/java/com/meherazrafi/nit3213/
     ├─ data/remote         # Retrofit API + DTOs
     ├─ di                  # Hilt modules
     ├─ ui                  # Activities, Adapters, ViewModels
     └─ NIT3213App.kt       # @HiltAndroidApp

✅ Permissions

AndroidManifest.xml

<uses-permission android:name="android.permission.INTERNET" />

📦 Main Dependencies
// Hilt
implementation("com.google.dagger:hilt-android:2.51.1")
kapt("com.google.dagger:hilt-compiler:2.51.1")

// Retrofit
implementation("com.squareup.retrofit2:retrofit:2.11.0")
implementation("com.squareup.retrofit2:converter-gson:2.11.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// AndroidX / Coroutines
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
implementation("androidx.recyclerview:recyclerview:1.3.2")
implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
implementation("com.google.android.material:material:1.12.0")

🧪 Unit Tests (optional)

Place ViewModel tests in:

app/src/test/java/com/meherazrafi/nit3213/


Run:

./gradlew test

🔧 Build Artifacts

Debug APK: app/build/outputs/apk/debug/app-debug.apk

To build:

./gradlew assembleDebug

👤 Author

Meheraz Hossain Rafi
Student ID: s8131531
NIT3213 Final Project
