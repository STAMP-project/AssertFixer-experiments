# GoodData Java SDK [![Build Status](https://travis-ci.org/gooddata/gooddata-java.png?branch=master)](https://travis-ci.org/gooddata/gooddata-java) [![Javadocs](http://javadoc.io/badge/com.gooddata/gooddata-java.svg)](http://javadoc.io/doc/com.gooddata/gooddata-java) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.gooddata/gooddata-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.gooddata/gooddata-java)

The *GoodData Java SDK* encapsulates the REST API of the **GoodData Platform**.
The first version was implemented during the [All Data Hackathon](http://hackathon.gooddata.com) April 10 - 11 2014.
It is free and open-source software provided "as-is" under the [BSD License](LICENSE.txt) as an official project by [GoodData Corporation](http://www.gooddata.com).

## Usage

The *GoodData Java SDK* is available in Maven Central Repository, to use it from Maven add to `pom.xml`:

```xml
<dependency>
    <groupId>com.gooddata</groupId>
    <artifactId>gooddata-java</artifactId>
    <version>2.29.0</version>
</dependency>
```
See [releases page](https://github.com/gooddata/gooddata-java/releases) for information about versions and notable changes,
the [Upgrading Guide](https://github.com/gooddata/gooddata-java/wiki/Upgrading) will navigate you
through changes between major versions.

See [Javadocs](http://javadoc.io/doc/com.gooddata/gooddata-java)
or [Wiki](https://github.com/gooddata/gooddata-java/wiki) for
[Code Examples](https://github.com/gooddata/gooddata-java/wiki/Code-Examples)
and [Extensibility How-To](https://github.com/gooddata/gooddata-java/wiki/Extending).

### Dependencies

The *GoodData Java SDK* uses:
* the [GoodData HTTP client](https://github.com/gooddata/gooddata-http-client) version 0.9.3 or later
* the *Apache HTTP Client* version 4.5 or later (for white-labeled domains at least version 4.3.2 is required)
* the *Spring Framework* version 4.3.*
* the *Jackson JSON Processor* version 2.8.*
* the *Java Development Kit (JDK)* version 8 or later

## Development

Build the library with `mvn package`, see the
[Testing](https://github.com/gooddata/gooddata-java/wiki/Testing) page for different testing methods.

## Contribute

Found a bug? Please create an [issue](https://github.com/gooddata/gooddata-java/issues). Missing functionality?
[Contribute your code](CONTRIBUTING.md).
