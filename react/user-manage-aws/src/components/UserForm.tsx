import React, { useState } from 'react';
import { createUser, } from '../services/api';
import styles from './UserForm.module.css';

const UserForm: React.FC = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await createUser({ name, email });
            alert('User created successfully!');
            setName('');
            setEmail('');
        } catch (error) {
            alert('Error creating user');
        }
    };

    return (
        <form onSubmit={handleSubmit} className={styles.form}>
            <div className={styles.formGroup}>
                <label className={styles.label}>Name:</label>
                <input
                    className={styles.input}
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    required
                />
            </div>
            <div className={styles.formGroup}>
                <label className={styles.label}>Email:</label>
                <input
                    className={styles.input}
                    type="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />
            </div>
            <button type="submit" className={styles.button}>
                Create User
            </button>
        </form>
    );
};

export default UserForm;
