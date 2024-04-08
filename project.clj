(defproject sixsq.nuvla/parent "6.8.0-SNAPSHOT"

  :description "parent project file for Nuvla modules"

  :url "https://github.com/nuvla/parent"

  :license {:name         "Apache 2.0"
            :url          "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}

  :plugins [[lein-ancient "1.0.0-RC3"]
            [lein-kibit "0.1.8"]
            [jonase/eastwood "1.4.2"]
            [lein-cloverage "1.2.4"]
            [lein-nvd "2.0.0"]
            [lein-nsorg "0.3.0"]
            [s3-wagon-private "1.3.5"]
            [lein-shell "0.5.0"]
            [lein-environ "1.2.0"]
            [lein-project-version "0.1.0"]]

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

  ;; managed-dependencies usage deprecated. It's adding more overhead work than helping.
  ;; declare version directly instead.
  :managed-dependencies
  [
   ;;
   ;; core languages
   ;;

   [org.clojure/clojure "1.11.2"]
   [org.clojure/clojurescript "1.11.4"]

   ;;
   ;; general dependencies
   ;; (please keep these in alphabetical order)
   ;;
   [aleph "0.7.1"]

   [buddy/buddy-core "1.11.423"]
   [buddy/buddy-hashers "2.0.167"]
   [buddy/buddy-sign "3.5.351"]
   [cheshire "5.13.0"]
   [clj-commons/clj-yaml "1.0.27"]
   [clj-commons/secretary "1.2.4"]
   [clj-http "3.12.3"]
   [clj-stacktrace "0.2.8"]
   [com.cemerick/url "0.1.1"
    :exclusions [com.cemerick/clojurescript.test]]
   [com.draines/postal "2.0.5"]
   [com.rpl/specter "1.1.4"]
   [org.clojure/tools.reader "1.4.1"]

   [duratom "0.5.9"]

   [environ "1.2.0"]
   [expound "0.9.0"]

   [instaparse "1.4.14"]
   [io.nervous/kvlt "0.1.5-20180119.082733-5"
    :exclusions [org.clojure/clojurescript]]

   [log4j "1.2.17"
    :exclusions [javax.mail/mail
                 javax.jms/jms
                 com.sun.jdmk/jmxtools
                 com.sun.jmx/jmxri]]

   [org.apache.logging.log4j/log4j-core "2.23.1"]
   [org.apache.logging.log4j/log4j-api "2.23.1"]
   [org.apache.logging.log4j/log4j-web "2.23.1"]
   [org.apache.httpcomponents/httpclient "4.5.14"]          ; force version used by clj-http

   [me.raynes/fs "1.4.6"]
   [metosin/spec-tools "0.10.6"]

   [org.clojure/tools.logging "1.3.0"]
   [org.clojure/tools.namespace "1.5.0"]
   [org.clojure/data.json "2.5.0"]
   [org.clojure/java.classpath "1.1.0"]
   [org.clojure/core.async "1.6.681" :exclusions [org.clojure/tools.reader]]
   [org.clojure/test.check "1.1.1" :scope "test"]

   [org.slf4j/slf4j-api "2.0.12"]
   [org.slf4j/slf4j-log4j12 "2.0.12"]
   [org.slf4j/slf4j-simple "2.0.12"]


   [org.apache.curator/curator-test "5.6.0" :scope "test"]

   [ring "1.12.1"]
   [ring/ring-core "1.12.1" :exclusions [commons-io]]        ; clj-http needs a more recent version
   [ring/ring-codec "1.2.0"]
   [ring/ring-json "0.5.1"]
   [ring/ring-defaults "0.4.0"]

   [zookeeper-clj "0.11.0" :exclusions [[org.slf4j/slf4j-log4j12]]]

   [org.apache.zookeeper/zookeeper "3.9.2"
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

   [com.google.javascript/closure-compiler-unshaded "v20220301"]

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
