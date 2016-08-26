# riemann-redis

This is a very simple wrapper for [taoensso/carmine](https://github.com/ptaoussanis/carmine) to publish
events to redis.

## Usage
In riemann.config

```clojure
(load-plugin "redis")

; See https://github.com/ptaoussanis/carmine/blob/master/src/taoensso/carmine.clj#L21 for options
(def redis-config {})

(let [index (index)]
  (streams
    (let [redis (redis/publish redis-config "riemann")] ; where "riemann" can be any channel
      redis)))

```

## Installation

Use [leiningen](http://leiningen.org) to create a jar:
```
lein uberjar
```

This will build the .jar in `target/uberjar/riemann-redis-0.1.0-SNAPSHOT-standalone.jar`
which will need to be placed in `/usr/lib/riemann/riemann-redis.jar`.

Finally, the .jar will need to be added to the classpath in `/etc/sysconfig/riemann`
or possibly `/etc/default/riemann` to `EXTRA_CLASSPATH`:
```
EXTRA_CLASSPATH=/usr/lib/riemann/riemann-redis.jar
```

## License

Copyright © 2016 Nexcess.net

Distributed under the Eclipse Public License 1.0.
