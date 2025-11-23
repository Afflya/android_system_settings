import com.android.build.api.variant.impl.VariantOutputImpl

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.autoext.systemsettings"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.autoext.systemsettings"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

androidComponents {
    onVariants {
        it.outputs.onEach { output ->
            (output as VariantOutputImpl).outputFileName =
                "systemsettings__${it.buildType.toString()}__${output.versionName.get()}.apk"
        }
    }
}

dependencies {
}