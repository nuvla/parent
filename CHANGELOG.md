# Changelog

## Unreleased

## [6.7.11] - 2022-04-06

- Downgrade to aleph 0.4.6
- Downgrade to clojure/clojurescript 1.10.3

## [6.7.10] - 2022-03-30

### Changed

- Move Elasticsearch version to dependency. Lein ancient plugin not able to
  consider defined variables.
- Exclusion of netty moved to per project based

## [6.7.9] - 2022-03-30

### Changed

- Upgrade to clojure/clojurescript 1.11
- Exclude netty from Aleph

## [6.7.8] - 2022-03-29

### Changed

- Zookeeper dependency fix exclusion

## [6.7.7] - 2022-03-28

### Changed

- Dependencies updated

## [6.7.6] - 2022-03-23

### Added

- Added static code analysis plugins.

## [6.7.5] - 2021-05-27

### Changed

- Dependencies updated

## [6.7.4] - 2020-07-31

### Changed

- Dependencies updated

## [6.7.3] - 2020-03-23

### Added

- [clj-commons/clj-yaml "0.7.0"]

### Changed

- Dependencies updated

## [6.7.2] - 2019-12-02

### Changed

- Revert back to clojurescript "1.10.597" the issue was'nt there

## [6.7.1] - 2019-12-02

### Changed

- Revert to clojurescript "1.10.520" after issue found in nuvla clojure library
  on firefox

## [6.7.0] - 2019-11-20

### Changed

- Dependencies updated:
    - [cheshire "5.8.1"]

    + [cheshire "5.9.0"]

    - [com.amazonaws/aws-java-sdk-s3 "1.11.601"]

    + [com.amazonaws/aws-java-sdk-s3 "1.11.678"]

    - [com.rpl/specter "1.1.2"]

    + [com.rpl/specter "1.1.3"]

    - [duratom "0.4.3"]

    + [duratom "0.4.9"]

    - [org.apache.logging.log4j/log4j-core "2.12.0"]

    + [org.apache.logging.log4j/log4j-core "2.12.1"]

    - [org.apache.logging.log4j/log4j-api "2.12.0"]

    + [org.apache.logging.log4j/log4j-api "2.12.1"]

    - [org.apache.logging.log4j/log4j-web "2.12.0"]

    + [org.apache.logging.log4j/log4j-web "2.12.1"]

    - [org.apache.httpcomponents/httpclient "4.5.9"]

    + [org.apache.httpcomponents/httpclient "4.5.10"]

    - [org.slf4j/slf4j-simple "1.7.26"]

    + [org.slf4j/slf4j-simple "1.7.29"]

    - [org.clojure/tools.namespace "0.3.0"]

    + [org.clojure/tools.namespace "0.3.1"]

    - [org.clojure/data.json "0.2.6"]

    + [org.clojure/data.json "0.2.7"]

    - [org.clojure/core.async "0.4.500"]

    + [org.clojure/core.async "0.5.527"]

    - [org.clojure/test.check "0.9.0"]

    + [org.clojure/test.check "0.10.0"]

    - [org.slf4j/slf4j-api "1.7.26"]

    + [org.slf4j/slf4j-api "1.7.29"]

    - [org.slf4j/slf4j-log4j12 "1.7.26"]

    + [org.slf4j/slf4j-log4j12 "1.7.29"]

    - [org.apache.curator/curator-test "2.12.0"]

    + [org.apache.curator/curator-test "4.2.0"]

    - [ring "1.7.1"]

    + [ring "1.8.0"]

    - [ring/ring-core "1.7.1"]

    + [ring/ring-core "1.8.0"]

    - [ring/ring-json "0.4.0"]

    + [ring/ring-json "0.5.0"]

    - [org.apache.zookeeper/zookeeper "3.5.5"]

    + [org.apache.zookeeper/zookeeper "3.5.6"]

    - [com.google.javascript/closure-compiler-unshaded "v20190618"]

    + [com.google.javascript/closure-compiler-unshaded "v20191027"]

    - [peridot "0.5.1" :scope "test"]

    + [peridot "0.5.2" :scope "test"]

## [6.6.0] - 2019-07-30

### Changed

- Dependencies updated:
    - [buddy/buddy-core "1.5.0"]

    + [buddy/buddy-core "1.6.0"]

    - [buddy/buddy-hashers "1.3.0"]

    + [buddy/buddy-hashers "1.4.0"]

    - [buddy/buddy-sign "3.0.0"]

    + [buddy/buddy-sign "3.1.0"]

    - [cc.qbits/spandex "0.7.0"]

    + [cc.qbits/spandex "0.7.1"]

    - [com.amazonaws/aws-java-sdk-s3 "1.11.583"]

    + [com.amazonaws/aws-java-sdk-s3 "1.11.601"]

    - [org.apache.logging.log4j/log4j-core "2.11.2"]

    + [org.apache.logging.log4j/log4j-core "2.12.0"]

    - [org.apache.logging.log4j/log4j-api "2.11.2"]

    + [org.apache.logging.log4j/log4j-api "2.12.0"]

    - [org.apache.logging.log4j/log4j-web "2.11.2"]

    + [org.apache.logging.log4j/log4j-web "2.12.0"]

    - [org.clojure/tools.logging "0.4.1"]

    + [org.clojure/tools.logging "0.5.0"]

    - [org.apache.zookeeper/zookeeper "3.4.14"]

    + [org.apache.zookeeper/zookeeper "3.5.5"]

- Dependencies removed. Moved to nuvla/ui project.clj:
    - [reagent "0.8.1"]
    - [re-frame "0.10.7"]
    - [binaryage/devtools "0.9.10" :scope "test"]
    - [thheller/shadow-cljs "2.8.39"]
    - [com.taoensso/tempura "1.2.1"]
    - [com.taoensso/timbre "4.10.0"]
    - [day8.re-frame/http-fx "0.1.6"]

## [6.5.1] - 2019-06-28

### Changed

- Various minor/patch updates of dependencies:
    - clojure 1.10.1
    - spandex from 0.7.0-beta3 to 0.7.0
    - aws-java-sdk-s3 to 1.11.583
    - duratom to 0.4.3
    - httpclient to 4.5.9
    - spec-tools to 0.10.0
    - tool.namespace to 0.3.0
    - closure compiler to v20190618
    - shadow-cljs to 2.8.39

## [6.5.0] - 2019-04-24

### Changed

- Replace Joda-time by Java-time
- update shadowcljs deps

## [6.4.0] - 2019-04-17

### Changed

- Elasticsearch version changed to v7.0.0

## [6.3.0] - 2019-04-16

### Changed

- Use public URLs for the release and snapshot repositories.
- Patch updates of a few existing dependencies.
 
