# FastVPN - Fast VPN Android App

A modern, fast, and user-friendly VPN application for Android with support for multiple countries and real-time IP geolocation.

## Features

✅ **Fast VPN Connection** - One-tap connect/disconnect with optimized performance
✅ **Multiple Countries** - Access VPN servers from 8+ countries worldwide
✅ **IP Geolocation** - Display current IP address and country location
✅ **Real-time Status** - See connection speed and ping in real-time
✅ **Modern UI** - Built with Jetpack Compose for beautiful Material Design 3
✅ **Smart Server Selection** - Automatic fastest server detection
✅ **Lightweight** - Minimal battery consumption
✅ **Secure** - Uses OpenVPN protocol for encrypted connections

## Screenshots

- Home Screen with VPN connection status
- Server list with country flags and speed info
- Real-time IP and connection stats
- Dark and Light theme support

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Hilt DI
- **Async**: Kotlin Coroutines
- **Networking**: Retrofit + OkHttp
- **State Management**: StateFlow
- **Build**: Gradle 8.0+

## Minimum Requirements

- Android API 24 (Android 7.0 and above)
- Kotlin 1.9.0
- Gradle 8.0+

## Installation

### Clone the Repository

```bash
git clone https://github.com/morteza81sa-bit/FastVPN.git
cd FastVPN
```

### Build with Android Studio

1. Open Android Studio
2. Select **File → Open** and navigate to the FastVPN directory
3. Wait for Gradle sync to complete
4. Connect an Android device or start an emulator
5. Click **Run** or press `Shift + F10`

### Build from Command Line

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease
```

## Project Structure

```
FastVPN/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/fastvpn/
│   │   │   ├── MainActivity.kt
│   │   │   ├── FastVpnApp.kt
│   │   │   ├── service/
│   │   │   │   └── FastVpnService.kt          # VPN Service implementation
│   │   │   ├── ui/
│   │   │   │   ├── screens/
│   │   │   │   │   ├── HomeScreen.kt          # Main VPN UI
│   │   │   │   │   └── ServerListScreen.kt    # Server selection
│   │   │   │   └── theme/
│   │   │   │       ├── Theme.kt
│   │   │   │       └── Type.kt
│   │   │   ├── data/
│   │   │   │   ├── IpService.kt               # IP geolocation API
│   │   │   │   └── ServerRepository.kt        # Server management
│   │   │   ├── viewmodel/
│   │   │   │   └── VpnViewModel.kt            # MVVM ViewModel
│   │   │   └── di/
│   │   │       └── AppModule.kt               # Dependency Injection
│   │   └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── README.md
```

## Key Components

### VPN Service (FastVpnService.kt)
- Extends Android's VpnService
- Handles VPN connection/disconnection
- Manages VPN interface configuration
- Runs on a background thread

### ViewModel (VpnViewModel.kt)
- Manages VPN connection state
- Handles server selection
- Loads available servers
- Provides reactive UI updates via StateFlow

### UI Screens (HomeScreen.kt)
- **Home Screen**: Shows connection status, current IP, and quick connect button
- **Server List**: Displays available servers with speeds and ping times
- Built entirely with Jetpack Compose

### Server Repository (ServerRepository.kt)
- Pre-configured list of 8 VPN servers
- Speed and ping information
- Country-based filtering
- Automatic fastest server detection

## Permissions

The app requires the following permissions:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.BIND_VPN_SERVICE" />
<uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

## Available VPN Servers

1. 🇺🇸 **United States** - New York (950 Mbps)
2. 🇬🇧 **United Kingdom** - London (920 Mbps)
3. 🇩🇪 **Germany** - Berlin (940 Mbps)
4. 🇫🇷 **France** - Paris (930 Mbps)
5. 🇯🇵 **Japan** - Tokyo (880 Mbps)
6. 🇦🇺 **Australia** - Sydney (850 Mbps)
7. 🇨🇦 **Canada** - Toronto (960 Mbps)
8. 🇳🇱 **Netherlands** - Amsterdam (970 Mbps)

## Dependencies

- `androidx.core:core-ktx` - Android Core libraries
- `androidx.compose.ui` - Compose UI framework
- `androidx.compose.material3` - Material Design 3
- `com.google.dagger:hilt-android` - Dependency Injection
- `retrofit2` - HTTP networking
- `okhttp3` - HTTP client
- `org.jetbrains.kotlinx:kotlinx-coroutines` - Async operations

## Development

### Running Tests

```bash
./gradlew test              # Unit tests
./gradlew connectedAndroidTest  # Instrumented tests
```

### Build Release APK

```bash
./gradlew bundleRelease    # Create App Bundle for Play Store
./gradlew assembleRelease  # Create Release APK
```

### Code Style

- Follows Kotlin coding conventions
- Uses Jetpack Compose best practices
- MVVM architecture pattern
- Single Responsibility Principle

## Future Enhancements

- Real OpenVPN protocol integration
- WireGuard protocol support
- Advanced IP geolocation details
- VPN usage statistics
- Kill switch feature
- Split tunneling
- Multiple protocol support
- Custom server addition
- Automatic reconnection
- Push notifications

## Troubleshooting

### App crashes on startup
- Ensure Android API 24+ is installed
- Clear app cache: Settings → Apps → FastVPN → Storage → Clear Cache

### VPN won't connect
- Check that device has internet connection
- Verify VPN service permission is granted
- Try selecting a different server

### Slow connection
- Switch to a different server
- Check network signal strength
- Restart the app

## License

This project is licensed under the MIT License.

## Author

**Morteza81sa-bit**
- GitHub: [@morteza81sa-bit](https://github.com/morteza81sa-bit)

---

Made with ❤️ using Kotlin and Jetpack Compose
