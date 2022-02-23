(def es-version "7.0.0")

(defproject sixsq.nuvla/parent "6.7.6"

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
            [lein-nvd "1.9.0"]
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

   [org.clojure/clojure "1.10.3"]
   [org.clojure/clojurescript "1.10.866"]

   ;;
   ;; general dependencies
   ;; (please keep these in alphabetical order)
   ;;

   ;; be careful of upgrading; newer versions have a
   ;; netty conflict with elasticsearch
   [aleph "0.4.6"]

   [buddy/buddy-core "1.10.1"]
   [buddy/buddy-hashers "1.8.1"]
   [buddy/buddy-sign "3.4.1"]

   [cc.qbits/spandex "0.7.7"]
   [cheshire "5.10.0"]                                      ;; newer, explicit version needed by ring-json
   [clj-commons/clj-yaml "0.7.106"]
   [clj-commons/secretary "1.2.4"]
   [clj-http "3.12.2"]
   [clj-stacktrace "0.2.8"]
   [clojure.java-time "0.3.2"]
   [compojure "1.6.2"]
   [com.amazonaws/aws-java-sdk-s3 "1.11.1028"]
   [com.cemerick/url "0.1.1"
    :exclusions [com.cemerick/clojurescript.test]]
   [com.draines/postal "2.0.4"]
   [com.rpl/specter "1.1.3"]
   [org.clojure/tools.reader "1.3.5"]

   [duratom "0.5.3"]

   [environ "1.2.0"]
   [expound "0.8.9"]

   [instaparse "1.4.10"]
   [io.nervous/kvlt "0.1.5-20180119.082733-5"
    :exclusions [org.clojure/clojurescript]]

   [log4j "1.2.17"
    :exclusions [javax.mail/mail
                 javax.jms/jms
                 com.sun.jdmk/jmxtools
                 com.sun.jmx/jmxri]]

   [org.apache.logging.log4j/log4j-core "2.14.1"]
   [org.apache.logging.log4j/log4j-api "2.14.1"]
   [org.apache.logging.log4j/log4j-web "2.14.1"]
   [org.apache.httpcomponents/httpclient "4.5.13"]          ; force version used by clj-http
   [org.slf4j/slf4j-simple "1.7.30"]

   [me.raynes/fs "1.4.6"]
   [metosin/spec-tools "0.10.5"]

   [org.clojure/tools.logging "1.1.0"]
   [org.clojure/tools.namespace "1.1.0"]
   [org.clojure/data.json "2.3.1"]
   [org.clojure/java.classpath "1.0.0"]
   [org.clojure/core.async "1.3.618" :exclusions [org.clojure/tools.reader]]
   [org.clojure/test.check "1.1.0" :scope "test"]
   [org.elasticsearch/elasticsearch ~es-version]
   [org.elasticsearch.client/transport ~es-version]
   [org.elasticsearch.plugin/transport-netty4-client ~es-version]
   [org.elasticsearch.test/framework ~es-version
    :exclusions [com.carrotsearch.randomizedtesting/randomizedtesting-runner]]

   [org.slf4j/slf4j-api "1.7.30"]
   [org.slf4j/slf4j-log4j12 "1.7.30"]

   [org.apache.curator/curator-test "5.1.0" :scope "test"]

   [ring "1.9.3"]
   [ring/ring-core "1.9.3" :exclusions [commons-io]]        ; clj-http needs a more recent version
   [ring/ring-codec "1.1.3"]
   [ring/ring-json "0.5.1"]
   [ring/ring-defaults "0.3.2"]

   [zookeeper-clj "0.9.4"]

   [org.apache.zookeeper/zookeeper "3.7.0"
    :exclusions [jline
                 org.slf4j/slf4j-api
                 org.slf4j/slf4j-log4j12]]

   ;;
   ;; libraries and utilities for testing
   ;;

   [clojure-complete "0.2.5" :scope "test"
    :exclusions [org.clojure/clojure]]

   [com.google.javascript/closure-compiler-unshaded "v20210505"]

   ;; cljs testing; control options here
   [doo "0.1.11" :scope "test"]

   [peridot "0.5.3" :scope "test"]

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
