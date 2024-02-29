# Table of Contents

- [Table of Contents](#table-of-contents)
- [Start](#start)
- [Building Locally](#building-locally)
- [Color Codes](#color-codes)
- [Create React App Deployment to GitHub Pages](#create-react-app-deployment-to-github-pages)
- [Deploying](#deploying)
- [Deployment to Hosting Service](#deployment-to-hosting-service)
- [Gradients](#gradients)
- [Light Mode and Dark Mode](#light-mode-and-dark-mode)
- [Update Browsers List](#update-browsers-list)
- [Yarn Packages](#yarn-packages)
- [Yarn Update/Upgrade Packages](#yarn-updateupgrade-packages)

# Start

- Create and clone repo in github called 'username.github.io'
- `npx create-react-app ./`
- Create a separate branch 'gh-pages' to use for deployment

# Building Locally

- `yarn start`

# Color Codes

- Dark
  - `#50fa7b`
- Light
  - `#17A9FD`
  - `#1ed760`

# Create React App Deployment to GitHub Pages

- Add 'homepage' field to package.json
  ```json
  "homepage": "https://samsolichin.github.io",
  ```
- `yarn add gh-pages`
- Add scripts to package.json
  - Deploys build to ‘gh-pages' branch
  ```json
  "predeploy": "npm run build",
  "deploy": "gh-pages -d build",
  ```
  - Deploys build to 'master' branch
  ```json
  "deploy": "gh-pages -b master -d build",
  ```
- Deploy changes to github pages (need to run this every time)
  ```
  npm run deploy
  yarn deploy
  ```
- Errors
  - Fatal: A branch named 'gh-pages' already exists.
    - Delete 'node_modules/.cache/gh-pages' folder
- Links
  - https://create-react-app.dev/docs/deployment/

# Deploying

- `yarn deploy`

# Deployment to Hosting Service

- https://create-react-app.dev/docs/deployment/#github-pages
- Buy Domain from Google Domains and VERIFY your email (check emails)
  - https://support.google.com/domains/answer/7630973?hl=en&visit_id=637803155816948115-1032482699&rd=1
- Google Domain
  - DNS -> Resource Records
  - Record 1
    - HostName = LeaveBlank
    - Type = A
    - TTL = 3600
    - DATA
      - 185.199.108.153
      - 185.199.109.153
      - 185.199.110.153
      - 185.199.111.153
  - Record 2
    - HostName = www
    - Type = CNAME
    - TTL = 3600
    - DATA = https://samsolichin.github.io
  - Record 3
    - HostName = LeaveBlank
    - Type = AAAA
    - TTL = 3600
    - DATA
      - 2606:50c0:8000::153
      - 2606:50c0:8001::153
      - 2606:50c0:8002::153
      - 2606:50c0:8003::153
- Github Repository
  - Settings -> Pages -> Custom Domain -> Add custom domain
  - Create CNAME file and put inside 'public' folder of repo
    - Put in 'master' branch and not 'gh-pages' branch
    - Make sure CNAME file appears in 'gh-pages' branch (directory that is being published)
  - Update "homepage" field in package.json
- Misc
  - `echo 'your_custom_domain.online' > ./build/CNAME && "gh-pages -d build"`

# Gradients

```js
'linear-gradient(109.6deg, rgba(253,239,132,1) 11.2%, rgba(128,255,221,1) 57.8%, rgba(255,128,249,1) 85.9%)';
'linear-gradient(109.6deg, rgba(254, 222, 0,1) 11.2%, rgba(0, 245, 179,1) 57.8%, rgba(255, 0, 243,1) 85.9%)';
'linear-gradient(90deg, #00DBDE 0%, #FC00FF 100%)';
'linear-gradient(to right, #92fe9d 0%, #00c9ff 100%)';
'linear-gradient( 68.6deg,  rgba(252,165,241,1) 1.8%, rgba(181,255,255,1) 100.5% )';
'radial-gradient( circle 1165px at -5.4% 50.5%,  rgba(0,255,239,1) 4.1%, rgba(243,4,251,1) 47%, rgba(251,223,0,1) 89.5% );';
'linear-gradient(180deg, #2af598 0%, #009efd 100%)';
```

# Light Mode and Dark Mode

- Replace `#50fa7b` with `#17A9FD`
- Replace `dot-dark` with `dot-light`
- Replace `timeline-cntr-dark` with `timeline-cntr-light`

# Update Browsers List

```
npx browserslist@latest --update-db
```

# Yarn Packages

- Material UI
  - `yarn add @mui/material @emotion/react @emotion/styled`
  - `yarn add @mui/icons-material`
- React Router
  - `yarn add react-router@5.2.1`
  - `yarn add react-router-dom@5.3.0`
- Chakra UI
  - `yarn add @chakra-ui/react @emotion/react@^11 @emotion/styled@^11 framer-motion@^5`
  - `yarn add @chakra-ui/theme`
  - `yarn add @chakra-ui/theme-tools`
  - `yarn add @chakra-ui/icons`
- React Icons
  - `yarn add react-icons`
- Font Awesome
- React-Toggle
  - `yarn add react-toggle`
- Particles
  - `yarn add react-tsparticles`
  - https://github.com/matteobruni/tsparticles
  - https://github.com/th1rst/personal-portfolio-page
- Pathseg
  - `yarn add pathseg`
- Tailwind CSS
  - `yarn add -D tailwindcss postcss autoprefixer`
  - `npx tailwindcss init -p`
  - https://tailwindcss.com/docs/guides/create-react-app
- Font
  - `yarn add @fontsource/source-code-pro`

# Yarn Update/Upgrade Packages

- `yarn outdated`
- `yarn upgrade`
- `yarn upgrade <packageName>`
- `yarn upgrade <packageName> --latest`
- `yarn upgrade-interactive`
