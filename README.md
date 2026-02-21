# ReelMate - Movie Watchlist & Review App

## 📱 Project Overview

ReelMate is an Android mobile application designed for entertainment enthusiasts to manage their movie watchlist and share reviews. The app focuses on user engagement through personalized preferences and community-driven reviews.

**Application Name:** ReelMate  
**Package Name:** com.example.reelmate  
**Min SDK:** 24  
**Target SDK:** 36  
**Development Language:** Java

---

## ✨ Features

### 1. **User Authentication**
   - Login & Register functionality
   - Secure credential management
   - User session persistence

### 2. **Movie Watchlist Management**
   - Add movies to personal watchlist
   - Remove movies from watchlist
   - Organize movies by status (To Watch, Watching, Watched)
   - Search and filter movies

### 3. **Movie Rating & Reviews**
   - Rate watched movies (1-5 stars)
   - Write short reviews (max 500 characters)
   - View community reviews
   - Edit/Delete personal reviews

---

## 👥 Team Structure

| Member | Role | Responsibility | GitHub Branch |
|--------|------|-----------------|----------------|
| Chanuka Lakshan | Lead Developer | Login & Authentication Module | `feature/login` |
| Member 2 | Developer | Watchlist Management Module | `feature/watchlist` |
| Member 3 | Developer | Rating & Review Module | `feature/rating-review` |

---

## 📁 Project Structure

```
ReelMate/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/reelmate/
│   │   │   │   ├── activities/          # Activity classes
│   │   │   │   │   ├── LoginActivity.java
│   │   │   │   │   ├── MainActivity.java
│   │   │   │   │   ├── WatchlistActivity.java
│   │   │   │   │   └── ReviewActivity.java
│   │   │   │   ├── viewmodels/         # ViewModel classes (MVVM pattern)
│   │   │   │   ├── models/             # Data models
│   │   │   │   ├── repositories/       # Data repositories
│   │   │   │   ├── utils/              # Utility classes
│   │   │   │   └── database/           # Local database (Room)
│   │   │   ├── res/
│   │   │   │   ├── layout/             # XML layout files
│   │   │   │   ├── values/             # String, color, dimension resources
│   │   │   │   └── drawable/           # Image resources
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── local.properties
├── gradle.properties
├── README.md (this file)
└── DEVELOPMENT.md          # Development guidelines
```

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (Latest version)
- JDK 11 or higher
- Git (for version control)
- Gradle 7.4+

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd ReelMate
   ```

2. **Open in Android Studio**
   - File → Open → Select ReelMate folder
   - Wait for Gradle sync to complete

3. **Build the project**
   ```bash
   ./gradlew build
   ```

4. **Run the application**
   - Connect an Android device or start an emulator
   - Click "Run" in Android Studio or press `Shift + F10`

---

## 📋 Development Workflow

### Branch Strategy
- **Main Branch:** `main` - Production-ready code
- **Development Branch:** `develop` - Integration branch
- **Feature Branches:** `feature/login`, `feature/watchlist`, `feature/rating-review`

### Commit Guidelines
```
Format: <type>(<scope>): <subject>
Example: feat(login): implement user authentication

Types:
- feat: New feature
- fix: Bug fix
- docs: Documentation
- style: Code style/formatting
- refactor: Code restructuring
- test: Adding tests
```

### Pull Request Process
1. Create a feature branch from `develop`
2. Make changes and commit regularly
3. Push to GitHub: `git push origin feature/<feature-name>`
4. Create a Pull Request with clear description
5. Code review by team members
6. Merge to `develop` after approval

---

## 🏗️ Technology Stack

| Component | Technology |
|-----------|-----------|
| UI Framework | Android Jetpack (Material Design) |
| Architecture Pattern | MVVM (Model-View-ViewModel) |
| Data Persistence | SQLite (Room Database) |
| Async Operations | LiveData, Coroutines |
| Networking | Retrofit (for API calls) |
| Testing | JUnit, Espresso |

---

## 📦 Dependencies

### Core Dependencies
- androidx.appcompat:appcompat:1.x.x
- com.google.android.material:material:1.x.x
- androidx.constraintlayout:constraintlayout:2.x.x

### Additional Libraries (To be added)
- Room Database
- Retrofit & OkHttp
- LiveData & ViewModel
- Coroutines
- Dagger (Dependency Injection)

---

## 🔒 Authentication Module (Chanuka Lakshan)

### Features to Implement
- [ ] User registration with email validation
- [ ] Login with credentials
- [ ] Forgot password functionality
- [ ] Session management
- [ ] Logout functionality

### Files to Create
- `LoginActivity.java`
- `RegisterActivity.java`
- `LoginViewModel.java`
- `AuthRepository.java`
- Layout files: `activity_login.xml`, `activity_register.xml`

---

## 📚 Watchlist Module (Member 2)

### Features to Implement
- [ ] Display list of movies in watchlist
- [ ] Add movie to watchlist
- [ ] Remove movie from watchlist
- [ ] Update movie status
- [ ] Search and filter functionality

### Files to Create
- `WatchlistActivity.java`
- `WatchlistAdapter.java`
- `Movie.java` (Model)
- `WatchlistRepository.java`
- Layout files: `activity_watchlist.xml`, `item_movie.xml`

---

## ⭐ Rating & Review Module (Member 3)

### Features to Implement
- [ ] Display reviews for a movie
- [ ] Submit a review (rating + text)
- [ ] Edit/Delete personal reviews
- [ ] View average rating
- [ ] Sort reviews by date/rating

### Files to Create
- `ReviewActivity.java`
- `ReviewAdapter.java`
- `Review.java` (Model)
- `ReviewRepository.java`
- Layout files: `activity_review.xml`, `item_review.xml`

---

## 📱 UI/UX Guidelines

### Color Scheme
- **Primary Color:** #6200EE (Deep Purple)
- **Secondary Color:** #03DAC6 (Teal)
- **Surface Color:** #FFFFFF / #121212 (Dark mode)

### Typography
- **App Name Font:** Roboto Bold (24sp)
- **Headings:** Roboto Medium (18sp)
- **Body Text:** Roboto Regular (14sp)

---

## 🐛 Debugging & Logging

### Logging Levels
```java
// Use Android Log class
Log.d("TAG", "Debug message");
Log.i("TAG", "Info message");
Log.e("TAG", "Error message");
```

### Common Issues
1. Gradle sync fails → Clean Project → Invalidate Cache & Restart
2. Build errors → Check SDK version in build.gradle.kts
3. Runtime errors → Check Logcat for stack traces

---

## 📚 Resources

- [Android Developer Documentation](https://developer.android.com)
- [Jetpack Architecture Guide](https://developer.android.com/jetpack/guide)
- [Material Design Guidelines](https://material.io/design)
- [Git Documentation](https://git-scm.com/doc)

---

## 📞 Support & Communication

- **Code Issues:** GitHub Issues
- **Team Communication:** Discord/Slack/WhatsApp
- **Code Reviews:** GitHub Pull Requests
- **Documentation:** This README + DEVELOPMENT.md

---

## 📄 License

This project is created for educational purposes as part of a mini project assignment.

---

**Last Updated:** February 2026  
**Project Status:** In Development
