# Changelog

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
 
