The auth_web_sdk package enables seamless integration of authentication in Android applications. It facilitates handling OAuth2 flows, allowing developers to manage user authentication and token retrieval within their apps easily.
 
## Prerequisites
 
- An existing Android project.
- Internet permission in your AndroidManifest.xml file.
- Support SDK
    - Android 21+
 
## How do I use the auth-web package

auth_web_version = 1.0.4

com.github.Subratsss19:AuthWeb: ${auth_web_version} 

To use the AuthWeb library, add it to your project dependencies.
Open your (Module: app) build. gradle file and add: 

Sync your project to download and include the dependency.

To initiate the authentication process, create an intent to open the Authentication Activity provided by the library. Use an ActivityResultLauncher to handle the result of the authentication process. 

Define authActivityResultLauncher in the Activity where you want to open. Here we want to open from LoginActivity. 


Initialize the authActivityResultLauncher like below and expect the access token.



Open the Library’s Authentication Activity like the below:

## Conclusion: 

This guide has covered the basic steps to integrate and use the auth_webview_sdk Package in your Android app. For more advanced configurations and troubleshooting, contact Skillmine Technologies. 
