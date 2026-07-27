-dontusemixedcaseclassnames
-verbose

-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

-keepattributes *Annotation*

-keep class * extends dagger.hilt.android.AndroidEntryPoint
-keep @dagger.hilt.** class *
-keep @javax.inject.** class *

-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

-keepattributes Signature
-keepattributes Exceptions
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }

-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** { *; }

-keep class androidx.compose.** { *; }