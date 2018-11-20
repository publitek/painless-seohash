# Painless SEO Hash Plugin

We use consistent hashes based on the test and path in our website code to test changes to the site.
This plugin allows us to recreate those hashes in elasticsearch to use in our test analysis/reports.

To build this plugin it appears that you have to build it as part of the elasticsearch application.
So checkout the correct version of elasticsearch and then check this out in the plugins directory.
https://github.com/elastic/elasticsearch/tree/v6.5.0#building-from-source

1. Git clone the elasticsearch project
   ```
   git clone https://github.com/elastic/elasticsearch.git
   cd ./elasticsearch
   git checkout tags/v6.5.0
1. Checkout the seohash plugin into the plugins directory
   ```
   git clone git@github.com:publitek/painless-seohash.git ./plugins/painless-seohash
   ```
1. Update the version number in the plugin
   ```
   vim ./plugins/painless-seohash/build.gradle
   ```
1. Install Java 11 JDK
   ```
   sudo dnf install java-11-openjdk-devel
   ```
1. Set JAVA_HOME environmental variable
   ```
   export JAVA_HOME=/usr/lib/jvm/java-11-openjdk
   ```
1. Compile elasticsearch project
   ```
   ./gradlew assemble
   ```
1. Copy the assembled plugin zip file
   ```
   ./plugins/painless-seohash/build/distributions/painless-seohash-6.5.0-SNAPSHOT.zip
   ```

