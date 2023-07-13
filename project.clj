(defproject sixsq.nuvla/parent "6.7.14-SNAPSHOT"

  :description "parent project file for Nuvla modules"

  :url "https://github.com/nuvla/parent"

  :license {:name         "Apache 2.0"
            :url          "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}

  :plugins [[lein-ancient "1.0.0-RC3"]
            [lein-kibit "0.1.8"]
            [jonase/eastwood "1.2.2"]
            [lein-cloverage "1.2.2"]
            [com.github.clj-kondo/lein-clj-kondo "0.1.3"]
            [lein-nvd "2.0.0"]
            [lein-nsorg "0.3.0"]
            [s3-wagon-private "1.3.5"]
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

   ;; Do not update to clojure 1.11.0 for the moment.
   ;; This will make IDE repl fail to run tests for api-server-private.
   [org.clojure/clojure "1.10.3"]
   [org.clojure/clojurescript "1.11.60"]

   ;;
   ;; general dependencies
   ;; (please keep these in alphabetical order)
   ;;

   ;; Do not update to aleph 0.4.7. This will make impossible to
   ;; start api-server-private in a repl
   ;; Conflicts with elasticsearch test framework
   [aleph "0.4.6"]

   [buddy/buddy-core "1.11.423"]
   [buddy/buddy-hashers "2.0.167"]
   [buddy/buddy-sign "3.5.351"]

   [cc.qbits/spandex "0.7.11"]
   [cheshire "5.11.0"]
   [clj-commons/clj-yaml "1.0.26"]
   [clj-commons/secretary "1.2.4"]
   [clj-http "3.12.3"]
   [clj-stacktrace "0.2.8"]
   [clojure.java-time "1.2.0"]
   [compojure "1.7.0"]
   [com.amazonaws/aws-java-sdk-s3 "1.12.505"]
   [com.cemerick/url "0.1.1"
    :exclusions [com.cemerick/clojurescript.test]]
   [com.draines/postal "2.0.5"]
   [com.rpl/specter "1.1.4"]
   [org.clojure/tools.reader "1.3.6"]

   [duratom "0.5.8"]

   [environ "1.2.0"]
   [expound "0.9.0"]

   [instaparse "1.4.12"]
   [io.nervous/kvlt "0.1.5-20180119.082733-5"
    :exclusions [org.clojure/clojurescript]]

   [log4j "1.2.17"
    :exclusions [javax.mail/mail
                 javax.jms/jms
                 com.sun.jdmk/jmxtools
                 com.sun.jmx/jmxri]]

   [org.apache.logging.log4j/log4j-core "2.20.0"]
   [org.apache.logging.log4j/log4j-api "2.20.0"]
   [org.apache.logging.log4j/log4j-web "2.20.0"]
   [org.apache.httpcomponents/httpclient "4.5.14"]          ; force version used by clj-http

   [me.raynes/fs "1.4.6"]
   [metosin/spec-tools "0.10.5"]

   [org.clojure/tools.logging "1.2.4"]
   [org.clojure/tools.namespace "1.4.4"]
   [org.clojure/data.json "2.4.0"]
   [org.clojure/java.classpath "1.0.0"]
   [org.clojure/core.async "1.6.673" :exclusions [org.clojure/tools.reader]]
   [org.clojure/test.check "1.1.1" :scope "test"]
   [org.elasticsearch.client/transport "7.0.0"]
   [org.elasticsearch.test/framework "7.0.0"
    :exclusions [com.carrotsearch.randomizedtesting/randomizedtesting-runner]]

   [org.slf4j/slf4j-api "2.0.7"]
   [org.slf4j/slf4j-log4j12 "2.0.7"]
   [org.slf4j/slf4j-simple "2.0.7"]

   [org.apache.curator/curator-test "5.5.0" :scope "test"]

   [ring "1.10.0"]
   [ring/ring-core "1.10.0" :exclusions [commons-io]]        ; clj-http needs a more recent version
   [ring/ring-codec "1.2.0"]
   [ring/ring-json "0.5.1"]
   [ring/ring-defaults "0.3.4"]

   [zookeeper-clj "0.10.0" :exclusions [[org.slf4j/slf4j-log4j12]]]

   [org.apache.zookeeper/zookeeper "3.8.1"
    :exclusions [ch.qos.logback/logback-classic
                 ch.qos.logback/logback-core
                 io.netty/netty-handler
                 io.netty/netty-tcnative
                 io.netty/netty-transport-native-epoll]]

   ;;
   ;; libraries and utilities for testing
   ;;

   [clojure-complete "0.2.5" :scope "test"
    :exclusions [org.clojure/clojure]]

   [com.google.javascript/closure-compiler-unshaded "v20230502"]

   ;; cljs testing; control options here
   [doo "0.1.11" :scope "test"]

   [peridot "0.5.4" :scope "test"]

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
                :update        :daily}]]

  :profiles {:dev {:dependencies [[clj-kondo "RELEASE"]]}})
