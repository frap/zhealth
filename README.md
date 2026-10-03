# Z Health

Marketing site for Z Health (Yoga & Pilates with Zuri), built with [Hyper](https://github.com/dynamic-alpha/hyper).

Requires JDK 21+, Clojure CLI, Babashka and the Tailwind v4 standalone binary at `bin/tailwindcss`.

## Tasks

- `bb dev`: compile CSS and start an nREPL; evaluate `(go)` / `(halt)` in `user` to start or stop the server on port 3000
- `bb css-watch`: recompile Tailwind on change
- `bb uber`: build `target/zhealth.jar`
- `bb serve`: run the uberjar (`PORT` env var, default 3000)

`/ping` returns `pong` for health checks.

## Deployment

Hosted on a Vultr VPS running [Basecamp ONCE](https://github.com/basecamp/once), provisioned with
[getcolors/once](https://github.com/getcolors/once) (green launcher). Desired state is `deploy/colors.yml`.

- `cd deploy && ./green build` renders the work directory offline; `./green create --dry-run`, then `./green create`
- Secrets are `COLORS_PAR_*` exports in the ignored `deploy/.envrc.private`:
  `VULTR_API_KEY`, `R2_ACCESS_KEY_ID`, `R2_SECRET_ACCESS_KEY`, `RESEND_API_KEY`, `RESEND_PASSWORD`,
  `ONCE_SSH_PASSPHRASE` (back it up) and `GITHUB_TOKEN` (`$(gh auth token)`)
- Pushes to `main` build `ghcr.io/frap/zhealth` and ping the server to pull it (`.github/workflows/deploy.yml`)
- Refresh the launcher after `npx skills update -p`: `cp .claude/skills/package-once-green/green green`
