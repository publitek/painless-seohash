# Painless SEO Hash Plugin

We use consistent hashes based on the test and path in our website code to test changes to the site.
This plugin allows us to recreate those hashes in elasticsearch to use in our test analysis/reports.

To build this plugin it appears that you have to build it as part of the elasticsearch application.
So checkout the correct version of elasticsearch and then check this out in the plugins directory.
Then form the elasticsearch project root run `gradle assemble` and then just copy the zip out of `plugins/painless-seohash/build/distributions/`