(ns riemann-redis.core
  (:require clj-time.core
            clj-time.format
            clj-time.coerce
            [taoensso.carmine :as car :refer [wcar]]
            [cheshire.core :as json]))

; https://github.com/riemann/riemann/blob/0.2.11/src/riemann/common.clj#L70
(defn unix-to-iso8601
  "Transforms unix time to iso8601 string"
  [unix]
  (clj-time.format/unparse (clj-time.format/formatters :date-time)
                           (clj-time.coerce/from-long (long (* 1000 unix)))))

; https://github.com/riemann/riemann/blob/0.2.11/src/riemann/common.clj#L126
(defn event-to-json
  "Convert an event to a JSON string."
  [event]
  (json/generate-string (assoc event :time (unix-to-iso8601 (:time event)))))

(defn publish
  "Use specified config to return function for publishing to passed channel."
  [config channel]
  (fn [event]
      (future (car/wcar config
                (car/publish channel (event-to-json event))))))
