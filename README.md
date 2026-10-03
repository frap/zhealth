# Z Health

Marketing site for Z Health (Yoga & Pilates with Zuri), built with [Hyper](https://github.com/dynamic-alpha/hyper).

Requires JDK 21+, Clojure CLI, Babashka and the Tailwind v4 standalone binary at `bin/tailwindcss`.

## Tasks

- `bb dev`: compile CSS and start an nREPL; evaluate `(go)` / `(halt)` in `user` to start or stop the server on port 3000
- `bb css-watch`: recompile Tailwind on change
- `bb uber`: build `target/zhealth.jar`
- `bb serve`: run the uberjar (`PORT` env var, default 3000)

`/ping` returns `pong` for health checks.
