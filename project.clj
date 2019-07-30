(def es-version "7.0.0")

(defproject sixsq.nuvla/parent "6.6.0-SNAPSHOT"

  :description "parent project file for Nuvla modules"

  :url "https://github.com/nuvla/parent"

  :license {:name         "Apache 2.0"
            :url          "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}

  :plugins [[jonase/eastwood "0.3.5"]
            [lein-ancient "0.6.15"]
            [lein-kibit "0.1.6"]
            [lein-nsorg "0.3.0"]
            [s3-wagon-private "1.3.2"]
            [lein-shell "0.5.0"]]

  :filespecs [{:type :path
               :path "./project.clj"}]

  :pom-location "target/"

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]]

  :vcs :git

  :managed-dependencies
  [
   ;;
   ;; core languages
   ;;

   [org.clojure/clojure "1.10.1"]
   [org.clojure/clojurescript "1.10.520"]

   ;;
   ;; general dependencies
   ;; (please keep these in alphabetical order)
   ;;

   ;; be careful of upgrading; newer versions have a
   ;; netty conflict with elasticsearch
   [aleph "0.4.6"]

   [buddy/buddy-core "1.6.0"]
   [buddy/buddy-hashers "1.4.0"]
   [buddy/buddy-sign "3.1.0"]

   [cc.qbits/spandex "0.7.1"]
   [cheshire "5.8.1"]                                       ;; newer, explicit version needed by ring-json
   [clj-commons/secretary "1.2.4"]                          ;; patched version for clojurescript 1.10.439
   [clj-http "3.10.0"]
   [clj-stacktrace "0.2.8"]
   [clojure.java-time "0.3.2"]
   [compojure "1.6.1"]
   [com.amazonaws/aws-java-sdk-s3 "1.11.601"]
   [com.cemerick/url "0.1.1"
    :exclusions [com.cemerick/clojurescript.test]]
   [com.draines/postal "2.0.3"]
   [com.rpl/specter "1.1.2"]
   [org.clojure/tools.reader "1.3.2"]

   [duratom "0.4.3"]

   [environ "1.1.0"]
   [expound "0.7.2"]

   [instaparse "1.4.10"]
   [io.nervous/kvlt "0.1.5-20180119.082733-5"
    :exclusions [org.clojure/clojurescript]]

   [log4j "1.2.17"
    :exclusions [javax.mail/mail
                 javax.jms/jms
                 com.sun.jdmk/jmxtools
                 com.sun.jmx/jmxri]]

   [org.apache.logging.log4j/log4j-core "2.12.0"]
   [org.apache.logging.log4j/log4j-api "2.12.0"]
   [org.apache.logging.log4j/log4j-web "2.12.0"]
   [org.apache.httpcomponents/httpclient "4.5.9"]           ; force version used by clj-http
   [org.slf4j/slf4j-simple "1.7.26"]

   [me.raynes/fs "1.4.6"]
   [metosin/spec-tools "0.10.0"]

   [org.clojure/tools.logging "0.5.0"]
   [org.clojure/tools.namespace "0.3.0"]
   [org.clojure/data.json "0.2.6"]
   [org.clojure/java.classpath "0.3.0"]
   [org.clojure/core.async "0.4.500" :exclusions [org.clojure/tools.reader]]
   [org.clojure/test.check "0.9.0" :scope "test"]
   [org.elasticsearch/elasticsearch ~es-version]
   [org.elasticsearch.client/transport ~es-version]
   [org.elasticsearch.plugin/transport-netty4-client ~es-version]
   [org.elasticsearch.test/framework ~es-version
    :exclusions [com.carrotsearch.randomizedtesting/randomizedtesting-runner]]

   [org.slf4j/slf4j-api "1.7.26"]
   [org.slf4j/slf4j-log4j12 "1.7.26"]

   ;; version 2.12.0 must be specified when using zookeeper
   ;; v3.4.x.  Upgrades beyond that may allow/require a
   ;; new version of curator-test. See:
   ;; https://curator.apache.org/zk-compatibility.html
   [org.apache.curator/curator-test "2.12.0" :scope "test"]

   [ring "1.7.1"]
   [ring/ring-core "1.7.1" :exclusions [commons-io]]        ; clj-http needs a more recent version
   [ring/ring-codec "1.1.2"]
   [ring/ring-json "0.4.0"]
   [ring/ring-defaults "0.3.2"]

   [zookeeper-clj "0.9.4"]

   ;; when upgrading beyond 3.4.x, update curator version above
   [org.apache.zookeeper/zookeeper "3.5.5"
    :exclusions [jline
                 org.slf4j/slf4j-api
                 org.slf4j/slf4j-log4j12]]

   ;;
   ;; libraries and utilities for testing
   ;;

   [clojure-complete "0.2.5" :scope "test"
    :exclusions [org.clojure/clojure]]

   [com.google.javascript/closure-compiler-unshaded "v20190618"]

   ;; cljs testing; control options here
   [doo "0.1.11" :scope "test"]

   [peridot "0.5.1" :scope "test"]

   ]

  :repositories
  [["nuvla-snapshots" {:url           "https://sixsq-build-artifacts.s3.amazonaws.com/snapshots"
                       :snapshots     true
                       :sign-releases false
                       :checksum      :fail
                       :update        :always}]
   ["nuvla-releases" {:url           "https://sixsq-build-artifacts.s3.amazonaws.com/releases"
                      :snapshots     false
                      :sign-releases false
                      :checksum      :fail
                      :update        :daily}]]

  :deploy-repositories
  [["clojars" {:url      "https://clojars.org/repo"
               :username :env/clojars_username
               :password :env/clojars_password
               :signing  {:gpg-key "SixSq Release Manager <admin@sixsq.com>"}}]
   ["snapshots" {:url           "s3p://sixsq-build-artifacts/snapshots"
                 :username      :env/AWS_ACCESS_KEY_ID
                 :passphrase    :env/AWS_SECRET_ACCESS_KEY
                 :snapshots     true
                 :sign-releases false
                 :checksum      :fail
                 :update        :always}]
   ["releases" {:url           "s3p://sixsq-build-artifacts/releases"
                :username      :env/AWS_ACCESS_KEY_ID
                :passphrase    :env/AWS_SECRET_ACCESS_KEY
                :snapshots     false
                :sign-releases false
                :checksum      :fail
                :update        :daily}]])
