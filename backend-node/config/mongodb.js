import mongoose from 'mongoose';

const connectDB = async () => {
    mongoose.connection.on('connected', () => console.log("Database Connected"));
    mongoose.connection.on('error', (err) => console.error("Database connection error:", err.message));
    
    const uri = process.env.MONGODB_URI;
    if (!uri) {
        console.error("MONGODB_URI is not defined in environment variables");
        return;
    }

    try {
        if (uri.includes('/prescripto')) {
            await mongoose.connect(uri);
        } else {
            await mongoose.connect(uri, {
                dbName: 'prescripto'
            });
        }
    } catch (error) {
        console.error("Failed to connect to MongoDB:", error.message);
        console.error("Please verify MONGODB_URI in your .env file or deployment environment.");
    }
}

export default connectDB;