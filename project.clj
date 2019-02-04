(defproject sixsq.nuvla/parent "6.0.0"

  :description "parent project file for Nuvla modules"

  :url "https://github.com/nuvla/parent"

  :license {:name         "Apache 2.0"
            :url          "http://www.apache.org/licenses/LICENSE-2.0"
            :distribution :repo}

  :plugins [[jonase/eastwood "0.2.5"]
            [kirasystems/lein-codox "0.10.4"]
            ;; FIXME update to lein-codox (remove kirasystems) after fix of
            ;; https://github.com/sattvik/leinjacker/issues/14
            ;; (leinjacker 0.4.3 is published and lein-codox update their leinjacker dependency to 0.4.3)
            [lein-ancient "0.6.15"]
            [lein-environ "1.1.0"]
            [lein-kibit "0.1.6"]
            [lein-licenses "0.2.2"]
            [lein-nsorg "0.1.4"]
            [lein-shell "0.5.0"]
            [com.livingsocial/lein-dependency-check "1.0.2"]]

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

  :managed-dependencies
  [
   ;;
   ;; core languages
   ;;

   [org.clojure/clojure "1.10.0"]                           ; defined also in SlipStream artifact
   [org.clojure/clojurescript "1.10.516"]

   ;;
   ;; general dependencies
   ;; (please keep these in alphabetical order)
   ;;

   ;; be careful of upgrading; newer versions have a
   ;; netty conflict with elasticsearch
   [aleph "0.4.4"]

   [buddy/buddy-core "1.5.0"]
   [buddy/buddy-hashers "1.3.0"]
   [buddy/buddy-sign "3.0.0"]

   [camel-snake-kebab "0.4.0"]
   [cc.qbits/spandex "0.6.4"]
   [cheshire "5.8.1"]                                       ;; newer, explicit version needed by ring-json
   [clj-commons/secretary "1.2.4"]                          ;; patched version for clojurescript 1.10.439
   [clj-http "3.9.1"]
   [clj-stacktrace "0.2.8"]
   [clj-time "0.15.1"]
   [clojure-ini "0.0.2"]
   [commons-io "2.6"]
   [commons-logging "1.2"]
   [commons-lang/commons-lang "2.6"]                        ; defined also in SlipStream artifact
   [commons-codec/commons-codec "1.11"]                     ; defined also in SlipStream artifact
   [compojure "1.6.1"]
   [com.amazonaws/aws-java-sdk-s3 "1.11.490"]
   [com.andrewmcveigh/cljs-time "0.5.2"]
   [com.cemerick/url "0.1.1"
    :exclusions [com.cemerick/clojurescript.test]]
   [com.draines/postal "2.0.3"]
   [com.jcraft/jsch "0.1.55"]                               ; defined also in SlipStream artifact
   [com.rpl/specter "1.1.2"]
   [com.taoensso/encore "2.105.0"]
   [com.taoensso/tempura "1.2.1"]
   [com.taoensso/tower "3.1.0-beta5"]
   [org.clojure/tools.reader "1.3.2"]

   ;; Pinned to this version because of a dependency conflict with the
   ;; deprecated tower library used by SlipStreamUI.
   [com.taoensso/timbre "4.7.4"]

   [day8.re-frame/http-fx "0.1.6"]
   [duratom "0.4.1"]

   [enlive "1.1.6"]
   [environ "1.1.0"]
   [expound "0.7.2"]

   [funcool/promesa "1.9.0"]

   [instaparse "1.4.10"]
   [io.nervous/kvlt "0.1.5-20180119.082733-5"
    :exclusions [org.clojure/clojurescript]]

   [javax.mail/mail "1.4.7" :scope "compile"]               ; defined also in SlipStream artifact
   [javax.servlet/javax.servlet-api "4.0.1"]                ; defined also in SlipStream artifact

   [log4j "1.2.17"
    :exclusions [javax.mail/mail
                 javax.jms/jms
                 com.sun.jdmk/jmxtools
                 com.sun.jmx/jmxri]]                        ; defined also in SlipStream artifact
   [org.apache.logging.log4j/log4j-core "2.11.1"]           ; defined also in SlipStream artifact
   [org.apache.logging.log4j/log4j-api "2.11.1"]            ; defined also in SlipStream artifact
   [org.apache.logging.log4j/log4j-web "2.11.1"]
   [org.apache.httpcomponents/httpclient "4.5.6"]           ; force version used by clj-http
   [org.slf4j/slf4j-simple "1.7.25"]

   [me.raynes/fs "1.4.6"]
   [metosin/spec-tools "0.8.3"]
   [metrics-clojure "2.10.0"]
   [metrics-clojure-ring "2.10.0"]
   [metrics-clojure-jvm "2.10.0"]
   [metrics-clojure-graphite "2.10.0"]

   [net.cgrand/moustache "1.1.0"]

   [org.clojure/data.xml "0.0.8"]
   [org.clojure/data.zip "0.1.2"]
   [org.clojure/tools.cli "0.4.1"]
   [org.clojure/tools.logging "0.4.1"]
   [org.clojure/tools.namespace "0.2.11"]
   [org.clojure/data.json "0.2.6"]
   [org.clojure/java.classpath "0.3.0"]
   [org.clojure/core.async "0.4.490" :exclusions [org.clojure/tools.reader]]
   [org.clojure/test.check "0.9.0" :scope "test"]           ; defined also in SlipStream artifact
   [org.elasticsearch/elasticsearch "6.2.4"]                ; defined also in SlipStream artifact
   [org.elasticsearch.client/elasticsearch-rest-client "6.2.4"]
   [org.elasticsearch.client/elasticsearch-rest-client-sniffer "6.2.4"]
   [org.elasticsearch.client/transport "6.2.4"]             ; defined also in SlipStream artifact
   [org.elasticsearch.plugin/transport-netty4-client "6.2.4"]
   [org.elasticsearch.test/framework "6.2.4"
    :exclusions [com.carrotsearch.randomizedtesting/randomizedtesting-runner]]

   [org.json/json "20180813"]
   [org.slf4j/slf4j-api "1.7.25"]
   [org.slf4j/slf4j-jdk14 "1.7.25"]                         ; defined also in SlipStream artifact
   [org.slf4j/slf4j-log4j12 "1.7.25"]                       ; defined also in SlipStream artifact

   ;; version 2.12.0 must be specified when using zookeeper
   ;; v3.4.x.  Upgrades beyond that may allow/require a
   ;; new version of curator-test. See:
   ;; https://curator.apache.org/zk-compatibility.html
   [org.apache.curator/curator-test "2.12.0" :scope "test"]

   [potemkin "0.4.5" :exclusions [riddley]]                 ; aleph needs a more recent version

   [reagent "0.8.1"]
   [re-frame "0.10.6"]
   [riddley "0.2.0"]
   [ring "1.7.1"]
   [ring/ring-core "1.7.1" :exclusions [commons-io]]        ; clj-http needs a more recent version
   [ring/ring-codec "1.1.1"]
   [ring/ring-json "0.4.0"]
   [ring/ring-defaults "0.3.2"]

   [superstring "3.0.0"]

   [zookeeper-clj "0.9.4"]

   ;; when upgrading beyond 3.4.x, update curator version above
   [org.apache.zookeeper/zookeeper "3.4.13"
    :exclusions [jline
                 org.slf4j/slf4j-log4j12]]

   ;;
   ;; libraries and utilities for testing
   ;;
   [binaryage/devtools "0.9.10" :scope "test"]

   [clojure-complete "0.2.5" :scope "test"
    :exclusions [org.clojure/clojure]]

   [com.google.javascript/closure-compiler-unshaded "v20190121"]

   ;; cljs testing; control options here
   [doo "0.1.11" :scope "test"]

   [expectations "2.1.10" :scope "test"]                    ; defined also in SlipStream artifact

   [junit "4.12" :scope "test"]

   [org.clojure/tools.nrepl "0.2.13" :scope "test"
    :exclusions [org.clojure/clojure]]

   [peridot "0.5.1" :scope "test"]

   [thheller/shadow-cljs "2.7.25"]
   ]

  :repositories
  [
   ["third-party" {:url           "https://nexus.sixsq.com/content/repositories/thirdparty/"
                   :snapshots     false
                   :sign-releases false
                   :checksum      :fail
                   :update        :daily}]
   ["community-snapshots" {:url           "https://nexus.sixsq.com/content/repositories/snapshots-community-rhel7/"
                           :snapshots     true
                           :sign-releases false
                           :checksum      :fail
                           :update        :always}]
   ["community-releases" {:url           "https://nexus.sixsq.com/content/repositories/releases-community-rhel7/"
                          :snapshots     false
                          :sign-releases false
                          :checksum      :fail
                          :update        :daily}]
   ["enterprise-snapshots" {:url           "https://nexus.sixsq.com/content/repositories/snapshots-enterprise-rhel7/"
                            :snapshots     true
                            :sign-releases false
                            :checksum      :fail
                            :update        :always}]
   ["enterprise-releases" {:url           "https://nexus.sixsq.com/content/repositories/releases-enterprise-rhel7/"
                           :snapshots     false
                           :sign-releases false
                           :checksum      :fail
                           :update        :daily}]]


  :deploy-repositories
  [["clojars" {:url      "https://clojars.org/repo"
               :username :env/clojars_username
               :password :env/clojars_password
               :signing  {:gpg-key "SixSq Release Manager <admin@sixsq.com>"}}]

   ["snapshots" {:url           "https://nexus.sixsq.com/content/repositories/snapshots-community-rhel7/"
                 :username      :env/sixsq_nexus_username
                 :password      :env/sixsq_nexus_password
                 :snapshots     true
                 :sign-releases false
                 :checksum      :fail
                 :update        :always}]
   ["releases" {:url           "https://nexus.sixsq.com/content/repositories/releases-community-rhel7/"
                :username      :env/sixsq_nexus_username
                :password      :env/sixsq_nexus_password
                :snapshots     false
                :sign-releases false
                :checksum      :fail
                :update        :daily}]])
