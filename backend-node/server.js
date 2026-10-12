import express from 'express'
import cors from 'cors'
import 'dotenv/config'
import connectDB from './config/mongodb.js'
import connectCloudinary from './config/cloudinary.js'
import adminRouter from './routes/adminRoute.js'
import doctorRouter from './routes/doctorRoute.js'
import userRouter from './routes/userRoute.js'


// app config
const app = express()
const port = process.env.PORT || 4000
connectDB()
connectCloudinary()

// middleware
app.use(express.json())
app.use(cors())

// api endpoints
app.use('/api/admin',adminRouter)
app.use('/api/doctor',doctorRouter)
app.use('/api/user',userRouter)

app.get('/', (req, res) => {
    res.send('API WORKING')
})

app.get('/health', (req, res) => {
    res.json({ status: 'ok', uptime: process.uptime() })
})

// global error handling middleware
app.use((err, req, res, next) => {
    console.error(err.stack)
    res.status(500).json({ success: false, message: err.message || 'Internal Server Error' })
})

if (process.env.NODE_ENV !== 'test') {
    app.listen(port, () => {
        console.log("Server Started on port", port)
    })
}

export default app