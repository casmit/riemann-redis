(defproject riemann-redis "0.1.0-SNAPSHOT"
  :description "Plugin wrapper for carmine"
  :url "https://github.com/casmit/riemann-redis"
  :dependencies [[com.taoensso/carmine "2.14.0"]
                 [cheshire "5.6.3"]
                 [clj-time "0.10.0"]]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
