# Deployment Guide - Prescripto Full Stack Project

This repository contains three sub-projects:
- `backend/`: Node.js / Express / MongoDB / Cloudinary / Razorpay API
- `frontend/`: React + Vite + Tailwind CSS User Portal
- `admin/`: React + Vite + Tailwind CSS Admin & Doctor Management Panel

---

## 1. Push to GitHub

1. Stage all tracked files:
   ```bash
   git add .
   ```
2. Commit changes:
   ```bash
   git commit -m "Fix all project errors and prepare for Render and Vercel deployment"
   ```
3. Set your main branch:
   ```bash
   git branch -M main
   ```
4. Link your GitHub repository (replace with your repository URL):
   ```bash
   git remote add origin https://github.com/<your-username>/<your-repo-name>.git
   ```
5. Push to GitHub:
   ```bash
   git push -u origin main
   ```

*Note: All `.env` files and `node_modules` folders are automatically ignored to protect your secrets and credentials.*

---

## 2. Deploy Backend on Render

1. Go to [Render Dashboard](https://dashboard.render.com/) and click **New +** -> **Web Service**.
2. Connect your GitHub repository.
3. Configure settings:
   - **Name**: `prescripto-backend`
   - **Root Directory**: `backend`
   - **Environment**: `Node`
   - **Build Command**: `npm install`
   - **Start Command**: `npm start` (or `node server.js`)
   - **Health Check Path**: `/health`
4. Add Environment Variables under the **Environment** tab:
   - `MONGODB_URI`: Your MongoDB Atlas connection string (e.g., `mongodb+srv://user:pass@cluster.mongodb.net/?retryWrites=true&w=majority`)
   - `JWT_SECRET`: Any random secure string
   - `ADMIN_EMAIL`: Admin email for login (e.g., `admin@prescripto.com`)
   - `ADMIN_PASSWORD`: Admin password for login
   - `CLOUDINARY_NAME`: Cloudinary cloud name
   - `CLOUDINARY_API_KEY`: Cloudinary API key
   - `CLOUDINARY_SECRET_KEY`: Cloudinary API secret
   - `RAZORPAY_KEY_ID`: Razorpay key ID (test or live)
   - `RAZORPAY_KEY_SECRET`: Razorpay key secret
   - `CURRENCY`: `INR`
5. Click **Deploy Web Service**.
6. Once deployed, copy your Render service URL (e.g., `https://prescripto-backend.onrender.com`).

---

## 3. Deploy Frontend on Vercel

1. Go to [Vercel Dashboard](https://vercel.com/) and click **Add New...** -> **Project**.
2. Import your GitHub repository.
3. In **Project Settings**:
   - **Framework Preset**: `Vite`
   - **Root Directory**: Click `Edit` and select `frontend`
   - **Build Command**: `npm run build`
   - **Output Directory**: `dist`
4. In **Environment Variables**:
   - `VITE_BACKEND_URL`: Your Render backend URL (e.g., `https://prescripto-backend.onrender.com` without trailing slash)
   - `VITE_RAZORPAY_KEY_ID`: Your Razorpay Key ID
5. Click **Deploy**.
6. Client-side routing is handled automatically by the included `vercel.json` rewrites.

---

## 4. Deploy Admin Panel on Vercel

1. In Vercel, click **Add New...** -> **Project**.
2. Import the same repository.
3. In **Project Settings**:
   - **Project Name**: `prescripto-admin`
   - **Framework Preset**: `Vite`
   - **Root Directory**: Click `Edit` and select `admin`
   - **Build Command**: `npm run build`
   - **Output Directory**: `dist`
4. In **Environment Variables**:
   - `VITE_BACKEND_URL`: Your Render backend URL (e.g., `https://prescripto-backend.onrender.com` without trailing slash)
5. Click **Deploy**.
6. Client-side routing is handled automatically by the included `vercel.json` rewrites.

---

## 5. Local Development Testing

To run locally:

1. **Backend**:
   ```bash
   cd backend
   npm install
   npm start
   # Server runs on http://localhost:4000
   ```

2. **Frontend**:
   ```bash
   cd frontend
   npm install
   npm run dev
   # App runs on http://localhost:5173
   ```

3. **Admin**:
   ```bash
   cd admin
   npm install
   npm run dev
   # App runs on http://localhost:5174
   ```
