# Painless SEO Hash Plugin

We use consistent hashes based on the test and path in our website code to test changes to the site.
This plugin allows us to recreate those hashes in elasticsearch to use in our test analysis/reports.

To build this plugin it appears that you have to build it as part of the elasticsearch application.
So checkout the correct version of elasticsearch and then check this out in the plugins directory.
https://github.com/elastic/elasticsearch/tree/v6.5.0#building-from-source

1. Git clone the elasticsearch project
   ```shell script
   git clone https://github.com/elastic/elasticsearch.git
   cd ./elasticsearch
   git checkout tags/v7.10.0
   ```
1. Checkout the seohash plugin into the plugins directory
   ```shell script
   git clone git@github.com:publitek/painless-seohash.git ./plugins/painless-seohash
   ```
1. Update the version number in the plugin
   ```shell script
   vim ./plugins/painless-seohash/build.gradle
   ```
1. Install Java 12 JDK
   ```shell script
   cd /home/byoungb/tmp/
   wget https://download.java.net/java/GA/jdk12.0.2/e482c34c86bd4bf8b56c0b35558996b9/10/GPL/openjdk-12.0.2_linux-x64_bin.tar.gz
   tar zxf openjdk-12.0.2_linux-x64_bin.tar.gz
   ```
1. Set JAVA_HOME environmental variable
   ```shell script
   export JAVA_HOME=/home/byoungb/tmp/jdk-12.0.2
   ```
1. Compile elasticsearch project
   ```shell script
   ./gradlew assemble
   ```
1. Copy the assembled plugin zip file
   ```
   ./plugins/painless-seohash/build/distributions/painless-seohash-7.10.0-SNAPSHOT.zip
   ```
1. Install plugin
   ```
   sudo /usr/share/elasticsearch/bin/elasticsearch-plugin install file:///home/byoungb/painless-seohash-7.10.0-SNAPSHOT.zip
   ```
