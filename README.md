# NIT3213 – Final Assignment (Android)

A simple 3-screen Android app (**Login → Dashboard → Details**) using **Hilt**, **Retrofit**, **Coroutines**, and **ViewBinding**.

## Screens
- **Login**: Username (first & last name, e.g., `Meheraz Hossain`) + Password (student ID without `s`, e.g., `8131531`).  
- **Dashboard**: Fetches a list of fashion entities from `/dashboard/{keypass}` and shows them in a RecyclerView. Pull-to-refresh + Logout button.  
- **Details**: Shows the full entity (including description) with an Up (back) button.

## Tech
- Language: Kotlin
- Min SDK: 24, Target/Compile: 35
- JDK: 11
- Dependency Injection: **Hilt**
- Networking: **Retrofit + OkHttp logging**
- Concurrency: **Kotlin Coroutines**
- UI: ViewBinding, Material Components

## API
- Base URL: `https://nit3213api.onrender.com/`
- Auth endpoint: `POST /{campus}/auth` (campus fixed to `br` in the app)
- Dashboard endpoint: `GET /dashboard/{keypass}`

### Sample Credentials
- Username: `Meheraz Hossain`
- Password: `8131531`

## Project Setup

1. **Open in Android Studio** (Giraffe+).
2. Ensure **Gradle JDK = 11**  
   *File → Settings → Build, Execution, Deployment → Build Tools → Gradle → Gradle JDK = “Embedded JDK” or JDK 11.*
3. **Sync Gradle**.
4. **Run** on an emulator or device with internet enabled.

## Build & Run

- Debug APK: `Build → Build Bundle(s) / APK(s) → Build APK(s)`
- Unit tests (if any):  
  ```bash
  ./gradlew test
