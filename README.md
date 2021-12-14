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
   git checkout tags/v7.16.1
   ```
1. Checkout the seohash plugin into the plugins directory
   ```shell script
   git clone git@github.com:publitek/painless-seohash.git ./plugins/painless-seohash
   ```
1. Update the version number in the plugin
   ```shell script
   vim ./plugins/painless-seohash/build.gradle
   ```
1. Install Java 16 JDK (https://jdk.java.net/archive/)
   ```shell script
   cd /data/
   wget https://download.java.net/java/GA/jdk16/7863447f0ab643c585b9bdebf67c69db/36/GPL/openjdk-16_linux-x64_bin.tar.gz
   tar zxf openjdk-16_linux-x64_bin.tar.gz
   ```
1. Set JAVA_HOME environmental variable
   ```shell script
   export JAVA_HOME=/data/jdk-16
   ```
1. Compile elasticsearch project
   ```shell script
   ./gradlew assemble
   ```
1. Copy the assembled plugin zip file
   ```
   ./plugins/painless-seohash/build/distributions/painless-seohash-7.16.1-SNAPSHOT.zip
   ```
1. Install plugin
   ```
   sudo /usr/share/elasticsearch/bin/elasticsearch-plugin install file:///home/byoungb/painless-seohash-7.16.1-SNAPSHOT.zip
   ```
