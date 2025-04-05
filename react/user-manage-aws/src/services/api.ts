import axios from 'axios';

const API_BASE_URL = 'http://localhost:8082/users';

const axiosInstance = axios.create({
    baseURL: API_BASE_URL,
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    }
});

export const createUser = async (user: { name: string; email: string }) => {
    try {
        const response = await axiosInstance.post('', user);
        return response;
    } catch (error) {
        console.error('Error creating user:', error);
        throw error;
    }
};

export const getUserById = async (id: number) => {
    try {
        const response = await axiosInstance.get(`/${id}`);
        return response;
    } catch (error) {
        console.error('Error fetching user:', error);
        throw error;
    }
};

export const getAllUsers = async () => {
    try {
        const response = await axiosInstance.get('');
        return response;
    } catch (error) {
        console.error('Error fetching users:', error);
        throw error;
    }
};
