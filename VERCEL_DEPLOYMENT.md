# Deploy the user frontend to Vercel

This repository contains several projects. The repository root now has a Vercel configuration that builds and serves the React/Vite user portal from `frontend`, so it can be imported with the default root directory.

## Vercel project settings

Recommended: use the repository root with the Vercel configuration committed here. Vercel uses:

- Install command: `npm install --prefix frontend`
- Build command: `npm run build --prefix frontend`
- Output directory: `frontend/dist`

Alternatively, set the Vercel project root directory to `frontend` and use the Vite defaults (`npm install`, `npm run build`, output `dist`). `frontend/vercel.json` includes the SPA fallback so direct visits to routes such as `/doctors` continue to work.

## Environment variables

Add these in **Vercel → Project → Settings → Environment Variables**, for Production (and Preview if needed):

- `VITE_BACKEND_URL`: Base URL of the deployed Express API, without a trailing slash, for example `https://your-api.example.com`.
- `VITE_RAZORPAY_KEY_ID`: Public Razorpay key ID if using payments.

The frontend calls `${VITE_BACKEND_URL}/api/...`. A Vercel frontend deployment does not deploy the API or its database. Deploy/configure the API separately and set `VITE_BACKEND_URL` to its reachable HTTPS URL. The value `https://your-backend-app.onrender.com` in `.env.example` is only a placeholder.

Do not add real credentials or `.env` files to Git. The repository ignores them; configure production values in Vercel.

## Deploy

1. Import `https://github.com/vedhanthgoud805-cyber/tt_project` in Vercel.
2. Keep the root directory set to the repository root, or use `frontend` with the alternative settings above.
3. Enter the environment variables above and deploy. Later pushes to the connected Git branch will trigger new deployments.

For local development, run `npm install` and `npm run dev` from `frontend`, then open `http://localhost:5173`.
