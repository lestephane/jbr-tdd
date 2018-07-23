
# Load and store junit-platform-console-standalone jar in ${ANT_HOME}/lib.

```
junit_platform_version='1.2.0'
wget --timestamping --continue --directory-prefix "test/lib" "http://central.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/${junit_platform_version}/junit-platform-console-standalone-${junit_platform_version}.jar"
```
